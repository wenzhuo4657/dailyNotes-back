package cn.wenzhuo4657.dailyWeb.utils;

import cn.dev33.satoken.stp.StpUtil;
import cn.wenzhuo4657.dailyWeb.domain.auth.model.dto.UserDto;

public class SaTokenUtils {

    /**
     * 获取登录用户的id
     * @return
     */
    public static Long getLoginId(){
        return Long.valueOf(StpUtil.getLoginId().toString());
    }

    /**
     * 存储用户信息
     */
    public static void setUserInfo(UserDto userInfo){
        StpUtil.getTokenSession().set("userInfo", userInfo);
    }

    /**
     * 获取用户信息
     */
    public static UserDto getUserInfo(){
        return (UserDto) StpUtil.getTokenSession().get("userInfo");
    }

}
