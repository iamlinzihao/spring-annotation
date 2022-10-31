package com.atguigu.test;

import com.atguigu.bean.Blue;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfig02;
import com.atguigu.bean.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @author linzihao
 * @create 2022-10-30-19:49
 */
public class IOCTest {

    AnnotationConfigApplicationContext annotationConfigApplicationContext =
            new AnnotationConfigApplicationContext(MainConfig02.class);

    @Test
    public void testImport(){

        printBeans(annotationConfigApplicationContext);

        // Blue bean = annotationConfigApplicationContext.getBean(Blue.class);
        // System.out.println(bean);

        Object colourFactoryBean = annotationConfigApplicationContext.getBean("colourFactoryBean");
        Object colourFactoryBean2 = annotationConfigApplicationContext.getBean("colourFactoryBean");
        //用工厂bean的ID获取的是调用getobject创建的对象
        System.out.println("colourFactoryBean的类型：" + colourFactoryBean);
        System.out.println(colourFactoryBean == colourFactoryBean2);

        Object colourFactoryBean3 = annotationConfigApplicationContext.getBean("&colourFactoryBean");
        System.out.println(colourFactoryBean3.getClass());


    }

    private void printBeans(AnnotationConfigApplicationContext annotationConfigApplicationContext){
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String name :
                beanDefinitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void test03(){

        //动态获取环境变量的值
        ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property); //window10

        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        for (String name:
             beanNamesForType) {
            System.out.println(name);
        }

        Map<String, Person> Persons = annotationConfigApplicationContext.getBeansOfType(Person.class);
        System.out.println(Persons);

    }

    @Test
    public void test02() {

        //通过配置类获取ioc容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MainConfig02.class);

        // //获取ioc容器中所有的name
        // String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        // for (String beanName :
        //         beanDefinitionNames) {
        //     System.out.println(beanName);
        // }
        //

        System.out.println("ioc容器创建完成。。。");

        Object person222 = annotationConfigApplicationContext.getBean("person222");
        // Object person2223 = annotationConfigApplicationContext.getBean("person222");
        // System.out.println(person222 == person2223);

    }

    @Test
    public void test01() {

        //通过配置类获取ioc容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MainConfig.class);

        //获取ioc容器中所有的name
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanName :
                beanDefinitionNames) {
            System.out.println(beanName);
        }

    }

}
