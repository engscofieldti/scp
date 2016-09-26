// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 8/24/2015 2:23:17 PM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   DocumentoAlfrescoResponse.java

package com.dgac.app.alfresco.dto ;

import java.io.Serializable;



public class DocumentoAlfrescoResponse implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public DocumentoAlfrescoResponse()
    {
    }

    public long getId()
    {
        return id;
    }

    public void setId(long value)
    {
        id = value;
    }

    public String getSpaceStore()
    {
        return spaceStore;
    }

    public void setSpaceStore(String spaceStore)
    {
        this.spaceStore = spaceStore;
    }

    private long id;
    private String spaceStore;
}
