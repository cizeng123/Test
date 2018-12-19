package com.example.springcloudprovider.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {
    @RequestMapping(value = "/call",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String call(){
        return "resultaurantA is open!";
    }
}
