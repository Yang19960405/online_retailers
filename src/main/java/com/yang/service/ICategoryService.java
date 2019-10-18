package com.yang.service;

import com.yang.pojo.ParentCategoryAO;

import java.util.List;

public interface ICategoryService {
    List<ParentCategoryAO> getCategories();
}
