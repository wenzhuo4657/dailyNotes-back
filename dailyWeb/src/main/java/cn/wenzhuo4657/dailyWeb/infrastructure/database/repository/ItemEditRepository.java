package cn.wenzhuo4657.dailyWeb.infrastructure.database.repository;

import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.UpdateItemDto;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.repository.IItemEditRepository;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.dao.DocsDao;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.dao.DocsItemDao;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.DocsItem;
import cn.wenzhuo4657.dailyWeb.types.Exception.AppException;
import cn.wenzhuo4657.dailyWeb.types.Exception.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemEditRepository implements IItemEditRepository {


    @Autowired
    private DocsDao docsDao;

    @Autowired
    private DocsItemDao docsItemDao;

    @Override
    public List<DocsItem> getDocsItems(Long docs_Id) {
        boolean exist = docsDao.isExist(docs_Id);

        if (!exist){
            throw  new AppException(ResponseCode.RESOURCE_NOT_FOUND);
        }
        return docsItemDao.queryByDocsId(docs_Id);
    }

    @Override
    public boolean updateItem(UpdateItemDto itemDto, Integer type, Long userId) {
//        1,检查权限
//        2.修改
        return false;
    }



    @Override
    public boolean addItem(Long docs_Id, Integer type, Long userId) {
        return false;
    }

    @Override
    public DocsItem selectDocsItem(Long id) {
        return null;
    }

    @Override
    public void updateField(Long id, String field) {

    }
}
