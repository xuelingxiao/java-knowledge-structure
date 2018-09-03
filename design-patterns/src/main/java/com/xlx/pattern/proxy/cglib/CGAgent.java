//package com.xlx.pattern.proxy.cglib;
//
//
//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
//
//import java.lang.reflect.Method;
//
///**
// * 演示 cglib 代理方式
// */
//public class CGAgent implements MethodInterceptor {
//
//    public Object getInstance(Class clazz) throws Exception{
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(clazz);
//        enhancer.setCallback(this);
//        return enhancer.create();
//    }
//
//    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//        System.out.println("代理开始了....");
//        // 这里必须使用方法invokeSuper,invoke会导致循环调用
//        methodProxy.invokeSuper(o,objects);
//        System.out.println("代理结束了....");
//        return null;
//    }
//}
