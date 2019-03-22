package com.oceanier.action;

import com.oceanier.entity.Merchant;
import com.oceanier.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
    商家注册登录模块
 */
@Controller
@RequestMapping("merchantRegisterLoginAction")
public class MerchantRegisterLoginAction {

    @Autowired
    MerchantService merchantService;

    @RequestMapping(value = "toRegister")
    public String toRegister() {
        return "merchant/merchantRegister";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(Merchant merchant, HttpServletRequest request) {
        merchantService.insertMerchant(merchant);
        HttpSession session = request.getSession();
        session.setAttribute("merchant", merchant);
        return "adminHomePage/adminHomePage";
    }

    @RequestMapping(value = "toLogin")
    public String toLogin() {
        return "merchant/merchantLogin";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(Merchant merchant, HttpServletRequest request) {
        String returnUrl = "homePage/error";
        String account = merchant.getMerchantAccount();
        String password = merchant.getMerchantPassword();
        Merchant merchantResult = merchantService.queryMerchantByAccount(account);
        if (merchantResult == null) {
            request.setAttribute("errorInfo", "无此商家！");
        } else if (!merchantResult.getMerchantPassword().equals(password)) {
            request.setAttribute("errorInfo", "密码错误！");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("merchant", merchantResult);
            returnUrl = "adminHomePage/adminHomePage";
        }
        return returnUrl;
    }

    @RequestMapping("exit")
    public String exit(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("merchant");
        return "adminHomePage/adminHomePage";
    }

}
