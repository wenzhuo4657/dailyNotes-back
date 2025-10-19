package cn.wenzhuo4657.dailyWeb.domain.mdEdit.function.typeDaily;

import cn.wenzhuo4657.dailyWeb.domain.mdEdit.model.vo.contentItemType;
import cn.wenzhuo4657.dailyWeb.entity.ContentItem;

@FunctionalInterface
public interface TitleFn {
    String apply(contentItemType.ItemType itemType, ContentItem field) throws ClassNotFoundException;
}