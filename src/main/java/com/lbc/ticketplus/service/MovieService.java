package com.lbc.ticketplus.service;

import com.lbc.ticketplus.entity.Movie;

public interface MovieService {
    //增加电影
    public String addMovie(Movie movie);

    //更新电影详情
    public String updateMovie(Movie movie);

    //删除电影
    public String deleteMovie(int id);

    //查看电影详情
    public Movie getMovieDetail(int id);
}
