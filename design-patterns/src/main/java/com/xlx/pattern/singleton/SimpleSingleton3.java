package com.xlx.pattern.singleton;

/**
 * 简单实现
 * 特点: 延迟加载, 线程不安全,但容易阻塞
 */
public class SimpleSingleton3 {

    private static SimpleSingleton3 onlyOneInstance;

    private SimpleSingleton3(){}

    public static synchronized SimpleSingleton3 getOnlyOneInstance(){
        if (onlyOneInstance==null){
            onlyOneInstance = new SimpleSingleton3();
        }
        return onlyOneInstance;
    }

}
