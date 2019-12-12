package com.duy.demo.redis;

import org.springframework.stereotype.Component;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/11/6 16:33
 **/
@Component
public interface RedisMsg {
    /**
     * 接受信息
     * @param message
     */
    public void receiveMessage(String message);
}
