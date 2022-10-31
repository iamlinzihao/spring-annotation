package com.atguigu;

import com.atguigu.config.MainConfig;
import com.atguigu.bean.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author linzihao
 * @create 2022-10-30-19:06
 */
public class MainTest {

    public static void main(String[] args) {
        //通过xml文件生成ioc容器
        // ClassPathXmlApplicationContext applicationContext =
        //         new ClassPathXmlApplicationContext("beans.xml");
        //获取id为person的bean
        // Person person = (Person) applicationContext.getBean("person");
        //
        // System.out.println(person);

        //通过配置类生成ioc容器
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfig.class);
        //通过类获取bean
        Person bean = applicationContext.getBean(Person.class);

        System.out.println(bean);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);

        for (String beanName :
                beanNamesForType) {
            System.out.println(beanName);
        }

    }
}
