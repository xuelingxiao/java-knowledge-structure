package com.xlx.ws;

import javax.jws.WebService;

@WebService
public class BMWCar implements ICar {
    @Override
    public String getCarName() {
        return "宝马汽车...";
    }
}
