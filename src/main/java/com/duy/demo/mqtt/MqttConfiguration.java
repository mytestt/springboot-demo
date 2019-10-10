package com.duy.demo.mqtt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/9/27 11:42
 **/
@Component
@ConfigurationProperties(prefix = "com.mqtt")
@Data
public class MqttConfiguration {
    private String host;
    private String clientid;
    private String topic;
    private String username;
    private String password;
    private int timeout;
    private int keepalive;

}
