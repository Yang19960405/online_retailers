package com.yang.dao;

import com.yang.pojo.EvaluateDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IEvaluateDao {
    /**
     * 根据物品编号按分页获取所有的评价信息
     * @param pageSize 每页显示的条数
     * @param pageOff 当前页码
     * @return 评价列表
     */
    @Select("select a.id,a.userid,l.username,a.goodsid,a.cartid,a.grade,a.comment,a.createtime from assess as a,login as l"
            + " where a.userid=l.userid and goodsid=#{gId}"
            + " LIMIT #{pSize} offset #{offset}")
    public List<EvaluateDO> getByGood(@Param("gId") int goodsId, @Param("pSize") int pageSize, @Param("offset") int pageOff);
}
