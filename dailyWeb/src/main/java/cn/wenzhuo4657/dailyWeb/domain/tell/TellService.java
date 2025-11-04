package cn.wenzhuo4657.dailyWeb.domain.tell;

import cn.wenzhuo4657.dailyWeb.domain.tell.strategy.INotifier;
import cn.wenzhuo4657.dailyWeb.domain.tell.strategy.NotifierMessage;





public interface TellService {

    /**
     * 使用通知器发送通知
     * @param notifyId 通知配置ID: 根据它可以找到通知策略+装饰器，以及相关配置
     * @param message 通知消息
     *
     */
    public void sendNotify(Integer notifyId, NotifierMessage message);
}
