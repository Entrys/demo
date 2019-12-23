package com.yanwei.movie.repository;

import com.yanwei.movie.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author li.tao
 * @since 2019/12/9 19:38
 */
@Repository
public interface IUserRepository {

    List<User> find();
}
