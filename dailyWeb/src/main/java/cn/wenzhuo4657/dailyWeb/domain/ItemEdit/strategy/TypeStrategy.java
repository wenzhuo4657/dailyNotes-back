package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.strategy;

import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.ItemDto;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.strategy.function.ExpandFn;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.strategy.function.FieldFn;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.strategy.function.TitleFn;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.DocsItem;

import java.util.List;


/**
 * 策略定义，typeName用于区分不同策略，此处只是用于提供方法的统一入口
 */
public interface TypeStrategy {

    /**
     * 初始化field属性
     * @param typeName
     * @return
     * @throws ClassNotFoundException
     */
    String toFiled(String typeName)throws ClassNotFoundException;

    List<ItemDto>  apply(String  typeName, List<DocsItem> item) throws ClassNotFoundException;




    FieldFn getFieldFn();

    TitleFn getTitleFn();

    ExpandFn getExpandFn();



}
