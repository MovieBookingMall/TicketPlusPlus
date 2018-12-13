package com.lbc.ticketplus.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class recommendSystemController {

    private final Logger log = LoggerFactory.getLogger(recommendSystemController.class);

    @RequestMapping(value = "/doRecommend")
    @ResponseBody
    public String doRecommend(String uId) {
        log.info("/doRecommend for " + uId);
        return "hello world";
    }
}
