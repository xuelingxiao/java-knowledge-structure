package com.xlx.pattern.singleton;

/**
 * 静态内部类
 * 特点: JVM保证了线程安全,延迟加载
 */
public class StaticInnerClassSingleton5 {

    private StaticInnerClassSingleton5(){}

    private static class InstanceHolder{

        private static final StaticInnerClassSingleton5 OnlyOneInstance = new StaticInnerClassSingleton5();

    }

    public static StaticInnerClassSingleton5 getOnlyOneInstance(){
        return InstanceHolder.OnlyOneInstance;
    }

}
