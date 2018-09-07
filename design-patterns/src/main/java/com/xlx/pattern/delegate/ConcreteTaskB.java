package com.xlx.pattern.delegate;

/**
 * 具体实现类B
 */
public class ConcreteTaskB implements Task {
    public void doTask() {
        System.out.println("执行 , 由B实现");
    }
}
