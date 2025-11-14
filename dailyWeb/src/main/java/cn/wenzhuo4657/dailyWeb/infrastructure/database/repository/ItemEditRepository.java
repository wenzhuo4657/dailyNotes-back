package cn.wenzhuo4657.dailyWeb.infrastructure.database.repository;

import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.function.typeDaily.FiledFunction;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.ItemDto;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.UpdateItemDto;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.vo.contentItemType;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.repository.IItemEditRepository;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.dao.DocsDao;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.dao.DocsItemDao;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.DocsItem;
import cn.wenzhuo4657.dailyWeb.types.Exception.AppException;
import cn.wenzhuo4657.dailyWeb.types.Exception.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ItemEditRepository implements IItemEditRepository {


    @Autowired
    private DocsDao docsDao;

    @Autowired
    private DocsItemDao docsItemDao;

    @Override
    public boolean updateItem(UpdateItemDto itemDto, Integer type, Long userId) {
        return false;
    }

    @Override
    public List<ItemDto> getDocsItems(Long docs_Id, Long typeId, Long userId) {
        try {

            boolean exist = docsDao.isExist(docs_Id);

            if (!exist){
                throw  new AppException(ResponseCode.RESOURCE_NOT_FOUND);
            }


            contentItemType.ItemType itemType = contentItemType.ItemType.toItemType(typeId);


            /**
             * todo
             *  重构filed属性处理逻辑
             *
             *  逻辑上没问题，但是很难扩展，我现在已经有点看不懂了，问题是没有清晰的入口点和提示，尝试使用设计模式进行优化
             *  此外：
             *  关于id问题，暂时可以不用担心，无论怎么样，最终都是在配置文件写死一部分，只是如果需要重构，写死的部分还是一个code代码比较好，方便记忆和理解
             *
             */
            return docsItemDao.queryByDocsId(docs_Id)
                    .stream()
                    .map(
                            item -> new ItemDto(
                                    item.getIndex(),
                                    FiledFunction.toTitle.apply(itemType,item),
                                    item.getItemContent(),
                                    FiledFunction.toExpand.apply(itemType,item)
                            )
                    )
                    .collect(Collectors.toList());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw  new AppException(ResponseCode.MISSING_CREDENTIALS);
        }


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
