package cn.wenzhuo4657.dailyWeb.domain.ItemEdit;


import cn.dev33.satoken.stp.StpUtil;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.*;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.vo.ContentItemFiled;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.repository.IItemEditRepository;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.ContentItem;
import cn.wenzhuo4657.dailyWeb.utils.SaTokenUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * 默认文档行为实现
 */
@Service
public  class ItemEditService implements IItemEditService,CheckListService {
    Logger log = org.slf4j.LoggerFactory.getLogger(ItemEditService.class);

    @Autowired
    protected IItemEditRepository mdRepository;



    @Override
    public boolean insertItem(InsertItemDto dto) {

        boolean b = mdRepository.queryContentName(dto.getContent_name_Id(), dto.getType(), SaTokenUtils.getLoginId());
        if (!b){
            log.error("用户没有操作该文档的权限");
            return false;
        }
        mdRepository.addItem(dto.getContent_name_Id(),dto.getType());
        return true;
    }

    @Override
    public boolean updateItem(UpdateItemDto dto) {

        boolean b = mdRepository.queryContentName(dto.getId(), dto.getType(), SaTokenUtils.getLoginId());
        if (!b){
            log.error("用户没有操作该文档的权限");
            return false;
        }
        mdRepository.updateMd( dto,dto.getType());
        return true;
    }

    @Override
    public List<ItemDto> getItem(QueryItemDto dto) {
        return mdRepository.getMd(dto.getContentNameId(),dto.getType());
    }


    @Override
    public boolean CheckList(UpdateCheckListDto params) {
        ContentItem contentItem = mdRepository.selectContentItem(params.getId());
        if (contentItem==null){
            log.error("未找到该条目");
            return false;

        }
        try {
            Map<String, String> map = ContentItemFiled.toMap(contentItem.getField());
            map.put(ContentItemFiled.ItemFiled.title.getFiled(), params.getTitle());
            String filed = ContentItemFiled.toFiled(map);
            mdRepository.updateField(contentItem.getId(),filed );
        }catch (ClassNotFoundException e){
            log.error("不支持的属性");
            return false;
        }
        return true;
    }

    @Override
    public boolean CheckListFinish(Integer id) {
        ContentItem contentItem = mdRepository.selectContentItem(id);
        if (contentItem==null){
            log.error("未找到该条目");
            return false;
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
            return false;
        }
        return true;
    }
}
