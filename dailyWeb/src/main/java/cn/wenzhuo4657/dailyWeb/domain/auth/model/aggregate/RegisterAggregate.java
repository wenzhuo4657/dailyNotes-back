package cn.wenzhuo4657.dailyWeb.domain.auth.model.aggregate;

import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.User;

public class RegisterAggregate {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
