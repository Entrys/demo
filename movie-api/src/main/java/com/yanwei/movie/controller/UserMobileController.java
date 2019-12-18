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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

/**
 * @author li.tao
 * @since 2019/12/16 13:52
 */
@RestController
@RequestMapping("/user/mobile")
public class UserMobileController {
    private final RestTemplate restTemplate;
    private final Logger logger = LoggerFactory.getLogger(UserMobileController.class);

    public UserMobileController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/export")
    public String test(HttpServletResponse servletResponse) throws JSONException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("token", "");
        JSONObject params = new JSONObject();
        String url = "https://api-much-dev.yanwei365.com/mu/cp/v1/customer/list?channelSid=&pageSize=100000000";
        HttpEntity<JSONObject> request = new HttpEntity<>(null, headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class);
        List<Map> datas = (ArrayList)response.getBody().get("data");
        HSSFWorkbook wb = new HSSFWorkbook();
//建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("用户基本信息");
        HSSFRow row2 = sheet.createRow(0);
//创建单元格并设置单元格内容
        row2.createCell(0).setCellValue("手机号");
        row2.createCell(1).setCellValue("姓名");
        row2.createCell(2).setCellValue("昵称");
        row2.createCell(3).setCellValue("身份");
        final int[] i = {1};
        datas.forEach(data -> {
            String sid = (String)data.get("sid");
            String name = (String)data.get("name");
            String nickname = (String)data.get("nickname");
            String userTypeName = (String)data.get("userTypeName");
            String mobileUrl = "https://api-much-dev.yanwei365.com/mu/cp/v1/customer/"+sid+"/mobile";
            ResponseEntity<Map> mobileResponse = restTemplate.exchange(mobileUrl, HttpMethod.GET, request, Map.class);
            String mobile = (String)mobileResponse.getBody().get("data");
            //在sheet里创建第三行
            HSSFRow row3 = sheet.createRow(i[0]);
            row3.createCell(0).setCellValue(mobile);
            row3.createCell(1).setCellValue(name);
            row3.createCell(2).setCellValue(nickname);
            row3.createCell(3).setCellValue(userTypeName);
            i[0]++;
        });
//输出Excel文件
        OutputStream output = null;
        try {
            output = servletResponse.getOutputStream();
            servletResponse.reset();
            servletResponse.setHeader("Content-disposition", "attachment; filename=details.xls");
            servletResponse.setContentType("application/msexcel");
            wb.write(output);
            output.flush();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Hello World!";
    }
}
