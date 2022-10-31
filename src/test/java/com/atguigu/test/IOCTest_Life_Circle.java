package com.atguigu.test;

import com.atguigu.config.MainConfigOfLifeCircle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author linzihao
 * @create 2022-10-31-9:58
 */
public class IOCTest_Life_Circle {

    @Test
    public void test01(){

        //1.创建ioc容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MainConfigOfLifeCircle.class);

        System.out.println("容器创建完成...");

        // Object car = annotationConfigApplicationContext.getBean("car");

        //2.关闭ioc容器
        annotationConfigApplicationContext.close();

    }

}
