package com.duy.demo.KFCmeal2;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/10/28 9:05
 **/
@Service
public class MealA extends Meal implements InitializingBean {

    @Override
    public void afterPropertiesSet(){
        this.setFood("薯条");
        this.setDrink("可乐");
        MealBuilder.buildMeal("a",this);
    }
}
