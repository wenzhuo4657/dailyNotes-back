package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.service;

import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.Dao.BaseRepositoryByItem;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.UpdateCheckListDto;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.vo.ContentItemFiled;
import cn.wenzhuo4657.dailyWeb.entity.ContentItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

@Slf4j
@Service
public class fieldService {
       @Autowired
       private BaseRepositoryByItem mdRepository;


    public void updateCheckListTitle(UpdateCheckListDto params) {
        ContentItem contentItem = mdRepository.selectContentItem(params.getId());
        if (contentItem==null){
            log.error("未找到该条目");
            return;
        }
        try {
            Map<String, String> map = ContentItemFiled.toMap(contentItem.getField());
            map.put(ContentItemFiled.ItemFiled.title.getFiled(), params.getTitle());
            String filed = ContentItemFiled.toFiled(map);
            mdRepository.updateField(contentItem.getId(),filed );
        }catch (ClassNotFoundException e){
            log.error("不支持的属性");
        }

    }

    public void updateCheckListFinish(Integer id) {
        ContentItem contentItem = mdRepository.selectContentItem(id);
        if (contentItem==null){
            log.error("未找到该条目");
            return;
        }
        try {
            Map<String, String> map = ContentItemFiled.toMap(contentItem.getField());
            map.put(ContentItemFiled.ItemFiled.status.getFiled(), "true");

            DateTimeFormatter TS = DateTimeFormatter.ofPattern("yyyyMMdd");
            map.put(ContentItemFiled.ItemFiled.data.getFiled(), LocalDateTime.now().format(TS));
            String filed = ContentItemFiled.toFiled(map);
            mdRepository.updateField(contentItem.getId(),filed );
        }catch (ClassNotFoundException e){
            log.error("不支持的属性");
        }
    }
}
