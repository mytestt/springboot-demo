package com.duy.demo.java8;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/9/24 15:05
 **/
@FunctionalInterface
public interface Converter<T,F> {
    /**
     * xxx
     * @param from
     * @return
     */
    T converter(F from);
}
