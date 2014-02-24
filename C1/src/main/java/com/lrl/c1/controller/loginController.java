package com.lrl.c1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author logic
 */
@Controller
public class loginController{
    
    @RequestMapping(value ="/" , method = RequestMethod.GET)
    public String indexPage(){
        return "index";
    }
    
//    @RequestMapping(value="/mediaPlan", method=RequestMethod.GET)
//    public String mediaPlan(){
//        return "mediaPlan";
//    }
}