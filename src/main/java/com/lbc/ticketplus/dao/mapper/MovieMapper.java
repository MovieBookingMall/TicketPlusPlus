package com.lbc.ticketplus.dao.mapper;

import com.lbc.ticketplus.entity.Movie;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MovieMapper {
//    long countByExample(MovieExample example);

//    int deleteByExample(MovieExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Movie record);

    int insertWithoutId(Movie movie);

    int insertSelective(Movie record);

//    List<Movie> selectByExample(MovieExample example);

    Movie selectByPrimaryKey(Integer id);

//    int updateByExampleSelective(@Param("record") Movie record, @Param("example") MovieExample example);

//    int updateByExample(@Param("record") Movie record, @Param("example") MovieExample example);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);
}