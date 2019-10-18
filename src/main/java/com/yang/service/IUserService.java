package com.yang.service;

import com.yang.pojo.VO.UserVO;

import java.util.List;

public interface IUserService {
    /**
     * 根据用户编号和密码获取用户信息
     * @param userName 用户编号
     * @param password 用户密码
     * @return 用户列表
     */
    List<UserVO> getUserInfoByUser(String userName, String password);

    /**
     * 根据用户编号获取用户信息
     * @param userName 用户编号
     * @return 用户列表
     */
    List<UserVO> getUserInfoByUserName(String userName);

    /**
     * 新增用户信息
     * @param userName 用户编号
     * @param password 用户密码
     * @return 用户列表
     */
     void addUser(String userName,String password);
}
