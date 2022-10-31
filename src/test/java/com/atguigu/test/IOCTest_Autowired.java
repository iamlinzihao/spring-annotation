package com.atguigu.test;

import com.atguigu.bean.Boss;
import com.atguigu.bean.Colour;
import com.atguigu.config.MainConfigOfAutowired;
import com.atguigu.config.MainConfigOfLifeCircle;
import com.atguigu.dao.BookDao;
import com.atguigu.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author linzihao
 * @create 2022-10-31-9:58
 */
public class IOCTest_Autowired {

    @Test
    public void test01(){

        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

        // BookService bean = annotationConfigApplicationContext.getBean(BookService.class);
        // System.out.println(bean);

        // BookDao bean1 = annotationConfigApplicationContext.getBean(BookDao.class);
        // System.out.println(bean1);

        System.out.println("==================================");

        Boss bean = annotationConfigApplicationContext.getBean(Boss.class);
        System.out.println(bean);

        Object car = annotationConfigApplicationContext.getBean("car");
        System.out.println(car);

        System.out.println("==================================");
        Colour bean1 = annotationConfigApplicationContext.getBean(Colour.class);
        System.out.println(bean1);

        annotationConfigApplicationContext.close();

    }

}
