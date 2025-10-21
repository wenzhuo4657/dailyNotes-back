package cn.wenzhuo4657.dailyWeb.controller.mdEdit.function.typeDaily;

import cn.wenzhuo4657.dailyWeb.controller.mdEdit.model.vo.contentItemType;

@FunctionalInterface
public interface FiledFn {

    String toFiled(contentItemType.ItemType itemType)throws ClassNotFoundException;
}
