package com.xlx.threads.threads01;

public class RunThread extends Thread {

    private boolean isDoing = true;

    public void setIsDoing(boolean isDoing) {
        this.isDoing = isDoing;
    }

    public void run() {
        while (isDoing) {
            System.out.println("RunThread is running...");
        }
        System.out.println("RunThread stoped...");
    }

    public static void main(String[] args) {
        try {
            RunThread thread = new RunThread();
            thread.start();
            Thread.sleep(3000);
            thread.setIsDoing(false);
            System.out.println("RunThread  set isDoing=false");
            Thread.sleep(1000);
            System.out.println(thread.isDoing);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
