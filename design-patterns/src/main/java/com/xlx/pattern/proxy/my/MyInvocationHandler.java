package com.xlx.pattern.proxy.my;

import java.lang.reflect.Method;

/**
 * 代理类需要实现该接口
 */
public interface MyInvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
