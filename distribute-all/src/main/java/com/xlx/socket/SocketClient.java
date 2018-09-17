package com.xlx.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        try{
            Socket socket = new Socket("localhost",8888);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            writer.println("this is a message from client");
            writer.close();
            socket.close();
        }catch (Exception e){

        }finally {

        }
    }
}
