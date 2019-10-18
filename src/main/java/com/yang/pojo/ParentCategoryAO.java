package com.yang.pojo;

import java.util.List;

public class ParentCategoryAO {
    private int id;
    private String title;
    private List<CategoryGroupAO> groups;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CategoryGroupAO> getGroups(){
        return this.groups;
    }

    public void setGroups(List<CategoryGroupAO> groups){
        this.groups = groups;
    }
}
