package com.xlx.threads.threads01;

public class MultThread {
    private int num = 0;

    // static
    public  synchronized void printNum(String tag) {
        try {
            if (tag.equals("a")) {
                num = 100;
                System.out.println("tag a,set num over!");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println("tag b,set num over!");
            }
            System.out.println("tag " + tag + ", num=" + num);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final MultThread m1 = new MultThread();
        final MultThread m2 = new MultThread();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
m1.printNum("a");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                m2.printNum("b");
            }
        });

        t1.start();
        t2.start();
    }
}
