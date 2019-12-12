package com.duy.demo.redis;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {
	@Autowired
    private RedisTemplate redisTemplate;
    /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * 写入缓存设置时效时间
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.DAYS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * 读取缓存
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }
    
    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public boolean exists(final String key) {
    	boolean result = redisTemplate.hasKey(key);
    	
    	return result;
    }
    
    /**
     * 刷新过期时间
     * @param key
     * @param expireTime
     * @return
     */
    public boolean expire(final String key, Long expireTime) {
    	return redisTemplate.expire(key, expireTime, TimeUnit.DAYS);
    }
    
    /**
     * 删除缓存
     * @param key
     * @return
     */
    public void delete(final String key) {
    	redisTemplate.delete(key);
    }
}
