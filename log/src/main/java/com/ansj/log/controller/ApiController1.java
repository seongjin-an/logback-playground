package com.ansj.log.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ApiController1 {
    private final Logger _logger = LoggerFactory.getLogger(ApiController1.class);
    @GetMapping("log1")
    public void log1(){
        _logger.info("api controller11111");
    }
}
