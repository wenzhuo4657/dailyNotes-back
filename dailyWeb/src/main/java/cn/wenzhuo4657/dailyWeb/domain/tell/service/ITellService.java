package cn.wenzhuo4657.dailyWeb.domain.tell.service;

import cn.wenzhuo4657.dailyWeb.domain.tell.model.entity.UserNotifierDto;
import cn.wenzhuo4657.dailyWeb.domain.tell.service.strategy.NotifierConfig;
import cn.wenzhuo4657.dailyWeb.domain.tell.service.strategy.NotifierMessage;

import java.util.List;


public interface ITellService {

    /**
     * 使用通知器发送通知
     * @param notifyId 通知配置ID: 根据它可以找到通知策略+装饰器，以及相关配置
     * @param message 通知消息
     *
     */
    public void sendNotify(Integer notifyId,String type, NotifierMessage message);


    /**
     * 查询通知配置列表: 用户维度
     */
    public List<UserNotifierDto> queryNotifyConfigs(Integer userId);
}
