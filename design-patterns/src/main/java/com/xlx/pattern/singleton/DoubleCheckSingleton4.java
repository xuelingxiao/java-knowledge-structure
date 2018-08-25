package com.xlx.pattern.singleton;

/**
 * 双重校验
 * 特点: 线程安全,延迟加载,基本不会发生阻塞
 */
public class DoubleCheckSingleton4 {

    private volatile DoubleCheckSingleton4 onlyOneInstance;

    private DoubleCheckSingleton4(){}

    public DoubleCheckSingleton4 getOnlyOneInstance(){
        if (onlyOneInstance==null){
            synchronized (DoubleCheckSingleton4.class){
                if (onlyOneInstance==null){
                    onlyOneInstance = new DoubleCheckSingleton4();
                }
            }
        }
        return onlyOneInstance;
    }

}
