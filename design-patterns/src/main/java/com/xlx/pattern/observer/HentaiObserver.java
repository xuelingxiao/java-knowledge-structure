package com.xlx.pattern.observer;

public class HentaiObserver implements MyObserver {
    public void update(Subject subject) {
        ConcreteSubject concreteSubject = (ConcreteSubject)subject;
        System.out.println("HentaiObserver 知道了: "+concreteSubject.getName());
    }
}
