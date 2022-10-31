package com.atguigu.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author linzihao
 * @create 2022-10-31-10:43
 */
@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat() {
        System.out.println("cat constructor...");
    }

    @Override
    public void destroy() throws Exception {

        System.out.println("cat destroy...");

    }

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("cat afterPropertiesSet...");

    }
}
