package com.duy.demo.redis;

import com.alibaba.fastjson.JSONObject;
import com.duy.demo.webscoket.CustomWebSocket;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/11/6 16:45
 **/
@Component
public class Sender implements RedisMsg {
    @Override
    public void receiveMessage(String message) {
//        JSONObject jo = JSONObject.parseObject(message);
//        String msg = jo.getString("message");
//
//        System.out.println("Redis的Sender开始发送消息");
//        try {
//            CustomWebSocket.sendInfo(message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
