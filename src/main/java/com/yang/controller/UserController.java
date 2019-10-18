package com.yang.controller;

import com.yang.pojo.VO.PreferVO;
import com.yang.pojo.VO.UserVO;
import com.yang.service.IFaceRecognitionService;
import com.yang.service.IPreferService;
import com.yang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    /**
     * 用户逻辑类
     */
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IFaceRecognitionService iFaceRecognitionService;

    /**
     * 个人喜好逻辑类
     */
    @Autowired
    private IPreferService ipreferService;

    /**
     * 用户登录验证，验证成功将用户信息存入session
     * @param arr
     * @param httpSession
     * @return
     */
    @ResponseBody
    @RequestMapping("/user/login")
    public int  Login(@RequestBody UserVO arr, HttpSession httpSession) {
        List<UserVO> users=iUserService.getUserInfoByUser(arr.getUserName(),arr.getPassword());
        if(users==null || users.size()==0){
            return 0;
        }
        else{
            httpSession.setAttribute("user", users.get(0));
            return users.get(0).getUserId();
        }
    }

    /**
     * 退出登录操作
     * @param session
     * @return
     */
    @RequestMapping("/user/logout")
    public boolean execute(HttpSession session){
        session.invalidate();
        return true;
    }

    /**
     * 判断登录状态
     * @param httpSession
     * @return
     */
    @RequestMapping("/user/checkLogin")
    @ResponseBody
    public boolean IsLogin (HttpSession httpSession) {
        if (httpSession.getAttribute("user")!=null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @RequestMapping("/user/check/{data}")
    @ResponseBody
    public boolean  Check(@PathVariable("data") String data) {
        List<UserVO> users=iUserService.getUserInfoByUserName(data);
        if(users==null || users.size()==0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 注册新用户
     * @param arr
     * @return
     */
    @ResponseBody
    @RequestMapping("/user/register")
    public Boolean  Register(@RequestBody UserVO arr) {
        iUserService.addUser(arr.getUserName(),arr.getPassword());
        return true;
    }

    /**
     * 获取个人喜好
     * @param httpSession
     * @return
     */
    @ResponseBody
    @RequestMapping("/user/checkPrefer")
    public boolean CheckPrefer( HttpSession httpSession) {
        int userId=((UserVO)httpSession.getAttribute("user")).getUserId();
        List<PreferVO> prefers=ipreferService.getByUserId(userId);
        if(prefers==null || prefers.size()==0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 设置个人喜好
     * @param arrList
     * @param httpSession
     */
    @ResponseBody
    @RequestMapping("/user/addPrefer")
    public void  AddPrefer(@RequestBody List<PreferVO> arrList, HttpSession httpSession) {
        int userId=((UserVO)httpSession.getAttribute("user")).getUserId();
        for (PreferVO arr : arrList) {
            ipreferService.insertInfo(userId,arr.getCategoryId());
        }
    }

    @ResponseBody
    @RequestMapping("/user/faceLogin")
    public String FaceLogin(){
        iFaceRecognitionService.openCamera();
        return "";
    }
}
