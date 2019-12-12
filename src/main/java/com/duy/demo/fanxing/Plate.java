package com.duy.demo.fanxing;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/11/6 8:29
 **/
public class Plate<T> {
    private T item;
    public Plate(T item){
        this.item = item;
    }
    public void set(T item){
        this.item = item;
    }
    public T get(){
        return this.item;
    }
}
