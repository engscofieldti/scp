// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 8/24/2015 2:23:01 PM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   DocumentoAlfresco.java

package com.dgac.app.alfresco.dto;

import java.io.Serializable;

public class DocumentoAlfresco implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public DocumentoAlfresco()
    {
    }

    public String getContentType()
    {
        return contentType;
    }

    public void setContentType(String value)
    {
        contentType = value;
    }

    public byte[] getData()
    {
        return data;
    }

    public void setData(byte value[])
    {
        data = value;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long value)
    {
        id = value;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String value)
    {
        name = value;
    }

    public Long getSize()
    {
        return size;
    }

    public void setSize(Long value)
    {
        size = value;
    }

    private String contentType;
    private byte data[];
    private long id;
    private String name;
    private Long size;
}
