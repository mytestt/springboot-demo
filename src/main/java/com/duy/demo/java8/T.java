package com.duy.demo.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @auth duyulong
 * @description
 * @date 2019/9/24 14:30
 **/
public class T {
    public static void main(String[] args) {
        Converter<String,String> converter = from -> String.valueOf(from.charAt(0));
        String converter1 = converter.converter("110");
        System.out.println(converter1);

//        Something something = new Something();
//        Converter<String,String> converter = something::startwith;
    }
}
