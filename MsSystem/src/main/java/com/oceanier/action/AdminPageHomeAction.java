package com.oceanier.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("adminPageHomeAction")
public class AdminPageHomeAction {

    @RequestMapping("toHome")
    public String toHome(){
        return "adminHomePage/adminHomePage";
    }
}
