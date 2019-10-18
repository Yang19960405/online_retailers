package com.yang.dao;

import com.yang.pojo.HotGoodsDO;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface IHotGoodsDao {
    /**
     * 获取前10所有的热门商品信息
     * @return 商品列表
     */
    @Select("select id,goodsId,createtime from hotgoods order by createtime DESC LIMIT 1,9")
     List<HotGoodsDO> getTopSelect();


}
