package cn.wenzhuo4657.dailyWeb.domain.Types.model.dto;

public class ContentNameDto {

    private Integer id;

    private String name;

    public ContentNameDto() {
    }

    public ContentNameDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
