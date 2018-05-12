package com.thymeleaf001.thymeleaf001.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Thymeleaf001Controller {

    @RequestMapping("/")
    public String getIndex(ModelMap modelMap){
        modelMap.addAttribute("host","https://www.google.com/");
        return "index";
        // Go To:  /resources/templates/index
    }

    @RequestMapping("/page2")
    public String getPage2(ModelMap modelMap){
        modelMap.addAttribute("host","https://www.google.com/");
        return "page2";
        // Go To:  /resources/templates/index
    }

    //Only Show String on the Browser
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello world!!!!";
    }

}