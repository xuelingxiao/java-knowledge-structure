package com.xlx.pattern.observer;

import java.util.ArrayList;

/**
 * 主题抽象角色
 */
public abstract class Subject {

    private ArrayList<MyObserver> list = new ArrayList<MyObserver>();

    public Subject register(MyObserver observer){
        if(!list.contains(observer)){
            list.add(observer);
        }
        return this;
    }

    public Subject unRegister(MyObserver observer){
        if(list.contains(observer)){
            list.remove(observer);
        }
        return this;
    }

    public final void notifyObservers(){
        for (MyObserver item:list) {
            item.update(this);
        }
    }

    /**
     * 具体状态的变更
     */
    abstract void change();
}
