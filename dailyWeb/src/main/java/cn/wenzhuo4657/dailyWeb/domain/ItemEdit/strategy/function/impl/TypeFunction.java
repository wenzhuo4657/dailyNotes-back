package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.strategy.function.impl;


import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.vo.DocsItemFiled;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.vo.DocsItemType;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.strategy.function.ExpandFn;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.strategy.function.FieldFn;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.strategy.function.TitleFn;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.DocsItem;

import java.util.Map;

public class TypeFunction {





    public  static TitleFn toTitle = new TitleFn() {
        @Override
        public String apply(DocsItemType.ItemType itemType, DocsItem item) throws ClassNotFoundException {
            if (itemType.getTypeName().equals(DocsItemType.ItemType.dailyBase.getTypeName())){
                Map<String, String> map = DocsItemFiled.toMap(item.getItemField());
                return  map.get(DocsItemFiled.ItemFiled.data.getFiled());
            }

            if (itemType.getTypeName().equals(DocsItemType.ItemType.checkList.getTypeName())){
                Map<String, String> map = DocsItemFiled.toMap(item.getItemField());
                return  map.get(DocsItemFiled.ItemFiled.title.getFiled());
            }
            throw  new ClassNotFoundException("不支持的ItemType");

        }
    };

    public static FieldFn toField = new FieldFn() {
        @Override
        public String toField(DocsItemType.ItemType itemType) throws ClassNotFoundException {

            return DocsItemFiled.toFiled(itemType.getFiled());

        }

    };


    public static ExpandFn toExpand = new ExpandFn() {
        @Override
        public String apply(DocsItemType.ItemType itemType, DocsItem item) throws ClassNotFoundException {
            if (itemType.getTypeName().equals(DocsItemType.ItemType.checkList.getTypeName())){
                Map<String, String> map = DocsItemFiled.toMap(item.getItemField());
                return  map.get(DocsItemFiled.ItemFiled.status.getFiled());
            }
            return "";
        }
    };
}
