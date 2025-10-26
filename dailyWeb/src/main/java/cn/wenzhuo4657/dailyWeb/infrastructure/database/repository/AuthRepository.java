package cn.wenzhuo4657.dailyWeb.infrastructure.database.repository;


import cn.dev33.satoken.stp.StpUtil;
import cn.wenzhuo4657.dailyWeb.domain.auth.model.aggregate.CheckUserByOauthAggregate;
import cn.wenzhuo4657.dailyWeb.domain.auth.model.aggregate.RegisterAggregate;
import cn.wenzhuo4657.dailyWeb.domain.auth.model.dto.UserDto;
import cn.wenzhuo4657.dailyWeb.domain.auth.repository.IAuthRepository;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.dao.UserDao;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Repository
public class AuthRepository  implements IAuthRepository {

    @Autowired
    private UserDao userDao;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



    @Override
    public User checkUserExists(CheckUserByOauthAggregate user) {
        return userDao.queryByOauthId(user.getOauth_provider(),user.getOauth_provider_user_id());

    }

    @Override
    public User initUser(RegisterAggregate user) {
        User userEntity = user.getUser();
        userEntity.setCreatedAt(simpleDateFormat.format(System.currentTimeMillis()));

        int insert = userDao.insert(userEntity);

        if (insert==1){
//           todo 初始化操作，文档id集合，对于日报和备忘录类型来说，他们没有必要进行多文档装配，所以直接初始化即可

            return userEntity;
        }
        return null;
    }



}
