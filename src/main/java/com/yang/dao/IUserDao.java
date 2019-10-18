package com.yang.dao;


import com.yang.pojo.UserDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {
    /**
     * 根据用户编号和密码获取用户信息
     * @param userName 用户Name编号
     * @param password 用户密码
     * @return 用户列表
     */
    @Select("select userId,username,password from login where username=#{userName} and password=#{password}")
    List<UserDO> getUserInfoByUser(@Param("userName") String userName, @Param("password") String password);

    /**
     * 根据用户编号获取用户信息
     * @param userName 用户编号
     * @return 用户列表
     */
    @Select("select userId,username,password from login where username=#{userName}")
    List<UserDO> getUserInfoByUserName(@Param("userName") String userName);

    /**
     * 新增用户信息
     * @param userName 用户编号
     * @param password 用户密码
     * @return 用户列表
     */
    @Insert("insert into login (username,password) VALUES(#{userName},#{password})")
    void addUser(@Param("userName") String userName,@Param("password") String password);
}
