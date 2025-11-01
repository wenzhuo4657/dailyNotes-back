package cn.wenzhuo4657.dailyWeb.domain.auth;


import cn.wenzhuo4657.dailyWeb.domain.auth.model.dto.RegisterByOauthDto;
import cn.wenzhuo4657.dailyWeb.domain.auth.model.dto.UserDto;
import org.springframework.stereotype.Service;


public  interface IUserService {

    /**
     * 初始化用户
     * 如果已存在，则直接返回相应的用户信息
     */
    public UserDto registerByOauth(RegisterByOauthDto registerByOauthDto);
}
