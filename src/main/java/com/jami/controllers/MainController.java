package com.jami.controllers;

import com.jami.Service;
import com.jami.repositories.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jakub.mis on 5/22/2017.
 */
@RestController
@RequestMapping("/main")
public class MainController {

    private Service service;

    public MainController(Service service){
        this.service = service;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){

        service.test();
        return "Hello";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addUser(){
    }
}
