package cn.wenzhuo4657.dailyWeb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContentItem {


    private Integer id;

    private Integer content_name_Id;

    private String content;

    private String field;

    private Date data;
}
