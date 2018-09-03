package com.xlx.pattern.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class CarProperty implements Cloneable, Serializable {

    public final String test ="test";

    private String power;
    private double maxSpeed;
    private double oilPerKm;

    public Object clone(){
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
