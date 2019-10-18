package com.yang.dao;

import com.yang.pojo.CategoryDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICategoryDao {
    /**
     * 根据ID获取对应菜单
     * @param id
     * @return
     */
    @Select("select * from category where id=#{id}")
    CategoryDO getCategoryByID(@Param("id") int id);

    /**
     * 获取所有的一级分类信息
     * @return 一级分类列表
     */
    @Select("Select id, title from category where parentId is null")
    List<CategoryDO> getParents();

    /**
     * 根据一级分类信息获取所有的分组信息
     * @param parentId 父类编号
     * @return 父类信息
     */
    @Select("Select distinct `group` from category where parentId=#{pId}")
    List<CategoryDO> getGroups(@Param("pId") int parentId);

    /**
     * 根据一级分类和分组信息查询对应的商品信息
     * @param parentId 父类编号
     * @param groupName 分类名称
     * @return 子类列表
     */
    @Select("Select id, title from category where parentId=#{pId} and `group`=#{group}")
    List<CategoryDO> getChildren(@Param("pId") int parentId, @Param("group") String groupName);
}
