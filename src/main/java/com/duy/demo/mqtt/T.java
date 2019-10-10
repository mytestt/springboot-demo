package com.duy.demo.mqtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/9/27 13:36
 **/
@RestController
public class T {
    @Autowired
    private MqttPushClient mqttPushClient;
    @PostMapping("/init")
    public String  pushMessage(){
        mqttPushClient.connectOpen();
        mqttPushClient.subscribe(new String[]{"windows"});
        return "success";
    }
    @PostMapping("/pushmsg")
    public String  pushMessage1(){
        PushPayload payload = new PushPayload();
        payload.setTitle("国庆节快乐呀！");
        mqttPushClient.publish("windows",payload);
        return "success";
    }
}