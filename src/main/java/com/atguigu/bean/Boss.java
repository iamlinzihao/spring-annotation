package com.atguigu.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author linzihao
 * @create 2022-10-31-17:12
 */
//默认加在ioc容器中的组件，容器启动会加载无参构造器创建对象，在进行初始化赋值操作
@Component
public class Boss {

    // @Autowired
    private Car car;

    //构造器要用到的组件，都要从ioc中获取
    @Autowired
    public Boss(@Autowired Car car) {
        this.car = car;
        System.out.println("Boss...有参构造器");
    }

    public Boss() {
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }

    public Car getCar() {
        return car;
    }

    // @Autowired
    //标住在方法上，spring容器创建当前对象时就会调用方法，完成赋值
    //方法调用的参数则从容器中获取
    public void setCar(Car car) {
        this.car = car;
    }
}
