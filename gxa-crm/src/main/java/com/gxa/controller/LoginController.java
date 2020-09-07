package com.gxa.controller;

import com.gxa.dto.ResultDto;
import com.gxa.pojo.Admin;
import com.gxa.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 渲染登录页面视图
     * @return
     */
    @GetMapping("/page/login")
    public  String loginPage(){
        return "login";

    }


    /**
     * 登录接口
     * @param admin
     * @param session
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public ResultDto login(Admin admin, HttpSession session){
        return loginService.login(admin,session);
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @PostMapping("/loginOut")
    @ResponseBody
    public  ResultDto loginOut(HttpSession session){
        return  loginService.loginOut(session);
    }


}
