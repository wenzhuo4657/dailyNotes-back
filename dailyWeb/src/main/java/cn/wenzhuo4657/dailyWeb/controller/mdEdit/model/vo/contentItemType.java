package cn.wenzhuo4657.dailyWeb.controller.mdEdit.model.vo;


/**
 * ItemType遵循ContentTyp表中类型，  todo 但目前未设置初始化逻辑
 */
public   class   contentItemType{

//        根据ItemType生成对应的Filed属性


        public enum ItemType{
            BASIC_CONTENT(0,new ContentItemFiled.ItemFiled[0],"basic_content"),
            CHECK_LIST(1, new ContentItemFiled.ItemFiled[]{ContentItemFiled.ItemFiled.status, ContentItemFiled.ItemFiled.data},"check_list");



            ItemType(Integer id, ContentItemFiled.ItemFiled[] field, String des) {
                this.id = id;
                this.field = field;
                this.des = des;
            }

            Integer id;
            ContentItemFiled.ItemFiled[]  field;//item field的模版
            String des;

            public Integer getId() {
                return id;
            }

            public ContentItemFiled.ItemFiled[] getField() {
                return field;
            }

            public String getDes() {
                return des;
            }


//            todo 这里可以拓展，启用哪些ItemType，
//            具体来说，可以写到环境里，然后做成一个路由接口返回给前端，这样在解析contentItemType，也就是

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