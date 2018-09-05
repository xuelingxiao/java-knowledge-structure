package com.xlx.pattern.strategy;

/**
 *
 */
public class StrategyTest {
    public static void main(String[] args) {
//        WinStrategy iWillWin = new AlwaysHideWinStrategy();
//        iWillWin.win();
//        iWillWin = new AlwaysKillWinStrategy();
//        iWillWin.win();
//        Context context = new Context("雾天",iWillWin);
//        context.winGame();

        WinStrategy iWillWin = new AlwaysKillWinStrategy("雾天");
        Context context = new Context("雾天",iWillWin);
        context.winGame();
    }
}
