package com.duy.demo.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.text.MessageFormat;

/**
 * @auth duyulong
 * @Description尝试与EQMX消息代理服务器建立连接
 * @Date 2019/9/26 16:40
 **/
public class TestConnect {
    public static void main(String[] args) {
        String broker = "tcp://47.101.180.112:1883";
        String clientId = "1";
        MemoryPersistence memoryPersistence = new MemoryPersistence();
        MqttClient mqttClient = null;
        try {
            mqttClient = new MqttClient(broker, clientId, memoryPersistence);
            System.out.println("连接到中间代理:" + broker);
            mqttClient.connect();
            System.out.println("已连接");
        } catch (MqttException me) {
            System.out.println("reason" + me.getReasonCode());
            System.out.println("msg" + me.getMessage());
            System.out.println("loc" + me.getLocalizedMessage());
            System.out.println("cause" + me.getCause());
            System.out.println("excep" + me);
            me.printStackTrace();
        }

        //订阅主题
        String topic = "windows";
        MqttTopic mTopic = mqttClient.getTopic(topic);
        if(mTopic != null){
            System.out.println("订阅主题："+mTopic.getName());
        }else{
            System.out.println("topic not exist");
        }
        try {
            mqttClient.subscribe(topic);
            mqttClient.setCallback(new MqttCallback() {

                @Override
                public void messageArrived(String topic, MqttMessage message){
                    String theMsg = MessageFormat.format("{0} is arrived for topic {1}.", new String(message.getPayload()), topic);
                    System.out.println(theMsg);
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                }

                @Override
                public void connectionLost(Throwable throwable) {
                    System.out.println("连接断开");
                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
