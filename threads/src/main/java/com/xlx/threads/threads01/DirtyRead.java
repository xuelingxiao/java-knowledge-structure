package com.xlx.threads.threads01;

public class DirtyRead {

    private String username="xlx";
    private String password="123456";

    public synchronized void setValue(String username,String password){
        this.username=username;
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        this.password=password;
        System.out.println("setValue的最终结果: username="+this.username+",password="+this.password);
    }

    // synchronized
    public synchronized void getValue(){
        System.out.println("getValue方法得到:username="+this.username+",password="+this.password);
    }

    public static void main(String[] args) throws Exception {
        final DirtyRead dr = new DirtyRead();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                dr.setValue("yxj","789");
            }
        });
        t1.start();
        Thread.sleep(1000);
        dr.getValue();
    }

}
