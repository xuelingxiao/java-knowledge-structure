package com.xlx.pattern.factorymethod;

/**
 * BMW 汽车工厂实现
 */
public class BMWFactory implements CarFactory {

    public Car getCar() {
        return new BMWCar();
    }

}
