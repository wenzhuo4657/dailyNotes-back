package cn.wenzhuo4657.dailyWeb.tigger.http;

import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.ItemDto;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.UpdateItemDto;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.repository.IItemEditRepository;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.DocsItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemEditRepository implements IItemEditRepository {

    @Override
    public List<ItemDto> getMd(Integer content_name_Id, Integer type) {
        return List.of();
    }

    @Override
    public boolean updateMd(UpdateItemDto itemDto, Integer type) {
        return false;
    }

    @Override
    public void addItem(Integer content_name_Id, Integer type) {

    }

    @Override
    public DocsItem selectDocsItem(Long id) {
        return null;
    }

    @Override
    public void updateField(Integer id, String field) {

    }

    @Override
    public boolean queryContentName(Integer content_name_Id, Integer type, Long userid) {
        return false;
    }

    @Override
    public int queryContentType(Integer id) {
        return 0;
    }
}
