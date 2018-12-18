package com.lbc.ticketplus.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/cinemaSelection")
    public String getCinemaSelectionPage(Model model) {
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
