package com.xlx.pattern.delegate;

/**
 * 具体实现类A
 */
public class ConcreteTaskA implements Task {
    public void doTask() {
        System.out.println("执行 , 由A实现");
    }
}
