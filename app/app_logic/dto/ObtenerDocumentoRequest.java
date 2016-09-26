// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 8/24/2015 2:21:45 PM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ObtenerDocumentoRequest.java

package com.dgac.app.alfresco.dto;

import java.io.Serializable;


public class ObtenerDocumentoRequest implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public ObtenerDocumentoRequest()
    {
    }

    public String getId()
    {
        return id;
    }

    public void setId(String value)
    {
        id = value;
    }

    private String id;
}
