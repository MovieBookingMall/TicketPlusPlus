package com.lbc.ticketplus.service;

import com.lbc.ticketplus.entity.WatchRecord;

import java.util.List;

public interface RecommendSystemService {

    public List<WatchRecord> findWatchRecordOfUers(Integer user_id);

    public String doRecommend(String curUserID, String toRecUserID);
}
