package com.yanwei.movie.controller;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import javax.servlet.http.HttpServletResponse;

/**
 * @author li.tao
 * @since 2019/12/16 13:52
 */
@Controller
@RequestMapping("/user/mobile")
public class UserMobileController {
    private final RestTemplate restTemplate;
    private final Logger logger = LoggerFactory.getLogger(UserMobileController.class);

    public UserMobileController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/test")
    public String test(){

        return null;
    }
}
