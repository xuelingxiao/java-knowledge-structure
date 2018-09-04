package com.xlx.pattern.templatemethod;

/**
 * 小麦磨坊
 */
public class WheatMill extends MillTemplate {

    protected void prepare() {
        System.out.println("准备好小麦");
    }

    protected void transport() {
        System.out.println("船运");
    }

    @Override
    protected boolean needRecheck(){
        return false;
    }
}
