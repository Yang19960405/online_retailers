package com.yang.service.impl;

import com.yang.dao.IUserDao;
import com.yang.pojo.UserDO;
import com.yang.pojo.VO.UserVO;
import com.yang.service.IUserService;
import com.yang.utils.TypeExchangeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserImpl implements IUserService {
    @Autowired
    private IUserDao iUserDao;

    @Override
    public List<UserVO> getUserInfoByUser(String userName, String password){
        return buidUserVO(iUserDao.getUserInfoByUser(userName, password));
    }

    @Override
    public List<UserVO> getUserInfoByUserName(String userName){
        return buidUserVO(iUserDao.getUserInfoByUserName(userName));
    }

    @Override
    public void addUser(String userName,String password){
        iUserDao.addUser(userName,password);
    }

    /**
     * 数据模型转换 将DO转换成VO
     * @param userDOList
     * @return
     */
    public List<UserVO> buidUserVO(List<UserDO> userDOList){
        List<UserVO> userVOList=new ArrayList<UserVO>();
        for(UserDO userDO:userDOList){
            userVOList.add(TypeExchangeUtil.convertClass(userDO,UserVO.class));
        }
        return userVOList;
    }
}
