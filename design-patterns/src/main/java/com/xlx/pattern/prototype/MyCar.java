package com.xlx.pattern.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class MyCar extends DeepCloneBase implements Serializable {

    private String brand;
    private double price;
    private CarProperty carProperty;




    public static void main(String[] args) throws  Exception{

        CarProperty carProperty = new CarProperty("8匹",250,30);
        MyCar car= new MyCar("BMW",200,carProperty);

        MyCar copy = (MyCar)car.deepClone();

        if (copy!=null){
            System.out.println("copy最大速度为: "+copy.getCarProperty().getMaxSpeed());
            System.out.println("原型最大速度为: "+car.getCarProperty().getMaxSpeed());
            car.getCarProperty().setMaxSpeed(360);
            System.out.println("copy最大速度为: "+copy.getCarProperty().getMaxSpeed());
            System.out.println("原型最大速度为: "+car.getCarProperty().getMaxSpeed());
        }else{
            System.out.println("对象没拷贝成功....");
        }
    }
}
