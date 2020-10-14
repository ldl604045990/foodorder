package com.foodorder;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;

@EnableDubbo
@ImportResource(locations = { "classpath:dubbo-cunsumer.xml" })
@ServletComponentScan
@SpringBootApplication
public class UserApplication {


    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(UserApplication.class);

        logger.info("orderUser工程开始启动");
        SpringApplication.run(UserApplication.class, args);
        logger.info("orderUser启动成功");
    }

}
