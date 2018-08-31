package com.xlx.pattern.factorymethod;

/**
 * 汽车工厂接口
 */
public interface CarFactory {

    /**
     * 生产汽车
     * @return 实现Car接口的类实例
     */
    Car getCar();

}
