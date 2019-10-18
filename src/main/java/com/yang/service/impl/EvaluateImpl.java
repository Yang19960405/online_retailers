package com.yang.service.impl;

import com.yang.dao.IEvaluateDao;
import com.yang.pojo.AO.EvaluateAO;
import com.yang.pojo.EvaluateDO;
import com.yang.service.IEvaluateService;
import com.yang.utils.TypeExchangeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EvaluateImpl implements IEvaluateService {
    @Autowired
    private IEvaluateDao iEvaluateDao;

    @Override
    public List<EvaluateAO> getByGood(int goodsId, int pageSize, int pageIndex) {
        List<EvaluateAO> evaluateAOList=new ArrayList<>();
        List<EvaluateDO> evaluateDOList=iEvaluateDao.getByGood(goodsId,pageSize,pageIndex*pageSize);
        for(EvaluateDO evaluateDO:evaluateDOList){
            evaluateAOList.add(TypeExchangeUtil.convertClass(evaluateDO,EvaluateAO.class));
        }
        return evaluateAOList;
    }
}
