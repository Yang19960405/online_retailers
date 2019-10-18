package com.yang.pojo;

import java.util.Date;

public class GoodsDO {
    /**
     * 数据表Goods映射类
     */
        private int id;
        private String goodsName;
        private String goodsIntroduce;
        private double goodsPrice;
        private int categoryId;
        private String url;
        private String slidePicture;
        private double grade;
        private int rankNum;
        private String detailPicture;

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

        public String getGoodsIntroduce() {
            return goodsIntroduce;
        }

        public void setGoodsIntroduce(String goodsIntroduce) {
            this.goodsIntroduce = goodsIntroduce;
        }

        public double getGoodsPrice() {
            return goodsPrice;
        }

        public void setGoodsPrice(double goodsPrice) {
            this.goodsPrice = goodsPrice;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSlidePicture() {
            return slidePicture;
        }

        public void setSlidePicture(String slidePicture) {
            this.slidePicture = slidePicture;
        }

        public double getGrade() {
            return grade;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }

        public int getRankNum() {
            return rankNum;
        }

        public void setRankNum(int rankNum) {
            this.rankNum = rankNum;
        }

        public String getDetailPicture() {
            return detailPicture;
        }

        public void setDetailPicture(String detailPicture) {
            this.detailPicture = detailPicture;
        }

}
