
package org.dgac.webservices.server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.dgac.webservices.server package. 
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

    private final static QName _LoginResponse_QNAME = new QName("http://server.webservices.dgac.org/", "loginResponse");
    private final static QName _Login_QNAME = new QName("http://server.webservices.dgac.org/", "login");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.dgac.webservices.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link Login_Type }
     * 
     */
    public Login_Type createLogin_Type() {
        return new Login_Type();
    }

    /**
     * Create an instance of {@link Grupo }
     * 
     */
    public Grupo createGrupo() {
        return new Grupo();
    }

    /**
     * Create an instance of {@link ResultDTO }
     * 
     */
    public ResultDTO createResultDTO() {
        return new ResultDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservices.dgac.org/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservices.dgac.org/", name = "login")
    public JAXBElement<Login_Type> createLogin(Login_Type value) {
        return new JAXBElement<Login_Type>(_Login_QNAME, Login_Type.class, null, value);
    }

}
