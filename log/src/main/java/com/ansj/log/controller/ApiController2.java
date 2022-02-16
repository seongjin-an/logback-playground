package com.ansj.log.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ApiController2 {
    private final Logger _logger = LoggerFactory.getLogger(ApiController2.class);
    @GetMapping("log2")
    public void log2(){
        _logger.info("api controller22222");
    }
}
