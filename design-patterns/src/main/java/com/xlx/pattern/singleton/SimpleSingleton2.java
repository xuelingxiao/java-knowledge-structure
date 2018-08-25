package com.xlx.pattern.singleton;

/**
 * 简单实现
 * 特点: 延迟加载, 但线程不安全
 */
public class SimpleSingleton2 {

    private static SimpleSingleton2 onlyOneInstance;

    private SimpleSingleton2(){}

    public static SimpleSingleton2 getOnlyOneInstance(){
        if (onlyOneInstance==null){
            onlyOneInstance = new SimpleSingleton2();
        }
        return  onlyOneInstance;
    }

}
