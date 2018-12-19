package com.lbc.ticketplus.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PageController {

    private final Logger log = LoggerFactory.getLogger(PageController.class);

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String helloWorld() {
        log.info("/hello");
        return "hello world";
    }

    @RequestMapping("/index")
    public String getHomePage(Model model) {
        return "index";
    }


    @RequestMapping(value="/cinemaSelection", method={RequestMethod.GET})
    public String  getCinemaSelectionPage(Model model, String name) {
        //修改HTML中某个标签为参数值
        //写接口，传入电影名，返回数据
        // name为本函数中的形参名，也是在url中的参数名. "movie_name"为传到thymeleaf后的参数名
        model.addAttribute("movie_name",name);
        String time="";
        if(name.equals("test"))
        {
            time="100";
        }
        model.addAttribute("time",time);
        return "cinemaSelection";
    }

    @RequestMapping("/cinemaInfo")
    public String getCinemaInfoPage(Model model) {
        return "cinemaInfo";
    }

    @RequestMapping("/selectSeat")
    public String getSelectSeatPage(Model model) {
        return "selectSeat";
    }

    @RequestMapping("/alipay")
    public String getAlipayPage(Model model) {
        return "alipay";
    }

    @RequestMapping("/loginPage")
    public String getLoginPage(Model model) {
        return "loginPage";
    }
}
