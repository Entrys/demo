package com.wenxi.house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author li.tao
 * @since 2019/12/9 16:37
 */
@SpringBootApplication
@EnableZuulProxy
public class zuulServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(zuulServerApplication.class, args);
    }

}
