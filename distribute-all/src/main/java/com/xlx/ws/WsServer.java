package com.xlx.ws;

import javax.xml.ws.Endpoint;

public class WsServer {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8090/car",new BMWCar());
    }
}
