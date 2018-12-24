package com.lbc.ticketplus.service.imp;

import com.lbc.ticketplus.dao.mapper.UserMapper;
import com.lbc.ticketplus.entity.User;
import com.lbc.ticketplus.service.UserService;
import org.springframework.stereotype.Service;
import com.lbc.ticketplus.tool.md5Alogorithm;

import javax.annotation.Resource;



@Service
public class UserServiceImp implements UserService {

    @Resource
    public UserMapper userMapper;

    @Override
    public String UserRegister(User user) {

        //判断是否已有此用户
        int countUser = userMapper.countUserByAccount(user.getAccount());
//        System.out.println("count："+countUser);
        if(countUser != 0)
            //已存在此用户
            return "301";
        //密码加密过程
        String pass = user.getPassword();
        String encodePassword = md5Alogorithm.getMd5(pass);
        user.setPassword(encodePassword);
//        System.out.println("123456");
//        System.out.println("newpass:"+encodePassword);
        int tag = userMapper.insert(user);
        if(tag == 1)
            //add successfully
            return "200";
        // add failed
        return "300";
    }

    @Override
    public String UserLogin(User user) {
        int countUser = userMapper.countUserByAccount(user.getAccount());
        if(countUser != 1){
            //不存在此用户
            System.out.println("此用户未注册");
            return "301";
        }


        //密码转换过程
        String passwordTrans = md5Alogorithm.getMd5(user.getPassword());
        System.out.println("aaa:"+passwordTrans);
        int tag = userMapper.selectByAccountPass(user.getAccount(),passwordTrans);
        if(tag == 1){
            //登录成功
            System.out.println("登录成功");
            return "200";
        }
        //登录失败
        System.out.println("密码错误");
        return "300";
    }

    @Override
    public int getIdByAccount(String userAcc) {
        int id = userMapper.getIdByAccount(userAcc);
        System.out.println(id);
        return id;
    }
}
