package com.xlx.pattern.builder;

import lombok.Data;

/**
 *  Car 有很多成员变量, 当然成员可能是一些复杂类型, 这里简化只定义一些基本类型
 */
@Data
public class Car {
    private String engine; //发动机
    private String chassis; // 底盘
    private String body; //车身
    private String wheels;  //轮子
    private String equipment; //构件, 可选
    private String radar;// 雷达, 可选
}
