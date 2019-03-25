package com.oceanier.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("welcome")
public class Forehome {

    @RequestMapping("forehome")
    public String toForehome(){
        return "welcome";
    }
}
