package com.duy.demo.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/11/6 8:28
 **/
public class Test {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        System.out.println(apple instanceof Apple?"apple是苹果类型":"apple是水果类型");
        Plate<? extends Fruit> applePlate = new Plate<>(new Apple());
        System.out.println("是否是Apple："+(applePlate.get() instanceof Apple));
        System.out.println("是否是Fruit："+(applePlate.get() instanceof Fruit));
        applePlate.get();
        List<? extends Fruit> fruits = new ArrayList<>(new ArrayList<Apple>());
    }
}
