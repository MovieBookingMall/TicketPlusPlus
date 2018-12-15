package com.lbc.ticketplus;

import com.lbc.ticketplus.entity.User;
import com.lbc.ticketplus.web.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    @Autowired
    private UserController userController;

//    @Test
    public void UserRegisterTest() {
        User user = new User("456  ","456","fang",22,"广东广州");


        String status = userController.UserRegister(user);
        System.out.println(status);
    }


    @Test
    public void UserLoginTest() {
        User user = new User("456","456","fang",22,"广东广州");


        String status = userController.UserLogin(user);
        System.out.println(status);
    }
}
