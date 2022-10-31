package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfigOfLifeCircle;
import com.atguigu.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author linzihao
 * @create 2022-10-31-9:58
 */
public class IOCTest_PropertyValue {

    AnnotationConfigApplicationContext annotationConfigApplicationContext =
            new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    @Test
    public void test01(){
        //打印
        printBeans(annotationConfigApplicationContext);

        //输出person
        System.out.println("================");
        Person person = (Person) annotationConfigApplicationContext.getBean("person");
        System.out.println(person);

        //也可以直接获取从配置文件中加载到环境变量中的值
        System.out.println("================");
        ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);

        annotationConfigApplicationContext.close();

    }

    private void printBeans(AnnotationConfigApplicationContext annotationConfigApplicationContext){
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String name :
                beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
