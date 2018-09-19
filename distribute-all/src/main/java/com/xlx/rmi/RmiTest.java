package com.xlx.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiTest extends UnicastRemoteObject implements IRmiTest {

    public RmiTest() throws RemoteException {

    }

    @Override
    public String hello() {
        return "Hello ....";
    }
}
