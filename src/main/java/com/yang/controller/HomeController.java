package com.yang.controller;

import com.yang.pojo.AO.EvaluateAO;
import com.yang.pojo.Goods4ListAO;
import com.yang.pojo.HomeVO;
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

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IGoodsService iGoodsService;
    @Autowired
    private IHotGoodsService iHotGoodsService;
    @Autowired
    private IEvaluateService iEvaluateService;

    @RequestMapping(value = "/home")
    public String home(){
        return "index";
    }

    @RequestMapping(value = "/head")
    public String head(){
        return "head";
    }


    /**
     * 加载首页热门，最新，猜你喜欢数据
     * @return
     */
    @RequestMapping(value = "/home/data")
    @ResponseBody
    public HomeVO getHomeVO(){
        HomeVO homeVO=new HomeVO();
        homeVO.setHotGoods(iHotGoodsService.getTopGoods());
        homeVO.setNewGoods(iGoodsService.getNewGoods());
        return homeVO;
    }

    /**
     * 获取首页菜单数据
     * @return
     */
    @RequestMapping(value = "/headSearch/data")
    @ResponseBody
    public HomeVO getHeadHomeVO(){
        HomeVO homeVO=new HomeVO();
        homeVO.setParentCategoryAOS(iCategoryService.getCategories());
        return homeVO;
    }

    /**
     * 获取用户登录信息信息
     * @param httpSession
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/head/user")
    public UserVO getUserVO(HttpSession httpSession){
        if(httpSession.getAttribute("user")!=null){
            return (UserVO) httpSession.getAttribute("user");
        }
        else{
            return new UserVO();
        }
    }

    /**
     *物品详情页跳转
     * @return
     */
    @RequestMapping("/home/productView/{gId}")
    public String ProductView(){
        return "detail";
    }
}
