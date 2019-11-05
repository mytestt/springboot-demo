package com.duy.demo.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/11/5 15:31
 **/
public class FristCache {
    /**
     * expireAfterAccess设置过期时间，缓存的对象在最后一次被访问后指定时间过期
     * expireAfterWrite设置过期时间，缓存的对象在被放入缓存中指定时间过期
     */
    public static Cache<String,String> firstCache = CacheBuilder.newBuilder().expireAfterAccess(1, TimeUnit.MINUTES).build();
}
