package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.vo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class DocsItemFiled {

    private static final Logger log = LoggerFactory.getLogger(DocsItemFiled.class);

    public static final String FILED_SPLIT_1=":";
    public static final String FILED_SPLIT_2=" ";



    /**
     * 合法属性记录
     * ps（1）： 关于属性值的解析和变更不去控制，仅仅保证所有field属性都为合法属性，且设置默认值
     * ps（2） 所有属性值都为字符串形式
     */
    public  enum ItemFiled{
        title("title","摸鱼~~~~~"),
        status("status","false"),
        data("data","null");


        private String filed;
        private String Default;


        ItemFiled(String filed, String Default) {
            this.filed = filed;
            this.Default = Default;
        }

        public String getFiled() {
            return filed;
        }

        public String getDefault() {
            return Default;
        }

        public static ItemFiled toItemFiled(String filed) {
            for (ItemFiled itemFiled : ItemFiled.values()) {
                if (itemFiled.getFiled().equals(filed)){
                    return itemFiled;
                }
            }
            log.error("不支持的属性");
            return null;
        }



    }

    public static String toFiled(ItemFiled[] itemFileds){
        StringBuilder filed=new StringBuilder();
        for (ItemFiled itemFiled : itemFileds) {
            filed.append(itemFiled.getFiled()).append(FILED_SPLIT_1).append(itemFiled.getDefault()).append(FILED_SPLIT_2);
        }
        return filed.toString();
    }

    public static Map<String,String> toMap(String  filed) throws ClassNotFoundException {
        HashMap<String, String> map=new HashMap<>();
        String[] split = filed.split(FILED_SPLIT_2);
        for (String s : split) {
            String[] split1 = s.split(FILED_SPLIT_1);
            if (ItemFiled.toItemFiled(split1[0])==null){
                throw new ClassNotFoundException("不支持的属性");
            }
            map.put(split1[0],split1[1]);
        }
        return map;
    }


    /**
     * 该函数有点危险，会返回带有未知属性的filed,但是校验的话感觉又没必要
     */
    public static String  toFiled(Map<String,String> map){
        StringBuilder filed=new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            filed.append(entry.getKey()).append(FILED_SPLIT_1).append(entry.getValue()).append(FILED_SPLIT_2);
        }
        return filed.toString();
    }
}
