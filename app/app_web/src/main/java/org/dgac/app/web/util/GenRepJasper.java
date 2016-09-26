package org.dgac.app.web.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.dgac.app.web.bean.ConexionBD;
import org.dgac.app.web.bean.Filtro;
import org.dgac.app.web.bean.SistemaBean;
import org.dgac.app.web.bean.UnidadesZonas;

import com.lowagie.text.pdf.fonts.cmaps.CodespaceRange;

public class GenRepJasper {

	private static final String GEN2015NOMINA = "C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportesNew\\horasextrasGen2015nominaConn.jasper";
	//private static final String REPORT8EJEC = "C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportesNew\\report8EJEC.jasper";
	private static final String GEN2016NOMINA = "C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportesNew\\horasextrasGen2016nominaConnXX.jasper";
	//private static final String REPORT8EJEC16 = "C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportesNew\\report8EJEC16.jasper";
	private static final String CODIGO_PADRE_DASA = "11000000";
	private static final String CODIGO_PADRE_LOGISTICA = "10801400";												
	private static final String CODIGO_PADRE_DMC = "10700000";
	private static final String CODIGO_PADRE_AMB = "11001000";
	private static final String CODIGO_PADRE_ZONA_NORTE = "11700000";
	private static final String CODIGO_PADRE_ZONA_CENTRAL = "11800000";
	private static final String CODIGO_PADRE_ZONA_SUR = "11900000";
	private static final String CODIGO_PADRE_ZONA_AUSTRAL="12000000";
	private static final Integer ANO_2015=2015;
	private static final Integer ANO_2016=2016;
	private static final String  COD_ASIG_HONO ="3";
	private static final List<String> COD_ASIG_HONO2 = Collections.singletonList("3");//PARA CREAR CONSTANTE DE TIPO COLECCION DE UN SOLO PARAM
	private static final String REPORT1LINE = "C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportesNew\\report1Line.jasper";
	private static final String REPORT1LINE15 = "C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportesNew\\report1Line15.jasper";
	private static final String ESPECIALIDADES16GRANDES = "C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportesNew\\hheeEspecialidadesPadre16.jasper";
	private static final String ESPECIALIDADES16PEQ = "C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportesNew\\hheeEspecialidadesChicas16.jasper";
	private static final String HONO16 = "C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportesNew\\hono2016CambiosResum.jasper";
	private static final String HONO16RESUM = "C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportesNew\\hono2016CuadroResum (2).jasper";
	private static final String HONO16DETA = "C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportesNew\\hono2016Cambios.jasper";
	private static final String ESPECIALIDADES15GRANDES = "C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportesNew\\hheeEspecialidades2016.jasper";
	private static final String ESPECIALIDADES15PEQ = "C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportesNew\\hheeEspecialidades2016.jasper";  
	
	
	
	public static byte[] getReporte(Filtro filtro) {
		byte[] reportPdf = null;
			if(filtro.getAsignacion().equals(COD_ASIG_HONO2)){
			System.out.println("verdadero");
			return getReporte2(filtro);
		}	
	
		
			else {
		List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
		Map<String, Object> parametros = new HashMap<String, Object>();
		//List<String> mes = Arrays.asList(new String[]{getCsvFromList(filtro.getMes())});
		parametros.put("subtitulo", filtro.getSubtitulo());
		parametros.put("items", getCsvFromList(filtro.getItem()));
		parametros.put("asignaciones",getCsvFromList(filtro.getAsignacion()));
		List<String> listaSinCodTodasUni= new ArrayList<String>();
		for(int x=0;x< filtro.getUnidadZona().size();x++)	{
		if (!filtro.getUnidadZona().get(x).equals("0")){
			listaSinCodTodasUni.add(filtro.getUnidadZona().get(x));
			}
		}
		filtro.setUnidadZona(listaSinCodTodasUni);
		parametros.put("unidadesZonas", getCsvFromList(filtro.getUnidadZona()));
		parametros.put("unidadesEjecutoras",getCsvFromList(filtro.getUnidadEjec()));
		parametros.put("mes", getCsvFromList(filtro.getMes()));
				parametros.put("ano", filtro.getAno());
		parametros.put("tipo", filtro.getTipo());
		parametros.put("user", filtro.getLoginBean2().getsession2());
		List<String> listaSinCodTodasEspe= new ArrayList<String>();
		for(int x=0;x<filtro.getEspecialidades().size();x++){
		if (!filtro.getEspecialidades().get(x).equals("'TODAS'")){
			listaSinCodTodasEspe.add(filtro.getEspecialidades().get(x));
			}
		}
		filtro.setEspecialidades(listaSinCodTodasEspe);
		parametros.put("especialidad",getCsvFromList(filtro.getEspecialidades()));
		parametros.put("cuentaMes",filtro.getMes().size()-1);
		
		//CODIGOS SON LOS QUE LLEGAN
				
		ByteArrayOutputStream baos;
		try {// CON ESTA LINEA PASO PARAMETROS PARA GENERAR LA RUTA
			System.out.println("array :"+filtro.getUnidadZona().size());
			List<String> rutaReporte = getRutaReporte(filtro.getUnidadZona(),filtro.getAno(),filtro.getEspecialidades(),filtro.getAsignacion());// ,filtro.getAsignacion()
			System.out.println("ASIG LARGO COLECC: "+filtro.getAsignacion().size());
			System.out.println("UNIDAD ZONA LARGO COLECC: "+filtro.getUnidadZona().size());
			System.out.println("ESPECIALIDADES LARGO COLECC: "+filtro.getEspecialidades().size());
			for(String cadena : rutaReporte){
				JasperReport jasperReport = (JasperReport) JRLoader
						.loadObject(new File(cadena));
				JasperPrint jasperPrint = JasperFillManager.fillReport(
						jasperReport, parametros, ConexionBD.obtenerConeNomina());
				jasperPrintList.add(jasperPrint);
			}
			baos = new ByteArrayOutputStream();
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST,
					jasperPrintList);
			exporter.setParameter(
					JRPdfExporterParameter.IS_CREATING_BATCH_MODE_BOOKMARKS,
					Boolean.TRUE);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
			exporter.exportReport();
			reportPdf = baos.toByteArray();

		} catch (JRException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("SI cumple condicion de asignacion=3(se supone) y va a metodo getreporte2");
		//return getReporte2(filtro);
		}
		return reportPdf;
	}
	
	
	
private static List<String> getRutaReporte(List<String>codigoPadre,int anoParam,List<String>codigoEspecialidad,List<String> codAsignacion) {// ,List<String> codAsignacion
		System.out.println("Metodo getRutaReporte");
				//Filtro filtro=new Filtro();
		//boolean flag=false;
				List<String> listado = new ArrayList<String>();
		for (String codigo : codigoPadre) {
			//for (String codigoAsi : codAsignacion){
				
//				if(filtro.getAsignacion().equals(codigoAsi)){
//					flag=true;
//				}
				if ((codigoPadre.isEmpty() && ANO_2016==anoParam) && (codigoEspecialidad.isEmpty()) && COD_ASIG_HONO2.equals(codAsignacion)){ 
					System.out.println("ENTRO.............PERO NO HAY REPORTE, CUANDO BORRO LA LINEA 313,314");
					if (!listado.contains(HONO16)) {
						 listado.add(HONO16);
						// listado.add(HONO16DETA);
											}//DESDE LA LINEA 288 --ELSE 
					
				
   }else if (codigoEspecialidad.isEmpty() && ANO_2016==anoParam && (CODIGO_PADRE_AMB.equals(codigo)//AÑO 2016 UNIDADES GRANDES
					|| CODIGO_PADRE_DMC.equals(codigo)
					|| CODIGO_PADRE_LOGISTICA.equals(codigo)
					|| CODIGO_PADRE_DASA.equals(codigo)
					|| CODIGO_PADRE_ZONA_NORTE.equals(codigo)
					|| CODIGO_PADRE_ZONA_CENTRAL.equals(codigo)
					|| CODIGO_PADRE_ZONA_SUR.equals(codigo)
					|| CODIGO_PADRE_ZONA_AUSTRAL.equals(codigo))){ 
					System.out.println("cond 1");
					if (!listado.contains(REPORT1LINE)){ 
					listado.add(REPORT1LINE);
					continue;
				}
			}else if((!codigoEspecialidad.isEmpty()) && ANO_2016==anoParam && (CODIGO_PADRE_AMB.equals(codigo)//AÑO 2016 UNIDADES GRANDES+ESPECIALIDADES
					|| CODIGO_PADRE_DMC.equals(codigo)
					|| CODIGO_PADRE_LOGISTICA.equals(codigo)
					|| CODIGO_PADRE_DASA.equals(codigo)
					|| CODIGO_PADRE_ZONA_NORTE.equals(codigo)
					|| CODIGO_PADRE_ZONA_CENTRAL.equals(codigo)
					|| CODIGO_PADRE_ZONA_SUR.equals(codigo)
					|| CODIGO_PADRE_ZONA_AUSTRAL.equals(codigo))){ 
				System.out.println("cond 2");
				if (!listado.contains(ESPECIALIDADES16GRANDES)){ //TENIA ESPECIALIDADES16GRANDES NO ENTRA A ESTE ,SE PROBO CON GEN2016NOMINA
					listado.add(ESPECIALIDADES16GRANDES);
					continue;
				}
			}else if(!codigoEspecialidad.isEmpty() && ANO_2016==anoParam && (!CODIGO_PADRE_AMB.equals(codigo)//AÑO 2016 UNIDADES GRANDES+ESPECIALIDADES
					|| CODIGO_PADRE_DMC.equals(codigo)
					|| CODIGO_PADRE_LOGISTICA.equals(codigo)
					|| CODIGO_PADRE_DASA.equals(codigo)
					|| CODIGO_PADRE_ZONA_NORTE.equals(codigo)
					|| CODIGO_PADRE_ZONA_CENTRAL.equals(codigo)
					|| CODIGO_PADRE_ZONA_SUR.equals(codigo)
					|| CODIGO_PADRE_ZONA_AUSTRAL.equals(codigo))){ 
				System.out.println("especialidad !=null,año2016,codpadres= false");
				
				
				if (!listado.contains(ESPECIALIDADES16PEQ)){ //TENIA *****ESPECIALIDADES16PEQ *****A ESTE ENTRA INCLUSO CON ESPECIALIDAD NULL.....
					listado.add(ESPECIALIDADES16PEQ);
					continue;
			   }
			}else if ((codigoEspecialidad.isEmpty()) && ANO_2016==anoParam && (!CODIGO_PADRE_AMB.equals(codigo)// AÑO 2015 UNIDADES PEQUEÑAS MAS ESPECIALIDADES
					|| !CODIGO_PADRE_DMC.equals(codigo)
					|| !CODIGO_PADRE_LOGISTICA.equals(codigo)
					|| !CODIGO_PADRE_DASA.equals(codigo)
					|| !CODIGO_PADRE_ZONA_NORTE.equals(codigo)
					|| !CODIGO_PADRE_ZONA_CENTRAL.equals(codigo)
					|| !CODIGO_PADRE_ZONA_SUR.equals(codigo)
					|| !CODIGO_PADRE_ZONA_AUSTRAL.equals(codigo))){ 
				System.out.println("cond 4");
			 
					if (!listado.contains(GEN2016NOMINA)) {
					listado.add(GEN2016NOMINA);
					continue;
				}
			}else if((codigoEspecialidad.isEmpty()) && ANO_2015==anoParam && (!CODIGO_PADRE_AMB.equals(codigo)//AÑO 2015 UNIDADES PEQUEÑAS
					|| CODIGO_PADRE_DMC.equals(codigo)
					|| CODIGO_PADRE_LOGISTICA.equals(codigo)
					|| CODIGO_PADRE_DASA.equals(codigo)
					|| CODIGO_PADRE_ZONA_NORTE.equals(codigo)
					|| CODIGO_PADRE_ZONA_CENTRAL.equals(codigo)
					|| CODIGO_PADRE_ZONA_SUR.equals(codigo)
					|| CODIGO_PADRE_ZONA_AUSTRAL.equals(codigo))) {
				System.out.println("cond 5");
				if (!listado.contains(GEN2015NOMINA)) {
					listado.add(GEN2015NOMINA);
					continue;
				}
			}else if((!codigoEspecialidad.isEmpty()) && ANO_2015==anoParam && (!CODIGO_PADRE_AMB.equals(codigo)//AÑO 2015 UNIDADES PEQUEÑAS
					|| CODIGO_PADRE_DMC.equals(codigo)
					|| CODIGO_PADRE_LOGISTICA.equals(codigo)
					|| CODIGO_PADRE_DASA.equals(codigo)
					|| CODIGO_PADRE_ZONA_NORTE.equals(codigo)
					|| CODIGO_PADRE_ZONA_CENTRAL.equals(codigo)
					|| CODIGO_PADRE_ZONA_SUR.equals(codigo)
					|| CODIGO_PADRE_ZONA_AUSTRAL.equals(codigo))) {
					System.out.println("cond 6");
				if (!listado.contains(ESPECIALIDADES15PEQ)) {
					listado.add(ESPECIALIDADES15PEQ);
					continue;
				}
						
			}else if((codigoEspecialidad.isEmpty()) && ANO_2015==anoParam && (CODIGO_PADRE_AMB.equals(codigo)//AÑO 2015 UNIDADES GRANDES
					|| CODIGO_PADRE_DMC.equals(codigo)
					|| CODIGO_PADRE_LOGISTICA.equals(codigo)
					|| CODIGO_PADRE_DASA.equals(codigo)
					|| CODIGO_PADRE_ZONA_NORTE.equals(codigo)
					|| CODIGO_PADRE_ZONA_CENTRAL.equals(codigo)
					|| CODIGO_PADRE_ZONA_SUR.equals(codigo)
					|| CODIGO_PADRE_ZONA_AUSTRAL.equals(codigo))){
				System.out.println("cond 7");
				if (!listado.contains(REPORT1LINE15)) {
					listado.add(REPORT1LINE15);
					continue;
				}
				}else if((!codigoEspecialidad.isEmpty()) && ANO_2015==anoParam && (CODIGO_PADRE_AMB.equals(codigo)//AÑO 2015 UNIDADES GRANDES MAS ESPECIALIDADES
						|| CODIGO_PADRE_DMC.equals(codigo)
						|| CODIGO_PADRE_LOGISTICA.equals(codigo)
						|| CODIGO_PADRE_DASA.equals(codigo)
						|| CODIGO_PADRE_ZONA_NORTE.equals(codigo)
						|| CODIGO_PADRE_ZONA_CENTRAL.equals(codigo)
						|| CODIGO_PADRE_ZONA_SUR.equals(codigo)
						|| CODIGO_PADRE_ZONA_AUSTRAL.equals(codigo))){
					System.out.println("cond 8");
					if (!listado.contains(ESPECIALIDADES15GRANDES)) {
						 listado.add(ESPECIALIDADES15GRANDES);
						 continue;
					}//DESDE LA LINEA 288 --ELSE IF EMPECE A MODIFICAR
					
				}
//				else if((codigoPadre.isEmpty()) && ANO_2016==anoParam && (codigoEspecialidad.isEmpty() && COD_ASIG_HONO.equals("3"))){
//						System.out.println("cond hono");
//			if (!listado.contains(HONO16)) {
//				 listado.add(HONO16);
//			}//DESDE LA LINEA 288 --ELSE IF EMPECE A MODIFICAR 
//		   }
		//  }
				
		}
		return listado;
	}
	

	public static byte[] getReporte2(Filtro filtro) {// SIRVE PARA HONORARIOS SOLAMENTE
	System.out.println("Metodo getReporte2");
		byte[] reportPdf = null;
			List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
			Map<String, Object> parametros = new HashMap<String, Object>();

			parametros.put("subtitulo", filtro.getSubtitulo());
			parametros.put("items", getCsvFromList(filtro.getItem()));
			parametros.put("asignaciones",getCsvFromList(filtro.getAsignacion()));
			parametros.put("unidadesZonas", getCsvFromList(filtro.getUnidadZona()));
			parametros.put("unidadesEjecutoras",getCsvFromList(filtro.getUnidadEjec()));
			parametros.put("mes", getCsvFromList(filtro.getMes()));
			parametros.put("unidadTodas",getCsvFromList(filtro.getUnidadTodas()));
			parametros.put("ano", filtro.getAno());
			parametros.put("tipo", filtro.getTipo());
			parametros.put("user", filtro.getLoginBean2().getsession2());
			parametros.put("especialidad",getCsvFromList(filtro.getEspecialidades()));//CODIGOS SON LOS QUE LLEGAN
			parametros.put("cuentaMes",filtro.getMes().size()-1);
			ByteArrayOutputStream baos;
			
				try {// CON ESTA LINEA PASO PARAMETROS PARA GENERAR LA RUTA
				List<String> rutaReporte = getRutaReporte2(filtro.getUnidadZona(),filtro.getAno(),filtro.getEspecialidades(),filtro.getAsignacion());// ,filtro.getAsignacion()
				for(String cadena : rutaReporte){
					JasperReport jasperReport = (JasperReport) JRLoader
							.loadObject(new File(cadena));
					JasperPrint jasperPrint = JasperFillManager.fillReport(
							jasperReport, parametros, ConexionBD.obtenerConeNomina());
					jasperPrintList.add(jasperPrint);
				}
				baos = new ByteArrayOutputStream();
				JRPdfExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST,
						jasperPrintList);
				exporter.setParameter(
						JRPdfExporterParameter.IS_CREATING_BATCH_MODE_BOOKMARKS,
						Boolean.TRUE);
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
				exporter.exportReport();
				reportPdf = baos.toByteArray();

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
				
		return reportPdf;
	}
	
	
	public static byte[] getReporte3(Filtro filtro) {// SIRVE PARA HONORARIOS SOLAMENTE
	System.out.println("Metodo getReporte2");
		byte[] reportXls = null;
	
		 
			List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("subtitulo", filtro.getSubtitulo());
			parametros.put("items", getCsvFromList(filtro.getItem()));
			parametros.put("asignaciones",getCsvFromList(filtro.getAsignacion()));
			parametros.put("unidadesZonas", getCsvFromList(filtro.getUnidadZona()));
			parametros.put("unidadesEjecutoras",getCsvFromList(filtro.getUnidadEjec()));
			parametros.put("mes", getCsvFromList(filtro.getMes()));
			parametros.put("unidadTodas",getCsvFromList(filtro.getUnidadTodas()));
			parametros.put("ano", filtro.getAno());
			parametros.put("tipo", filtro.getTipo());
			parametros.put("user", filtro.getLoginBean2().getsession2());
			parametros.put("especialidad",getCsvFromList(filtro.getEspecialidades()));//CODIGOS SON LOS QUE LLEGAN
			parametros.put("cuentaMes",filtro.getMes().size()-1);
			ByteArrayOutputStream baos;
			
				try {// CON ESTA LINEA PASO PARAMETROS PARA GENERAR LA RUTA
				List<String> rutaReporte = getRutaReporte2(filtro.getUnidadZona(),filtro.getAno(),filtro.getEspecialidades(),filtro.getAsignacion());// ,filtro.getAsignacion()
				for(String cadena : rutaReporte){
					JasperReport jasperReport = (JasperReport) JRLoader
							.loadObject(new File(cadena));
					JasperPrint jasperPrint = JasperFillManager.fillReport(
							jasperReport, parametros, ConexionBD.obtenerConeNomina());
					jasperPrintList.add(jasperPrint);
				}
				baos = new ByteArrayOutputStream();
				JRXlsExporter exporter = new JRXlsExporter();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST,
						jasperPrintList);
				exporter.setParameter(
						JRPdfExporterParameter.IS_CREATING_BATCH_MODE_BOOKMARKS,
						Boolean.TRUE);
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
				exporter.exportReport();
				reportXls = baos.toByteArray();

			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
				
		return reportXls;
	}
	
	
private static List<String> getRutaReporte2(List<String>codigoPadre,int anoParam,List<String>codigoEspecialidad,List<String> codAsignacion) {// SIRVE SOLO PARA HONORARIOS
	System.out.println("metodo getRutaReporte2");
	List<String> listado = new ArrayList<String>();
	for (String codigo : codAsignacion) {
		if (codigoPadre.isEmpty() && ANO_2016==anoParam && codigoEspecialidad.isEmpty() && COD_ASIG_HONO.equals(codigo)){ 
			System.out.println("ENTRO.............PERO NO HAY REPORTE, CUANDO BORRO LA LINEA 313,314");
			if (!listado.contains(HONO16)) {
				listado.add(HONO16RESUM); 
				listado.add(HONO16);
			    listado.add(HONO16DETA);
					}//DESDE LA LINEA 288 --ELSE I
			} else{
		System.out.println("no entro a cond hono");
			}
	}
	return listado;
}

	public void largoZona(Filtro filtro){
		if (filtro.getUnidadZona().contains("0")){//AGREGA TODOS LOS ELEM DE LA LISTA
					filtro.getUnidadZona().remove(0);
	}
	System.out.println("array :"+filtro.getUnidadZona().size());
	}
	
//	private static List<String> getRutaReporte(List<String>codigoPadre,int anoParam) {//PEDIR 
//		List<String> listado = new ArrayList<String>();
//		for (String codigo : codigoPadre) {
//			if (ANO_2015==anoParam && (CODIGO_PADRE_AMB.equals(codigo)
//					|| CODIGO_PADRE_DMC.equals(codigo)
//					|| CODIGO_PADRE_LOGISTICA.equals(codigo)
//					|| CODIGO_PADRE_DASA.equals(codigo)
//					|| CODIGO_PADRE_ZONA_NORTE.equals(codigo)
//					|| CODIGO_PADRE_ZONA_CENTRAL.equals(codigo)
//					|| CODIGO_PADRE_ZONA_SUR.equals(codigo)
//					|| CODIGO_PADRE_ZONA_AUSTRAL.equals(codigo))){ 
//					
//					
//					if (!listado.contains(REPORT8EJEC)) {// CAMBIAR A REPORT1LINE PERO AÑO 2015
//					listado.add(REPORT8EJEC);
//					continue;
//				}
//			}else if (ANO_2016==anoParam && CODIGO_PADRE_AMB.equals(codigo)
//					|| CODIGO_PADRE_DMC.equals(codigo)
//					|| CODIGO_PADRE_LOGISTICA.equals(codigo)
//					|| CODIGO_PADRE_DASA.equals(codigo)
//					|| CODIGO_PADRE_ZONA_NORTE.equals(codigo)
//					|| CODIGO_PADRE_ZONA_CENTRAL.equals(codigo)
//					|| CODIGO_PADRE_ZONA_SUR.equals(codigo)
//					|| CODIGO_PADRE_ZONA_AUSTRAL.equals(codigo)){ 
//				
//					if (!listado.contains(REPORT1LINE)) {
//					listado.add(REPORT1LINE);
//					continue;
//				}
//			}else if((!listado.contains(GEN2015NOMINA))) {
//				listado.add(GEN2015NOMINA);
//				continue;
//			}
//			else if(ANO_2016==anoParam && (!listado.contains(GEN2016NOMINA))) {
//				listado.add(GEN2016NOMINA);
//			}
//		}
//		return listado;
//	}
			
	private static String getCsvFromList(List<String> item) {
		StringBuilder sb = new StringBuilder();
		for (String it : item) {
			if (sb.length() > 0) {
				sb.append(",");
			}
			sb.append(it);
		}
		return sb.toString();
	}
	
	private static String getCsvFromList2(List<String> item) {
		StringBuilder sb = new StringBuilder();
		for (String it : item) {
			if (sb.length() > 0) {
				//sb.append("\' \'");  
				sb.append("'" +it+ "'");  
			}
			sb.append(it);
		}
		return sb.toString();
	}

//	public static byte[] getReporteXLS(Filtro filtro) {
//		byte[] reportXls = null;
//		List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
//		Map<String, Object> parametros = new HashMap<String, Object>();
//		parametros.put("subtitulo", filtro.getSubtitulo());
//		parametros.put("items", getCsvFromList(filtro.getItem()));
//		parametros.put("asignaciones", getCsvFromList(filtro.getAsignacion()));
//		parametros.put("unidadesZonas", getCsvFromList(filtro.getUnidadZona()));
//		parametros.put("unidadesEjecutoras",getCsvFromList(filtro.getUnidadEjec()));
//		parametros.put("mes", getCsvFromList(filtro.getMes()));
//		// parametros.put("mes",filtro.getMes());
//		parametros.put("ano", filtro.getAno());
//		parametros.put("tipo", filtro.getTipo());
//		//parametros.put("user",sistemaBean.getTxtUsrName());//AGREGUE ESTA LINEA PARA CAPTURAR EL USER
//		//parametros.put("user",filtro.getSistemaBean().getTxtUsrName());
//		parametros.put("user", filtro.getLoginBean2().getsession2());
//		parametros.put("especialidad",getCsvFromList(filtro.getEspecialidades()));
//
//		ByteArrayOutputStream baos;
//		try {
//			List<String> rutaReporte = getRutaReporte(filtro.getUnidadZona(),filtro.getAno(),filtro.getEspecialidades(),filtro.getAsignacion() );
//			
//			for(String cadena : rutaReporte){
//				JasperReport jasperReport = (JasperReport) JRLoader
//						.loadObject(new File(cadena));
//				JasperPrint jasperPrint = JasperFillManager.fillReport(
//						jasperReport, parametros, ConexionBD.obtenerConeNomina());
//				jasperPrintList.add(jasperPrint);
//			}
//			baos = new ByteArrayOutputStream();
//			JRXlsExporter exporter = new JRXlsExporter();
//			exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST,
//					jasperPrintList);
//			exporter.setParameter(
//					JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
//			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
//					Boolean.FALSE);
//			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
//			exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,Boolean.FALSE);
//			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
//			exporter.exportReport();
//			reportXls = baos.toByteArray();
//
//		} catch (JRException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return reportXls;
//	}

	public static byte[] getReporteXLS(Filtro filtro) {
		byte[] reportXls = null;
			if(filtro.getAsignacion().equals(COD_ASIG_HONO2)){
			System.out.println("verdadero");
			return getReporte3(filtro);
		}	
			
			else {
				List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
				Map<String, Object> parametros = new HashMap<String, Object>();
				//List<String> mes = Arrays.asList(new String[]{getCsvFromList(filtro.getMes())});
				parametros.put("subtitulo", filtro.getSubtitulo());
				parametros.put("items", getCsvFromList(filtro.getItem()));
				parametros.put("asignaciones",getCsvFromList(filtro.getAsignacion()));
				List<String> listaSinCodTodasUni= new ArrayList<String>();
				for(int x=0;x< filtro.getUnidadZona().size();x++)	{
				if (!filtro.getUnidadZona().get(x).equals("0")){
					listaSinCodTodasUni.add(filtro.getUnidadZona().get(x));
					}
				}
				filtro.setUnidadZona(listaSinCodTodasUni);
				parametros.put("unidadesZonas", getCsvFromList(filtro.getUnidadZona()));
				parametros.put("unidadesEjecutoras",getCsvFromList(filtro.getUnidadEjec()));
				parametros.put("mes", getCsvFromList(filtro.getMes()));
						parametros.put("ano", filtro.getAno());
				parametros.put("tipo", filtro.getTipo());
				parametros.put("user", filtro.getLoginBean2().getsession2());
				List<String> listaSinCodTodasEspe= new ArrayList<String>();
				for(int x=0;x<filtro.getEspecialidades().size();x++){
				if (!filtro.getEspecialidades().get(x).equals("'TODAS'")){
					listaSinCodTodasEspe.add(filtro.getEspecialidades().get(x));
					}
				}
				filtro.setEspecialidades(listaSinCodTodasEspe);
				parametros.put("especialidad",getCsvFromList(filtro.getEspecialidades()));
				parametros.put("cuentaMes",filtro.getMes().size()-1);
				
				//CODIGOS SON LOS QUE LLEGAN
						
				ByteArrayOutputStream baos;
				try {// CON ESTA LINEA PASO PARAMETROS PARA GENERAR LA RUTA
					System.out.println("array :"+filtro.getUnidadZona().size());
					List<String> rutaReporte = getRutaReporte(filtro.getUnidadZona(),filtro.getAno(),filtro.getEspecialidades(),filtro.getAsignacion());// ,filtro.getAsignacion()
					System.out.println("ASIG LARGO COLECC: "+filtro.getAsignacion().size());
					System.out.println("UNIDAD ZONA LARGO COLECC: "+filtro.getUnidadZona().size());
					System.out.println("ESPECIALIDADES LARGO COLECC: "+filtro.getEspecialidades().size());
					for(String cadena : rutaReporte){
						JasperReport jasperReport = (JasperReport) JRLoader
								.loadObject(new File(cadena));
						JasperPrint jasperPrint = JasperFillManager.fillReport(
								jasperReport, parametros, ConexionBD.obtenerConeNomina());
						jasperPrintList.add(jasperPrint);
					}
					baos = new ByteArrayOutputStream();
					JRXlsExporter exporter = new JRXlsExporter();
					exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST,
							jasperPrintList);
					exporter.setParameter(
							JRPdfExporterParameter.IS_CREATING_BATCH_MODE_BOOKMARKS,
							Boolean.TRUE);
					exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
					exporter.exportReport();
					reportXls = baos.toByteArray();

				} catch (JRException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("SI cumple condicion de asignacion=3(se supone) y va a metodo getreporte2");
				//return getReporte2(filtro);
				}
				return reportXls;
			}
	
}
