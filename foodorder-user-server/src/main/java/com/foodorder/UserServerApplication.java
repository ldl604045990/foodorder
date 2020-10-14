package com.foodorder;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@EnableDubbo
@MapperScan(basePackages = { "com.foodorder.dao" })
@ImportResource(locations = { "classpath:dubbo-cunsumer.xml" ,"classpath:dubbo-provider.xml" })
@SpringBootApplication
public class UserServerApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(UserServerApplication.class);
        logger.info("orderUserServer工程开始启动");
        SpringApplication.run(UserServerApplication.class, args);
        logger.info("orderUserServer启动成功");
    }
}
