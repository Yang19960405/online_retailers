package com.yang.pojo;

import java.util.Date;

public class SimilarPurchasedDO {
    private int id;
    private int goodsId;
    private int similarGoodsId;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getSimilarGoodsId() {
        return similarGoodsId;
    }

    public void setSimilarGoodsId(int similarGoodsId) {
        this.similarGoodsId = similarGoodsId;
    }
}
