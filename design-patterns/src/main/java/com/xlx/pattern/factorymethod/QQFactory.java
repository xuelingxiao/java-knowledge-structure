package com.xlx.pattern.factorymethod;

/**
 * QQ 汽车工厂实现
 */
public class QQFactory implements CarFactory {

    public Car getCar() {
        return new QQCar();
    }

}
