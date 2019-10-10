package com.duy.demo.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/9/27 11:50
 **/
@Component
public class MqttClientFactory {
    public MqttClient client;

    @Autowired
    private MqttConfiguration mqttConfiguration;

    public MqttClient createMqttClient(){
        try {
            client = new MqttClient(mqttConfiguration.getHost(),mqttConfiguration.getClientid(),new MemoryPersistence());
            MqttConnectOptions options = new MqttConnectOptions();
            options.setUserName(mqttConfiguration.getUsername());
            options.setPassword(mqttConfiguration.getPassword().toCharArray());
            options.setConnectionTimeout(mqttConfiguration.getTimeout());
            options.setKeepAliveInterval(mqttConfiguration.getKeepalive());
            options.setCleanSession(false);
            client.connect(options);
            System.out.println("连接成功");
        } catch (MqttException e) {
            e.printStackTrace();
        }
        return client;
    }

}
