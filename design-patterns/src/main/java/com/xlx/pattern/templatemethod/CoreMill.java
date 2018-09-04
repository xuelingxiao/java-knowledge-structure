package com.xlx.pattern.templatemethod;

/**
 * 玉米磨坊
 */
public class CoreMill extends MillTemplate {
    protected void prepare() {
        System.out.println("准备好玉米");
    }

    protected void transport() {
        System.out.println("火车运输");
    }
}
