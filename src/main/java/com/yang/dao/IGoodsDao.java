package com.yang.dao;

import com.yang.pojo.GoodsDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IGoodsDao {
    /**
     * 根据ID获取商品信息
     * @param id
     * @return
     */
    @Select("select * from goods where id=#{id}")
    GoodsDO getGoodByIDSelect(@Param("id") int id);

    /**
     * 获取最新创建的前9个商品，由于爬虫没有爬到创建时间暂时用id代替
     * @return
     */
    @Select("select * from goods where (select parentid from category where goods.categoryid=category.id)=1005000 order by id desc limit 10,9")
    List<GoodsDO> listGoodByTime();
}

