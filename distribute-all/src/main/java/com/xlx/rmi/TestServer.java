package com.xlx.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class TestServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        IRmiTest rmiTest = new RmiTest();
        LocateRegistry.createRegistry(8888);
        Naming.bind("rmi://localhost:8888/hello",rmiTest);
        System.out.println("server started");
    }
}
