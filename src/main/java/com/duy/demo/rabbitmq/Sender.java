package com.duy.demo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/8/28 14:44
 **/
public class Sender {
    private static final String TASK_QUEUE_NAME = "task_queue";
    public static void main(String[] args) throws IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqp://admin:admin@47.112.14.63:5672/my_vhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //(队列名，是否持久化，是否排外，是否自动删除，其他)
        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
        //分发消息
        for(int i = 0 ; i < 5; i++){
            String message = "Hello World! " + i;
            channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}
