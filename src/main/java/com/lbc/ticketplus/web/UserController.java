package com.lbc.ticketplus.web;

import com.lbc.ticketplus.entity.User;
import com.lbc.ticketplus.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    public UserService userService;

    @RequestMapping("/{id}")
    public String  getUser(@PathVariable Integer id, Model model) {

        model.addAttribute("user",new User("123","123","fang",22,"广东广州"));
        return "/user/detail";
    }

    @RequestMapping("/list")
    public String  listUser(Model model) {
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i <10; i++) {
            userList.add(new User("456","456","fang",22,"广东广州"));
        }
        model.addAttribute("users", userList);
        return "userList";
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public String UserRegister(User user){
        String status = userService.UserRegister(user);
        System.out.println(status);
        return status;
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public String UserLogin(User user){
        String status = userService.UserLogin(user);
        System.out.println(status);
        return status;
    }

}
