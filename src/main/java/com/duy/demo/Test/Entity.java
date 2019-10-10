package com.duy.demo.Test;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/9/27 9:26
 **/
public class Entity {
    private static String name;
    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public void setName(String name1){
        name = name1;
    }
    public String getName(){
        return name;
    }
}
