package com.yanwei.movie.service.impl;

import com.yanwei.movie.model.User;
import com.yanwei.movie.repository.IUserRepository;
import com.yanwei.movie.service.IMovieService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author li.tao
 * @since 2019/12/9 18:38
 */
@Service
public class MovieService implements IMovieService {

    private final IUserRepository userRepository;

    public MovieService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> find() {
        System.out.println("测试:-------------------------");
        List<User> users = userRepository.find();
        return users;
    }
}
