package com.xlx.threads.threads01;

public class MyObject {
    public synchronized  void method1(){
        try{
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    // synchronized
    public synchronized void method2(){
        System.out.println(Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        final MyObject mo = new MyObject();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                mo.method1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                mo.method2();
            }
        });

        t1.start();
        t2.start();
    }
}
