package com.xlx.pattern.templatemethod;

/**
 * 磨坊
 */
public abstract class MillTemplate {

    /**
     * 模板方法,定义步骤
     */
    public final void produce(){
        //准备(可能是小麦,也可能是玉米)
        prepare();
        //开机器
        start();
        //包装
        packaging();

        //检查的钩子方法
        if(needRecheck()){
            recheck();
        }

        //运输(可能水路也可能火车)
        transport();
    }



    //准备(可能是小麦,也可能是玉米)
    protected abstract void prepare();

    private void start(){
        System.out.println("启动机器, 开始研磨...");
    }

    private void packaging(){
        System.out.println("包装...");
    }

    private void recheck(){
        System.out.println("检查...");
    }

    //运输(可能水路也可能火车)
    protected abstract void transport();

    //钩子方法
    protected boolean needRecheck(){
        return true;
    }
}
