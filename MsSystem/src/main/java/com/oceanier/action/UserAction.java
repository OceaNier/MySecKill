package com.oceanier.action;

import com.oceanier.entity.User;
import com.oceanier.service.UserService;
import com.oceanier.vo.user.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("userAction")
public class UserAction {

    @Autowired
    UserService userService;

    @RequestMapping("toAdd")
    public String toAdd(){
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(User user){
        userService.insertUser(user);
        System.out.println(user);
        return "redirect:queryByVo";
    }

    @RequestMapping("toUpdate")
    public String toUpdate(HttpServletRequest request, int id){
        User user = userService.queryUserById(id);
        request.setAttribute("user", user);
        return "user/update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(User user){
        userService.updateUser(user);
        System.out.println(user);
        return "redirect:queryByVo";
    }

    @RequestMapping("delete")
    public String delete(int id){
        userService.deleteUserById(id);
        return "redirect:queryByVo";
    }

    @RequestMapping("query")
    public String queryMerchantById(HttpServletRequest request, int id){
        User user = userService.queryUserById(id);
        request.setAttribute("user", user);
        return "user/view";
    }

    @RequestMapping("queryByVo")
    public String queryUserByVo(HttpServletRequest request, UserVo userVo){
        List<User> list = userService.queryUserByVo(userVo);
        request.setAttribute("userList", list);
        return "user/list";
    }
}
