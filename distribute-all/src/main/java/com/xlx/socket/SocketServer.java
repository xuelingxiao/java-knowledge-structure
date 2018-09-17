package com.xlx.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try{
            serverSocket = new ServerSocket(8888);
            Socket socket= serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());
            reader.close();
            socket.close();
        }catch (Exception e){

        }finally {
            if(serverSocket!=null){
                serverSocket.close();
            }
        }
    }
}
