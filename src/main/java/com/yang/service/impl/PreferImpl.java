package com.yang.service.impl;

import com.yang.dao.IPreferDao;
import com.yang.pojo.PreferDO;
import com.yang.pojo.UserDO;
import com.yang.pojo.VO.PreferVO;
import com.yang.pojo.VO.UserVO;
import com.yang.service.IPreferService;
import com.yang.utils.TypeExchangeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreferImpl implements IPreferService {
    @Autowired
    private IPreferDao iPreferDao;


    @Override
    public List<PreferVO> getByUserId(int userId){
        return buildPreferList(iPreferDao.getByUserId(userId));
    }

    @Override
    public void insertInfo(int userId,int categoryId){
        iPreferDao.insertInfo(userId,categoryId);
    }

    /**
     * 数据模型转换 将DO转换成VO
     * @param userDOList
     * @return
     */
    public List<PreferVO> buildPreferList(List<PreferDO> userDOList){
        List<PreferVO> preferVOList=new ArrayList<PreferVO>();
        for(PreferDO preferDO:userDOList){
            preferVOList.add(TypeExchangeUtil.convertClass(preferDO,PreferVO.class));
        }
        return preferVOList;
    }
}
