package com.xlx.pattern;


import com.xlx.pattern.abstractfactory.*;
import com.xlx.pattern.proxy.jdk.Agent;
import com.xlx.pattern.proxy.jdk.Car;
import com.xlx.pattern.proxy.jdk.QQCar;
import com.xlx.pattern.proxy.my.MyAgent;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class Program {

    public static void main(String[] args) {

        //工厂方法
        //Client client = new Client();
        //client.drive();

        // proxy代理模式
        //new QQCar().sale();
        try {
//            Car car = (Car) new Agent().getInstance(new QQCar());
//            car.sale();
//
//
//            //生产接口Car对应的代理类class文件并保存到文件
//            byte[] data = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Car.class});
//            FileOutputStream outputStream = new FileOutputStream("E:\\学习\\代码\\java-knowledge-structure\\design-patterns\\src\\main\\java\\com\\xlx\\pattern\\proxy\\jdk\\$Proxy0.class");
//            outputStream.write(data);
//            outputStream.close();

            // 使用自定义的代理模式
//            Car car = (Car)new MyAgent().getInstance(new QQCar());
//            car.sale();

            PCAbstractFactory factory = new MacFactory();
            CPU cpu = factory.createCPU();
            RAM ram = factory.createRAM();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
