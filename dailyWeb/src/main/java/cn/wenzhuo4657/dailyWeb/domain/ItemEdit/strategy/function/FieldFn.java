package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.strategy.function;

import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.vo.DocsItemType;


@FunctionalInterface
public interface FieldFn {
    String toField(DocsItemType.ItemType itemType)throws ClassNotFoundException;
}
