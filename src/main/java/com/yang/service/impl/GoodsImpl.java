package com.yang.service.impl;

import com.yang.dao.ICategoryDao;
import com.yang.dao.IGoodsDao;
import com.yang.dao.IHotGoodsDao;
import com.yang.dao.ISimilarPurchasedDao;
import com.yang.pojo.Goods4ListAO;
import com.yang.pojo.GoodsDO;
import com.yang.pojo.HotGoodsDO;
import com.yang.pojo.SimilarPurchasedDO;
import com.yang.service.IGoodsService;
import com.yang.utils.TypeExchangeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsImpl implements IGoodsService {
    /**
     * 商品数据访问层
     */
    @Autowired
    private IGoodsDao iGoodsDao;
    /**
     * 菜单数据访问层
     */
    @Autowired
    private ICategoryDao iCategoryDao;
    /**
     * 相似商品数据访问层
     */
    @Autowired
    private ISimilarPurchasedDao iSimilarPurchasedDao;


    @Override
    public List<Goods4ListAO> getNewGoods() {
        List<Goods4ListAO> goods4ListDOList=new ArrayList<Goods4ListAO>();
        List<GoodsDO> goodsDOList= iGoodsDao.listGoodByTime();

        if(goodsDOList==null||goodsDOList.size()==0){
            return new ArrayList<>(0);
        }

        for (GoodsDO goodsDO:goodsDOList) {
            Goods4ListAO goods4ListAO=TypeExchangeUtil.convertClass(goodsDO,Goods4ListAO.class);
            goods4ListAO.setCategory(iCategoryDao.getCategoryByID(goods4ListAO.getCategoryId()));
            goods4ListDOList.add(goods4ListAO);
        }
        return goods4ListDOList;
    }

    @Override
    public Goods4ListAO getGoodByID(int id) {
        GoodsDO goodsDO=iGoodsDao.getGoodByIDSelect(id);
        Goods4ListAO goods4ListAO=TypeExchangeUtil.convertClass(goodsDO,Goods4ListAO.class);
        goods4ListAO.setCategory(iCategoryDao.getCategoryByID(goods4ListAO.getCategoryId()));
        //处理滑动图片
        String slide=goodsDO.getSlidePicture();
        slide=slide.substring(1, slide.length()-1);
        String[] sp = slide.split("\\|");
        goods4ListAO.setSlide_1(sp[0].substring(1, sp[0].length()-1));
        goods4ListAO.setSlide_2(sp[1].substring(1, sp[1].length()-1));
        goods4ListAO.setSlide_3(sp[2].substring(1, sp[2].length()-1));
        goods4ListAO.setSlide_4(sp[3].substring(1, sp[3].length()-1));
        //处理detail图片
        if (goodsDO.getDetailPicture()!=null) {
            String details = goodsDO.getDetailPicture();

            List<String> sList=new ArrayList<>();
            if (details.length()>2) {
                details = details.substring(1, details.length() - 1);
                String[] sDetails = details.split("\\|");
                for (String s : sDetails) {
                    sList.add(s.substring(1, s.length()-1));
                }
            }
            goods4ListAO.setDetailPicture(sList);
        }
        return goods4ListAO;
    }

    @Override
    public List<Goods4ListAO> getSimilarByGoodsId(int goodsId) {
        return buildSimilarPurchasedList(iSimilarPurchasedDao.getByGoodsId(goodsId));
    }

    /**
     * 数据模型转换 根据相似数据类获取商品信息
     * @param goods
     * @return
     */
    private List<Goods4ListAO> buildSimilarPurchasedList(List<SimilarPurchasedDO> goods){
        if(goods==null || goods.size()==0){
            return new ArrayList<>(0);
        }

        List<Goods4ListAO> result = new ArrayList<>();
        for(SimilarPurchasedDO good:goods){
            GoodsDO item=iGoodsDao.getGoodByIDSelect(good.getSimilarGoodsId());
            Goods4ListAO g4list = buildGoods(item);
            result.add(g4list);
        }
        return result;
    }

    /**
     * 数据模型转换
     * @param item
     * @return
     */
    private Goods4ListAO buildGoods(GoodsDO item){
        Goods4ListAO result = new Goods4ListAO();
        result.setId(item.getId());
        result.setGoodsName(item.getGoodsName());
        result.setGoodsPrice(item.getGoodsPrice());
        result.setUrl(item.getUrl());
        result.setGoodsIntroduce(item.getGoodsIntroduce());
        result.setCategoryId(item.getCategoryId());
        result.setCategory(iCategoryDao.getCategoryByID(item.getCategoryId()));
        result.setCategoryId(item.getCategoryId());

        return result;
    }
}
