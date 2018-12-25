package com.lbc.ticketplus.service.imp;

import com.lbc.ticketplus.dao.mapper.MovieMapper;
import com.lbc.ticketplus.entity.Movie;
import com.lbc.ticketplus.service.MovieService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class MovieServiceImp implements MovieService {
    @Resource
    public MovieMapper movieMapper;


    @Override
    public String addMovie(Movie movie) {
        int count = movieMapper.insertWithoutId(movie);
        if(count == 1){
            return "200";
        }else {
            return "300";
        }
    }

    @Override
    public String updateMovie(Movie movie) {
        int cnt = movieMapper.updateByPrimaryKey(movie);
        if(cnt == 1){
            return "200";
        }else {
            return "300";
        }
    }

    @Override
    public String deleteMovie(int id) {
        int cnt = movieMapper.deleteByPrimaryKey(id);
        if(cnt == 1){
            return "200";
        }else {
            return "300";
        }
    }

    @Override
    public Movie getMovieDetail(int id) {
        Movie movie = movieMapper.selectByPrimaryKey(id);
        return movie;
    }
}
