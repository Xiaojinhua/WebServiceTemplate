package com.istuary.webserviceTemplate.api.common.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by xiaojinhua on 17/9/9.
 */
@Component
public class RedisHelper<V extends Serializable>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisHelper.class);

    @Autowired
    private RedisTemplate<String,V> redisTemplate;

    public void setValue(String key, V value){
        redisTemplate.opsForValue().set(key,value);
    }

    public V getValue(String key){
        return redisTemplate.opsForValue().get(key);
    }
}
