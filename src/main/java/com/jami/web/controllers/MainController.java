package com.jami.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jakub.mis on 5/22/2017.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "Hello";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "init";
    }
}
