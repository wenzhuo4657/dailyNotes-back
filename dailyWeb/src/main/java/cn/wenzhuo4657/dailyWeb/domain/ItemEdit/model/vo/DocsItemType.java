package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.vo;


/**
 * ItemType遵循ContentTyp表中类型，
 */
public   class   DocsItemType{

//        根据ItemType生成对应的Filed属性

        private static DocsItemFiled.ItemFiled[] Daily_Base_Field=
                new DocsItemFiled.ItemFiled[]{ DocsItemFiled.ItemFiled.data
        };
        private static DocsItemFiled.ItemFiled[] Check_List_Field=
                new DocsItemFiled.ItemFiled[]{ DocsItemFiled.ItemFiled.status,
             DocsItemFiled.ItemFiled.data,
             DocsItemFiled.ItemFiled.title
        };


        public  enum  ItemType{
            dailyBase("dailyBase", Daily_Base_Field),
            checkList("checkList", Check_List_Field)
            ;

            ItemType(String typeName, DocsItemFiled.ItemFiled[] filed) {
                this.typeName = typeName;
                this.filed = filed;
            }

            private String typeName;

            private DocsItemFiled.ItemFiled[] filed;

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public DocsItemFiled.ItemFiled[] getFiled() {
                return filed;
            }

            public void setFiled(DocsItemFiled.ItemFiled[] filed) {
                this.filed = filed;
            }

            public static ItemType valueOfByName(String name) throws ClassNotFoundException {
                for(ItemType item:ItemType.values()){
                    if(item.getTypeName().equals(name)){
                        return item;
                    }
                }
                throw new ClassNotFoundException("No enum constant " + name);
            }
        }


}