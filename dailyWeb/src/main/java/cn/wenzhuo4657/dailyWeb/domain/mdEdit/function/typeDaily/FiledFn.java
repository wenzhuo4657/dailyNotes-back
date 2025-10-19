package cn.wenzhuo4657.dailyWeb.domain.mdEdit.function.typeDaily;

import cn.wenzhuo4657.dailyWeb.domain.mdEdit.model.vo.contentItemType;

@FunctionalInterface
public interface FiledFn {

    String toFiled(contentItemType.ItemType itemType)throws ClassNotFoundException;
}
