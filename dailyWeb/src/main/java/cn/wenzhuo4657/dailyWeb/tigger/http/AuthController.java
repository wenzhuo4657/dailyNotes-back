package cn.wenzhuo4657.dailyWeb.tigger.http;


import cn.dev33.satoken.stp.StpUtil;
import cn.wenzhuo4657.dailyWeb.domain.auth.UserService;
import cn.wenzhuo4657.dailyWeb.domain.auth.model.dto.RegisterByOauthDto;
import cn.wenzhuo4657.dailyWeb.domain.auth.model.dto.UserDto;
import cn.wenzhuo4657.dailyWeb.utils.SaTokenUtils;
import jakarta.servlet.http.HttpServletResponse;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.utils.AuthStateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Controller(value = "oauth")
@RequestMapping(value = "/oauth")
public class AuthController {
    @Autowired
    private AuthRequest authRequest;

    @Autowired
    private UserService userService;

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
    public ResponseEntity<?> callbackGithub(AuthCallback callback, HttpServletResponse response) {
        // 1. 使用 JustAuth 处理回调，获取用户信息
        AuthResponse authResponse = authRequest.login(callback);

        if (authResponse.getCode() == 2000) {
            // 2. 登录成功，获取用户信息
            AuthUser authUser = (AuthUser) authResponse.getData();


//            3,系统缓存登录信息
            RegisterByOauthDto registerByOauthDto = new RegisterByOauthDto();
            registerByOauthDto.setOauth_provider("github");
            registerByOauthDto.setOauth_provider_avatar(authUser.getAvatar());
            registerByOauthDto.setOauth_provider_username(authUser.getUsername());
            registerByOauthDto.setOauth_provider_user_id(authUser.getUuid());
            UserDto user = userService.registerByOauth(registerByOauthDto);

            StpUtil.login(user.getId());

            // 4. 可以将用户信息存入 Sa-Token 的 Session 中，方便后续获取
            SaTokenUtils.setUserInfo(user);

            System.out.println("GitHub 用户 " + authUser.getUsername() + " 登录成功！");

            return ResponseEntity.ok(Map.of(
                    "code", 200,
                    "message", "登录成功",
                    "token", StpUtil.getTokenValue(),
                    "userInfo", user
            ));
        } else {
            return ResponseEntity.ok(Map.of(
                    "code", 500,
                    "message", "登录失败"
            ));
        }
    }
}
