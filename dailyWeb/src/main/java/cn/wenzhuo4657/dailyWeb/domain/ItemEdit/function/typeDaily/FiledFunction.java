package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.function.typeDaily;

import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.vo.ContentItemFiled;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.vo.contentItemType;

import java.util.Map;

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
