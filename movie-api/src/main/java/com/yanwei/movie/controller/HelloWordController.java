package com.yanwei.movie.controller;

import com.yanwei.movie.model.User;
import com.yanwei.movie.service.IMovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author li.tao
 * @since 2019/12/9 16:34
 */
@RestController
@RequestMapping("/hello")
public class HelloWordController {
    private IMovieService movieService;

    public HelloWordController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/word")
    public String test() {
        List<User> users = movieService.find();
        System.out.println("测试:" + users);
        return "Hello World!";
    }
}
