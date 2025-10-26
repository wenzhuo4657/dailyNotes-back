package cn.wenzhuo4657.dailyWeb.domain.ItemEdit;

import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.InsertItemDto;

public interface DailyBaseService {
    /**
     * 指定时间创建item，已存在不会报错，返回true
     */
    boolean createItem(String date,InsertItemDto dto);
}
