package com.xlx.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class MultcastClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 多播必须是224网段
        InetAddress group = InetAddress.getByName("224.7.8.9");
        MulticastSocket socket = new MulticastSocket(8888);
        socket.joinGroup(group);

        byte[] buf = new byte[32];
        while (true){
            DatagramPacket packet = new DatagramPacket(buf,buf.length);
            socket.receive(packet);
            String reveived = new String(packet.getData());
            System.out.println("received:"+reveived);
        }


    }
}
