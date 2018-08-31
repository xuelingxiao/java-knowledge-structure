package com.xlx.pattern.factorymethod;

/**
 * 调用方角色
 */
public class Client {

    /**
     * 调用演示
     */
    public void drive(){
        CarFactory bmwFactory = new BMWFactory();
        Car bmwCar = bmwFactory.getCar();
        bmwCar.run();

        CarFactory qqFactory = new QQFactory();
        Car qqCar = qqFactory.getCar();
        qqCar.run();

        Car car = getCarByType(1);
        if (car!=null){
            car.run();
        }
        car = getCarByType(2);
        if (car!=null){
            car.run();
        }
    }

    /**
     * 简单工厂实现, 通过传入的参数返回具体的汽车
     * @param carType
     * @return
     */
    public Car getCarByType(int carType){

        Car car = null;
        switch (carType){
            case 1:
                CarFactory bmwFactory = new BMWFactory();
                Car bmwCar = bmwFactory.getCar();
                car = bmwCar;
                break;
            case 2:
                CarFactory qqFactory = new QQFactory();
                Car qqCar = qqFactory.getCar();
                car = qqCar;
                break;
        }

        return car;
    }

}
