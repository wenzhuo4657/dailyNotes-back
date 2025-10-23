package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateItemDto {

    @NotNull
    @Min(value = 0)
    private Integer id;
    @NotNull
    private String content;
}
