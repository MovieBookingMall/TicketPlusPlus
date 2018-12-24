package com.lbc.ticketplus.service;


import com.lbc.ticketplus.entity.User;

public interface UserService {
    //新增用户
    public String UserRegister(User user);

    //用户登录
    public String UserLogin(User user);

    public int getIdByAccount(String userAcc);
}
