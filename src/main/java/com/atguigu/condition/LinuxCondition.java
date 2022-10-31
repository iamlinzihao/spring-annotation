package com.atguigu.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author linzihao
 * @create 2022-10-30-22:02
 */
//判断是否Linux系统
public class LinuxCondition implements Condition {

    /**
     *
     * @param conditionContext：判断条件能使用的上下文（环境）
     * @param annotatedTypeMetadata：注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //1.能获取到ioc使用的beanFactory（创建对象执行装配的工厂）
        // ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //2.获取类加载信息
        // ClassLoader classLoader = conditionContext.getClassLoader();
        //3.获取当前环境信息
        Environment environment = conditionContext.getEnvironment();
        //4.获取到bean定义的注册类（可以在里边操作bean定义）
        // BeanDefinitionRegistry registry = conditionContext.getRegistry();

        //判断容器中的bean的注册情况，也可以给容器注册bean
        // boolean person = registry.containsBeanDefinition("person");

        //判断是否Linux系统
        String property = environment.getProperty("os.name");
        return property.contains("linux");
    }
}
