package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.function.typeDaily;

import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.vo.contentItemType;

@FunctionalInterface
public interface TitleFn {
    String apply(contentItemType.ItemType itemType, ContentItem field) throws ClassNotFoundException;
}