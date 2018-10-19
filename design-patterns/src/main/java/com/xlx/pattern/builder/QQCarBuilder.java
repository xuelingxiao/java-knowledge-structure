package com.xlx.pattern.builder;

public class QQCarBuilder extends AbstractCarBuilder {
    public AbstractCarBuilder setEngine() {
        Car car = this.getCar();
        car.setEngine("QQ setEngine");
        return this;
    }

    public AbstractCarBuilder setChassis() {
        Car car = this.getCar();
        car.setChassis("QQ setChassis");
        return this;
    }

    public AbstractCarBuilder setBody() {
        Car car = this.getCar();
        car.setBody("QQ setBody");
        return this;
    }

    public AbstractCarBuilder setWheels() {
        Car car = this.getCar();
        car.setWheels("QQ setWheels");
        return this;
    }

    public AbstractCarBuilder setEquipment() {
        return this;
    }

    public AbstractCarBuilder setRadar() {
        return this;
    }
}
