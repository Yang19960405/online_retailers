package com.yang.pojo;

import java.util.List;

public class Goods4ListAO {
    private int id;
    private String goodsName;
    private double goodsPrice;
    private String url;
    private String goodsIntroduce;
    private int categoryId;
    private String slide_1;
    private String slide_2;
    private String slide_3;
    private String slide_4;
    private CategoryDO category;
    private List<String> detailPicture;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public int getCategoryId() { return categoryId;}

    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public String getSlide_1() {
        return slide_1;
    }

    public void setSlide_1(String slide_1) {
        this.slide_1 = slide_1;
    }

    public String getSlide_2() {
        return slide_2;
    }

    public void setSlide_2(String slide_2) {
        this.slide_2 = slide_2;
    }

    public String getSlide_3() {
        return slide_3;
    }

    public void setSlide_3(String slide_3) {
        this.slide_3 = slide_3;
    }

    public String getSlide_4() {
        return slide_4;
    }

    public void setSlide_4(String slide_4) {
        this.slide_4 = slide_4;
    };

    public CategoryDO getCategory() {
        return category;
    }

    public void setCategory(CategoryDO category) {
        this.category = category;
    }

    public List<String> getDetailPicture() {
        return detailPicture;
    }

    public void setDetailPicture(List<String> detailPicture) {
        this.detailPicture = detailPicture;
    }


}
