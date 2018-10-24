package com.xlx.mvc.service;

public class MyService {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MyThing getMyThing() {
        return myThing;
    }

    public void setMyThing(MyThing myThing) {
        this.myThing = myThing;
    }

    private int id;
    private MyThing myThing;

    @Override
    public String toString() {
        return "class MyService[id="+this.getId()+"; myThing="+this.myThing.toString()+"]";
    }
}
