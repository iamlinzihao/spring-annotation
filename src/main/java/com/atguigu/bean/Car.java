package com.atguigu.bean;

import org.springframework.stereotype.Component;

/**
 * @author linzihao
 * @create 2022-10-31-9:54
 */
@Component
public class Car {

    public Car() {
        System.out.println("car constructor...");
    }

    public void init(){
        System.out.println("car...init...");
    }

    public void destroy(){
        System.out.println("car...destroy...");
    }

}
