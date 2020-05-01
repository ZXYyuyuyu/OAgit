package com.dwz.xietongoa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @Author: DWZ
 * @Date: 2020/4/9 22:49
 * 主页的Controller
 */
@Controller
public class IndexController {
    /**
     * 登陆跳转
     */
    @RequestMapping(value = "/")
    public String in(){
        return "login";
    }
    /**
     * 主页
     */
    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    /**
     * 没有权限访问
     */
    @RequestMapping(value = "/403")
    public String error403(){
        return "403";
    }
}
