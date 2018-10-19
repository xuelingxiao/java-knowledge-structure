package com.xlx.pattern.builder;

public class BMWCarBuilder extends AbstractCarBuilder {

    public AbstractCarBuilder setEngine() {
        Car car = this.getCar();
        car.setEngine("BMW setEngine");
        return this;
    }

    public AbstractCarBuilder setChassis() {
        Car car = this.getCar();
        car.setChassis("BMW setChassis");
        return this;
    }

    public AbstractCarBuilder setBody() {
        Car car = this.getCar();
        car.setBody("BMW setBody");
        return this;
    }

    public AbstractCarBuilder setWheels() {
        Car car = this.getCar();
        car.setWheels("BMW setWheels");
        return this;
    }

    public AbstractCarBuilder setEquipment() {
        Car car = this.getCar();
        car.setEquipment("BMW setEquipment");
        return this;
    }

    public AbstractCarBuilder setRadar() {
        Car car = this.getCar();
        car.setRadar("BMW setRadar");
        return this;
    }
}
