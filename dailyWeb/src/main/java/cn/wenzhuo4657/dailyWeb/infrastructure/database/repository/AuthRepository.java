package cn.wenzhuo4657.dailyWeb.infrastructure.database.repository;


import cn.wenzhuo4657.dailyWeb.domain.auth.model.aggregate.CheckUserByOauthAggregate;
import cn.wenzhuo4657.dailyWeb.domain.auth.model.aggregate.RegisterAggregate;
import cn.wenzhuo4657.dailyWeb.domain.auth.repository.IAuthRepository;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class AuthRepository  implements IAuthRepository {



    @Override
    public User checkUserExists(CheckUserByOauthAggregate user) {
        return null;
    }

    @Override
    public User initUser(RegisterAggregate user) {
        return null;
    }
}
