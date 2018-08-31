package com.xlx.pattern.proxy.jdk;

/**
 * 接口Car的具体实现,是代理模式中的真实角色
 */
public class QQCar implements Car {
    public void sale() {
        System.out.println("卖了一辆qq");
    }
}
