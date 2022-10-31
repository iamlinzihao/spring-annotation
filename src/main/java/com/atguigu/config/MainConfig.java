package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.*;

/**
 * @author linzihao
 * @create 2022-10-30-19:19
 */
//配置类=配置文件
@Configuration    //告诉Spring这是一个配置类
@ComponentScans(value = {
        @ComponentScan(value = "com.atguigu",
                includeFilters = {
                // @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
                // @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})},
                useDefaultFilters = false
        )
})
//@ComponentScan value指定要扫描的包
//excludeFilter = Filter[]：指定扫描的时候按照那些规则，排除哪些组件
//includeFilter = Filter[]: 指定扫描的时候只包含哪些组件
//FilterType.ANNOTATION:按照注解
//FilterType.ASSIGNABLE_TYPE：按照指定类型
public class MainConfig {

    /**
     * @Bean注解的作用：
     * 给容器注册一个Bean，容器启动的时候把该方法的返回值放到ioc容器中，
     * class：为返回值的类型，id：默认是方法名作为id
     * value属性为该组件的名字
     */
    @Bean("person111")
    public Person person(){
        return new Person("lisi", 20);
    }

}
