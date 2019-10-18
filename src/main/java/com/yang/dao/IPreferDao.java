package com.yang.dao;

import com.yang.pojo.PreferDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPreferDao {
    /**
     * 根据用户编号获取用户喜欢列表
     * @param userId 用户编号
     * @return 喜好列表
     */
    @Select("select * from prefer where userid=#{userId}")
    List<PreferDO> getByUserId(@Param("userId") int userId);

    /**
     * 插入一条用户喜欢数据
     * @param userId 用户编号
     * @param categoryId 父级分类编号
     * @return 喜好列表
     */
    @Insert("insert into Prefer (userid,categoryid,createtime) VALUES(#{userId},#{categoryId},NOW())")
    void insertInfo(@Param("userId") int userId, @Param("categoryId") int categoryId);
}
