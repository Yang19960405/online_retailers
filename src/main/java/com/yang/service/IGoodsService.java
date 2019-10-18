package com.yang.service;

import com.yang.pojo.Goods4ListAO;

import java.util.List;

public interface IGoodsService {
    /**
     * 获取最新商品展示
     * @return
     */
    List<Goods4ListAO> getNewGoods();

    /**
     * 根据id获取详细商品信息
     * @param id
     * @return
     */
    Goods4ListAO getGoodByID(int id);

    /**
     * 根据商品编号获取商推荐购买商品信息
     * @param goodsId
     * @return
     */
    List<Goods4ListAO> getSimilarByGoodsId(int goodsId);
}
