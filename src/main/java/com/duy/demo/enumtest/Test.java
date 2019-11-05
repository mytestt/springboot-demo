package com.duy.demo.enumtest;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/11/5 13:34
 **/
public class Test {
    String name;
    public static void main(String[] args) {
        System.out.println(Day.FRIDAY.getDesc());
        Day.FRIDAY.setDesc("啦啦啦");
        System.out.println("Day.FRIDAY.getDesc() = " + Day.FRIDAY.getDesc());
    }
}
