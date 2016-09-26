package org.dgac.app.logic.service.mantenedores;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.dgac.app.logic.service.ServiceGeneric;
import org.dgac.app.logic.service.sistema.SistemaService;
import org.dgac.common.constantes.ConstantesBd;
import org.dgac.common.dto.DestinatarioDTO;
import org.dgac.common.dto.DocumentoDTO;
import org.dgac.common.dto.LogDTO;
import org.dgac.common.enums.LevelEnum;
//import org.dgac.ws.integration.client.alfresco.AlmacenarAlfrescoClient;
//import org.dgac.ws.integration.server.alfresco.AlmacenarDocumentosRequest;
//import org.dgac.ws.integration.server.alfresco.AlmacenarDocumentosResponse;
//import org.dgac.ws.integration.server.alfresco.DocumentoAlfresco;
//import org.dgac.ws.integration.server.alfresco.DocumentoAlfrescoArray;
import org.dgac.ws.integration.util.IntegrationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgac.app.alfresco.dto.DocumentoAlfresco;
import com.dgac.app.alfresco.dto.DocumentoAlfrescoResponse;
import com.dgac.app.alfresco.impl.AlmacenarDocumentosAction;
import com.google.gson.Gson;

@Service
public class DocumentoServiceImpl extends ServiceGeneric implements DocumentoService {

	/** The conn. */
	private Connection conn = null;
	
	/** The pstmt. */
	private PreparedStatement pstmt = null;
	
	/** The rs. */
	private ResultSet rs = null;
	
	@Autowired
	SistemaService sistema;
	
	@Autowired
	IntegrationProperties integrationProperties;
	
	@Override
	public boolean insertDocumento(String usuario, DocumentoDTO doc) {
		// TODO Auto-generated method stub
		boolean resultado=false;
		long idDocumento=0;

		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(ConstantesBd.INSERT_DOCUMENTO,pstmt.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, doc.getDoc_ano());
			pstmt.setLong(2, doc.getDes_id());
			pstmt.setLong(3, doc.getDesc_id());
			pstmt.setString(4, new String(doc.getDoc_materia().getBytes("ISO-8859-1"),"utf-8").toUpperCase());
			Calendar calendar = Calendar.getInstance();
			java.util.Date currentDate = calendar.getTime();
			pstmt.setDate(5, new Date(currentDate.getTime()));
			pstmt.setString(6, doc.getDoc_numero());
			pstmt.setLong(7, doc.getTpo_id());
			pstmt.setString(8, doc.getDoc_resumen().toUpperCase());
			pstmt.setString(9, new String(doc.getDoc_abogado().getBytes("ISO-8859-1"),"utf-8").toUpperCase());
			pstmt.setString(10, new String(doc.getDoc_nombre_archivo().getBytes("ISO-8859-1"),"utf-8").toUpperCase());
			pstmt.setString(11, doc.getDoc_id_alfresco());
			pstmt.setString(12, doc.getDoc_usr_insert());
			pstmt.setString(13, doc.getDoc_usr_mod());
			Calendar calendar2 = Calendar.getInstance();
			java.util.Date currentDate2 = calendar2.getTime();
			pstmt.setDate(14, new Date(currentDate2.getTime()));
			pstmt.setInt(15, doc.getDoc_estado());
			pstmt.setInt(16, doc.getDocDescarga());
			int execute=pstmt.executeUpdate();
			rs=pstmt.getGeneratedKeys();
			
			while(rs.next())
			{
				idDocumento=rs.getLong(1);
			}
			super.closeResultSet(rs);
			super.closePreparedStatement(pstmt);
			super.closeConnection(conn);
			if(execute>0)
			{
				String uuid = null;
				String carpeta;
				DocumentoAlfresco alfresco=new DocumentoAlfresco();
				alfresco.setId(validarDocumento(usuario,doc));
				alfresco.setContentType("application/pdf");
				alfresco.setName(doc.getDoc_nombre_archivo());
				alfresco.setData(doc.getByteArray());
				alfresco.setSize(doc.getSize());
				
				List<DocumentoAlfresco> documentos = new ArrayList<DocumentoAlfresco>();
				documentos.add(alfresco);
				
//				AlmacenarDocumentosRequest requestIn = new AlmacenarDocumentosRequest();
//				requestIn.setDocumentos(documentos);
				
				DestinatarioDTO destinatario=new DestinatarioDTO();
				destinatario=selectDestinatarioById(usuario,doc.getDes_id());
				
				if (doc.getDoc_nombre_archivo() != null){
					carpeta = "Portal/" + destinatario.getDes_nombre_large() + "/" + doc.getDoc_ano();	
				}else{
					carpeta = "Portal/" + destinatario.getDes_nombre_large() + "/" + doc.getDoc_ano();				
				}
//				requestIn.setCarpeta(carpeta);
				
				AlmacenarDocumentosAction cliente=new AlmacenarDocumentosAction();
				DocumentoAlfrescoResponse response= cliente.almacenarDocumentos(carpeta, documentos);
				uuid = response.getSpaceStore();
				
				if(uuid!=null)
				{
					doc.setDoc_id(idDocumento);
					doc.setDoc_id_alfresco(uuid);
					updateDocumento(usuario, doc);
					resultado=true;
				}
				else
				{
					doc.setDoc_id(idDocumento);
					deleteDocumento(usuario,doc);
					resultado=false;
				}
				
				
			}
			else
			{
				resultado=false;
			}
			
			
		} catch (Exception e) {
			resultado=false;
			sistema.registroLog(new LogDTO(usuario,
					DocumentoServiceImpl.class.getSimpleName()
							+ "[insertarDocumento]", LevelEnum.ERR.getId(), e
							.getMessage().toString().replaceAll("<<", "")
							.replaceAll(">>", "")));

		}

		finally {
			
			if(conn!=null){
				super.closeResultSet(rs);
				super.closePreparedStatement(pstmt);
				super.closeConnection(conn);
			}
		}
		
		return resultado;
	}
	
	@Override
	public long validarDocumento(String usuario,DocumentoDTO doc)
	{
		Connection c = null;
		PreparedStatement p = null;
		ResultSet r = null;
		long id=0;

		try {
			c = super.getConnection();
			p = c.prepareStatement(ConstantesBd.VALIDAR_DOCUMENTO);
			p.setString(1, doc.getDoc_nombre_archivo().toUpperCase());

			r = (ResultSet) p.executeQuery();

			while (r.next()) {	
				id=r.getLong(ConstantesBd.DOC_ID.substring(ConstantesBd.DOC_ID.indexOf('.')+1,ConstantesBd.DOC_ID.length()));
				
			}
			
			r.close();
			p.close();
			c.close();
		} catch (Exception e) {

			sistema.registroLog(new LogDTO(usuario,
					DocumentoServiceImpl.class.getSimpleName()
							+ "[validarDocumento]", LevelEnum.ERR.getId(), e
							.getMessage()));
		}
		
		finally
		{
			if(c!=null){
				super.closeResultSet(r);
				super.closePreparedStatement(p);
				super.closeConnection(c);
			}
		}

		return id;
	}
	
	
	
	private DestinatarioDTO selectDestinatarioById(String usuario,long id) {
		// TODO Auto-generated method stub
		DestinatarioDTO obj = new DestinatarioDTO();

		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(ConstantesBd.SELECT_DESTINATARIO_BYID);
			pstmt.setLong(1, id);
			rs = (ResultSet) pstmt.executeQuery();

			while (rs.next()) {
				obj.setDes_id(rs.getLong(ConstantesBd.DES_ID));
				obj.setDes_nombre_small(rs.getString(ConstantesBd.DES_NOMBRE_SMALL));
				obj.setDes_nombre_large(rs.getString(ConstantesBd.DES_NOMBRE_LARGE));
				obj.setDes_estado(rs.getInt(ConstantesBd.DES_ESTADO));
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {

			sistema.registroLog(new LogDTO(usuario,
					DestinatarioServiceImpl.class.getSimpleName()
							+ "[selectDestinatarioById]", LevelEnum.ERR.getId(), e
							.getMessage()));
		}
		finally {
			
			if(conn!=null){
				super.closeResultSet(rs);
				super.closePreparedStatement(pstmt);
				super.closeConnection(conn);
			}
		}

		return obj;
	}
	
	
	@Override
	public boolean updateDocumento(String usuario, DocumentoDTO doc) {
		// TODO Auto-generated method stub
		boolean resultado=false;
		Gson objGson = new Gson();
		Connection c=null;
		PreparedStatement p=null;

		try {
			c = super.getConnection();
			p = c.prepareStatement(ConstantesBd.UPDATE_DOCUMENTO);
			p.setInt(1, doc.getDoc_ano());
			p.setLong(2, doc.getDes_id());
			p.setLong(3, doc.getDesc_id());
			p.setString(4, new String(doc.getDoc_materia().getBytes("ISO-8859-1"),"utf-8").toUpperCase());
			Calendar calendar = Calendar.getInstance();
			java.util.Date currentDate = calendar.getTime();
			p.setDate(5, new Date(currentDate.getTime()));
			p.setString(6, doc.getDoc_numero());
			p.setLong(7, doc.getTpo_id());
			p.setString(8, doc.getDoc_resumen().toUpperCase());
			p.setString(9, new String(doc.getDoc_abogado().getBytes("ISO-8859-1"),"utf-8").toUpperCase());
			p.setString(10, new String(doc.getDoc_nombre_archivo().getBytes("ISO-8859-1"),"utf-8").toUpperCase());
			p.setString(11, doc.getDoc_id_alfresco());
			p.setString(12, doc.getDoc_usr_insert());
			p.setString(13, doc.getDoc_usr_mod());
			Calendar calendar2 = Calendar.getInstance();
			java.util.Date currentDate2 = calendar2.getTime();
			p.setDate(14, new Date(currentDate2.getTime()));
			p.setInt(15, doc.getDoc_estado());
			p.setLong(16, doc.getDoc_id());
			
			p.executeUpdate();
			resultado=true;
			
			p.close();
			c.close();
		} catch (Exception e) {
			resultado=false;
			System.out.println(e.getMessage());
			System.out.println(objGson.toJson(p));
			sistema.registroLog(new LogDTO(usuario,
					DocumentoServiceImpl.class.getSimpleName()
							+ "[updateDocumento]", LevelEnum.ERR.getId(), e
							.getMessage().toString().replaceAll("<<", "")
							.replaceAll(">>", "")));

		}

		finally {
			
			if(c!=null){
				super.closePreparedStatement(p);
				super.closeConnection(c);
			}
		}
		
		return resultado;
	}

	@Override
	public boolean deleteDocumento(String usuario, DocumentoDTO doc) {
		// TODO Auto-generated method stub
		boolean resultado=false;
		Connection c=null;
		PreparedStatement p=null;
		try {
			c = super.getConnection();
			p = c.prepareStatement(ConstantesBd.DELETE_DOCUMENTO);
			p.setLong(1, doc.getDoc_id());
			
			p.executeUpdate();
			resultado=true;

			p.close();
			c.close();
		} catch (Exception e) {
			resultado=false;
			sistema.registroLog(new LogDTO(usuario,
					DocumentoServiceImpl.class.getSimpleName()
							+ "[deleteDocumento]", LevelEnum.ERR.getId(), e
							.getMessage().toString().replaceAll("<<", "")
							.replaceAll(">>", "")));

		}

		finally {
			
			if(c!=null){
				super.closePreparedStatement(p);
				super.closeConnection(c);
			}
		}
		
		return resultado;
	}
	
	@Override
	public boolean publicarDocumento(String usuario, DocumentoDTO doc) {
		// TODO Auto-generated method stub
		boolean resultado=false;

		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(ConstantesBd.PUBLICAR_DOCUMENTO);
			pstmt.setLong(1, doc.getDoc_id());
			
			pstmt.executeUpdate();
			resultado=true;
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			resultado=false;
			sistema.registroLog(new LogDTO(usuario,
					DocumentoServiceImpl.class.getSimpleName()
							+ "[publicarDocumento]", LevelEnum.ERR.getId(), e
							.getMessage().toString().replaceAll("<<", "")
							.replaceAll(">>", "")));

		}

		finally {
			
			if(conn!=null){
				super.closePreparedStatement(pstmt);
				super.closeConnection(conn);
			}
		}
		
		return resultado;
	}

	@Override
	public List<DocumentoDTO> selectDocumentos(String usuario, long rol_id) {
		// TODO Auto-generated method stub
		List<DocumentoDTO> lista = new ArrayList<DocumentoDTO>();

		try {
			conn = super.getConnection();
			if(rol_id==1)
			{
				pstmt = conn.prepareStatement(ConstantesBd.SELECT_DOCUMENTO_USR);
			}
			else
			{
				pstmt = conn.prepareStatement(ConstantesBd.SELECT_DOCUMENTO_ADMIN);
			}
			rs = (ResultSet) pstmt.executeQuery();

			while (rs.next()) {
				DocumentoDTO objDoc = new DocumentoDTO();
				
				objDoc.setDoc_id(rs.getLong(ConstantesBd.DOC_ID));
				objDoc.setDoc_ano(rs.getInt(ConstantesBd.DOC_ANO));
				objDoc.setDes_id(rs.getLong(ConstantesBd.DOC_DES_ID));
				objDoc.setDesc_id(rs.getLong(ConstantesBd.DOC_DESC_ID));
				objDoc.setDoc_materia(rs.getString(ConstantesBd.DOC_MATERIA));
				objDoc.setDoc_fecha_ingreso(rs.getDate(ConstantesBd.DOC_FECHA_INGRESO));
				objDoc.setDoc_numero(rs.getString(ConstantesBd.DOC_NUMERO));
				objDoc.setTpo_id(rs.getLong(ConstantesBd.DOC_TPO_ID));
				objDoc.setDoc_resumen(rs.getString(ConstantesBd.DOC_RESUMEN));
				objDoc.setDoc_abogado(rs.getString(ConstantesBd.DOC_ABOGADO));
				objDoc.setDoc_nombre_archivo(rs.getString(ConstantesBd.DOC_NOMBRE_ARCHIVO));
				objDoc.setDoc_id_alfresco(rs.getString(ConstantesBd.DOC_ID_ALFRESCO));
				objDoc.setDoc_usr_insert(rs.getString(ConstantesBd.DOC_USR_INSERT));
				objDoc.setDoc_usr_mod(rs.getString(ConstantesBd.DOC_USR_MOD));
				objDoc.setDoc_fecha_mod(rs.getDate(ConstantesBd.DOC_FECHA_MOD));
				objDoc.setDoc_estado(rs.getInt(ConstantesBd.DOC_ESTADO));
				objDoc.setNombreDescriptor(rs.getString(ConstantesBd.DESC_NOMBRE_SMALL));
				objDoc.setNombreDestinatario(rs.getString(ConstantesBd.DES_NOMBRE_SMALL));
				objDoc.setNombreTipoDoc(rs.getString(ConstantesBd.TPO_NOMBRE_SMALL));
				
				lista.add(objDoc);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {

			sistema.registroLog(new LogDTO(usuario,
					DocumentoServiceImpl.class.getSimpleName()
							+ "[selectDocumento]", LevelEnum.ERR.getId(), e
							.getMessage()));
		}
		finally {
			
			if(conn!=null){
				super.closeResultSet(rs);
				super.closePreparedStatement(pstmt);
				super.closeConnection(conn);
			}
		}

		return lista;
	}

	@Override
	public boolean updateDescargaDocumento(String usuario, DocumentoDTO doc) {
		// TODO Auto-generated method stub
		boolean resultado=false;
		Connection c=null;
		PreparedStatement p=null;
		try {
			c = super.getConnection();
			p = c.prepareStatement(ConstantesBd.UPDATE_DESCDOCUMENTO);
			p.setLong(1, doc.getDoc_id());
			p.setLong(2, doc.getDoc_id());
			
			p.executeUpdate();
			resultado=true;

			p.close();
			c.close();
		} catch (Exception e) {
			resultado=false;
			sistema.registroLog(new LogDTO(usuario,
					DocumentoServiceImpl.class.getSimpleName()
							+ "[updateDescargaDocumento]", LevelEnum.ERR.getId(), e
							.getMessage().toString().replaceAll("<<", "")
							.replaceAll(">>", "")));

		}

		finally {
			
			if(c!=null){
				super.closePreparedStatement(p);
				super.closeConnection(c);
			}
		}
		
		return resultado;
	}

}
