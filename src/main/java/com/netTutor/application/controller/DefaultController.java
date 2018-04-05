package com.netTutor.application.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;


//@Controller
//@Controller("/")
public class DefaultController {

    @RequestMapping(method = RequestMethod.GET, produces = "text/html")
    public String redirectToLogin(){
        return "login";
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public Role_Enum redirectToLoginPost(){
//        return "index.html";
//    }

}
