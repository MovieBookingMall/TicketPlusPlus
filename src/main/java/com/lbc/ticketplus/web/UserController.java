package com.lbc.ticketplus.web;

import com.lbc.ticketplus.entity.User;
import com.lbc.ticketplus.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String UserLogin(User user, HttpServletRequest request){
//        System.out.println("123456");
//        System.out.println(user.getAccount()+","+user.getPassword());
        String status = userService.UserLogin(user);
//        System.out.println(status);
        if("200".equals(status)){
//            System.out.println("已存session"+user.getAccount());
            request.getSession().setAttribute("userName",user.getAccount());

            //获取用户的id
            int userId = userService.getIdByAccount(user.getAccount());
            request.getSession().setAttribute("userId",userId);
            System.out.println(userId);
        }
        return status;
    }


    @RequestMapping(value = "/userInfo")
    @ResponseBody
    public void GetUserInfoBySession(HttpServletRequest request,HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        System.out.println("hhhhhhh");
        try {
            PrintWriter out = response.getWriter();
//            request.getSession().setAttribute("userName","fang");
            String userName = (String) request.getSession().getAttribute("userName");
//            int userId =  (Integer) request.getSession().getAttribute("userId");
//            System.out.println(userName);
            out.write(userName);
//            out.write(userId+"");
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
