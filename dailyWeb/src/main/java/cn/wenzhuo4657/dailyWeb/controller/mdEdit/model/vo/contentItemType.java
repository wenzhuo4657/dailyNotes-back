package cn.wenzhuo4657.dailyWeb.controller.mdEdit.model.vo;

import cn.wenzhuo4657.dailyWeb.entity.ContentItem;
import lombok.Data;

public   class   contentItemType{

//        根据ItemType生成对应的Filed属性


        public enum ItemType{
            BASIC_CONTENT(0,"","basic_content"),
            CHECK_LIST(1,"status:no data:null","check_list");



            ItemType(Integer id, String field, String des) {
                this.id = id;
                this.field = field;
                this.des = des;
            }

            Integer id;
            String field;//item field的模版
            String des;

            public Integer getId() {
                return id;
            }

            public String getField() {
                return field;
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




    }