package com.project.wechat.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class RequestController {

    @RequestMapping("/getDingYue")
    public String getTest(String accessToken){
        String showapi_appid = "724089";
        String showapi_sign = "fb1e3b461bdc4c0f832fcb3c2423b9bb";
        String url =
                "https://route.showapi.com/1196-1?showapi_appid="+showapi_appid+"&showapi_sign=" + showapi_sign;

        HashMap<String, String> map = new HashMap<>();
        map.put("keyword","龙飞凤舞");

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<String>(map.toString(), header);
        return restTemplate.postForObject(url, request, String.class);
    }
}
