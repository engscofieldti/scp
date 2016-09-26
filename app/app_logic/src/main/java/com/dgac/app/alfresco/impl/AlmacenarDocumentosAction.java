// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 8/24/2015 2:22:24 PM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   AlmacenarDocumentosAction.java

package com.dgac.app.alfresco.impl;

import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.log4j.Logger;

import com.dgac.app.alfresco.cmis.ClienteCMIS;
import com.dgac.app.alfresco.cmis.FabricaCMISBean;
import com.dgac.app.alfresco.dto.DocumentoAlfresco;
import com.dgac.app.alfresco.dto.DocumentoAlfrescoResponse;
import com.dgac.app.alfresco.dto.DocumentoAlfrescoResponseArray;


// Referenced classes of package cl.exe.alfresco.services.action:
//            Accion

public class AlmacenarDocumentosAction
{


    public DocumentoAlfrescoResponse almacenarDocumentos(String ruta, List documentos)
        throws Exception
    {
        Document documento = null;
        java.io.InputStream stream = null;
        DocumentoAlfrescoResponse docResponse = null;
        DocumentoAlfrescoResponseArray docsResponseArray = new DocumentoAlfrescoResponseArray();
        FabricaCMISBean fabricaCMIS = new FabricaCMISBean();
        fabricaCMIS.create();
        ClienteCMIS clienteCMIS = new ClienteCMIS(fabricaCMIS);
        String carpetas[] = ruta.split("/");
        String doc = null;
        try
        {
            Folder f = crearRutaDirectorios(clienteCMIS, carpetas);
            DocumentoAlfresco d;
            for(Iterator iterator = documentos.iterator(); iterator.hasNext(); System.out.println((new StringBuilder("--- Documento [")).append(d.getId()).append("] almacenado en [").append(documento.getId()).append("] ---").toString()))
            {
                d = (DocumentoAlfresco)iterator.next();
                doc = d.getName();
                stream = new ByteArrayInputStream(d.getData());
                documento = clienteCMIS.crearDocumento(d.getName(), d.getContentType(), stream, d.getSize().longValue(), f);
                docResponse = new DocumentoAlfrescoResponse();
                docResponse.setId(d.getId());
                docResponse.setSpaceStore(documento.getId());
                docsResponseArray.getItem().add(docResponse);
            }

        }
        catch(Exception ex)
        {
            System.out.println((new StringBuilder("Error al almacenar documento [")).append(doc).append("]:").toString());
            throw new Exception(ex);
        }
        return docResponse;
    }

    private Folder crearRutaDirectorios(ClienteCMIS clienteCMIS, String carpetas[])
    {
        Folder f = null;
        String ruta = "/";
        String as[];
        int j = (as = carpetas).length;
        for(int i = 0; i < j; i++)
        {
            String carpeta = as[i];
            if(!carpeta.isEmpty())
            {
                System.out.println((new StringBuilder("carpeta [")).append(carpeta).append("] : ").append(ruta.length() <= 1 ? ruta : ruta.substring(0, ruta.length() - 1)).toString());
                f = clienteCMIS.crearCarpeta(carpeta, ruta.length() <= 1 ? "" : ruta.substring(0, ruta.length() - 1));
                ruta = (new StringBuilder(String.valueOf(ruta))).append(carpeta).append("/").toString();
            }
        }

        return f;
    }

    public static void main(String args[])
    {
        String path = "/A/B/C/D/F";
        String carpetas[] = path.split("/");
        String ruta = "/";
        String args1[];
        int j = (args1 = carpetas).length;
        for(int i = 0; i < j; i++)
        {
            String carpeta = args1[i];
            if(!carpeta.isEmpty())
            {
                System.out.println((new StringBuilder("carpeta [")).append(carpeta).append("] : ").append(ruta.length() <= 1 ? ruta : ruta.substring(0, ruta.length() - 1)).toString());
                ruta = (new StringBuilder(String.valueOf(ruta))).append(carpeta).append("/").toString();
            }
        }

    }
}
