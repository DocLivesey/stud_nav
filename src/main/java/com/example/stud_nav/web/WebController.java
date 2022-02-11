package com.example.stud_nav.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @RequestMapping("/")
    public String home(){
        return ("Index");
    }

    @GetMapping("/user")
    public String user(){
        return ("Welcome User");
    }
}
