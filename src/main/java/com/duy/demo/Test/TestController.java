package com.duy.demo.Test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/9/27 9:24
 **/
@RestController
public class TestController {
    @PostMapping("init/{name}")
    public void InitClass(@PathVariable("name") String name){
        Entity e = new Entity();
        e.setName(name);
    }
    @GetMapping("getName")
    public String getName(){
        Entity e = new Entity();
        System.out.println(e.getName());
        return e.getName();
    }

    public static void main(String[] args) throws InterruptedException {
        Entity e = new Entity();
        e.setName("aaa");
        System.out.println(e.getName());

        Entity e1 = new Entity();
        e1.setName("bbb");
        System.out.println(e.getName());
        System.out.println(e1.getName());
        Thread.sleep(30000);
    }
}
