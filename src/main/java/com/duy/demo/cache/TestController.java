package com.duy.demo.cache;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auth duyulong
 * @Description google的guava缓存尝试
 * @Date 2019/11/5 15:42
 **/
@RestController
@RequestMapping("/cache")
public class TestController {
    @GetMapping("/set")
    public String setCache(@Param("msg")String msg){
        FristCache.firstCache.put("first",msg);
        System.out.println(FristCache.firstCache.size());
        return "success";
    }
    @GetMapping("/get")
    public String getCache(@Param("key")String key){
        String present = FristCache.firstCache.getIfPresent(key);
        System.out.println("present = " + present);
        return present;
    }
}
