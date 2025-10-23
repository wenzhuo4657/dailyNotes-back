package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Date;

@Data
public class InsertItemDto {


    @NotNull
    private  Integer content_name_Id;
    @NotNull
    @Min(value = 0)
    private  Integer type;
    private Date date;



}
