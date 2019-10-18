package com.yang.service.impl;

import com.yang.dao.ICategoryDao;
import com.yang.dao.IGoodsDao;
import com.yang.dao.IHotGoodsDao;
import com.yang.pojo.Goods4ListAO;
import com.yang.pojo.GoodsDO;
import com.yang.pojo.HotGoodsDO;
import com.yang.service.IHotGoodsService;
import com.yang.utils.TypeExchangeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotGoodsImpl implements IHotGoodsService {
    @Autowired
    private IHotGoodsDao iHotGoodsDao;
    @Autowired
    private IGoodsDao iGoodsDao;
    @Autowired
    private ICategoryDao iCategoryDao;
    /**
     * 获取热门商品top10
     * @return
     */
    @Override
    public List<Goods4ListAO> getTopGoods(){
        List<Goods4ListAO> goods4ListDOList=new ArrayList<Goods4ListAO>();
        List<HotGoodsDO> hotGoodsDOList= iHotGoodsDao.getTopSelect();
        if(hotGoodsDOList==null||hotGoodsDOList.size()==0){
            return new ArrayList<>(0);
        }

        for (HotGoodsDO hotGood:hotGoodsDOList) {
            GoodsDO goodsDO=iGoodsDao.getGoodByIDSelect(hotGood.getGoodsId());
            Goods4ListAO goods4ListAO=TypeExchangeUtil.convertClass(goodsDO,Goods4ListAO.class);
            goods4ListAO.setCategory(iCategoryDao.getCategoryByID(goods4ListAO.getCategoryId()));
            goods4ListDOList.add(goods4ListAO);
        }
        return goods4ListDOList;
    }
}
