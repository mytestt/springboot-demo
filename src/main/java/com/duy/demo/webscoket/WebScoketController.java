package com.duy.demo.webscoket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author CW6478
 * @auth duyulong
 * @Description
 * @Date 2019/8/16 13:37
 **/
@RestController
public class WebScoketController {

    @GetMapping("/handle/mirco/sendMsg")
    public void sendMsg(){
        try {
            CustomWebSocket.sendInfo("Hello,everybody!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
