package cn.wenzhuo4657.dailyWeb.infrastructure.database.repository;


import cn.wenzhuo4657.dailyWeb.domain.auth.model.aggregate.CheckUserByOauthAggregate;
import cn.wenzhuo4657.dailyWeb.domain.auth.model.aggregate.RegisterAggregate;
import cn.wenzhuo4657.dailyWeb.domain.auth.repository.IAuthRepository;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.dao.ContentNameDao;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.dao.ContentTypeDao;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.dao.UserContentnameDao;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.dao.UserDao;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.ContentName;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.ContentType;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.User;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.UserContentname;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class AuthRepository  implements IAuthRepository {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserContentnameDao userContentnameDao;

    @Autowired
    private ContentNameDao contentNameDao;

    @Autowired
    private ContentTypeDao contentTypeDao;

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
            initUser(userEntity);
            return userEntity;
        }
        throw  new RuntimeException("用户初始化失败");
    }


    private void initUser(User user){
//       todo  1,基本文档初始化,所有类型文档都创建一个     2，目前没有处理多文档逻辑，所以全靠初始化
        List<ContentType> all = contentTypeDao.getAll();
        for (ContentType contentType : all){
            ContentName contentName = new ContentName();
            contentName.setName("default");
            contentName.setType(contentType.getId());
            contentName.setCreateTime(new Date());
            contentName.setUpdateTime(new Date());
            contentNameDao.insert(contentName);

            UserContentname userContentname = new UserContentname();
            userContentname.setUserid(user.getId());
            userContentname.setContentnameid(contentName.getId());
            userContentnameDao.insert(userContentname);
        }


    }




}
