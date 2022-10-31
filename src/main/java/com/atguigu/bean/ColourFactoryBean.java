package com.atguigu.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author linzihao
 * @create 2022-10-31-9:17
 */
//创建一个Spring定义的工厂bean，要继承FactoryBean
public class ColourFactoryBean implements FactoryBean<Colour> {

    //返回一个Colour对象，这个对象会被添加到容器中
    @Override
    public Colour getObject() throws Exception {
        System.out.println("ColourFactoryBean...getObject...");
        return new Colour();
    }

    @Override
    public Class<?> getObjectType() {
        return Colour.class;
    }

    //控制是否为单例
    //true：这个bean为单实例，在容器中保存一份
    //false：多实例，每次获取都会用getObject创建一个
    @Override
    public boolean isSingleton() {
        return false;
    }
}
