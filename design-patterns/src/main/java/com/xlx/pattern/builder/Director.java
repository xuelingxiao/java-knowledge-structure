package com.xlx.pattern.builder;

public class Director {

    private AbstractCarBuilder builder;

    public Director(AbstractCarBuilder builder) {
        this.builder = builder;
    }

    public Car BuildCar(){

        return builder
                .setWheels()
                .setRadar()
                .setEngine()
                .setChassis()
                .setBody()
                .setEquipment()
                .build();
    }

    public static void main(String[] args) {
        Director director = new Director(new QQCarBuilder());
        Car car = director.BuildCar();
        System.out.println(car.toString());

        director = new Director(new BMWCarBuilder());
        car = director.BuildCar();
        System.out.println(car.toString());
    }

}
