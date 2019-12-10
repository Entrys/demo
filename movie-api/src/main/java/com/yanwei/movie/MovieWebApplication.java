package com.yanwei.movie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author li.tao
 * @since 2019/12/9 16:37
 */
@SpringBootApplication(scanBasePackages = "com.yanwei.movie")
@MapperScan("com.yanwei.movie.repository")
public class MovieWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieWebApplication.class, args);
    }
}
