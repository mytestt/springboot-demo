package com.duy.demo.mqtt;

import lombok.Data;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/9/27 11:47
 **/
@Data
public class PushPayload {
    private String type;
    private String mobile;
    private String title;
    private String content;
    private Integer badge = 1;
    private String sound = "default";
}
