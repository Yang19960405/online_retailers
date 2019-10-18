package com.yang.service.impl;

import com.yang.dao.ICategoryDao;
import com.yang.pojo.CategoryDO;
import com.yang.pojo.CategoryGroupAO;
import com.yang.pojo.ChildCategoryAO;
import com.yang.pojo.ParentCategoryAO;
import com.yang.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class CategoryImpl implements ICategoryService {
    @Autowired
    private ICategoryDao iCategoryDao;

    @Override
    public List<ParentCategoryAO> getCategories() {
        List<CategoryDO> categories = iCategoryDao.getParents();
        if(categories==null || categories.size()==0){
            return new ArrayList<ParentCategoryAO>(0);
        }
        List<ParentCategoryAO> result = new ArrayList<>();
        // 遍历父类
        for(CategoryDO category:categories){
            ParentCategoryAO item = new ParentCategoryAO();
            item.setId(category.getId());
            item.setTitle(category.getTitle());
            item.setGroups(new ArrayList<>());
            result.add(item);
            List<CategoryDO> groups = iCategoryDao.getGroups(item.getId());
            // 构建group
            for(CategoryDO groupItem:groups){
                CategoryGroupAO group = new CategoryGroupAO();
                group.setGroupName(groupItem.getGroup());
                group.setCategories(new ArrayList<>());
                item.getGroups().add(group);
                // 构建item
                List<CategoryDO> children = iCategoryDao.getChildren(item.getId(), group.getGroupName());
                for(CategoryDO childItem:children){
                    ChildCategoryAO child = new ChildCategoryAO();
                    child.setId(childItem.getId());
                    child.setTitle(childItem.getTitle());
                    group.getCategories().add(child);
                }
            }
        }
        return result;
    }
}
