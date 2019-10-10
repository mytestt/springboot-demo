package com.duy.demo.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/9/27 11:58
 **/
@Component
public class MqttPushClient {
    @Autowired
    private MqttClientFactory mqttClientFactory;

    private MqttClient client;

    public void connectOpen(){
        this.client = mqttClientFactory.createMqttClient();
    }

    private void publish(int qos,boolean retained,String topic,PushPayload pushMessage){
        MqttMessage message = new MqttMessage();
        message.setQos(qos);
        message.setRetained(retained);
        message.setPayload(pushMessage.toString().getBytes());
        MqttTopic mTopic = client.getTopic(topic);
        if(null == mTopic){
            System.out.println("topic not exist");
        }
        MqttDeliveryToken token;
        try {
            token = mTopic.publish(message);
            token.waitForCompletion();
            System.out.println("消息推送成功");
        } catch (MqttPersistenceException e) {
            e.printStackTrace();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
    public void publish(String topic,PushPayload pushMessage){
        this.publish(0,false,topic,pushMessage);
    }

    private void subscribe(String[] topic,int qos){
        try {
            for (int i = 0; i < topic.length; i++) {
                String t = topic[i];
                MqttTopic mTopic = client.getTopic(t);
                if(mTopic != null){
                    System.out.println("订阅主题："+mTopic.getName());
                }else{
                    System.out.println("主题不存在："+mTopic.getName());
                }
            }
            client.subscribe(topic);
            client.setCallback(new Callback());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void subscribe(String[] topic){
        subscribe(topic,0);
    }
}
