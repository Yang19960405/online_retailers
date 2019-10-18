package com.yang.controller;

import com.yang.pojo.AO.EvaluateAO;
import com.yang.pojo.Goods4ListAO;
import com.yang.pojo.ParentCategoryAO;
import com.yang.pojo.VO.DetailVO;
import com.yang.pojo.VO.UserVO;
import com.yang.service.ICategoryService;
import com.yang.service.IEvaluateService;
import com.yang.service.IGoodsService;
import com.yang.service.IHotGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DetailController {
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IGoodsService iGoodsService;
    @Autowired
    private IHotGoodsService iHotGoodsService;
    @Autowired
    private IEvaluateService iEvaluateService;

    /**
     *获取物品详情页数据
     * @param model
     * @return
     */
    @RequestMapping("/detail/data")
    @ResponseBody
    public DetailVO ProductView(Model model, HttpServletRequest request, HttpSession httpSession){
        int goodsId=Integer.parseInt( request.getParameter("gId"));
        DetailVO detailVO=new DetailVO();
        //商品信息
        Goods4ListAO goods = iGoodsService.getGoodByID(goodsId);
        detailVO.setGoods4ListAO(goods);
        //评论信息
        List<EvaluateAO> evaluates = iEvaluateService.getByGood(goodsId,10,0);
        detailVO.setEvaluateAOList(evaluates);
        List<Goods4ListAO> similarGoods = iGoodsService.getSimilarByGoodsId(goodsId);
        detailVO.setSimilarList(similarGoods);
        List<ParentCategoryAO> categories = iCategoryService.getCategories();
        detailVO.setCategorieList(categories);
        UserVO user=new UserVO();
        if (httpSession.getAttribute("user")!=null) {
            user=((UserVO)httpSession.getAttribute("user"));
        }
        detailVO.setUserVO(user);

        return detailVO;
    }



}
