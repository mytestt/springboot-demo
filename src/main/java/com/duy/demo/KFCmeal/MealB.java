package com.duy.demo.KFCmeal;

/**
 * @author duyulong
 * @Description
 * @Date 2019/8/7 14:37
 **/
public class MealB extends MealBuilder {
    @Override
    void buildFood() {
        meal.setFood("汉堡");
    }

    @Override
    void buildDrink() {
        meal.setDrink("炸鸡");
    }
}
