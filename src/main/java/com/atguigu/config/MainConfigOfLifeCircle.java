package com.atguigu.config;

import com.atguigu.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * bean的生命周期：
 *      bean的创建---初始化---销毁的过程
 * 容器管理bean的生命周期：
 * 构造（对象创建）
 *      单实例：在容器启动的时候创建对象
 *      多实例：在每次获取的时候创建对象
 * BeanPostProcessor.postprocessBeforeInitialzation
 * 初始化：
 *      对象创建完成，并赋值好，调用初始化方法
 * BeanPostProcessor.postprocessAfterInitialzation
 * 销毁：
 *      单实例：容器关闭的时候
 *      多实例：容器不会管理这个bean，容器不会调用销毁方法
 *
 *
 *
 * 我们可以自定义初始化和销毁方法，在容器执行到当前生命周期的时候调用我们自定义的初始化和销毁方法
 * 1）指定初始化和销毁方法：
 *      指定init-method和destroy-method
 * 2）通过让bean实现InitializingBean（定义初始化逻辑），
 *      DisposableBean（定义销毁逻辑）
 * 3) 可以使用JSR250；
 *      @PostConstructor：在bean创建完成并且属性赋值完成，来执行初始化方法
 *      @PreDestroy：在容器销毁bean之前通知我们进行清理工作
 * 4) BeanPostProcessor【interface】 ：bean的后置处理器
 *      在bean的初始化前后进行一些处理工作；
 *      postprocessBeforeInitialzation：在初始化之前工作
 *      postprocessAfterInitialzation：在初始化之后工作
 *
 * 遍历得到容器中所有的BeanPostProcessor；挨个执行beforeInitialization，一但返回null，跳出for循环，
 * 不会执行后面的BeanPostProcessor.postProcessorsBeforeInitialization
 *
 * BeanPostProcessor原理：
 *
 * 1.populateBean(beanName, mbd, instanceWrapper);给bean进行属性赋值
 * 2.initializeBean
 *  {
 *  applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 *  invokeInitMethods(beanName, wrappedBean, mbd);执行自定义初始化
 *  applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 * }
 *
 *Spring底层也大量使用到BeanPostProcessor：
 *      bean的赋值，注入其他组件，@Autowired，生命周期注解功能，@Async，xxx，BeanPostProcessor
 *
 * @author linzihao
 * @create 2022-10-31-9:48
 */
@ComponentScan("com.atguigu.bean")
@Configuration
public class MainConfigOfLifeCircle {

    // @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }

}
