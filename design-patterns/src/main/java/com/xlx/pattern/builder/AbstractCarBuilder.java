package com.xlx.pattern.builder;

/**
 * 抽象构建角色,定义每个组件的创建返回类型为本类型, 这样就可以使用链式编程方式了
 * 定义了返回最终产品的接口
 */
public abstract class AbstractCarBuilder {

    //产品
    private Car car = new Car();

    protected Car getCar(){
        return car;
    }

    public abstract AbstractCarBuilder setEngine();
    public abstract AbstractCarBuilder setChassis();
    public abstract AbstractCarBuilder setBody();
    public abstract AbstractCarBuilder setWheels();
    public abstract AbstractCarBuilder setEquipment();
    public abstract AbstractCarBuilder setRadar();

    // 返回产品
    public Car build(){
        return car;
    }
}
