
package com.xlx.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.xlx.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCarName_QNAME = new QName("http://ws.xlx.com/", "getCarName");
    private final static QName _GetCarNameResponse_QNAME = new QName("http://ws.xlx.com/", "getCarNameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.xlx.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCarNameResponse }
     * 
     */
    public GetCarNameResponse createGetCarNameResponse() {
        return new GetCarNameResponse();
    }

    /**
     * Create an instance of {@link GetCarName }
     * 
     */
    public GetCarName createGetCarName() {
        return new GetCarName();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCarName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.xlx.com/", name = "getCarName")
    public JAXBElement<GetCarName> createGetCarName(GetCarName value) {
        return new JAXBElement<GetCarName>(_GetCarName_QNAME, GetCarName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCarNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.xlx.com/", name = "getCarNameResponse")
    public JAXBElement<GetCarNameResponse> createGetCarNameResponse(GetCarNameResponse value) {
        return new JAXBElement<GetCarNameResponse>(_GetCarNameResponse_QNAME, GetCarNameResponse.class, null, value);
    }

}
