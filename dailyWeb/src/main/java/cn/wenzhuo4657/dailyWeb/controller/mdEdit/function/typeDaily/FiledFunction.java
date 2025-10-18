package cn.wenzhuo4657.dailyWeb.controller.mdEdit.function.typeDaily;

import cn.wenzhuo4657.dailyWeb.controller.mdEdit.model.vo.ContentItemFiled;
import cn.wenzhuo4657.dailyWeb.controller.mdEdit.model.vo.contentItemType;
import cn.wenzhuo4657.dailyWeb.entity.ContentItem;

import java.util.Map;
import java.util.function.Function;

public class FiledFunction {


    public  static TitleFn toTitle = new TitleFn() {
        @Override
        public String apply(contentItemType.ItemType itemType, ContentItem field) throws ClassNotFoundException {
            if (itemType.getId().equals(contentItemType.ItemType.BASIC_CONTENT.getId())){
                return  field.getDate().toString();
            }
            if (itemType.getId().equals(contentItemType.ItemType.CHECK_LIST.getId())){
                Map<String, String> map = ContentItemFiled.toMap(field.getField());
                return  map.get(ContentItemFiled.ItemFiled.title.getFiled());
            }
            throw  new ClassNotFoundException("不支持的ItemType");

        }
    };

    public static  FiledFn toFiled = new FiledFn() {
        @Override
        public String toFiled(contentItemType.ItemType itemType) throws ClassNotFoundException {

            return ContentItemFiled.toFiled(itemType.getField());

        }

    };


    public static TitleFn toExpand = new TitleFn() {
        @Override
        public String apply(contentItemType.ItemType itemType, ContentItem field) throws ClassNotFoundException {
            if (itemType.getId().equals(contentItemType.ItemType.CHECK_LIST.getId())){
                Map<String, String> map = ContentItemFiled.toMap(field.getField());
                return  map.get(ContentItemFiled.ItemFiled.status.getFiled());
            }
            return "";
        }
    };
}
