package com.lbc.ticketplus.service.imp;

import com.lbc.ticketplus.dao.mapper.RecommendSystemMapper;
import com.lbc.ticketplus.entity.WatchRecord;
import com.lbc.ticketplus.service.RecommendSystemService;
import com.lbc.ticketplus.tool.UserCF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RecommendSystemServiceImpl implements RecommendSystemService {
    @Autowired
    private RecommendSystemMapper recommendSystemMapper;

    @Override
    public List<WatchRecord> findWatchRecordOfUers(Integer user_id) {
        return recommendSystemMapper.findWatchRecordOfUers(user_id);
    }

    @Override
    public String doRecommend(String curUserID, String toRecUserId) {
        if (null == curUserID || null == toRecUserId) {
            return null;
        }
        List<WatchRecord> curUserRecord = this.findWatchRecordOfUers(Integer.valueOf(curUserID));
        List<WatchRecord> toRecUserRecord = this.findWatchRecordOfUers(Integer.valueOf(toRecUserId));
        //获取最大观看电影记录数量
        int N = curUserRecord.size() > toRecUserRecord.size() ? curUserRecord.size() : toRecUserRecord.size();
        List<String> userItems = new ArrayList<>();
        String content1 = curUserID + "";
        for (WatchRecord wr : curUserRecord) {
//            System.out.println(wr.getUser_name() + "\t" + wr.getMovie_name());
            content1 += " " + wr.getMovie_id();
        }
        userItems.add(content1);

        String content2 = toRecUserId + "";
        String record = "";
        for (WatchRecord wr : toRecUserRecord) {
//            System.out.println(wr.getUser_name() + "\t" + wr.getMovie_name());
            content2 += " " + wr.getMovie_id();
            record += wr.getMovie_name() + "<br/>";
        }
        userItems.add(content2);

        Map<String, Double> cosineSimilarity = UserCF.getCosineSimilarity(Integer.valueOf(curUserID), userItems);
        DecimalFormat df = new DecimalFormat("#.00");
        Double similarity = cosineSimilarity.get(toRecUserId) * 10;
        String resultStr = "<b>默契度：" + df.format(similarity) + "</b><br/>";
        resultStr += "观看过的电影：<br/>";
        resultStr += record;
        System.out.println(resultStr);
        return resultStr;
    }

}
