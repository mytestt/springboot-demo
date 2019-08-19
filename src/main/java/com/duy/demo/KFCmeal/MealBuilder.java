package com.duy.demo.KFCmeal;

/**
 * @author CW6478
 * @auth duyulong
 * @Description
 * @Date 2019/8/7 14:16
 **/
public abstract class MealBuilder {
    Meal meal = new Meal();
    abstract void buildFood();
    abstract void buildDrink();
    public Meal getMeal(){
        return meal;
    }
}
