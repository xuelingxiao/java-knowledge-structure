
package com.xlx.ws.client;

import com.xlx.ws.BMWCar;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "BMWCarService", targetNamespace = "http://ws.xlx.com/", wsdlLocation = "http://localhost:8090/car?wsdl")
public class BMWCarService
    extends Service
{

    private final static URL BMWCARSERVICE_WSDL_LOCATION;
    private final static WebServiceException BMWCARSERVICE_EXCEPTION;
    private final static QName BMWCARSERVICE_QNAME = new QName("http://ws.xlx.com/", "BMWCarService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8090/car?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BMWCARSERVICE_WSDL_LOCATION = url;
        BMWCARSERVICE_EXCEPTION = e;
    }

    public BMWCarService() {
        super(__getWsdlLocation(), BMWCARSERVICE_QNAME);
    }

    public BMWCarService(WebServiceFeature... features) {
        super(__getWsdlLocation(), BMWCARSERVICE_QNAME, features);
    }

    public BMWCarService(URL wsdlLocation) {
        super(wsdlLocation, BMWCARSERVICE_QNAME);
    }

    public BMWCarService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BMWCARSERVICE_QNAME, features);
    }

    public BMWCarService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BMWCarService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BMWCar
     */
    @WebEndpoint(name = "BMWCarPort")
    public com.xlx.ws.client.BMWCar getBMWCarPort() {
        return super.getPort(new QName("http://ws.xlx.com/", "BMWCarPort"), com.xlx.ws.client.BMWCar.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BMWCar
     */
    @WebEndpoint(name = "BMWCarPort")
    public com.xlx.ws.BMWCar getBMWCarPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.xlx.com/", "BMWCarPort"), BMWCar.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BMWCARSERVICE_EXCEPTION!= null) {
            throw BMWCARSERVICE_EXCEPTION;
        }
        return BMWCARSERVICE_WSDL_LOCATION;
    }

}