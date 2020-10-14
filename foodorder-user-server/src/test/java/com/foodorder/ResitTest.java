package com.foodorder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodorder.inter.user.bean.OrderUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

//@SpringBootTest
public class ResitTest {

    @Autowired
    private RedisTemplate redisTemplate;


    public void expireKey() throws JsonProcessingException {
        String value = new ObjectMapper().writeValueAsString("李大龙");
        redisTemplate.opsForValue().set("111",value,100,TimeUnit.SECONDS);
    }


}
