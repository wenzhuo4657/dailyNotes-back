package cn.wenzhuo4657.dailyWeb.domain.tell.repository;


import cn.wenzhuo4657.dailyWeb.domain.tell.service.strategy.Impl.GmailConfig;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.Usernotifier;

import java.util.List;

public interface ITellRepository {


    /**
     * 找寻通知配置
     *
     */

    String queryNotifyConfig(Integer notifyId);


    /**
     * 查找用户的通知配置
     */
    List<Usernotifier> queryUserNotifyConfig(Integer userId);
}
