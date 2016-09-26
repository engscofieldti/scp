// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 8/24/2015 2:22:31 PM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ObtenerDocumentoAction.java

package com.dgac.app.alfresco.impl;

import java.io.IOException;

import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.commons.io.IOUtils;

import com.dgac.app.alfresco.cmis.ClienteCMIS;
import com.dgac.app.alfresco.cmis.FabricaCMISBean;
import com.dgac.app.alfresco.dto.DocumentoAlfresco;


// Referenced classes of package cl.exe.alfresco.services.action:
//            Accion

public class ObtenerDocumentoAction
{

    public DocumentoAlfresco obtenerDocumento(String id)
        throws IOException
    {
        System.out.println((new StringBuilder("--- Obteniendo Documento desde [")).append(id).append("] ---").toString());
        DocumentoAlfresco documento = new DocumentoAlfresco();
        FabricaCMISBean fabricaCMIS = new FabricaCMISBean();
        try {
			fabricaCMIS.create();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ClienteCMIS clienteCMIS = new ClienteCMIS(fabricaCMIS);
        Document doc = (Document)clienteCMIS.getObject(id);
        documento.setName(doc.getContentStream().getFileName());
        java.io.InputStream is = doc.getContentStream().getStream();
        byte bs[] = IOUtils.toByteArray(is);
        documento.setData(bs);
        documento.setContentType(doc.getContentStream().getMimeType());
        documento.setSize(doc.getContentStream().getLength());
        return documento;
    }
}
