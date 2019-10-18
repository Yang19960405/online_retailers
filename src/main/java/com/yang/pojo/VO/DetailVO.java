package com.yang.pojo.VO;

import com.yang.pojo.AO.EvaluateAO;
import com.yang.pojo.Goods4ListAO;
import com.yang.pojo.ParentCategoryAO;

import java.util.List;

public class DetailVO {
    private Goods4ListAO goods4ListAO;
    private List<EvaluateAO> evaluateAOList;
    private List<Goods4ListAO> similarList;
    private List<ParentCategoryAO> categorieList;
    private UserVO userVO;

    public UserVO getUserVO() {
        return userVO;
    }

    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }

    public List<ParentCategoryAO> getCategorieList() {
        return categorieList;
    }

    public void setCategorieList(List<ParentCategoryAO> categorieList) {
        this.categorieList = categorieList;
    }

    public List<Goods4ListAO> getSimilarList() {
        return similarList;
    }

    public void setSimilarList(List<Goods4ListAO> similarList) {
        this.similarList = similarList;
    }

    public Goods4ListAO getGoods4ListAO() {
        return goods4ListAO;
    }

    public void setGoods4ListAO(Goods4ListAO goods4ListAO) {
        this.goods4ListAO = goods4ListAO;
    }

    public List<EvaluateAO> getEvaluateAOList() {
        return evaluateAOList;
    }

    public void setEvaluateAOList(List<EvaluateAO> evaluateAOList) {
        this.evaluateAOList = evaluateAOList;
    }
}
