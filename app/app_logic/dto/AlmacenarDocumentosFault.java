// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 8/24/2015 2:22:40 PM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   AlmacenarDocumentosFault.java

package com.dgac.app.alfresco.dto;

import java.io.Serializable;

public class AlmacenarDocumentosFault implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlmacenarDocumentosFault()
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
