package com.duy.demo.enumtest;

public enum Day {
    /**
     *
     */
    MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"),
    THURSDAY("星期四"), FRIDAY("星期五"), SATURDAY("星期六"), SUNDAY("星期日");
    private String desc;
    Day(String day){
        desc = day;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }
    public String getDesc(){
        return this.desc;
    }
}
