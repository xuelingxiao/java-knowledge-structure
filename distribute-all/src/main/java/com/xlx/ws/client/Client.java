package com.xlx.ws.client;

public class Client {
    public static void main(String[] args) {
        BMWCarService service = new BMWCarService();
        com.xlx.ws.client.BMWCar car = (com.xlx.ws.client.BMWCar) service.getBMWCarPort();
        System.out.println(car.getCarName());
    }
}
