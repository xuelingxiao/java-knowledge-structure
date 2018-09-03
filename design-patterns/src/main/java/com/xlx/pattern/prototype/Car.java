package com.xlx.pattern.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car implements Cloneable {

    private String brand;
    private double price;
    private CarProperty carProperty;

    /**
     * 深拷贝在此实现,对于复杂的应用类型, 这里的代码可能会相当复杂,如果类有修改(新增成员变量等),这里也需要相应修改
     * @return
     */
    public Object clone(){
        Object car = null;
        try {
            car = super.clone();
            CarProperty carPropertyClone = (CarProperty)this.getCarProperty().clone();
            ((Car)car).setCarProperty(carPropertyClone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return car;
    }


    public static void main(String[] args) {

        CarProperty carProperty = new CarProperty("8匹",250,30);
        Car car= new Car("BMW",200,carProperty);

        Car copy = (Car) car.clone();
        System.out.println("copy最大速度为: "+copy.getCarProperty().getMaxSpeed());
        System.out.println("原型最大速度为: "+car.getCarProperty().getMaxSpeed());
        car.getCarProperty().setMaxSpeed(360);
        System.out.println("copy最大速度为: "+copy.getCarProperty().getMaxSpeed());
        System.out.println("原型最大速度为: "+car.getCarProperty().getMaxSpeed());
    }

}
