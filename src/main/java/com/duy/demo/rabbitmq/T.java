package com.duy.demo.rabbitmq;

import com.rabbitmq.client.*;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/8/26 8:43
 **/
public class T {
    public static void main(String[] args) throws IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqp://admin:admin@47.112.14.63:5672/my_vhost");
        //打开连接
        Connection connection = factory.newConnection();
        System.out.println("连接是否打开："+connection.isOpen());
        //建立通道
        Channel channel = connection.createChannel();
        System.out.println("通道是否打开："+channel.isOpen());
        //创建转换机，规则：
        //direct （直连）
        //topic （主题）
        //headers （标题）
        //fanout （分发）
        channel.exchangeDeclare("exchange01","direct",true);
        channel.exchangeDeclare("exchange02","direct",true);
        //创建队列
        String queue01 = channel.queueDeclare().getQueue();
        String queue02 = channel.queueDeclare().getQueue();
        //绑定转换机和队列
        channel.queueBind(queue01,"exchange01","routingKey01");
        channel.queueBind(queue02,"exchange01","routingKey02");

        //发送消息
        byte[] messageBodyBytes = "Hello, world!".getBytes();
        channel.basicPublish("exchange01", "routingKey01", null, messageBodyBytes);

        boolean autoAck = false;
        channel.basicConsume(queue01, autoAck, "myConsumerTag",
                //DefaultConsumer类实现了Consumer接口，通过传入一个通道，告诉服务器我们需要哪个通道的消息，如果通道中有消息，就会执行回调函数handleDelivery
                new DefaultConsumer(channel) {
                    @Override
                    public void handleDelivery(String consumerTag,
                                               Envelope envelope,
                                               AMQP.BasicProperties properties,
                                               byte[] body)
                            throws IOException
                    {
                        String routingKey = envelope.getRoutingKey();
                        String contentType = properties.getContentType();
                        long deliveryTag = envelope.getDeliveryTag();
                        // (process the message components here ...)
                        channel.basicAck(deliveryTag, false);
                        System.out.println(new String(body));
                    }
                });

        AMQP.Queue.DeclareOk response = channel.queueDeclarePassive(queue01);
        //返回队列中处于就绪状态的消息数量
        System.out.println(response.getMessageCount());
        //返回队列拥有的消费者数量
        System.out.println(response.getConsumerCount());
    }
}
