package com.oceanier.action;

import com.oceanier.entity.User;
import com.oceanier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("userRegisterLoginAction")
public class UserRegisterLoginAction {

    @Autowired
    UserService userService;

    @RequestMapping(value = "toRegister")
    public String toRegister() {
        return "user/userRegister";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(User user, HttpServletRequest request) {
        userService.insertUser(user);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        System.out.println(user);
        return "homePage/homePage";
    }

    @RequestMapping(value = "toLogin")
    public String toLogin() {
        return "user/userLogin";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User user, HttpServletRequest request) {
        String returnUrl = "homePage/error";
        String account = user.getUserAccount();
        String password = user.getUserPassword();
        User userResult = userService.queryUserByAccount(account);
        if (userResult == null) {
            System.out.println("无此用户！");
            request.setAttribute("errorInfo", "无此用户！");
        } else if (!userResult.getUserPassword().equals(password)) {
            System.out.println("密码错误！");
            request.setAttribute("errorInfo", "密码错误！");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", userResult);
            returnUrl = "redirect:/pageHomeAction/toHome";
        }
        return returnUrl;
    }

    @RequestMapping("exit")
    public String exit(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "redirect:/pageHomeAction/toHome";
    }
}
