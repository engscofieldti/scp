package com.dgac.app.alfresco.cmis;

import java.io.InputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.chemistry.opencmis.client.api.ChangeEvents;
import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.ItemIterable;
import org.apache.chemistry.opencmis.client.api.ObjectFactory;
import org.apache.chemistry.opencmis.client.api.ObjectId;
import org.apache.chemistry.opencmis.client.api.ObjectType;
import org.apache.chemistry.opencmis.client.api.OperationContext;
import org.apache.chemistry.opencmis.client.api.Policy;
import org.apache.chemistry.opencmis.client.api.QueryResult;
import org.apache.chemistry.opencmis.client.api.Relationship;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.Tree;
import org.apache.chemistry.opencmis.commons.PropertyIds;
import org.apache.chemistry.opencmis.commons.data.Ace;
import org.apache.chemistry.opencmis.commons.data.Acl;
import org.apache.chemistry.opencmis.commons.data.ContentStream;
import org.apache.chemistry.opencmis.commons.data.RepositoryInfo;
import org.apache.chemistry.opencmis.commons.enums.AclPropagation;
import org.apache.chemistry.opencmis.commons.enums.IncludeRelationships;
import org.apache.chemistry.opencmis.commons.enums.RelationshipDirection;
import org.apache.chemistry.opencmis.commons.enums.VersioningState;
import org.apache.chemistry.opencmis.commons.exceptions.CmisBaseException;
import org.apache.chemistry.opencmis.commons.impl.dataobjects.ContentStreamImpl;
import org.apache.chemistry.opencmis.commons.spi.CmisBinding;

public class ClienteCMIS implements Session {

	private Session session;
	
	FabricaCMISBean fabricaCMIS;

	public ClienteCMIS() {

	}

	public ClienteCMIS(FabricaCMISBean fabricaCMIS) {
		this.fabricaCMIS = fabricaCMIS;
	}

	public Session getSession() {
		if (session == null) {
			session = fabricaCMIS.getSession();
		}
		return session;
	}

	public void clear() {
		getSession().clear();

	}

	public ObjectId createDocument(Map<String, ?> arg0, ObjectId arg1,
			ContentStream arg2, VersioningState arg3, List<Policy> arg4,
			List<Ace> arg5, List<Ace> arg6) {
		return getSession().createDocument(arg0, arg1, arg2, arg3, arg4, arg5,
				arg6);
	}

	public ObjectId createDocumentFromSource(ObjectId arg0,
			Map<String, ?> arg1, ObjectId arg2, VersioningState arg3,
			List<Policy> arg4, List<Ace> arg5, List<Ace> arg6) {
		return getSession().createDocumentFromSource(arg0, arg1, arg2, arg3,
				arg4, arg5, arg6);
	}

	public ObjectId createFolder(Map<String, ?> arg0, ObjectId arg1,
			List<Policy> arg2, List<Ace> arg3, List<Ace> arg4) {
		return getSession().createFolder(arg0, arg1, arg2, arg3, arg4);
	}

	public ObjectId createObjectId(String arg0) {
		// TODO Auto-generated method stub
		return getSession().createObjectId(arg0);
	}

	public OperationContext createOperationContext() {
		return getSession().createOperationContext();
	}

	public OperationContext createOperationContext(Set<String> arg0,
			boolean arg1, boolean arg2, boolean arg3,
			IncludeRelationships arg4, Set<String> arg5, boolean arg6,
			String arg7, boolean arg8, int arg9) {

		return getSession().createOperationContext(arg0, arg1, arg2, arg3,
				arg4, arg5, arg6, arg7, arg8, arg9);
	}

	public ObjectId createPolicy(Map<String, ?> arg0, ObjectId arg1,
			List<Policy> arg2, List<Ace> arg3, List<Ace> arg4) {
		return getSession().createPolicy(arg0, arg1, arg2, arg3, arg4);
	}

	public ObjectId createRelationship(Map<String, ?> arg0, List<Policy> arg1,
			List<Ace> arg2, List<Ace> arg3) {
		return getSession().createRelationship(arg0, arg1, arg2, arg3);
	}

	public CmisBinding getBinding() {
		return getSession().getBinding();
	}

	public ItemIterable<Document> getCheckedOutDocs() {
		return getSession().getCheckedOutDocs();
	}

	public ItemIterable<Document> getCheckedOutDocs(OperationContext arg0) {
		return getSession().getCheckedOutDocs(arg0);
	}

	public OperationContext getDefaultContext() {
		return getSession().getDefaultContext();
	}

	public Locale getLocale() {
		return getSession().getLocale();
	}

	public CmisObject getObject(ObjectId arg0) {
		return getSession().getObject(arg0);
	}

	public CmisObject getObject(ObjectId arg0, OperationContext arg1) {
		return getSession().getObject(arg0, arg1);
	}

	public CmisObject getObjectByPath(String arg0) {
		return getSession().getObjectByPath(arg0);
	}

	public CmisObject getObjectByPath(String arg0, OperationContext arg1) {
		return getSession().getObjectByPath(arg0, arg1);
	}

	public ObjectFactory getObjectFactory() {
		return getSession().getObjectFactory();
	}

	public RepositoryInfo getRepositoryInfo() {
		return getSession().getRepositoryInfo();
	}

	public Folder getRootFolder() {
		return getSession().getRootFolder();
	}

	public Folder getRootFolder(OperationContext arg0) {
		return getRootFolder(arg0);
	}

	public ItemIterable<ObjectType> getTypeChildren(String arg0, boolean arg1) {
		return getSession().getTypeChildren(arg0, arg1);
	}

	public ObjectType getTypeDefinition(String arg0) {
		return getSession().getTypeDefinition(arg0);
	}

	public List<Tree<ObjectType>> getTypeDescendants(String arg0, int arg1,
			boolean arg2) {
		return getTypeDescendants(arg0, arg1, arg2);
	}

	public ItemIterable<QueryResult> query(String arg0, boolean arg1) {
		return getSession().query(arg0, arg1);
	}

	public ItemIterable<QueryResult> query(String arg0, boolean arg1,
			OperationContext arg2) {
		return getSession().query(arg0, arg1);
	}

	public void setDefaultContext(OperationContext arg0) {
		getSession().setDefaultContext(arg0);

	}

	public Acl applyAcl(ObjectId arg0, List<Ace> arg1, List<Ace> arg2,
			AclPropagation arg3) {
		return getSession().applyAcl(arg0, arg1, arg2, arg3);
	}

	public void applyPolicy(ObjectId arg0, ObjectId... arg1) {
		getSession().applyPolicy(arg0, arg1);

	}

	public ObjectId createDocument(Map<String, ?> arg0, ObjectId arg1,
			ContentStream arg2, VersioningState arg3) {

		return getSession().createDocument(arg0, arg1, arg2, arg3);
	}

	public ObjectId createDocumentFromSource(ObjectId arg0,
			Map<String, ?> arg1, ObjectId arg2, VersioningState arg3) {
		return getSession().createDocumentFromSource(arg0, arg1, arg2, arg3);
	}

	public ObjectId createFolder(Map<String, ?> arg0, ObjectId arg1) {

		return getSession().createFolder(arg0, arg1);
	}

	public ObjectId createPolicy(Map<String, ?> arg0, ObjectId arg1) {

		return getSession().createPolicy(arg0, arg1);
	}

	public ObjectId createRelationship(Map<String, ?> arg0) {
		return getSession().createRelationship(arg0);
	}

	public Acl getAcl(ObjectId arg0, boolean arg1) {
		return getSession().getAcl(arg0, arg1);
	}

	public ChangeEvents getContentChanges(String arg0, boolean arg1, long arg2) {
		return getSession().getContentChanges(arg0, arg1, arg2);
	}

	public ChangeEvents getContentChanges(String arg0, boolean arg1, long arg2,
			OperationContext arg3) {
		return getSession().getContentChanges(arg0, arg1, arg2);
	}

	public CmisObject getObject(String arg0) {
		// TODO Auto-generated method stub
		return getSession().getObject(arg0);
	}

	public CmisObject getObject(String arg0, OperationContext arg1) {
		return getSession().getObject(arg0, arg1);
	}

	public ItemIterable<Relationship> getRelationships(ObjectId arg0,
			boolean arg1, RelationshipDirection arg2, ObjectType arg3,
			OperationContext arg4) {
		return getSession().getRelationships(arg0, arg1, arg2, arg3, arg4);
	}

	public void removePolicy(ObjectId arg0, ObjectId... arg1) {
		getSession().removePolicy(arg0, arg1);

	}

	public String procesarNombre(String nombre) {
		int indiceSlash = nombre.lastIndexOf("/");
		int indiceBackSlash = nombre.lastIndexOf("\\");
		int indice = indiceSlash > indiceBackSlash ? indiceSlash
				: indiceBackSlash;
		if (indice > 0)
			nombre = nombre.substring(indice + 1);
		return nombre;
	}

	public Folder crearCarpeta(String nombre) {
		return crearCarpeta(nombre, null);
	}

	public Folder crearCarpeta(String nombre, String ruta) {
		Folder carpeta = null;
		
		String rutaCarpeta = (ruta != null) ? ruta + "/" : "/";
		try {
			carpeta = (Folder) getObjectByPath(rutaCarpeta + nombre);
		} catch (CmisBaseException ex) {
			Map<String, Object> properties = new HashMap<String, Object>();
			properties.put(PropertyIds.OBJECT_TYPE_ID,
					ObjectType.FOLDER_BASETYPE_ID);
			properties.put(PropertyIds.NAME, nombre);
			Folder padre = (Folder) getObjectByPath(rutaCarpeta);
			carpeta = padre.createFolder(properties);
		}
		return carpeta;
	}

	public Document crearDocumento(String nombre, String mimeType,
			InputStream contenido, long largo, ObjectId idCarpeta) {
		Document documento = null;
		ContentStream contentStream = new ContentStreamImpl(nombre,
				BigInteger.valueOf(largo), mimeType, contenido);
		Folder padre = (Folder) getObject(idCarpeta);
		nombre = procesarNombre(nombre);
		try {
			documento = (Document) getObjectByPath(padre.getPath() + "/"
					+ nombre);
			documento.setContentStream(contentStream, true);
		} catch (CmisBaseException ex) {
			Map<String, Object> properties = new HashMap<String, Object>();
			properties.put(PropertyIds.OBJECT_TYPE_ID,
					ObjectType.DOCUMENT_BASETYPE_ID);
			properties.put(PropertyIds.NAME, nombre);
			documento = padre.createDocument(properties, contentStream,
					VersioningState.MAJOR);
		}
		return documento;
	}

	public Document crearDocumento(String nombre, String mimeType,
			InputStream contenido, long largo, String ruta) {
		Document documento = null;
		String rutaCarpeta = (ruta != null) ? ruta : "/";
		nombre = procesarNombre(nombre);
		ContentStream contentStream = new ContentStreamImpl(nombre,
				BigInteger.valueOf(largo), mimeType, contenido);
		try {
			documento = (Document) getObjectByPath(rutaCarpeta + nombre);
			documento.setContentStream(contentStream, true);
		} catch (CmisBaseException ex) {
			Map<String, Object> properties = new HashMap<String, Object>();
			properties.put(PropertyIds.OBJECT_TYPE_ID,
					ObjectType.DOCUMENT_BASETYPE_ID);
			properties.put(PropertyIds.NAME, nombre);
			Folder padre = (Folder) getObjectByPath(rutaCarpeta);

			documento = padre.createDocument(properties, contentStream,
					VersioningState.MAJOR);
		}
		return documento;
	}

}
