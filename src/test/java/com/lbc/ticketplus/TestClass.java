package com.lbc.ticketplus;

import com.lbc.ticketplus.tool.md5Alogorithm;
import org.junit.Test;

public class TestClass {

    @Test
    public  void testMethod1(){
        System.out.println(md5Alogorithm.getMd5("123456"));
    }
}
