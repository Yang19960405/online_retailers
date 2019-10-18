package com.yang.service;

import com.yang.pojo.AO.EvaluateAO;

import java.util.List;

public interface IEvaluateService {
    /**
     * 获取某个商品的所有评价信息
     * @param pageSize 每页大小
     * @param pageIndex 当前页码
     * @return 用于展示的商品列表
     */

    List<EvaluateAO> getByGood(int goodsId, int pageSize, int pageIndex);
}
