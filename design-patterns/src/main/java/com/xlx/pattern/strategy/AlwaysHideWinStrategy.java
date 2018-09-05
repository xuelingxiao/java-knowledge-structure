package com.xlx.pattern.strategy;

/**
 * 采用LYB的模式
 */
public class AlwaysHideWinStrategy implements WinStrategy {
    public void win() {
        System.out.println("总是很苟,活得长久; 天气: ");
    }
}
