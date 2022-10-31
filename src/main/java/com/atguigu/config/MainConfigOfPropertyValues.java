package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author linzihao
 * @create 2022-10-31-14:48
 */
//使用PropertySource读取外部配置文件中的K/V属性保存到运行的环境变量中
//在value属性里面可以指定从类路径（classpath：）开始的或者从文件路径（file：）开始的配置文件
//如下就是从类路径开始的根路径下的person.properties
@PropertySource(value = {"classpath:/person.properties"},encoding = "gbk")
@Configuration
public class MainConfigOfPropertyValues {

    @Bean
    public Person person(){
        return new Person();
    }

}
