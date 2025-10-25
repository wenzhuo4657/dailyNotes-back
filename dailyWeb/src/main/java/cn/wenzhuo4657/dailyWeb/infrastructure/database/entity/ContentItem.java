package cn.wenzhuo4657.dailyWeb.infrastructure.database.entity;

import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.function.typeDaily.FiledFn;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.vo.contentItemType;

import java.util.Objects;


public class ContentItem {


    private Integer id;

    private Integer content_name_Id;

    private String content;

    private String field;


    private String date;


    public ContentItem() {
    }

    public ContentItem(Integer id, Integer content_name_Id, String content, String field, String date) {
        this.id = id;
        this.content_name_Id = content_name_Id;
        this.content = content;
        this.field = field;
        this.date = date;
    }

    public void setField(String field) {
        this.field = field;
    }

    /**
     * 初始化filed
     */
    public void setField(FiledFn function, contentItemType.ItemType itemType) throws ClassNotFoundException {
        String res=function.toFiled(itemType);
        this.field=res;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContent_name_Id() {
        return content_name_Id;
    }

    public void setContent_name_Id(Integer content_name_Id) {
        this.content_name_Id = content_name_Id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getField() {
        return field;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ContentItem that = (ContentItem) o;
        return Objects.equals(id, that.id) && Objects.equals(content_name_Id, that.content_name_Id) && Objects.equals(content, that.content) && Objects.equals(field, that.field) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content_name_Id, content, field, date);
    }
}
