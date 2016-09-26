// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 8/24/2015 2:21:37 PM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ObtenerDocumentoFault.java

package com.dgac.app.alfresco.dto;

import java.io.Serializable;

public class ObtenerDocumentoFault implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public ObtenerDocumentoFault()
    {
    }

    public String getCodigo()
    {
        return codigo;
    }

    public void setCodigo(String value)
    {
        codigo = value;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String value)
    {
        descripcion = value;
    }

    private String codigo;
    private String descripcion;
}
