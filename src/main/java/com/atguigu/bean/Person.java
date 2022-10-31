package com.atguigu.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author linzihao
 * @create 2022-10-30-19:00
 */
public class Person {
    //使用@Value赋值
    //1.基本数值
    //2.可以写SpEl：#{}
    //3.可以写${}：去除配置文件【properties】的值（就是运行环境变量里面的那些值，配置文件里面的值在运行环境变量里）
    @Value("张三")
    private String name;

    @Value("#{20-2}")
    private Integer age;

    @Value("${person.nickName}")
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
