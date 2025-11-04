package cn.wenzhuo4657.dailyWeb.infrastructure.database.repository;

import cn.wenzhuo4657.dailyWeb.domain.tell.model.entity.UserNotifierDto;
import cn.wenzhuo4657.dailyWeb.domain.tell.repository.ITellRepository;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.dao.UsernotifierDao;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.Usernotifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TellRepository implements ITellRepository {

    @Autowired
    private UsernotifierDao usernotifierDao;

    @Override
    public String queryNotifyConfig(Integer notifyId) {
        return  usernotifierDao.queryByNotifyId(notifyId);

    }

    @Override
    public List<Usernotifier> queryUserNotifyConfig(Integer userId) {
        return usernotifierDao.querByUserId(userId);
    }
}
