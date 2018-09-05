package com.xlx.pattern.strategy;

import lombok.Data;

/**
 * 上下文
 */
@Data
public class Context {

    private String weather;
    WinStrategy winStrategy;

    public Context(String weather, WinStrategy winStrategy) {
        this.weather = weather;
        this.winStrategy = winStrategy;
    }

    public void winGame() {
        winStrategy.win();
        System.out.println("天气情况:"+this.weather+"; 采用的策略"+winStrategy.getClass());
    }

}
