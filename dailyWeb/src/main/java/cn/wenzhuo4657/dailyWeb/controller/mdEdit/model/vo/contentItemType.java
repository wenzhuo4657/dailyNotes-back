package cn.wenzhuo4657.dailyWeb.controller.mdEdit.model.vo;

import cn.wenzhuo4657.dailyWeb.entity.ContentItem;
import lombok.Data;

public   class   contentItemType{

//        根据ItemType生成对应的Filed属性


        public enum ItemType{
            BASIC_CONTENT(0,"basic_content"),
            CHECK_LIST(1,"check_list");

            ItemType(int id,String des){
                this.id = id;
                this.des = des;
            }

            Integer id;
            String des;

            public Integer getId() {
                return id;
            }



            public String getDes() {
                return des;
            }


            public static ItemType toItemType(int id) throws ClassNotFoundException {
                for (ItemType itemType : ItemType.values()){
                    if (itemType.id.equals(id)){
                        return itemType;
                    }
                }
                throw  new ClassNotFoundException("不支持的ItemType");
            }
        }

        public static String toFiled(ItemType itemType) throws ClassNotFoundException {

            if (itemType.id.equals(ItemType.BASIC_CONTENT.id)){
                return  "";
            }
            if (itemType.id.equals(ItemType.CHECK_LIST.id)){
//              TODO  设置属性分割+属性解析菜单类，目前仅支持status属性进行应编码解析
//                属性分割：     ' '用于第一次分割，获取属性和值的字符串，':'表示第二次分割，获取属性和值。
//                举例：  status:yes syntax:markdown   ,每次解析前必须去除前后空格，避免空
//                属性解析，使用菜单类，或者reacd记录类，避免硬编码丢失
                return  "status:";
            }
            throw  new ClassNotFoundException("不支持的ItemType");
        }

        public static String toTitle(ItemType itemType, ContentItem field) throws ClassNotFoundException {
            if (itemType.id.equals(ItemType.BASIC_CONTENT.id)){
                return  field.getDate().toString();
            }
            if (itemType.id.equals(ItemType.CHECK_LIST.id)){
                return  field.getField();//这里实际上是将title作为前端的内容信息，此处备忘录为是否完成
            }
            throw  new ClassNotFoundException("不支持的ItemType");
        }
    }