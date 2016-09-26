// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 8/24/2015 2:21:55 PM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ObtenerDocumentoResponse.java

package com.dgac.app.alfresco.dto;

import java.io.Serializable;


// Referenced classes of package cl.exe.alfresco.services.obtenerdocumento:
//            DocumentoAlfresco

public class ObtenerDocumentoResponse implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public ObtenerDocumentoResponse()
    {
    }

    public DocumentoAlfresco getDocumento()
    {
        return documento;
    }

    public void setDocumento(DocumentoAlfresco value)
    {
        documento = value;
    }

    private DocumentoAlfresco documento;
}
