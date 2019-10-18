package com.yang.pojo;

import java.util.List;

public class CategoryGroupAO {
    private String groupName;
    private List<ChildCategoryAO> categories;

    /**
     * 重写equals函数
     *
     * @param other
     * @return
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (getClass() != other.getClass()) {
            return false;
        }
        CategoryGroupAO otherGroup = (CategoryGroupAO) other;
        return otherGroup.getGroupName() == this.getGroupName();
    }

    public int hashCode() {
        int result = 17;
        result += 31 * groupName.hashCode();
        result += 31 * categories.hashCode();
        return result;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<ChildCategoryAO> getCategories() {
        return categories;
    }

    public void setCategories(List<ChildCategoryAO> categories) {
        this.categories = categories;
    }
}
