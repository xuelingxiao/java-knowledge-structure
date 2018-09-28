package com.xlx.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ICar {
    @WebMethod
    String getCarName();
}
