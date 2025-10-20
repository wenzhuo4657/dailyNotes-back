package cn.wenzhuo4657.dailyWeb.domain.mdEdit.model.Dto;


import lombok.Data;

import java.sql.Date;

@Data
public class InsertItemDto {


    private  Integer content_name_Id;
    private  Integer type;

    private Date date;


}
