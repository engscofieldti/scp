
package org.dgac.ws.integration.server.alfresco.buscar;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "obtenerDocumentoFault", targetNamespace = "http://www.exe.cl/obtenerdocumento")
public class ObtenerDocumentoFault1
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ObtenerDocumentoFault faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public ObtenerDocumentoFault1(String message, ObtenerDocumentoFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public ObtenerDocumentoFault1(String message, ObtenerDocumentoFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: cl.exe.obtenerdocumento.ObtenerDocumentoFault
     */
    public ObtenerDocumentoFault getFaultInfo() {
        return faultInfo;
    }

}
