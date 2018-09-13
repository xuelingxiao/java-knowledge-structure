package com.xlx.pattern.observer;

import lombok.Data;

/**
 * 具体主题角色
 */
@Data
public class ConcreteSubject extends Subject {
    private String name;
    public void change() {
        this.setName("王多鱼");
        super.notifyObservers();
    }


    public static void main(String[] args) {
        new ConcreteSubject()
                .register(new UncleObserver())
                .register(new HentaiObserver())
                .change();
    }
}
