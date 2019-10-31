package com.duy.demo;

import com.duy.demo.KFCmeal2.Meal;
import com.duy.demo.KFCmeal2.MealBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTestDemoApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Test
    public void t1(){
        System.out.println(MealBuilder.meals);
        Meal meal = MealBuilder.getMealByType("a");
        System.out.println(meal.getDrink()+","+meal.getFood());
    }

}
