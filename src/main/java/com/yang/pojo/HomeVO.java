package com.yang.pojo;

import java.util.List;

/**
 * 首页数据模型
 */
public class HomeVO {
    //热门商品
    private List<Goods4ListAO> hotGoods;
    //最新商品
    private List<Goods4ListAO> newGoods;
    //菜单
    private List<ParentCategoryAO> parentCategoryAOS;

    public List<ParentCategoryAO> getParentCategoryAOS() {
        return parentCategoryAOS;
    }

    public void setParentCategoryAOS(List<ParentCategoryAO> parentCategoryAOS) {
        this.parentCategoryAOS = parentCategoryAOS;
    }

    public List<Goods4ListAO> getHotGoods() {
        return hotGoods;
    }

    public void setHotGoods(List<Goods4ListAO> hotGoods) {
        this.hotGoods = hotGoods;
    }

    public List<Goods4ListAO> getNewGoods() {
        return newGoods;
    }

    public void setNewGoods(List<Goods4ListAO> newGoods) {
        this.newGoods = newGoods;
    }
}
