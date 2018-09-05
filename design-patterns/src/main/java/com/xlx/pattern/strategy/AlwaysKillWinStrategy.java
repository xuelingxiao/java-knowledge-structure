package com.xlx.pattern.strategy;


import lombok.AllArgsConstructor;

/**

 * 采用人挡杀人的模式
 */
@AllArgsConstructor
public class AlwaysKillWinStrategy implements WinStrategy {

    private String weather;

    public void win() {
        System.out.println("总是很钢,大杀四方"+" 天气:"+weather);
    }
}
