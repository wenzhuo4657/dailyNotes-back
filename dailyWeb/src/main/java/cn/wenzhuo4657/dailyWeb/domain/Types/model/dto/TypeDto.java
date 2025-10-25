package cn.wenzhuo4657.dailyWeb.domain.Types.model.dto;

public class TypeDto {

    private Integer id;
    private String name;

    public TypeDto() {
    }

    public TypeDto(Integer id, String name) {
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
