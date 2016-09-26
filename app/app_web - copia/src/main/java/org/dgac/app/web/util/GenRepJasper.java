package org.dgac.app.web.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

public class GenRepJasper {

	private static final String GEN2015NOMINA = "C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportesNew\\horasextrasGen2015nominaConn.jasper";
	private static final String REPORT8EJEC = "C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportesNew\\report8EJEC.jasper";
	private static final String GEN2016NOMINA = "C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportesNew\\horasextrasGen2016nominaConn.jasper";
	private static final String REPORT8EJEC16 = "C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportesNew\\report8EJEC16.jasper";
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
	private static final String REPORT1LINE = "C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportesNew\\report1Line.jasper";
	private static final String REPORT1LINE15 = "C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportesNew\\report1Line15.jasper";


	public static byte[] getReporte(Filtro filtro) {
		byte[] reportPdf = null;
		List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("subtitulo", filtro.getSubtitulo());
		parametros.put("items", getCsvFromList(filtro.getItem()));
		parametros.put("asignaciones", getCsvFromList(filtro.getAsignacion()));
		parametros.put("unidadesZonas", getCsvFromList(filtro.getUnidadZona()));
		parametros.put("unidadesEjecutoras",getCsvFromList(filtro.getUnidadEjec()));
		parametros.put("mes", getCsvFromList(filtro.getMes()));
		// parametros.put("mes",filtro.getMes());
		parametros.put("ano", filtro.getAno());
		parametros.put("tipo", filtro.getTipo());
		ByteArrayOutputStream baos;
		try {
			List<String> rutaReporte = getRutaReporte(filtro.getUnidadZona(),filtro.getAno());
			
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

//	private static List<String> getRutaReporte(List<String>codigoPadre,int anoParam) {//PEDIR 
//		List<String> listado = new ArrayList<String>();
//		
//			if (ANO_2016==anoParam ){ 
//									
//					if (!listado.contains(GEN2016NOMINA)) {// CAMBIAR A REPORT1LINE PERO AÑO 2015
//					listado.add(GEN2016NOMINA);
//					
//				}
//			}
//		
//		return listado;
//	}
//	
	private static List<String> getRutaReporte(List<String>codigoPadre,int anoParam) {//PEDIR 
		List<String> listado = new ArrayList<String>();
		for (String codigo : codigoPadre) {
			if (ANO_2016==anoParam && (CODIGO_PADRE_AMB.equals(codigo)
					|| CODIGO_PADRE_DMC.equals(codigo)
					|| CODIGO_PADRE_LOGISTICA.equals(codigo)
					|| CODIGO_PADRE_DASA.equals(codigo)
					|| CODIGO_PADRE_ZONA_NORTE.equals(codigo)
					|| CODIGO_PADRE_ZONA_CENTRAL.equals(codigo)
					|| CODIGO_PADRE_ZONA_SUR.equals(codigo)
					|| CODIGO_PADRE_ZONA_AUSTRAL.equals(codigo))){ 
					
					
					if (!listado.contains(REPORT1LINE)) {// CAMBIAR A REPORT1LINE PERO AÑO 2015
					listado.add(REPORT1LINE);
					continue;
				}
			}else if (ANO_2016==anoParam && (!CODIGO_PADRE_AMB.equals(codigo)
					|| CODIGO_PADRE_DMC.equals(codigo)
					|| CODIGO_PADRE_LOGISTICA.equals(codigo)
					|| CODIGO_PADRE_DASA.equals(codigo)
					|| CODIGO_PADRE_ZONA_NORTE.equals(codigo)
					|| CODIGO_PADRE_ZONA_CENTRAL.equals(codigo)
					|| CODIGO_PADRE_ZONA_SUR.equals(codigo)
					|| CODIGO_PADRE_ZONA_AUSTRAL.equals(codigo))){ 
				
					if (!listado.contains(GEN2016NOMINA)) {
					listado.add(GEN2016NOMINA);
					continue;
				}
			}else if(ANO_2015==anoParam && (!CODIGO_PADRE_AMB.equals(codigo)
					|| CODIGO_PADRE_DMC.equals(codigo)
					|| CODIGO_PADRE_LOGISTICA.equals(codigo)
					|| CODIGO_PADRE_DASA.equals(codigo)
					|| CODIGO_PADRE_ZONA_NORTE.equals(codigo)
					|| CODIGO_PADRE_ZONA_CENTRAL.equals(codigo)
					|| CODIGO_PADRE_ZONA_SUR.equals(codigo)
					|| CODIGO_PADRE_ZONA_AUSTRAL.equals(codigo))) {
				if (!listado.contains(GEN2015NOMINA)) {
					listado.add(GEN2015NOMINA);
				}
			}else if(ANO_2015==anoParam && (CODIGO_PADRE_AMB.equals(codigo)
					|| CODIGO_PADRE_DMC.equals(codigo)
					|| CODIGO_PADRE_LOGISTICA.equals(codigo)
					|| CODIGO_PADRE_DASA.equals(codigo)
					|| CODIGO_PADRE_ZONA_NORTE.equals(codigo)
					|| CODIGO_PADRE_ZONA_CENTRAL.equals(codigo)
					|| CODIGO_PADRE_ZONA_SUR.equals(codigo)
					|| CODIGO_PADRE_ZONA_AUSTRAL.equals(codigo))){
				if (!listado.contains(REPORT1LINE15)) {
					listado.add(REPORT1LINE15);
				}
				}
		}
		return listado;
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
				sb.append(", ");
			}
			sb.append(it);
		}
		return sb.toString();
	}

	public static byte[] getReporteXLS(Filtro filtro) {
		byte[] reportXls = null;
		List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("subtitulo", filtro.getSubtitulo());
		parametros.put("items", getCsvFromList(filtro.getItem()));
		parametros.put("asignaciones", getCsvFromList(filtro.getAsignacion()));
		parametros.put("unidadesZonas", getCsvFromList(filtro.getUnidadZona()));
		parametros.put("unidadesEjecutoras",
				getCsvFromList(filtro.getUnidadEjec()));
		parametros.put("mes", getCsvFromList(filtro.getMes()));
		// parametros.put("mes",filtro.getMes());
		parametros.put("ano", filtro.getAno());
		parametros.put("tipo", filtro.getTipo());// EVALUAR SI ES O NO PARAMETRO
											// PARA REPORTE

		ByteArrayOutputStream baos;
		try {
			List<String> rutaReporte = getRutaReporte(filtro.getUnidadZona(),filtro.getAno());
			
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
					JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
					Boolean.FALSE);
			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,Boolean.FALSE);
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



//exporterXLS.setParameter( //	JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,	Boolean.TRUE);
	
		
	
//	public static byte[] getReporte(Filtro filtro) {
//	byte[] reportPdf = null;
//	List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
//	Map<String, Object> parametros = new HashMap<String, Object>();
//	parametros.put("subtitulo", filtro.getSubtitulo());
//	parametros.put("items", getCsvFromList(filtro.getItem()));
//	parametros.put("asignaciones", getCsvFromList(filtro.getAsignacion()));
//	parametros.put("unidadesZonas", getCsvFromList(filtro.getUnidadZona()));
//	parametros.put("unidadesEjecutoras",
//			getCsvFromList(filtro.getUnidadEjec()));
//	parametros.put("mes", getCsvFromList(filtro.getMes()));
//	// parametros.put("mes",filtro.getMes());
//	parametros.put("ano", filtro.getAno());
//	parametros.put("tipo", filtro.getTipo());// EVALUAR SI ES O NO PARAMETRO
//												// PARA REPORTE
//
//	ByteArrayOutputStream baos;
//	try {
//		List<String> rutaReporte = getRutaReporte(filtro.getUnidadZona());
//		
//		for(String cadena : rutaReporte){
//			JasperReport jasperReport = (JasperReport) JRLoader
//					.loadObject(new File(cadena));
//			JasperPrint jasperPrint = JasperFillManager.fillReport(
//					jasperReport, parametros, ConexionBD.obtenerConeNomina());
//			jasperPrintList.add(jasperPrint);
//		}
//		baos = new ByteArrayOutputStream();
//		JRPdfExporter exporter = new JRPdfExporter();
//		exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST,
//				jasperPrintList);
//		exporter.setParameter(
//				JRPdfExporterParameter.IS_CREATING_BATCH_MODE_BOOKMARKS,
//				Boolean.TRUE);
//		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
//		exporter.exportReport();
//		reportPdf = baos.toByteArray();
//
//	} catch (JRException e) {
//		e.printStackTrace();
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	return reportPdf;
//}
//
//private static List<String> getRutaReporte(List<String> codigoPadre) {
//	List<String> listado = new ArrayList<String>();
//	for (String codigo : codigoPadre) {
//		if (CODIGO_PADRE_AMB.equals(codigo)
//				|| CODIGO_PADRE_DMC.equals(codigo)
//				|| CODIGO_PADRE_LOGISTICA.equals(codigo)
//				|| CODIGO_PADRE_DASA.equals(codigo)
//				|| CODIGO_PADRE_ZONA_NORTE.equals(codigo)
//				|| CODIGO_PADRE_ZONA_CENTRAL.equals(codigo)
//				|| CODIGO_PADRE_ZONA_SUR.equals(codigo)
//				|| CODIGO_PADRE_ZONA_AUSTRAL.equals(codigo))
//				 {
//			if (!listado.contains(REPORT8EJEC)) {
//				listado.add(REPORT8EJEC);
//				continue;
//			}
//		}else if(!listado.contains(GEN2015NOMINA)) {
//			listado.add(GEN2015NOMINA);
//		}
//	}
//	return listado;
//}	
	
	
	
//	private static List<String> getRutaReporte2(List<String> codigoPadre,List<Integer> ano) {
//		List<String> listado = new ArrayList<String>();
//		for (String codigo : codigoPadre){
//			for(Integer anno : ano){
//			if (CODIGO_PADRE_AMB.equals(codigo)
//					|| CODIGO_PADRE_DMC.equals(codigo)
//					|| CODIGO_PADRE_LOGISTICA.equals(codigo)
//					|| CODIGO_PADRE_DASA.equals(codigo)){
//				if (!listado.contains(REPORT8EJEC)) {
//					listado.add(REPORT8EJEC);
//					continue;
//				}
//				
//			}
//			
//			
//			
//			
//			else if(!listado.contains(GEN2015NOMINA)) {
//				listado.add(GEN2015NOMINA);
//			}
//		}
//		}
//		return listado;
//	}
	
	
	
	
	// private static Integer getCsvFromListInt(List<Integer>item) {
	// StringBuilder sb = new StringBuilder();
	// for(Integer it : item2){
	// if(sb.length()>0){
	// sb.append(", ");
	// }
	// sb.append(it);
	// }
	// return sb.toString();
	// }

//	public static byte[] getReporte2() {
//		byte[] reportPdf = null;
//		List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
//		Map<String, Object> parametros = new HashMap<String, Object>();
//
//		ByteArrayOutputStream baos;
//		try {
//			String cadena = ("C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportes\\HHEEPROMEDIOCONNOMINA.jasper");
//			JasperReport jasperReport = (JasperReport) JRLoader
//					.loadObject(new File(cadena));
//			JasperPrint jasperPrint = JasperFillManager.fillReport(
//					jasperReport, parametros, ConexionBD.obtenerConeNomina());
//			jasperPrintList.add(jasperPrint);
//			baos = new ByteArrayOutputStream();
//			JRPdfExporter exporter = new JRPdfExporter();
//			exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST,
//					jasperPrintList);
//			exporter.setParameter(
//					JRPdfExporterParameter.IS_CREATING_BATCH_MODE_BOOKMARKS,
//					Boolean.TRUE);
//			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
//			exporter.exportReport();
//			reportPdf = baos.toByteArray();
//		} catch (JRException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return reportPdf;
//	}
//
//	public static byte[] getReporte3() {
//		byte[] reportPdf = null;
//		List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
//		Map<String, Object> parametros = new HashMap<String, Object>();
//
//		ByteArrayOutputStream baos;
//		try {
//			String cadena = ("C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportes\\HHEETURNOSCONNOMINA.jasper");
//			JasperReport jasperReport = (JasperReport) JRLoader
//					.loadObject(new File(cadena));
//			JasperPrint jasperPrint = JasperFillManager.fillReport(
//					jasperReport, parametros, ConexionBD.obtenerConeNomina());
//			jasperPrintList.add(jasperPrint);
//			baos = new ByteArrayOutputStream();
//			JRPdfExporter exporter = new JRPdfExporter();
//			exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST,
//					jasperPrintList);
//			exporter.setParameter(
//					JRPdfExporterParameter.IS_CREATING_BATCH_MODE_BOOKMARKS,
//					Boolean.TRUE);
//			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
//			exporter.exportReport();
//			reportPdf = baos.toByteArray();
//		} catch (JRException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return reportPdf;
//	}
//
//	JasperReport jr = null;
//	String ruta = "C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportes\\repviaticos3_2.jasper";
//
//	public static byte[] getReporte4(Integer tarea) {
//		byte[] reportPdf = null;
//
//		List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
//		Map<String, Object> parametros = new HashMap<String, Object>();
//		parametros.put("parameter1", tarea);
//		ByteArrayOutputStream baos;
//		try {
//			String cadena = ("C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportes\\repviaticos3_2.jasper");
//			JasperReport jasperReport = (JasperReport) JRLoader
//					.loadObject(new File(cadena));
//			JasperPrint jasperPrint = JasperFillManager.fillReport(
//					jasperReport, parametros, ConexionBD.obtenerConViati());
//			jasperPrintList.add(jasperPrint);
//			baos = new ByteArrayOutputStream();
//			JRPdfExporter exporter = new JRPdfExporter();
//			exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST,
//					jasperPrintList);
//			exporter.setParameter(
//					JRPdfExporterParameter.IS_CREATING_BATCH_MODE_BOOKMARKS,
//					Boolean.TRUE);
//			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
//			exporter.exportReport();
//			reportPdf = baos.toByteArray();
//		} catch (JRException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return reportPdf;
//	}
//
//	public static byte[] getReporte5(Integer ano_param, Integer mes_param,
//			Integer mes_param2, Integer mes_param3, Integer mes_param4,
//			Integer mes_param5, Integer mes_param6, Integer mes_param7,
//			Integer mes_param8, Integer mes_param9, Integer mes_param10,
//			// Integer mes_param11,Integer mes_param12,
//			String codigouni_param) {
//		byte[] reportPdf = null;
//		List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
//		Map<String, Object> parametros = new HashMap<String, Object>();
//		parametros.put("ano_param", ano_param);
//		parametros.put("mes_param", mes_param);
//		parametros.put("mes_param2", mes_param2);
//		parametros.put("mes_param3", mes_param3);
//		parametros.put("mes_param4", mes_param4);
//		parametros.put("mes_param5", mes_param5);
//		parametros.put("mes_param6", mes_param6);
//		parametros.put("mes_param7", mes_param7);
//		parametros.put("mes_param8", mes_param8);
//		parametros.put("mes_param9", mes_param9);
//		parametros.put("mes_param10", mes_param10);
//		// parametros.put("mes_param11", mes_param11);
//		// parametros.put("mes_param12", mes_param12);
//		parametros.put("codigouni_param", codigouni_param);
//
//		ByteArrayOutputStream baos;
//		try {
//			String cadena = ("C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportes\\parameters.jasper");
//			JasperReport jasperReport = (JasperReport) JRLoader
//					.loadObject(new File(cadena));
//			JasperPrint jasperPrint = JasperFillManager.fillReport(
//					jasperReport, parametros, ConexionBD.obtenerConeNomina());
//			jasperPrintList.add(jasperPrint);
//			baos = new ByteArrayOutputStream();
//			JRPdfExporter exporter = new JRPdfExporter();
//			exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST,
//					jasperPrintList);
//			exporter.setParameter(
//					JRPdfExporterParameter.IS_CREATING_BATCH_MODE_BOOKMARKS,
//					Boolean.TRUE);
//			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
//			exporter.exportReport();
//			reportPdf = baos.toByteArray();
//		} catch (JRException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return reportPdf;
//	}
//
//	public static byte[] getReporte6(Integer ano_param, Integer mes_param,
//			Integer mes_param2, Integer mes_param3, Integer mes_param4,
//			Integer mes_param5, Integer mes_param6, Integer mes_param7,
//			Integer mes_param8, Integer mes_param9, Integer mes_param10,
//			// Integer mes_param11,Integer mes_param12,
//			String codigouni_param) {
//		byte[] reportPdf = null;
//		List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
//		Map<String, Object> parametros = new HashMap<String, Object>();
//		parametros.put("ano_param", ano_param);
//		parametros.put("mes_param", mes_param);
//		parametros.put("mes_param2", mes_param2);
//		parametros.put("mes_param3", mes_param3);
//		parametros.put("mes_param4", mes_param4);
//		parametros.put("mes_param5", mes_param5);
//		parametros.put("mes_param6", mes_param6);
//		parametros.put("mes_param7", mes_param7);
//		parametros.put("mes_param8", mes_param8);
//		parametros.put("mes_param9", mes_param9);
//		parametros.put("mes_param10", mes_param10);
//		// parametros.put("mes_param11", mes_param11);
//		// parametros.put("mes_param12", mes_param12);
//		parametros.put("codigouni_param", codigouni_param);
//
//		ByteArrayOutputStream baos;
//		try {
//			String cadena = ("C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportes\\parameters.jasper");
//			JasperReport jasperReport = (JasperReport) JRLoader
//					.loadObject(new File(cadena));
//			JasperPrint jasperPrint = JasperFillManager.fillReport(
//					jasperReport, parametros, ConexionBD.obtenerConeNomina());
//			jasperPrintList.add(jasperPrint);
//			baos = new ByteArrayOutputStream();
//			JRPdfExporter exporter = new JRPdfExporter();
//			exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST,
//					jasperPrintList);
//			exporter.setParameter(
//					JRPdfExporterParameter.IS_CREATING_BATCH_MODE_BOOKMARKS,
//					Boolean.TRUE);
//			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
//			exporter.exportReport();
//			reportPdf = baos.toByteArray();
//		} catch (JRException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return reportPdf;
//	}
//
//	public static byte[] getReporte7(Integer mes_param, Integer mes_param2,
//			Integer mes_param3, Integer mes_param4, Integer mes_param5,
//			String codigouni_param, String codigouni_param2,
//			String codigouni_param3, String codigouni_param4,
//			String codigouni_param5) {
//
//		byte[] reportPdf = null;
//		List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
//		Map<String, Object> parametros = new HashMap<String, Object>();
//		parametros.put("mes_param", mes_param);
//		parametros.put("mes_param2", mes_param2);
//		parametros.put("mes_param3", mes_param3);
//		parametros.put("mes_param4", mes_param4);
//		parametros.put("mes_param5", mes_param5);
//		parametros.put("codigouni_param", codigouni_param); // "DEBE SER EL PRIMER PARAMETRO LA VARIABLE DE IREPORT "
//		parametros.put("codigouni_param2", codigouni_param2);
//		parametros.put("codigouni_param3", codigouni_param3);
//		parametros.put("codigouni_param4", codigouni_param4);
//		parametros.put("codigouni_param5", codigouni_param5);
//		ByteArrayOutputStream baos;
//		try {
//			String cadena = GEN2015NOMINA;
//			JasperReport jasperReport = (JasperReport) JRLoader
//					.loadObject(new File(cadena));
//			JasperPrint jasperPrint = JasperFillManager.fillReport(
//					jasperReport, parametros, ConexionBD.obtenerConeNomina());
//			jasperPrintList.add(jasperPrint);
//			baos = new ByteArrayOutputStream();
//			JRPdfExporter exporter = new JRPdfExporter();
//			exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST,
//					jasperPrintList);
//			exporter.setParameter(
//					JRPdfExporterParameter.IS_CREATING_BATCH_MODE_BOOKMARKS,
//					Boolean.TRUE);
//			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
//			exporter.exportReport();
//			reportPdf = baos.toByteArray();
//		} catch (JRException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return reportPdf;
//	}
//
//	public static byte[] getReporte8(String codigouni_param,
//			String codigouni_param2, String codigouni_param3,
//			String codigouni_param4, String codigouni_param5) {
//
//		byte[] reportXLS = null;
//		List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
//		Map<String, Object> parametros = new HashMap<String, Object>();
//		parametros.put("codigouni_param", codigouni_param); // "DEBE SER EL PRIMER PARAMETRO LA VARIABLE DE IREPORT "
//		parametros.put("codigouni_param2", codigouni_param2);
//		parametros.put("codigouni_param3", codigouni_param3);
//		parametros.put("codigouni_param4", codigouni_param4);
//		parametros.put("codigouni_param5", codigouni_param5);
//		ByteArrayOutputStream baos;
//		try {
//			String cadena = GEN2015NOMINA;
//			JasperReport jasperReport = (JasperReport) JRLoader
//					.loadObject(new File(cadena));
//			JasperPrint jasperPrint = JasperFillManager.fillReport(
//					jasperReport, parametros, ConexionBD.obtenerConeNomina());
//			jasperPrintList.add(jasperPrint);
//			baos = new ByteArrayOutputStream();
//			JRXlsExporter exporterXLS = new JRXlsExporter();
//			exporterXLS.setParameter(JRExporterParameter.JASPER_PRINT_LIST,
//					jasperPrintList);
//			exporterXLS.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
//			exporterXLS
//					.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
//							Boolean.FALSE);
//			exporterXLS.setParameter(
//					JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
//			exporterXLS.setParameter(
//					JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
//					Boolean.FALSE);
//			exporterXLS.setParameter(
//					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
//					Boolean.TRUE);
//			exporterXLS.exportReport();
//			reportXLS = baos.toByteArray();
//		} catch (JRException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return reportXLS;
//	}

	// NO ESTA EN USO
//	public void exportarPDF(ActionEvent actionEvent) throws JRException,
//			IOException {
//		Map<String, Object> parametros = new HashMap<String, Object>();
//		parametros.put("jasperro", "scp");
//		File jasper = new File(FacesContext.getCurrentInstance()
//				.getExternalContext().getRealPath("/pruebaZebra.jasper"));
//		JasperPrint jasperPrint = JasperFillManager.fillReport(
//				jasper.getPath(), null, ConexionBD.obtenerCon());
//		HttpServletResponse response = (HttpServletResponse) FacesContext
//				.getCurrentInstance().getExternalContext().getResponse();
//		response.addHeader("Content-disposition",
//				"attachment; filename=jsfReporte.pdf");
//		ServletOutputStream stream = response.getOutputStream();
//		JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
//		stream.flush();
//		stream.close();
//		FacesContext.getCurrentInstance().responseComplete();
//	}

}
