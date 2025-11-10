package cn.wenzhuo4657.dailyWeb.infrastructure.database.repository;

import cn.wenzhuo4657.dailyWeb.domain.tell.repository.ITellRepository;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.dao.NotifierDao;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.dao.NotifierTypeDao;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.Notifier;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.NotifierType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TellRepository implements ITellRepository {

    @Autowired
    private NotifierDao usernotifierDao;

    @Autowired
    private NotifierTypeDao notifierTypeDao;

//   todo 缺少安全性配置  例如，如果找不到，应该返回什么？

    @Override
    public String queryNotifyConfig(Integer notifyId) {
        return  usernotifierDao.queryByNotifyId(notifyId);

    }

    @Override
    public List<Notifier> queryUserNotifyConfig(Long userId) {
        return usernotifierDao.querByUserId(userId);
    }

    @Override
    public NotifierType queryNotifierTypeById(Integer notifierTypeId) {
        return notifierTypeDao.queryById(notifierTypeId);
    }
}
