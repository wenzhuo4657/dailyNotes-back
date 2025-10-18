package cn.wenzhuo4657.dailyWeb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContentName {

    private Integer id;

    private String name;

    private Integer type;

    private Date createTime;

    private Date updateTime;
}
