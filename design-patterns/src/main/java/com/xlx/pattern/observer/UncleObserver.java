package com.xlx.pattern.observer;

public class UncleObserver implements MyObserver {
    public void update(Subject subject) {
        ConcreteSubject concreteSubject = (ConcreteSubject)subject;
        System.out.println("UncleObserver 知道了: "+concreteSubject.getName());
    }
}
