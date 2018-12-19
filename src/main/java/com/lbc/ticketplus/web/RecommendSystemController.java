package com.lbc.ticketplus.web;

import com.lbc.ticketplus.service.RecommendSystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RecommendSystemController {

    private final Logger log = LoggerFactory.getLogger(RecommendSystemController.class);

    @Autowired
    private RecommendSystemService recommendSystemService;

    @RequestMapping(value = "/doRecommend")
    @ResponseBody
    public String doRecommend(String uId) {
        log.info("/doRecommend for " + uId);
        return recommendSystemService.doRecommend("1", "2");
    }

    @RequestMapping(value = "/testre")
    @ResponseBody
    public String testRecommend() {
        log.info("/testRecommend");
        return recommendSystemService.doRecommend("1", "2");
    }}
