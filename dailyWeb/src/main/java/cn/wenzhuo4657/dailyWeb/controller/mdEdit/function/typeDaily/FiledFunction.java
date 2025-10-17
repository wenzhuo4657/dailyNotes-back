package cn.wenzhuo4657.dailyWeb.controller.mdEdit.function.typeDaily;

import cn.wenzhuo4657.dailyWeb.controller.mdEdit.model.vo.contentItemType;
import cn.wenzhuo4657.dailyWeb.entity.ContentItem;

import java.util.function.Function;

public class FiledFunction {


    public  static TitleFn toTitle = new TitleFn() {
        @Override
        public String apply(contentItemType.ItemType itemType, ContentItem field) throws ClassNotFoundException {
            if (itemType.getId().equals(contentItemType.ItemType.BASIC_CONTENT.getId())){
                return  field.getDate().toString();
            }
            if (itemType.getId().equals(contentItemType.ItemType.CHECK_LIST.getId())){
                return  field.getField();//这里实际上是将title作为前端的内容信息，此处备忘录为是否完成
            }
            throw  new ClassNotFoundException("不支持的ItemType");

        }
    };

    public static  FiledFn toFiled = new FiledFn() {
        @Override
        public String toFiled(contentItemType.ItemType itemType) throws ClassNotFoundException {
//            TODO 这是item field属性的初始化方法，但由于目前不出处理，所以实际上直接返回也行，但这样子写方便后续拓展
            if (itemType.getId().equals(contentItemType.ItemType.BASIC_CONTENT.getId())){
                return contentItemType.ItemType.BASIC_CONTENT.getField() ;
            }
            if (itemType.getId().equals(contentItemType.ItemType.CHECK_LIST.getId())){

                return  contentItemType.ItemType.CHECK_LIST.getField();
            }
            throw  new ClassNotFoundException("不支持的ItemType");
        }

    };


}
