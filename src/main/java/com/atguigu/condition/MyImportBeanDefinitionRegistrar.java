package com.atguigu.condition;

import com.atguigu.bean.Rainbow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author linzihao
 * @create 2022-10-31-8:42
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param annotationMetadata：当前类的注解信息
     * @param beanDefinitionRegistry：BeanDefinition注册类，把所有需要添加到容器的bean
     *                              调用beanDefinitionRegistry.registerBeanDefinition手工注册进来
     *
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        boolean red = beanDefinitionRegistry.containsBeanDefinition("com.atguigu.bean.Red");
        boolean blue = beanDefinitionRegistry.containsBeanDefinition("com.atguigu.bean.Blue");

        if (red && blue){

            //指定bean定义信息，（Bean的类型）
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Rainbow.class);
            //注册一个bean，指定bean的id
            beanDefinitionRegistry.registerBeanDefinition("rainbow",rootBeanDefinition);

        }

    }
}
