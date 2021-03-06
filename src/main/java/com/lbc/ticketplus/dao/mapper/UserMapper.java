package com.lbc.ticketplus.dao.mapper;

import com.lbc.ticketplus.entity.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
//    long countByExample(UserExample example);

//    int deleteByExample(UserExample example);

    int insert(User record);

    int insertSelective(User record);

//    List<User> selectByExample(UserExample example);

//    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

//    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int selectByAccountPass(@Param("acc") String acc,@Param("pass") String pass);

    int countUserByAccount(@Param("acc")String acc);

    int getIdByAccount(@Param("acc")String acc);
}

