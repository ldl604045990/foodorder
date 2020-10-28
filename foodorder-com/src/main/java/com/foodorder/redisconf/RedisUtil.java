package com.foodorder.redisconf;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    Logger logger = LoggerFactory.getLogger(RedisUtil.class);

    @Autowired
    private RedisTemplate redisTemplate;

    private RedisSerializer redisSerializer = new StringRedisSerializer();

    /**
     * 根据缓存键获取Redis缓存中的值
     *
     * @param key 键
     * @return Object 支持泛型 可能为空
     */
    public <T> T getObject(String key) {
        try {
            if(StringUtils.isBlank(key))return null;
            Object value = redisTemplate.opsForValue().get(key);
            if (value != null) {
                return (T) value;
            }
        } catch (Exception e) {
            logger.error("redis获取失败..key=" + key, e);
        }
        return null;
    }

    /**
     * 保存一个对象到redis中并指定过期时间
     *
     * @param key 键 .
     * @param value 缓存对象
     * @param seconds 过期时间（单位为秒）
     * @return true or false
     */
    public Boolean saveObject(String key, Object value, int seconds) {
        try {
            redisTemplate.setKeySerializer(redisSerializer);
            if (seconds > 0) {
                redisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
            } else {
                redisTemplate.opsForValue().set(key, value);
            }
            return true;
        } catch (Exception e) {
            logger.error("Object放入失败..key=" + key + " value=" + value + " time=" + seconds, e);
        }
        return false;
    }

    /**
     * 根据缓存键清除Redis缓存中的值.<br/>
     *
     * @param key
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public Boolean deleteKey(String... key) {
        try {
            if (key != null && key.length > 0) {
                if (key.length == 1) {
                    redisTemplate.delete(key[0]);
                } else {
                    redisTemplate.delete(CollectionUtils.arrayToList(key));
                }
            }
        } catch (Exception e) {
            logger.error("redis删除失败..key=" + key, e);
        }
        return true;
    }

}
