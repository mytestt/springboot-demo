package com.duy.demo.redis;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/11/6 17:32
 **/
@RestController
@RequestMapping("/redis")
public class TestRedisController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/send")
    public void sendMsg(){
        JSONObject message = new JSONObject();
        message.put("message", "你好,everybody!");
        message.put("userId","duyulong");
        redisTemplate.convertAndSend("harbor",message.toString());
    }
}
