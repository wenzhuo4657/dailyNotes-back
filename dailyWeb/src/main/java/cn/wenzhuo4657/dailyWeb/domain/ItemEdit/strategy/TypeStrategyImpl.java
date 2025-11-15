package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.strategy;

import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.ItemDto;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.vo.DocsItemType;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.strategy.function.ExpandFn;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.strategy.function.FieldFn;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.strategy.function.TitleFn;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.strategy.function.impl.TypeFunction;
import cn.wenzhuo4657.dailyWeb.domain.Types.model.dto.DocsDto;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.DocsItem;
import org.springframework.stereotype.Component;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Component
public    class TypeStrategyImpl implements TypeStrategy {


    protected DocsItemType.ItemType router(String typeName) throws ClassNotFoundException {
        return DocsItemType.ItemType.valueOfByName(typeName);
    }

//    todo 在面对多个时会有性能问题，本质上应该是返回一个策略，或者是直接执行返回数据


    @Override
    public String toFiled(String typeName) throws ClassNotFoundException {
        DocsItemType.ItemType itemType  = router(typeName);

        return TypeFunction.toField.toField(itemType);
    }


    @Override
    public List<ItemDto> apply(String typeName, List<DocsItem> items) throws ClassNotFoundException {
        DocsItemType.ItemType itemType  = router(typeName);

        List<ItemDto> list=new ArrayList<>(items.size());

        for (DocsItem item:items) {


            ItemDto itemDto = new ItemDto();
            itemDto.setIndex(item.getIndex());
            itemDto.setTitle(getTitleFn().apply(itemType,item));
            itemDto.setContent(item.getItemContent());
            itemDto.setExpand(getExpandFn().apply(itemType,item));
            list.add(itemDto);
        }


        return list;
    }

    @Override
    public FieldFn getFieldFn() {
        return TypeFunction.toField;
    }

    @Override
    public TitleFn getTitleFn() {
        return TypeFunction.toTitle;
    }

    @Override
    public ExpandFn getExpandFn() {
        return TypeFunction.toExpand;
    }
}
