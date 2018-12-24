package com.lbc.ticketplus.web;

import com.lbc.ticketplus.service.RecommendSystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RecommendSystemController {

    private final Logger log = LoggerFactory.getLogger(RecommendSystemController.class);

    @Autowired
    private RecommendSystemService recommendSystemService;

    @RequestMapping(value = "/doRecommend")
    @ResponseBody
    public String doRecommend(String uId,  HttpServletRequest req) {
        Integer curUserID = (Integer) req.getSession().getAttribute("userId");
        if(null == curUserID || 0 == curUserID){
            log.info("user did not login!");
            return "请登录获取推荐信息。";
        }
        log.info("toRedUserId: " + uId  + "; curUserID: " + curUserID);
        String strCurUserID = String.valueOf(curUserID);
        return recommendSystemService.doRecommend(strCurUserID, uId);
    }

    @RequestMapping(value = "/testre")
    @ResponseBody
    public String testRecommend() {
        log.info("/testRecommend");
        return recommendSystemService.doRecommend("1", "2");
    }}
