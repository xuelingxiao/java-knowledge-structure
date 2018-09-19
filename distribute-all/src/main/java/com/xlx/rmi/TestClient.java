package com.xlx.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class TestClient {
    public static void main(String[] args) throws RemoteException,  MalformedURLException, NotBoundException {
        IRmiTest rmiTest = (IRmiTest) Naming.lookup("rmi://localhost:8888/hello");
        System.out.println(rmiTest.hello());
    }
}
