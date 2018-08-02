package com.dyu.config;


import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dyu
 * @date 2018/08/01
 */
@Controller
public class MainsiteErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request){
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode == 401){
            return "/error/401";
        }else if(statusCode == 404){
            System.out.println("hello world...");
            return "/error/404";
        }else if(statusCode == 403){
            return "/error/403";
        }else{
            return "/error/500";
        }

    }
    @Override
    public String getErrorPath() {
        System.out.println("hello - world ...");
        return "/error";
    }


}
