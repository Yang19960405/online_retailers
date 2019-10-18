package com.yang.dao;

import com.yang.pojo.SimilarPurchasedDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISimilarPurchasedDao {
    /**
     * 根据商品编号获取商推荐购买商品信息
     * @param goodsId 商品编号
     * @return 商品列表
     */
    @Select("select id,goodsid,similargoodsid,createtime from similarpurchased where goodsid=#{goodsId}")
    List<SimilarPurchasedDO> getByGoodsId(@Param("goodsId") int goodsId);
}
