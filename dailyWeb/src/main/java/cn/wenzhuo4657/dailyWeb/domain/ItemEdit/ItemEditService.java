package cn.wenzhuo4657.dailyWeb.domain.ItemEdit;


import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.*;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.vo.DocsItemFiled;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.repository.IItemEditRepository;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.strategy.TypeStrategy;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.DocsItem;
import cn.wenzhuo4657.dailyWeb.types.Exception.AppException;
import cn.wenzhuo4657.dailyWeb.types.Exception.ResponseCode;
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

//    todo 重构

    @Autowired
    private TypeStrategy strategy;



    @Override
    public boolean insertItem(InsertItemDto dto,Long userId) {

        //        1，检查权限
//        2，操作数据库
//      todo  这是为了方便后续需要同时修改多个item，尽量让数据库方法单一职责

        return mdRepository.addItem(dto.getDocsId(),dto.getType(),userId);

    }

    @Override
    public boolean updateItem(UpdateItemDto dto,Long userId) {
//        1，检查权限
//        2，操作数据库
//      todo  这是为了方便后续需要同时修改多个item，尽量让数据库方法单一职责

        mdRepository.updateItem( dto,dto.getType(),userId);
        return true;
    }

    @Override
    public List<ItemDto> getItem(QueryItemDto dto) {

        try {
            List<DocsItem> docsItems = mdRepository.getDocsItems(dto.getDocsId());
            return  strategy.apply(dto.getTypeName(), docsItems);
        }catch (ClassNotFoundException e){
            throw  new AppException(ResponseCode.MISSING_CREDENTIALS);
        }


    }


    @Override
    public boolean CheckList(UpdateCheckListDto params) {
        DocsItem docsItem = mdRepository.selectDocsItem(params.getIndex());
        if (docsItem==null){
            log.error("未找到该条目");
            return false;

        }
        try {
            Map<String, String> map = DocsItemFiled.toMap(docsItem.getItemField());
            map.put(DocsItemFiled.ItemFiled.title.getFiled(), params.getTitle());
            String filed = DocsItemFiled.toFiled(map);
            mdRepository.updateField(docsItem.getId(),filed );
        }catch (ClassNotFoundException e){
            log.error("不支持的属性");
            return false;
        }
        return true;
    }

    @Override
    public boolean CheckListFinish(Long id) {
        DocsItem docsItem = mdRepository.selectDocsItem(id);
        if (docsItem==null){
            log.error("未找到该条目");
            return false;
        }
        try {
            Map<String, String> map = DocsItemFiled.toMap(docsItem.getItemField());
            map.put(DocsItemFiled.ItemFiled.status.getFiled(), "true");

            DateTimeFormatter TS = DateTimeFormatter.ofPattern("yyyyMMdd");
            map.put(DocsItemFiled.ItemFiled.data.getFiled(), LocalDateTime.now().format(TS));
            String filed = DocsItemFiled.toFiled(map);
            mdRepository.updateField(docsItem.getId(),filed );
        }catch (ClassNotFoundException e){
            log.error("不支持的属性");
            return false;
        }
        return true;
    }
}
