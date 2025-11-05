package cn.wenzhuo4657.dailyWeb.domain.tell.service;

import cn.wenzhuo4657.dailyWeb.domain.tell.model.entity.UserNotifierDto;
import cn.wenzhuo4657.dailyWeb.domain.tell.model.vo.ConfigType;
import cn.wenzhuo4657.dailyWeb.domain.tell.repository.ITellRepository;
import cn.wenzhuo4657.dailyWeb.domain.tell.service.strategy.INotifier;
import cn.wenzhuo4657.dailyWeb.domain.tell.service.strategy.NotifierConfig;
import cn.wenzhuo4657.dailyWeb.domain.tell.service.strategy.NotifierMessage;
import cn.wenzhuo4657.dailyWeb.domain.tell.service.strategy.NotifierResult;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.Usernotifier;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TellServiceImpl implements ITellService {

    private  ITellRepository tellRepository;

    public TellServiceImpl(ITellRepository tellRepository) {
        this.tellRepository = tellRepository;
    }

    @Override
    public NotifierResult sendNotify(Integer notifyId, String type, NotifierMessage message) {
//        1,读取配置
        ConfigType configType = ConfigType.fromTag(type);
        String json = tellRepository.queryNotifyConfig(notifyId);


        // 2,解析配置，创建通知器

        Class strategy = configType.getStrategy();
        Class config = configType.getConfig();

        NotifierConfig notifierConfig = (NotifierConfig) JSONObject.parseObject(json,config);

//        3，发起通知
        try {
            INotifier notifier = (INotifier) strategy.getDeclaredConstructor(NotifierConfig.class).newInstance(notifierConfig);
            return notifier.send(message);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e){
            e.printStackTrace();
        }

        return  NotifierResult.fail();


    }


    @Override
    public List<UserNotifierDto> queryNotifyConfigs(Integer userId) {
        List<Usernotifier> usernotifiers = tellRepository.queryUserNotifyConfig(userId);
        return  usernotifiers.stream().map(entity->{
            UserNotifierDto userNotifierDto = new UserNotifierDto();
            userNotifierDto.setId(entity.getId());
            userNotifierDto.setType(entity.getType());
            return  userNotifierDto;
        }).collect(Collectors.toList());
    }
}
