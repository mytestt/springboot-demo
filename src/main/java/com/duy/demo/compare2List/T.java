package com.duy.demo.compare2List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/8/27 15:41
 **/
public class T {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            list1.add("test"+i);
            list2.add("test"+i*3);
        }
        mapCompare(list1,list2);
        forCompare(list1,list2);
        streamCompare(list1,list2);
    }
    /**
     * 对比两个list，返回list并集
     * @param oldList
     * @param newList
     * @return value为1,旧数据;2,重复的数据;3,新增的数据
     */
    public static List<String> mapCompare(List<String> oldList, List<String> newList) {
        long st = System.nanoTime();

        //若知道两个list大小区别较大，以大的list优先处理
        Map<String,Integer> map = new HashMap<>(oldList.size());

        //lambda for循环数据量越大，效率越高，小数据建议用普通for循环
        oldList.forEach(s -> map.put(s, 1) );

        List<String> list = new ArrayList<>();
        newList.forEach(s -> {
            if(map.get(s)!=null)
            {
                //相同的数据
                list.add(s);
            }else {
                //若只是比较不同数据，不需要此步骤，浪费资源
//                map.put(s,3);
            }
        });

        System.out.println("mapCompare total times "+ TimeUnit.NANOSECONDS.toMillis(System.nanoTime()-st)+"ms");
        return list;
    }
    /**
     * 对比两个list，返回list并集
     * @param oldList
     * @param newList
     * @return value为1,旧数据;2,重复的数据;3,新增的数据
     */
    public static List<String> forCompare(List<String> oldList, List<String> newList){
        long st = System.nanoTime();
        List<String> list = new ArrayList<>();
        for (String o : oldList) {
            for (String n : newList) {
                if(o.equalsIgnoreCase(n)){
                    list.add(o);
                }
            }
        }
        System.out.println("forCompare total times "+ TimeUnit.NANOSECONDS.toMillis(System.nanoTime()-st)+"ms");
        return list;
    }
    public static List<String> streamCompare(List<String> oldList, List<String> newList){
        long st = System.nanoTime();
        List<String> list = new ArrayList<>();
        oldList.stream().forEach(o -> {
            newList.stream().forEach(n -> {
                if(o.equalsIgnoreCase(n)){
                    list.add(o);
                }
            });
        });
        System.out.println("streamCompare total times "+ TimeUnit.NANOSECONDS.toMillis(System.nanoTime()-st)+"ms");
        return list;
    }
}
