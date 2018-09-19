package com.xlx.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRmiTest extends Remote {
    String hello() throws RemoteException;
}
