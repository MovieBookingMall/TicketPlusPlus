package com.lbc.ticketplus.dao.mapper;

import com.lbc.ticketplus.entity.WatchRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RecommendSystemMapper {

    @Select("select * from watch_record where user_id = #{user_id}")
    List<WatchRecord> findWatchRecordOfUers(@Param("user_id") Integer user_id);
}
