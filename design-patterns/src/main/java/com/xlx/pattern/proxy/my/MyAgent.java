package com.xlx.pattern.proxy.my;

import com.xlx.pattern.proxy.jdk.Car;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类
 */
public class MyAgent implements MyInvocationHandler {

    private Car car;

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Agent find some costumers");
        //this.car.sale();
        method.invoke(this.car,args);
        System.out.println("Agent saled the car");
        return null;
    }

    public Object getInstance(Car car) throws Exception {
        this.car=car;
        Class clazz = car.getClass();
        Object obj = MyProxy.newProxyInstance(new MyClassLoader(),clazz.getInterfaces(),this);
        return obj;
    }
}
