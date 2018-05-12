package com.thymeleaf001.thymeleaf001.controller;

import com.thymeleaf001.thymeleaf001.models.HelloMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Thymeleaf001Controller {



    @RequestMapping("/")
    public String getIndex(ModelMap modelMap,Model model){
        modelMap.addAttribute("host","https://www.google.com/");
        model.addAttribute("message","really good!!!");

        return "index";
        // Go To:  /resources/templates/index
    }

    @RequestMapping("/page2")
    public String getPage2(ModelMap modelMap,Model model){
        modelMap.addAttribute("host","https://www.google.com/");

        return "page2";
        // Go To:  /resources/templates/index
    }

    //Only Show String on the Browser
    @RequestMapping(value="/hello", method= RequestMethod.GET)
    @ResponseBody
    public String helloString(HttpServletRequest request, Model model){
        String name = request.getParameter("name");

        if(!StringUtils.isEmptyOrWhitespace(name)){
            name = name+" !! ";
        }else{
            name = "";
        }


        return "<h3> Hello World!!!!  "+name+"</h3>";
    }


    @RequestMapping(value = "/helloform",method=RequestMethod.GET)
    public String helloForm(){
        return "hello";
    }

    //Go to a html page
    //Only Show String on the Browser
    @RequestMapping(value="/helloform", method= RequestMethod.POST)
    public String helloForm(HttpServletRequest request, Model model){
        String name = request.getParameter("name");

        if(!StringUtils.isEmptyOrWhitespace(name)){
            name = name+" !! ";
        }else{
            name = "";
        }

        model.addAttribute("message", HelloMessage.getMessage(name));
        //model.addAttribute("name",name);
        return "hello";
    }
}