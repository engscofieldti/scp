package org.dgac.app.web.bean;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import org.dgac.app.web.enumsSubt21.Zona;
import org.dgac.app.web.util.GenRepJasper;
import org.dgac.web.enumsGenericos.ConstantesWeb;
import org.hibernate.validator.util.privilegedactions.GetConstructor;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@RequestScoped
public class VerRepo {
 //private static final Integer tarea = null;

//public StreamedContent getFile() {
//			try {
//			byte[] reportPdf = GenRepJasper.getReporte();
//			InputStream fis = new ByteArrayInputStream(reportPdf);
//			return new DefaultStreamedContent(fis,
//					"application/pdf; charset=UTF-8",
//					"INFORME - HHEEGENERAL.pdf");
//					} catch (Exception e) {
////			System.out.println("xxxxxx");
//						e.printStackTrace();
//				}
//		return null;
//	}

//public StreamedContent getFile2() {
//		try {
//			byte[] reportPdf = GenRepJasper.getReporte2();
//		InputStream fis = new ByteArrayInputStream(reportPdf);
//		return new DefaultStreamedContent(fis,
//				"application/pdf; charset=UTF-8",
//				"INFORME - HHEEPROMEDIO.pdf");
//				} catch (Exception e) {
////		System.out.println("xxxxxx");
//					e.printStackTrace();
//			}
//	return null;
//}
//
//public StreamedContent getFile3() {
//	try {
//	
//		byte[] reportPdf = GenRepJasper.getReporte3();
//		InputStream fis = new ByteArrayInputStream(reportPdf);
//		return new DefaultStreamedContent(fis,
//				"application/pdf; charset=UTF-8",
//				"INFORME - HHEETURNO.pdf");
//				} catch (Exception e) {
//					e.printStackTrace();
//			}
//	return null;
//}
//public StreamedContent getFile4() {
//	 
//	PanelUsuario pan=new PanelUsuario(2414);//capturar el numero de la tarea NO estaticamente
//		//HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//	  Integer tareaPar=pan.getTarea();
//	        try {
//		if(tarea== null){
//			tarea=2414;
//		}
//		byte[] reportPdf = GenRepJasper.getReporte4(tareaPar);
//		InputStream fis = new ByteArrayInputStream(reportPdf);
//		return new DefaultStreamedContent(fis,
//				"application/pdf; charset=UTF-8",
//				"INFORME - viaticos.pdf");
//				} catch (Exception e) {
//					e.printStackTrace();
//			}
//	return null;
//}

//public StreamedContent getFile5() {
//	 // paso de parametros 			   año,      meses,		    codigo de unidad
//	PanelUsuario pan=new PanelUsuario(2015,1,2,3,4,5,6,7,8,9,10,"11703000");//capturar el numero de la tarea NO estaticamente
//	
//	//HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//	  Integer ano_param=pan.getAno_param();
//	  Integer mes_param=pan.getMes_param();
//	  Integer mes_param2=pan.getMes_param2();
//	  Integer mes_param3=pan.getMes_param3();
//	  Integer mes_param4=pan.getMes_param4();
//	  Integer mes_param5=pan.getMes_param5();
//	  Integer mes_param6=pan.getMes_param6();
//	  Integer mes_param7=pan.getMes_param7();
//	  Integer mes_param8=pan.getMes_param8();
//	  Integer mes_param9=pan.getMes_param9();
//	  Integer mes_param10=pan.getMes_param10();
//	  Integer mes_param11=pan.getMes_param11();
//	  Integer mes_param12=pan.getMes_param12();
//	  String codigouni_param =pan.getCodigouni_param();
	 //       try {
//		if(tarea== null){
//			tarea=2414;
//		}
//		byte[] reportPdf = GenRepJasper.getReporte5(ano_param,mes_param,mes_param2,mes_param3,// mes_param11,mes_param12 no estan considerados
//				mes_param4,mes_param5,mes_param6,mes_param7,mes_param8,mes_param9,
//				mes_param10,codigouni_param);
//		InputStream fis = new ByteArrayInputStream(reportPdf);
//		return new DefaultStreamedContent(fis,
//				"application/pdf; charset=UTF-8",
//				"INFORME - hheeparam.pdf");
//				} catch (Exception e) {
//					e.printStackTrace();
//			}
//	return null;
//}

//public StreamedContent getFile6() {
//		 // PASO DE PARAMETROS		 AÑO,MESES,CODIGO DE UNIDAD
//	PanelUsuario pan=new PanelUsuario(2015,ConstantesWeb.ENERO,ConstantesWeb.FEBRERO,ConstantesWeb.MARZO,ConstantesWeb.ABRIL,
//			ConstantesWeb.MAYO,ConstantesWeb.JUNIO,ConstantesWeb.JULIO,ConstantesWeb.AGOSTO,
//			ConstantesWeb.SEPTIEMBRE,ConstantesWeb.OCTUBRE,Zona.DIEGO_ARA.getCodigo());//DATOS ESTATICOS,DEBEN SER DINAMICOS
//		        try {
//	        		byte[] reportPdf = GenRepJasper.getReporte6(2015,ConstantesWeb.ENERO,ConstantesWeb.FEBRERO,ConstantesWeb.MARZO,ConstantesWeb.ABRIL,
//	        				ConstantesWeb.MAYO,ConstantesWeb.JUNIO,ConstantesWeb.JULIO,ConstantesWeb.AGOSTO,
//	        				ConstantesWeb.SEPTIEMBRE,ConstantesWeb.OCTUBRE,Zona.DIEGO_ARA.getCodigo());
//		InputStream fis = new ByteArrayInputStream(reportPdf);// codigouni_param
//		return new DefaultStreamedContent(fis,
//				"application/pdf; charset=UTF-8",
//				"INFORME - hheeparam.pdf");
//				} catch (Exception e) {
//				e.printStackTrace();
//			}
//	return null;
//}
//
//public StreamedContent getFile7() {
//	 // PASO DE PARAMETROS		 AÑO,MESES,CODIGO DE UNIDAD
//PanelUsuario pan=new PanelUsuario(ConstantesWeb.ENERO,ConstantesWeb.FEBRERO,ConstantesWeb.MARZO,ConstantesWeb.ABRIL,ConstantesWeb.MAYO,
//		Zona.DIEGO_ARA.getCodigo(),Zona.CHACALLUTA.getCodigo(),Zona.EL_LOA.getCodigo(),Zona.MATAVERI.getCodigo(),Zona.BALMACEDA.getCodigo());//DATOS ESTATICOS,DEBEN SER DINAMICOS
//	        try {
//       		byte[] reportPdf = GenRepJasper.getReporte7(ConstantesWeb.ENERO,ConstantesWeb.FEBRERO,ConstantesWeb.MARZO,ConstantesWeb.ABRIL,ConstantesWeb.MAYO,
//       				Zona.DIEGO_ARA.getCodigo(),Zona.CHACALLUTA.getCodigo(),Zona.EL_LOA.getCodigo(),Zona.MATAVERI.getCodigo(),Zona.BALMACEDA.getCodigo());
//	InputStream fis = new ByteArrayInputStream(reportPdf);// codigouni_param
//	return new DefaultStreamedContent(fis,
//			"application/pdf; charset=UTF-8",
//			"INFORME - hheeparam.pdf");
//			} catch (Exception e) {
//			e.printStackTrace();
//		}
//return null;
//}
//
//public StreamedContent getFile8() {
//	 // PASO DE PARAMETROS		 AÑO,MESES,CODIGO DE UNIDAD
//PanelUsuario pan=new PanelUsuario(Zona.DIEGO_ARA.getCodigo(),Zona.CHACALLUTA.getCodigo(),Zona.EL_LOA.getCodigo(),Zona.MATAVERI.getCodigo(),Zona.BALMACEDA.getCodigo());//DATOS ESTATICOS,DEBEN SER DINAMICOS
//	        try {
//      		byte[] reportXLS = GenRepJasper.getReporte8(Zona.DIEGO_ARA.getCodigo(),Zona.CHACALLUTA.getCodigo(),Zona.EL_LOA.getCodigo(),Zona.MATAVERI.getCodigo(),Zona.BALMACEDA.getCodigo());
//	InputStream fis = new ByteArrayInputStream(reportXLS);// codigouni_param
//	return new DefaultStreamedContent(fis,
//			"application/xls; charset=UTF-8",
//			"INFORME - hheeparam.xls");
//			} catch (Exception e) {
//			e.printStackTrace();
//		}
//return null;
//}

}
	        
