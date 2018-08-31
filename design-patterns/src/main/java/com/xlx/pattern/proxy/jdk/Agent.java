package com.xlx.pattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 经纪公司,或者经销商
 */
public class Agent implements InvocationHandler {

    private Car car ;

    /**
     * 返回代理对象,接收被代理对象
     * @param car
     * @return
     * @throws Exception
     */
    public Object getInstance(Car car) throws Exception {
        this.car=car;
        Class clazz = car.getClass();
        System.out.println("代理前对象的类型"+car.getClass().getName());
        Object obj = Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
        System.out.println("代理后对象类型变为"+obj.getClass().getName());
        return obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Agent find some costumers");
        //this.car.sale();
        method.invoke(this.car, args);
        System.out.println("Agent saled the car");
        return null;
    }
}
