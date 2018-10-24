package com.xlx.mvc.service;

public class MyThing {

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int count;

    @Override
    public String toString() {
        return "class MyThing[count="+this.getCount()+"]";
    }
}
