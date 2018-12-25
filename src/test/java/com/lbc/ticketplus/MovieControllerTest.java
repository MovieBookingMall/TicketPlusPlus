package com.lbc.ticketplus;


import com.lbc.ticketplus.entity.Movie;
import com.lbc.ticketplus.web.MovieController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieControllerTest {
    @Autowired
    private MovieController movieController;

//    @Test
    public void addMovieTest(){
        BigDecimal d = new BigDecimal(50);
        Movie movie = new Movie("123", d, "科幻", "你好啊", "张一", "zhang" , "中国");
        String tag = movieController.addMovie(movie);
        System.out.println("test："+tag);
    }

//    @Test
    public void updateMovieTest(){
        BigDecimal d = new BigDecimal(50);
        Movie movie = new Movie(31,"将夜", d, "科幻", "你好啊", "张一", "zhang" , "中国");
        String tag = movieController.updateMovie(movie);
        System.out.println("test："+tag);
    }

//    @Test
    public void deleteMovieTest(){
        int id = 31;
        String tag = movieController.deleteMovieById(id);
        System.out.println("test："+tag);
    }


    @Test
    public void getMovieDetailTest(){
        int id = 33;
        Movie movie = movieController.getMovieDetail(id);
        System.out.println("test："+movie.getName());
    }


}
