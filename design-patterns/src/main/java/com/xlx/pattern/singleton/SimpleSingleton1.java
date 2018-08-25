package com.xlx.pattern.singleton;

/**
 * 最简单实现,饿汉模式
 * 特点: 线程安全,但没有延迟加载带来的节省资源好处
 */
public class SimpleSingleton1 {

    private static SimpleSingleton1 onlyOneInstance = new SimpleSingleton1();

    private SimpleSingleton1(){}

    public static SimpleSingleton1 getOnlyOneInstance(){
        return onlyOneInstance;
    }

}
