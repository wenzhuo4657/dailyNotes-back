package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.function.typeDaily;

import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.vo.contentItemType;

@FunctionalInterface
public interface FiledFn {

    String toFiled(contentItemType.ItemType itemType)throws ClassNotFoundException;
}
