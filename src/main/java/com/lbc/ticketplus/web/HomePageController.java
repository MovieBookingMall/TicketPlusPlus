package com.lbc.ticketplus.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomePageController {

    private final Logger log = LoggerFactory.getLogger(HomePageController.class);
    @RequestMapping(value = "/hello")
    @ResponseBody
    public String helloWorld() {
        log.info("/hello");
        return "hello world";
    }

    @RequestMapping("/index")
    public String  listUser(Model model) {
        return "index";
    }
}
