package com.lbc.ticketplus.web;


import com.lbc.ticketplus.entity.Movie;
import com.lbc.ticketplus.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/movie")
public class MovieController {
    @Resource
    public MovieService movieService;

    @RequestMapping("/addMovie")
    public String addMovie(Movie movie){
        String tag = movieService.addMovie(movie);
        if("200".equals(tag)){
            //新增成功
            System.out.println("新增成功");
        }else {
            //新增失败
            System.out.println("新增失败");
        }

        return tag;
    }


    @RequestMapping("/updateMovie")
    public String updateMovie(Movie movie){
        String tag = movieService.updateMovie(movie);
        if("200".equals(tag)){
            //更新成功
            System.out.println("更新成功");
        }else {
            //更新失败
            System.out.println("更新失败");
        }
        return tag;
    }

    @RequestMapping("/deleteMovie")
    public String deleteMovieById(int id){
        String tag = movieService.deleteMovie(id);
        if("200".equals(tag)){
            //删除成功
            System.out.println("删除成功");
        }else {
            //删除失败
            System.out.println("删除失败");
        }
        return tag;
    }

    @RequestMapping("/getMovieDetail")
    public Movie getMovieDetail(int id){
        Movie movie = movieService.getMovieDetail(id);
        return movie;
    }
}
