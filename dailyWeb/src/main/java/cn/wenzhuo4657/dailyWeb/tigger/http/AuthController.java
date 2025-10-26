package cn.wenzhuo4657.dailyWeb.tigger.http;


import cn.dev33.satoken.stp.StpUtil;
import jakarta.servlet.http.HttpServletResponse;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.utils.AuthStateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller(value = "oauth")
@RequestMapping(value = "/oauth")
public class AuthController {
    @Autowired
    private AuthRequest authRequest;

    /**
     * 重定向到 GitHub 授权页面
     */
    @GetMapping("/render/github")
    public void renderGithub(HttpServletResponse response) throws IOException {
        String state = AuthStateUtils.createState();
        response.sendRedirect(authRequest.authorize(state));
    }

    /**
     * GitHub 授权回调
     */
    @GetMapping("/callback/github")
    public String callbackGithub(AuthCallback callback, HttpServletResponse response) {
        // 1. 使用 JustAuth 处理回调，获取用户信息
        AuthResponse authResponse = authRequest.login(callback);

        if (authResponse.getCode() == 2000) {
            // 2. 登录成功，获取用户信息
            AuthUser authUser = (AuthUser) authResponse.getData();

            // 3. 使用 Sa-Token 进行登录
            //    这里我们使用 GitHub 的 UUID 作为用户的唯一标识符
            String userId = authUser.getUuid();

            StpUtil.login(userId);

            // 4. 可以将用户信息存入 Sa-Token 的 Session 中，方便后续获取
            StpUtil.getTokenSession().set("userInfo", authUser);

            System.out.println("GitHub 用户 " + authUser.getUsername() + " 登录成功！");

            // 5. 登录成功后，重定向到主页
            return "redirect:/index";
        } else {
            // 登录失败，返回错误页面
            return "redirect:/error?msg=" + authResponse.getMsg();
        }
    }
}
