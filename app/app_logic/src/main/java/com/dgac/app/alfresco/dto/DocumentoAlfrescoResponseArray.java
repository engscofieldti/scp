// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 8/24/2015 2:23:24 PM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   DocumentoAlfrescoResponseArray.java

package com.dgac.app.alfresco.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DocumentoAlfrescoResponseArray implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public DocumentoAlfrescoResponseArray()
    {
    }

    public List getItem()
    {
        if(item == null)
            item = new ArrayList();
        return item;
    }
    private List item;
}
