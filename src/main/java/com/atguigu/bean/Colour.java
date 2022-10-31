package com.atguigu.bean;

/**
 * @author linzihao
 * @create 2022-10-30-22:39
 */
public class Colour {

    private Car car;

    @Override
    public String toString() {
        return "Colour{" +
                "car=" + car +
                '}';
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
