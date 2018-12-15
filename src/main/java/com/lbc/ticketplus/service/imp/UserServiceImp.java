package com.lbc.ticketplus.service.imp;

import com.lbc.ticketplus.dao.mapper.UserMapper;
import com.lbc.ticketplus.entity.User;
import com.lbc.ticketplus.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;



@Service
public class UserServiceImp implements UserService {

    @Resource
    public UserMapper userMapper;

    @Override
    public String UserRegister(User user) {
        int tag = userMapper.insert(user);
        if(tag == 1)
            //add successfully
            return "200";
        // add failed
        return "300";
    }
}
