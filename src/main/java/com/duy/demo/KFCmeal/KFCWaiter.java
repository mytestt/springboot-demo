package com.duy.demo.KFCmeal;

/**
 * @auth duyulong
 * @Description 指挥者
 * @Date 2019/8/7 14:23
 **/
public class KFCWaiter {
    private MealBuilder mealBuilder;
    public KFCWaiter(MealBuilder mealBuilder){
        this.mealBuilder = mealBuilder;
    }
    public Meal construct(){
        mealBuilder.buildDrink();
        mealBuilder.buildFood();
        return mealBuilder.getMeal();
    }
}
