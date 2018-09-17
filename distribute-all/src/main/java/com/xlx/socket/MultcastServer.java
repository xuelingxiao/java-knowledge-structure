package com.xlx.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.concurrent.TimeUnit;

// 服务端
public class MultcastServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 多播必须是224网段
        InetAddress group = InetAddress.getByName("224.7.8.9");
        MulticastSocket socket = new MulticastSocket();
        for (int i = 0; i < 10; i++) {
            String data = "multcast"+i;
            byte[] bytes = data.getBytes();
            socket.send(new DatagramPacket(bytes,bytes.length,group,8888));
            TimeUnit.SECONDS.sleep(2);
        }
    }
}
