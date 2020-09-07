package com.gxa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;


/**
 * @author:IT-CNLM
 * @date:Created at 2020/08/12
 */
@Controller
public class IndexController {

    /**
     * 渲染登录页面视图
     * @param
     * @return
     */
    @GetMapping("/index")
    public String index(){
        return "index";

    }

    /**
     * 渲染欢迎页面视图
     * @return
     */
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}
