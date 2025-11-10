package cn.wenzhuo4657.dailyWeb.domain.tell.repository;


import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.Notifier;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.NotifierType;

import java.util.List;
import java.util.Optional;

public interface ITellRepository {


    /**
     * 找寻通知配置
     *
     */

    String queryNotifyConfig(Integer notifyId);


    /**
     * 查找用户的通知配置
     */
    List<Notifier> queryUserNotifyConfig(Long userId);

    NotifierType queryNotifierTypeById(Integer notifierTypeId);
}
