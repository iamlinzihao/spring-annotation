package com.atguigu.test;

import com.atguigu.bean.Boss;
import com.atguigu.bean.Colour;
import com.atguigu.bean.Yellow;
import com.atguigu.config.MainConfigOfAutowired;
import com.atguigu.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author linzihao
 * @create 2022-10-31-9:58
 */
public class IOCTest_Profile {

    //1.使用命令行动态参数：在虚拟机参数位置加载 -Dspring.profiles.active=test
    //2.代码的方式激活某种环境
    @Test
    public void test01(){

        //1)创建通过无参构造器获取applicationContext
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext();
        //2）设置需要激活的环境
        annotationConfigApplicationContext.getEnvironment().setActiveProfiles("dev");
        //3)注册主配置类
        annotationConfigApplicationContext.register(MainConfigOfProfile.class);
        //4)启动刷新容器
        annotationConfigApplicationContext.refresh();

        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(DataSource.class);

        for (String beanName :
                beanNamesForType) {
            System.out.println(beanName);
        }
        System.out.println("===========================");
        Yellow bean = annotationConfigApplicationContext.getBean(Yellow.class);
        System.out.println(bean);

        annotationConfigApplicationContext.close();

    }

}
