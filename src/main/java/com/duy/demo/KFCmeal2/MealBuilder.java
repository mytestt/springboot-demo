package com.duy.demo.KFCmeal2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/10/28 9:11
 **/
public class MealBuilder {
    public static Map<String,MealA> meals = new ConcurrentHashMap<String,MealA>();
    public static Meal getMealByType(String type){
        return meals.get(type);
    }
    public static void buildMeal(String type,MealA meal){
        meals.put(type,meal);
    }
}
