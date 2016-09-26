package org.dgac.app.web.bean;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import org.dgac.app.web.util.GenRepJasper;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
 

@ManagedBean(name = "panelUsuarioMb")
@ViewScoped
public class PanelUsuario implements Serializable {

	private static final long serialVersionUID = 5600369132889054255L;
	
	private Object filtros;
	
	
	

////	private boolean checkeado = false;
////	private boolean noCheckeado;
//	private String uniname;
//	private String[] asignacionesSelec;
//	private List<String> asignacion;
//	private String[] itemSelec;
//	private List<String> item;
//	private String[] zonasSelec;
//	private List<String> zonas;
//	private String[] uniEjeSelec;
//	private List<String> unidadesEjecutoras;
//	private String[] periodoMensSelec;
//	private List<String> periodoMens;
//	private String[] subtSelec;
//	private List<String> subtitulo;
//	private String[] tipoSelec;
//	private List<String> tipo;
//	private String[] periodoSelec;
//	private List<String> periodo;
//	private String[] periodoAnualSelec;
//	private List<String> periodoAnual;
//	private String[] subZonasSelec;
//	private List<String> subZonas;
//	private String[] subZonasNorteSelec;
//	private List<String> subZonasNorte;
//	private String[] subZonasCentroSelec;
//	private List<String> subZonasCentro;
//	private String[] subZonasDmcSelec;
//	private List<String> subZonasDmc;
//	private String[] subZonasAmbSelec;
//	private List<String> subZonasAmb;
//	private String[] subZonasDasaSelec;
//	private List<String> subZonasDasa;
//	private String[] subZonasSurSelec;
//	private List<String> subZonasSur;
//	private String[] subZonasAustralSelec;
//	private List<String> subZonasAustral;
//	private Integer tarea;
//	private Integer ano_param;
//	private Integer mes_param;
//	private Integer mes_param2;
//	private Integer mes_param3;
//	private Integer mes_param4;
//	private Integer mes_param5;
//	private Integer mes_param6;
//	private Integer mes_param7;
//	private Integer mes_param8;
//	private Integer mes_param9;
//	private Integer mes_param10;
//	private Integer mes_param11;
//	private Integer mes_param12;
//	private String codigouni_param;
//	private String codigouni_param2;
//	private String codigouni_param3;
//	private String codigouni_param4;
//	private String codigouni_param5;
//	
//
//	@PostConstruct
//	public void init() {
//		subtitulo = new ArrayList<String>();
//		subtitulo.add("Seleccione un Subtítulo");
//		subtitulo.add("Subtítulo 21 ");
//		subtitulo.add("Subtítulo 22 ");
//		subtitulo.add("Subtítulo 23 ");
//		item = new ArrayList<String>();
//		item.add("Remuneración Variable");
//		item.add("Otras Remuneraciones");
//		item.add("Otros Gastos En Personal");
//		asignacion = new ArrayList<String>();
//		asignacion.add("Horas Extras");
//		asignacion.add("Viáticos");
//		asignacion.add("Honorarios");
//		asignacion.add("Remuneraciones");
//		asignacion.add("Asignación Traslado");
//		zonas = new ArrayList<String>();
//		zonas.add("Todas");
//		zonas.add("AMB");
//		zonas.add("DMC");
//		zonas.add("Logística(Stgo)");
//		zonas.add("DASA");
//		zonas.add("Zona Norte");
//		zonas.add("Zona Centro");
//		zonas.add("Zona Sur");
//		zonas.add("Zona Austral");
//		unidadesEjecutoras = new ArrayList<String>();
//		unidadesEjecutoras.add("178 - Recursos Humanos");
//		unidadesEjecutoras.add("179 - Capacitación");
//		unidadesEjecutoras.add("180 - Beneficios Médicos");
//		unidadesEjecutoras.add("183 - ETA");
//		unidadesEjecutoras.add("184 - Subdepto.Personal");
//		unidadesEjecutoras.add("185 - Remuneraciones");
//		unidadesEjecutoras.add("187 - Prevención de Riesgos");
//		periodoMens = new ArrayList<String>();
//		periodoMens.add("Enero");
//		periodoMens.add("Febrero");
//		periodoMens.add("Marzo");
//		periodoMens.add("Abril");
//		periodoMens.add("Mayo");
//		periodoMens.add("Junio");
//		periodoMens.add("Julio");
//		periodoMens.add("Agosto");
//		periodoMens.add("Septiembre");
//		periodoMens.add("Octubre");
//		periodoMens.add("Noviembre");
//		periodoMens.add("Diciembre");
//		tipo = new ArrayList<String>();
//		tipo.add("Seleccione una opción");
//		tipo.add("Presupuesto Aprobado Por Ley");
//		tipo.add("Ejecución Presupuestaria");
//		periodo = new ArrayList<String>();
//		periodo.add("Seleccione un período");
//		periodo.add("Mensual");
//		periodo.add("Anual");
//		periodoAnual = new ArrayList<String>();
//		periodoAnual.add("Seleccione un Año");
//		periodoAnual.add("2013");
//		periodoAnual.add("2014");
//		periodoAnual.add("2015");
//		periodoAnual.add("2016");
//		subZonas = new ArrayList<String>();
//		subZonasNorte = new ArrayList<String>();
//		subZonasNorte.add("SELECCIONE UNIDAD:");
//		subZonasNorte.add("AEROPUERTO CHACALLUTA");
//		subZonasNorte.add("AEROPUERTO GENERAL DIEGO ARACENA");
//		subZonasNorte.add("IQUIQUE/ AP. DIEGO ARACENA");
//		subZonasNorte.add("CALAMA/ AD. EL LOA");
//		subZonasNorte.add("AERODROMO EL LOA");
//		subZonasNorte.add("AEROPUERTO ANDRES SABELLA");
//		subZonasNorte.add("SUBDEPARTAMENTO ZONA AEROPORTUARIA NORTE COMERCIAL");
//		subZonasNorte.add("SUBDPTO. ZONA AEROPORTUARIA NORTE");
//		subZonasNorte.add("AERODROMO DESIERTO DE ATACAMA");
//		subZonasNorte.add("ATACAMA/ AD. DESIERTO DE ATACAMA");
//		subZonasCentro = new ArrayList<String>();
//		subZonasCentro.add("AERODROMO LA FLORIDA");
//		subZonasCentro.add("LA SERENA/ AD. LA FLORIDA");
//		subZonasCentro.add("ISLA DE PASCUA/ AP. MATAVERI");
//		subZonasCentro.add("VIÑA DEL MAR/ AD. VIÑA DEL MAR");
//		subZonasCentro.add("AERODROMO VIÑA DEL MAR");
//		subZonasCentro.add("SUBDPTO. ZONA AEROPORTUARIA CENTRAL");
//		subZonasCentro.add("SUBDEPARTAMENTO ZONA AEROPORTTUARIA CENTRAL");
//		subZonasCentro.add("SANTIAGO/ AD. EULOGIO SÁNCHEZ");
//		subZonasCentro.add("AERODROMO EULOGIO SANCHEZ");
//		subZonasCentro.add("CONCEPCIÓN/ AD. CARRIEL SUR");
//		subZonasCentro.add("AERODROMO CARRIEL SUR");
//		subZonasCentro.add("AERODROMO ROBINSON CRUSOE");
//		subZonasDmc = new ArrayList<String>();
//		subZonasDmc.add("DEPARTAMENTO METEOROLOGICA DE CHILE");
//		subZonasAmb = new ArrayList<String>();
//		subZonasAmb.add("AEROPUERTO ARTURO MERINO BENITEZ");
//		subZonasAmb.add("SANTIAGO/ AMB");
//		subZonas.add("SECCION SERVICIOS GENERALES LOGISTICA");
//		subZonasDasa = new ArrayList<String>();
//		subZonasDasa.add("SANTIAGO/ DASA");
//		subZonasDasa.add("DEPARTAMENTO AERODROMOS Y SERVICIOS AERONAUTICOS");
//		subZonasSur = new ArrayList<String>();
//		subZonasSur.add("SECCION ZONA AEROPORTUARIA SUR");
//		subZonasSur.add("SUBDPTO. ZONA AEROPORTUARIA SUR");
//		subZonasSur.add("AERODROMO LA ARAUCANIA");
//		subZonasSur.add("TEMUCO/ AD. LA ARAUCANÍA");
//		subZonasSur.add("AERODROMO PICHOY");
//		subZonasSur.add("VALDIVIA/ AD. PICHOY");
//		subZonasSur.add("OSORNO/ AD. CAÑAL BAJO");
//		subZonasSur.add("AERODROMO CAÑAL BAJO");
//		subZonasSur.add("PTO. MONTT / AP. EL TEPUAL");
//		subZonasSur.add("AEROPUERTO EL TEPUAL");
//		subZonasSur.add("AERODROMO BALMACEDA");
//		subZonasAustral = new ArrayList<String>();
//		subZonasAustral.add("SUBDPTO. ZONA AEROPORTUARIA AUSTRAL");
//		subZonasAustral.add("SECCION ZONA AEROPORTUARIA AUSTRAL");
//		subZonasAustral.add("AEROPUERTO CARLOS IBAÑEZ DEL CAMPO");
//		subZonasAustral.add("PTA. ARENAS/ AP. CARLOS IBAÑEZ DEL CAMPO");
//		subZonas.add("OFICINA BIENESTAR B. SOCIAL");
//		subZonas.add("OFICINA DOCENTE ETA");
//		
//	}
//
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//
//	public PanelUsuario(Integer tarea) {
//		super();
//		this.tarea = tarea;
//	}
//	
//	
//
//	public PanelUsuario() {
//		super();
//	}
//
//	public PanelUsuario(Integer ano_param, Integer mes_param,
//			String codigouni_param) {
//		super();
//		this.ano_param = ano_param;
//		this.mes_param = mes_param;
//		this.codigouni_param = codigouni_param;
//	}
//	
//	
//	public PanelUsuario(Integer ano_param, Integer mes_param) {
//		super();
//		this.ano_param = ano_param;
//		this.mes_param = mes_param;
//	}
//
//	
//	
//	
//	public PanelUsuario(String uniname, String[] asignacionesSelec,
//			List<String> asignacion, String[] itemSelec, List<String> item,
//			String[] zonasSelec, List<String> zonas, String[] uniEjeSelec,
//			List<String> unidadesEjecutoras, String[] periodoMensSelec,
//			List<String> periodoMens, String[] subtSelec,
//			List<String> subtitulo, String[] tipoSelec, List<String> tipo,
//			String[] periodoSelec, List<String> periodo,
//			String[] periodoAnualSelec, List<String> periodoAnual,
//			Integer tarea, Integer ano_param, Integer mes_param,
//			Integer mes_param2, Integer mes_param3, Integer mes_param4,
//			Integer mes_param5, Integer mes_param6, Integer mes_param7,
//			Integer mes_param8, Integer mes_param9, Integer mes_param10,
//			Integer mes_param11, Integer mes_param12, String codigouni_param) {
//		super();
//		this.uniname = uniname;
//		this.asignacionesSelec = asignacionesSelec;
//		this.asignacion = asignacion;
//		this.itemSelec = itemSelec;
//		this.item = item;
//		this.zonasSelec = zonasSelec;
//		this.zonas = zonas;
//		this.uniEjeSelec = uniEjeSelec;
//		this.unidadesEjecutoras = unidadesEjecutoras;
//		this.periodoMensSelec = periodoMensSelec;
//		this.periodoMens = periodoMens;
//		this.subtSelec = subtSelec;
//		this.subtitulo = subtitulo;
//		this.tipoSelec = tipoSelec;
//		this.tipo = tipo;
//		this.periodoSelec = periodoSelec;
//		this.periodo = periodo;
//		this.periodoAnualSelec = periodoAnualSelec;
//		this.periodoAnual = periodoAnual;
//		this.tarea = tarea;
//		this.ano_param = ano_param;
//		this.mes_param = mes_param;
//		this.mes_param2 = mes_param2;
//		this.mes_param3 = mes_param3;
//		this.mes_param4 = mes_param4;
//		this.mes_param5 = mes_param5;
//		this.mes_param6 = mes_param6;
//		this.mes_param7 = mes_param7;
//		this.mes_param8 = mes_param8;
//		this.mes_param9 = mes_param9;
//		this.mes_param10 = mes_param10;
//		this.mes_param11 = mes_param11;
//		this.mes_param12 = mes_param12;
//		this.codigouni_param = codigouni_param;
//	}
//
//	
//	
//	
//	
//	public PanelUsuario(Integer ano_param, Integer mes_param,
//			Integer mes_param2, Integer mes_param3, Integer mes_param4,
//			Integer mes_param5, Integer mes_param6, Integer mes_param7,
//			Integer mes_param8, Integer mes_param9, Integer mes_param10,
//			String codigouni_param) {
//		super();
//		this.ano_param = ano_param;
//		this.mes_param = mes_param;
//		this.mes_param2 = mes_param2;
//		this.mes_param3 = mes_param3;
//		this.mes_param4 = mes_param4;
//		this.mes_param5 = mes_param5;
//		this.mes_param6 = mes_param6;
//		this.mes_param7 = mes_param7;
//		this.mes_param8 = mes_param8;
//		this.mes_param9 = mes_param9;
//		this.mes_param10 = mes_param10;
//		this.codigouni_param = codigouni_param;
//	}
//
//	public PanelUsuario(Integer ano_param, Integer mes_param,
//			Integer mes_param2, Integer mes_param3, Integer mes_param4,
//			Integer mes_param5, Integer mes_param6, Integer mes_param7,
//			Integer mes_param8, Integer mes_param9, Integer mes_param10,
//			Integer mes_param11, Integer mes_param12, String codigouni_param) {
//		super();
//		this.ano_param = ano_param;
//		this.mes_param = mes_param;
//		this.mes_param2 = mes_param2;
//		this.mes_param3 = mes_param3;
//		this.mes_param4 = mes_param4;
//		this.mes_param5 = mes_param5;
//		this.mes_param6 = mes_param6;
//		this.mes_param7 = mes_param7;
//		this.mes_param8 = mes_param8;
//		this.mes_param9 = mes_param9;
//		this.mes_param10 = mes_param10;
//		this.mes_param11 = mes_param11;
//		this.mes_param12 = mes_param12;
//		this.codigouni_param = codigouni_param;
//	}
//	
//	
//
//	public PanelUsuario(String codigouni_param, String codigouni_param2,
//			String codigouni_param3, String codigouni_param4,
//			String codigouni_param5) {
//		super();
//		this.codigouni_param = codigouni_param;
//		this.codigouni_param2 = codigouni_param2;
//		this.codigouni_param3 = codigouni_param3;
//		this.codigouni_param4 = codigouni_param4;
//		this.codigouni_param5 = codigouni_param5;
//	}
//	
//	
//	
//
//	public PanelUsuario(Integer mes_param, Integer mes_param2,
//			Integer mes_param3, Integer mes_param4, Integer mes_param5,
//			String codigouni_param, String codigouni_param2,
//			String codigouni_param3, String codigouni_param4,
//			String codigouni_param5) {
//		super();
//		this.mes_param = mes_param;
//		this.mes_param2 = mes_param2;
//		this.mes_param3 = mes_param3;
//		this.mes_param4 = mes_param4;
//		this.mes_param5 = mes_param5;
//		this.codigouni_param = codigouni_param;
//		this.codigouni_param2 = codigouni_param2;
//		this.codigouni_param3 = codigouni_param3;
//		this.codigouni_param4 = codigouni_param4;
//		this.codigouni_param5 = codigouni_param5;
//	}
//
//	public String getUniname() {
//		return uniname;
//	}
//
//	public void setUniname(String uniname) {
//		this.uniname = uniname;
//	}
//
//	public String[] getAsignacionesSelec() {
//		return asignacionesSelec;
//	}
//
//	public void setAsignacionesSelec(String[] asignacionesSelec) {
//		this.asignacionesSelec = asignacionesSelec;
//	}
//
//	public List<String> getAsignacion() {
//		return asignacion;
//	}
//
//	public void setAsignacion(List<String> asignacion) {
//		this.asignacion = asignacion;
//	}
//
//	public String[] getItemSelec() {
//		return itemSelec;
//	}
//
//	public void setItemSelec(String[] itemSelec) {
//		this.itemSelec = itemSelec;
//	}
//
//	public List<String> getItem() {
//		return item;
//	}
//
//	public void setItem(List<String> item) {
//		this.item = item;
//	}
//
//	public String[] getZonasSelec() {
//		return zonasSelec;
//	}
//
//	public void setZonasSelec(String[] zonasSelec) {
//		this.zonasSelec = zonasSelec;
//	}
//
//	public List<String> getZonas() {
//		return zonas;
//	}
//
//	public void setZonas(List<String> zonas) {
//		this.zonas = zonas;
//	}
//
//	public String[] getUniEjeSelec() {
//		return uniEjeSelec;
//	}
//
//	public void setUniEjeSelec(String[] uniEjeSelec) {
//		this.uniEjeSelec = uniEjeSelec;
//	}
//
//	public List<String> getUnidadesEjecutoras() {
//		return unidadesEjecutoras;
//	}
//
//	public void setUnidadesEjecutoras(List<String> unidadesEjecutoras) {
//		this.unidadesEjecutoras = unidadesEjecutoras;
//	}
//
//	public String[] getPeriodoMensSelec() {
//		return periodoMensSelec;
//	}
//
//	public void setPeriodoMensSelec(String[] periodoMensSelec) {
//		this.periodoMensSelec = periodoMensSelec;
//	}
//
//	public List<String> getPeriodoMens() {
//		return periodoMens;
//	}
//
//	public void setPeriodoMens(List<String> periodoMens) {
//		this.periodoMens = periodoMens;
//	}
//
//	public String[] getSubtSelec() {
//		return subtSelec;
//	}
//
//	public void setSubtSelec(String[] subtSelec) {
//		this.subtSelec = subtSelec;
//	}
//
//	public List<String> getSubtitulo() {
//		return subtitulo;
//	}
//
//	public void setSubtitulo(List<String> subtitulo) {
//		this.subtitulo = subtitulo;
//	}
//
//	public String[] getTipoSelec() {
//		return tipoSelec;
//	}
//
//	public void setTipoSelec(String[] tipoSelec) {
//		this.tipoSelec = tipoSelec;
//	}
//
//	public List<String> getTipo() {
//		return tipo;
//	}
//
//	public void setTipo(List<String> tipo) {
//		this.tipo = tipo;
//	}
//
//	public String[] getPeriodoSelec() {
//		return periodoSelec;
//	}
//
//	public void setPeriodoSelec(String[] periodoSelec) {
//		this.periodoSelec = periodoSelec;
//	}
//
//	public List<String> getPeriodo() {
//		return periodo;
//	}
//
//	public void setPeriodo(List<String> periodo) {
//		this.periodo = periodo;
//	}
//
//	public String[] getPeriodoAnualSelec() {
//		return periodoAnualSelec;
//	}
//
//	public void setPeriodoAnualSelec(String[] periodoAnualSelec) {
//		this.periodoAnualSelec = periodoAnualSelec;
//	}
//
//	public List<String> getPeriodoAnual() {
//		return periodoAnual;
//	}
//
//	public void setPeriodoAnual(List<String> periodoAnual) {
//		this.periodoAnual = periodoAnual;
//	}
//
//	
//	
//	public Integer getTarea() {
//		return tarea;
//	}
//
//	public void setTarea(Integer tarea) {
//		this.tarea = tarea;
//	}
//	
//	
//	public Integer getAno_param() {
//		return ano_param;
//	}
//
//	public void setAno_param(Integer ano_param) {
//		this.ano_param = ano_param;
//	}
//
//	public Integer getMes_param() {
//		return mes_param;
//	}
//
//	public void setMes_param(Integer mes_param) {
//		this.mes_param = mes_param;
//	}
//
//	
//	public Integer getMes_param2() {
//		return mes_param2;
//	}
//
//	public void setMes_param2(Integer mes_param2) {
//		this.mes_param2 = mes_param2;
//	}
//
//	public Integer getMes_param3() {
//		return mes_param3;
//	}
//
//	public void setMes_param3(Integer mes_param3) {
//		this.mes_param3 = mes_param3;
//	}
//
//	public Integer getMes_param4() {
//		return mes_param4;
//	}
//
//	public void setMes_param4(Integer mes_param4) {
//		this.mes_param4 = mes_param4;
//	}
//
//	public Integer getMes_param5() {
//		return mes_param5;
//	}
//
//	public void setMes_param5(Integer mes_param5) {
//		this.mes_param5 = mes_param5;
//	}
//
//	public Integer getMes_param6() {
//		return mes_param6;
//	}
//
//	public void setMes_param6(Integer mes_param6) {
//		this.mes_param6 = mes_param6;
//	}
//
//	public Integer getMes_param7() {
//		return mes_param7;
//	}
//
//	public void setMes_param7(Integer mes_param7) {
//		this.mes_param7 = mes_param7;
//	}
//
//	public Integer getMes_param8() {
//		return mes_param8;
//	}
//
//	public void setMes_param8(Integer mes_param8) {
//		this.mes_param8 = mes_param8;
//	}
//
//	public Integer getMes_param9() {
//		return mes_param9;
//	}
//
//	public void setMes_param9(Integer mes_param9) {
//		this.mes_param9 = mes_param9;
//	}
//
//	public Integer getMes_param10() {
//		return mes_param10;
//	}
//
//	public void setMes_param10(Integer mes_param10) {
//		this.mes_param10 = mes_param10;
//	}
//
//	public Integer getMes_param11() {
//		return mes_param11;
//	}
//
//	public void setMes_param11(Integer mes_param11) {
//		this.mes_param11 = mes_param11;
//	}
//
//	public Integer getMes_param12() {
//		return mes_param12;
//	}
//
//	public void setMes_param12(Integer mes_param12) {
//		this.mes_param12 = mes_param12;
//	}
//
//	public String getCodigouni_param() {
//		return codigouni_param;
//	}
//
//	public void setCodigouni_param(String codigouni_param) {
//		this.codigouni_param = codigouni_param;
//	}
//
//		
//	
//
//	public String[] getSubZonasSelec() {
//		return subZonasSelec;
//	}
//
//	public void setSubZonasSelec(String[] subZonasSelec) {
//		this.subZonasSelec = subZonasSelec;
//	}
//
//	public List<String> getSubZonas() {
//		return subZonas;
//	}
//
//	public void setSubZonas(List<String> subZonas) {
//		this.subZonas = subZonas;
//	}
//
//	public String[] getSubZonasNorteSelec() {
//		return subZonasNorteSelec;
//	}
//
//	public void setSubZonasNorteSelec(String[] subZonasNorteSelec) {
//		this.subZonasNorteSelec = subZonasNorteSelec;
//	}
//
//	public List<String> getSubZonasNorte() {
//		return subZonasNorte;
//	}
//
//	public void setSubZonasNorte(List<String> subZonasNorte) {
//		this.subZonasNorte = subZonasNorte;
//	}
//
//	public String[] getSubZonasCentroSelec() {
//		return subZonasCentroSelec;
//	}
//
//	public void setSubZonasCentroSelec(String[] subZonasCentroSelec) {
//		this.subZonasCentroSelec = subZonasCentroSelec;
//	}
//
//	public List<String> getSubZonasCentro() {
//		return subZonasCentro;
//	}
//
//	public void setSubZonasCentro(List<String> subZonasCentro) {
//		this.subZonasCentro = subZonasCentro;
//	}
//
//	public String[] getSubZonasDmcSelec() {
//		return subZonasDmcSelec;
//	}
//
//	public void setSubZonasDmcSelec(String[] subZonasDmcSelec) {
//		this.subZonasDmcSelec = subZonasDmcSelec;
//	}
//
//	public List<String> getSubZonasDmc() {
//		return subZonasDmc;
//	}
//
//	public void setSubZonasDmc(List<String> subZonasDmc) {
//		this.subZonasDmc = subZonasDmc;
//	}
//
//	public String[] getSubZonasAmbSelec() {
//		return subZonasAmbSelec;
//	}
//
//	public void setSubZonasAmbSelec(String[] subZonasAmbSelec) {
//		this.subZonasAmbSelec = subZonasAmbSelec;
//	}
//
//	public List<String> getSubZonasAmb() {
//		return subZonasAmb;
//	}
//
//	public void setSubZonasAmb(List<String> subZonasAmb) {
//		this.subZonasAmb = subZonasAmb;
//	}
//
//	public String[] getSubZonasDasaSelec() {
//		return subZonasDasaSelec;
//	}
//
//	public void setSubZonasDasaSelec(String[] subZonasDasaSelec) {
//		this.subZonasDasaSelec = subZonasDasaSelec;
//	}
//
//	public List<String> getSubZonasDasa() {
//		return subZonasDasa;
//	}
//
//	public void setSubZonasDasa(List<String> subZonasDasa) {
//		this.subZonasDasa = subZonasDasa;
//	}
//
//	public String[] getSubZonasSurSelec() {
//		return subZonasSurSelec;
//	}
//
//	public void setSubZonasSurSelec(String[] subZonasSurSelec) {
//		this.subZonasSurSelec = subZonasSurSelec;
//	}
//
//	public List<String> getSubZonasSur() {
//		return subZonasSur;
//	}
//
//	public void setSubZonasSur(List<String> subZonasSur) {
//		this.subZonasSur = subZonasSur;
//	}
//
//	public String[] getSubZonasAustralSelec() {
//		return subZonasAustralSelec;
//	}
//
//	public void setSubZonasAustralSelec(String[] subZonasAustralSelec) {
//		this.subZonasAustralSelec = subZonasAustralSelec;
//	}
//
//	public List<String> getSubZonasAustral() {
//		return subZonasAustral;
//	}
//
//	public void setSubZonasAustral(List<String> subZonasAustral) {
//		this.subZonasAustral = subZonasAustral;
//	}
//	
//	
//
//	public String getCodigouni_param2() {
//		return codigouni_param2;
//	}
//
//	public void setCodigouni_param2(String codigouni_param2) {
//		this.codigouni_param2 = codigouni_param2;
//	}
//
//	public String getCodigouni_param3() {
//		return codigouni_param3;
//	}
//
//	public void setCodigouni_param3(String codigouni_param3) {
//		this.codigouni_param3 = codigouni_param3;
//	}
//
//	public String getCodigouni_param4() {
//		return codigouni_param4;
//	}
//
//	public void setCodigouni_param4(String codigouni_param4) {
//		this.codigouni_param4 = codigouni_param4;
//	}
//
//	public String getCodigouni_param5() {
//		return codigouni_param5;
//	}
//
//	public void setCodigouni_param5(String codigouni_param5) {
//		this.codigouni_param5 = codigouni_param5;
//	}
//
//	public boolean asignacionDisabled(String asignacion) {
//		if (itemSelec == null) {
//			return true;
//		}
//		List<String> itemHabilita = getItemHabilitador(asignacion);
//
//		for (String match : itemSelec) {
//			if (itemHabilita.contains(match)) {
//				return false;
//			}
//		}
//		return true;
//
//	}
//	public boolean uniEjecDisab(String unidadesEjecutoras) {
//		if (asignacionesSelec == null) {
//			return true;
//		}
//		List<String> asigHabilita = getAsignacionHabilitadorUE(unidadesEjecutoras);
//
//		for (String match : itemSelec) {
//			if (asigHabilita.contains(match)) {
//				return false;
//			}
//		}
//		return true;
//
//	}
//	
//	public boolean activarPaneles() {
//	    if ("Subtítulo 21".equals(subtitulo)) {
//	       return true;
//	    } else {
//	       return false;
//	    }
//	}
//
//	public boolean zonasDisabled(String zonas) {
//		if (asignacionesSelec == null) {
//			return true;
//		}
//		List<String> asigHabilita = getAsignacionHabilitador(zonas);
//		for (String match : asignacionesSelec) {
//			if (asigHabilita.contains(match)) {
//				return false;
//			}
//		}
//		return true;
//	}
//
////  getMesesHabilitador(periodoMens);
//	public boolean mesesDisabled(String periodoMens) {
//		if (periodoMensSelec == null) {
//			return true;
//		}
//		List<String> zonasHabilita =  getZonaHabilitador2(periodoMens) ;
//		for (String match : periodoMensSelec) {
//			if (zonasHabilita.contains(match)) {
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	private List<String> getItemHabilitador(String asignacion) {
//		List<String> listaItems = new ArrayList<String>();
//		if ("Horas Extras".equals(asignacion)) {
//			listaItems.add("Remuneración Variable");
//		} else if ("Viáticos".equals(asignacion)) {
//			listaItems.add("Remuneración Variable");
//		} else if ("Honorarios".equals(asignacion)) {
//			listaItems.add("Otras Remuneraciones");
//		}else if("Remuneraciones".equals(asignacion)){
//			listaItems.add("Otras Remuneraciones");
//		}
//		else if("Asignación Traslado".equals(asignacion)){
//			listaItems.add("Otros Gastos En Personal");
//		}
//		return listaItems;
//	}
//
//	private List<String> getAsignacionHabilitador(String zonas) {
//		List<String> listaAsignacion = new ArrayList<String>();
//		if("Todas".equals(zonas)) {
//			listaAsignacion.add("Horas Extras");
//		} else if ("AMB".equals(zonas)) {
//			listaAsignacion.add("Horas Extras");
//		} else if ("DMC".equals(zonas)) {
//			listaAsignacion.add("Horas Extras");
//		} else if ("Logística(Stgo)".equals(zonas)) {
//			listaAsignacion.add("Horas Extras");
//		} else if ("Logística(Stgo)".equals(zonas)) {
//			listaAsignacion.add("Horas Extras");
//		} else if ("DASA".equals(zonas)) {
//			listaAsignacion.add("Horas Extras");
//		} else if ("Zona Norte".equals(zonas)) {
//			listaAsignacion.add("Horas Extras");
//		} else if ("Zona Centro".equals(zonas)) {
//			listaAsignacion.add("Horas Extras");
//		} else if ("Zona Sur".equals(zonas)) {
//			listaAsignacion.add("Horas Extras");
//		} else if ("Zona Austral".equals(zonas)) {
//			listaAsignacion.add("Horas Extras");
//		}
//		return listaAsignacion;
//	}
//	
//	private List<String> getAsignacionHabilitadorUE(String asignacion) {
//		List<String> listaUE = new ArrayList<String>();
//		if("Horas Extras".equals(asignacion)) {
//			listaUE.add("185 - Remuneraciones");
//		}
//				return listaUE;
//	}
//
//	private List<String> getMesesHabilitador(String zonas) {
//		List<String> listaAsignacionMes = new ArrayList<String>();
//		if ("Enero".equals(periodoMens)) {
//			listaAsignacionMes.add("Horas Extras");
//			
//		} else if ("Febrero".equals(periodoMens)) {
//			listaAsignacionMes.add("Horas Extras");
//
//		} else if ("Marzo".equals(periodoMens)) {
//			listaAsignacionMes.add("Horas Extras");
//
//		} else if ("Abril".equals(periodoMens)) {
//			listaAsignacionMes.add("Horas Extras");
//
//		} else if ("Mayo".equals(periodoMens)) {
//			listaAsignacionMes.add("Horas Extras");
//
//		} else if ("Junio".equals(periodoMens)) {
//			listaAsignacionMes.add("Horas Extras");
//
//		} else if ("Julio".equals(periodoMens)) {
//			listaAsignacionMes.add("Horas Extras");
//
//		} else if ("Agosto".equals(periodoMens)) {
//			listaAsignacionMes.add("Horas Extras");
//
//		} else if ("Septiembre".equals(periodoMens)) {
//			listaAsignacionMes.add("Horas Extras");
//
//		} else if ("Octubre".equals(periodoMens)) {
//			listaAsignacionMes.add("Horas Extras");
//
//		} else if ("Noviembre".equals(periodoMens)) {
//			listaAsignacionMes.add("Horas Extras");
//
//		} else if ("Diciembre".equals(periodoMens)) {
//			listaAsignacionMes.add("Horas Extras");
//
//		}
//
//		return listaAsignacionMes;
//	}
//
//	private List<String> getZonaHabilitador(String periodoMens) {
//		List<String> listaZonas = new ArrayList<String>();
//		if ("Enero".equals(periodoMens) || "Febrero".equals(periodoMens)
//				|| "Marzo".equals(periodoMens) || "Abril".equals(periodoMens)) {
//			listaZonas.add("Todas");
//			listaZonas.add("AMB");
//			listaZonas.add("DMC");
//			listaZonas.add("Logística(Stgo)");
//			listaZonas.add("DASA");
//			listaZonas.add("Zona Norte");
//			listaZonas.add("Zona Centro");
//			listaZonas.add("Zona Sur");
//			listaZonas.add("Zona Austral");
//
//		} else if ("Mayo".equals(periodoMens) || "Junio".equals(periodoMens)
//				|| "Julio".equals(periodoMens) || "Agosto".equals(periodoMens)) {
//			listaZonas.add("Todas");
//			listaZonas.add("AMB");
//			listaZonas.add("DMC");
//			listaZonas.add("Logística(Stgo)");
//			listaZonas.add("DASA");
//			listaZonas.add("Zona Norte");
//			listaZonas.add("Zona Centro");
//			listaZonas.add("Zona Sur");
//			listaZonas.add("Zona Austral");
//		} else if ("Septiembre".equals(periodoMens)
//				|| "Octubre".equals(periodoMens)
//				|| "Noviembre".equals(periodoMens)
//				|| "Diciembre".equals(periodoMens)) {
//			listaZonas.add("Todas");
//			listaZonas.add("AMB");
//			listaZonas.add("DMC");
//			listaZonas.add("Logística(Stgo)");
//			listaZonas.add("DASA");
//			listaZonas.add("Zona Norte");
//			listaZonas.add("Zona Centro");
//			listaZonas.add("Zona Sur");
//			listaZonas.add("Zona Austral");
//		}
//
//		return listaZonas;
//	}
//
//	private List<String> getZonaHabilitador2(String periodoMens) { 
//		List<String> listaZonas = new ArrayList<String>();
//		if ("Enero".equals(periodoMens)) {
//						listaZonas.add("Todas");
//						listaZonas.add("AMB");
//						listaZonas.add("DMC");
//						listaZonas.add("Logística(Stgo)");
//						listaZonas.add("DASA");
//						listaZonas.add("Zona Norte");
//						listaZonas.add("Zona Centro");
//						listaZonas.add("Zona Sur");
//						listaZonas.add("Zona Austral");
//		} 	else if ("Febrero".equals(periodoMens)) {
//			listaZonas.add("Todas");
//			listaZonas.add("AMB");
//			listaZonas.add("DMC");
//			listaZonas.add("Logística(Stgo)");
//			listaZonas.add("DASA");
//			listaZonas.add("Zona Norte");
//			listaZonas.add("Zona Centro");
//			listaZonas.add("Zona Sur");
//			listaZonas.add("Zona Austral");
//		} else if ("Marzo".equals(periodoMens)) {
//		listaZonas.add("Todas");
//		listaZonas.add("AMB");
//		listaZonas.add("DMC");
//		listaZonas.add("Logística(Stgo)");
//		listaZonas.add("DASA");
//		listaZonas.add("Zona Norte");
//		listaZonas.add("Zona Centro");
//		listaZonas.add("Zona Sur");
//		listaZonas.add("Zona Austral");
//	} else if ("Abril".equals(periodoMens)) {
//		listaZonas.add("Todas");
//		listaZonas.add("AMB");
//		listaZonas.add("DMC");
//		listaZonas.add("Logística(Stgo)");
//		listaZonas.add("DASA");
//		listaZonas.add("Zona Norte");
//		listaZonas.add("Zona Centro");
//		listaZonas.add("Zona Sur");
//		listaZonas.add("Zona Austral");
//	} else if ("Mayo".equals(periodoMens)) {
//		listaZonas.add("Todas");
//		listaZonas.add("AMB");
//		listaZonas.add("DMC");
//		listaZonas.add("Logística(Stgo)");
//		listaZonas.add("DASA");
//		listaZonas.add("Zona Norte");
//		listaZonas.add("Zona Centro");
//		listaZonas.add("Zona Sur");
//		listaZonas.add("Zona Austral");
//	} else if ("Junio".equals(periodoMens)) {
//		listaZonas.add("Todas");
//		listaZonas.add("AMB");
//		listaZonas.add("DMC");
//		listaZonas.add("Logística(Stgo)");
//		listaZonas.add("DASA");
//		listaZonas.add("Zona Norte");
//		listaZonas.add("Zona Centro");
//		listaZonas.add("Zona Sur");
//		listaZonas.add("Zona Austral");
//	}  else if ("Julio".equals(periodoMens)) {
//		listaZonas.add("Todas");
//		listaZonas.add("AMB");
//		listaZonas.add("DMC");
//		listaZonas.add("Logística(Stgo)");
//		listaZonas.add("DASA");
//		listaZonas.add("Zona Norte");
//		listaZonas.add("Zona Centro");
//		listaZonas.add("Zona Sur");
//		listaZonas.add("Zona Austral");
//	}   else if ("Agosto".equals(periodoMens)) {
//		listaZonas.add("Todas");
//		listaZonas.add("AMB");
//		listaZonas.add("DMC");
//		listaZonas.add("Logística(Stgo)");
//		listaZonas.add("DASA");
//		listaZonas.add("Zona Norte");
//		listaZonas.add("Zona Centro");
//		listaZonas.add("Zona Sur");
//		listaZonas.add("Zona Austral");
//	}    else if ("Septiembre".equals(periodoMens)) {
//		listaZonas.add("Todas");
//		listaZonas.add("AMB");
//		listaZonas.add("DMC");
//		listaZonas.add("Logística(Stgo)");
//		listaZonas.add("DASA");
//		listaZonas.add("Zona Norte");
//		listaZonas.add("Zona Centro");
//		listaZonas.add("Zona Sur");
//		listaZonas.add("Zona Austral");
//	}    else if ("Octubre".equals(periodoMens)) {
//		listaZonas.add("Todas");
//		listaZonas.add("AMB");
//		listaZonas.add("DMC");
//		listaZonas.add("Logística(Stgo)");
//		listaZonas.add("DASA");
//		listaZonas.add("Zona Norte");
//		listaZonas.add("Zona Centro");
//		listaZonas.add("Zona Sur");
//		listaZonas.add("Zona Austral");
//	}    else if ("Noviembre".equals(periodoMens)) {
//		listaZonas.add("Todas");
//		listaZonas.add("AMB");
//		listaZonas.add("DMC");
//		listaZonas.add("Logística(Stgo)");
//		listaZonas.add("DASA");
//		listaZonas.add("Zona Norte");
//		listaZonas.add("Zona Centro");
//		listaZonas.add("Zona Sur");
//		listaZonas.add("Zona Austral");
//	}    else if ("Diciembre".equals(periodoMens)) {
//		listaZonas.add("Todas");
//		listaZonas.add("AMB");
//		listaZonas.add("DMC");
//		listaZonas.add("Logística(Stgo)");
//		listaZonas.add("DASA");
//		listaZonas.add("Zona Norte");
//		listaZonas.add("Zona Centro");
//		listaZonas.add("Zona Sur");
//		listaZonas.add("Zona Austral");
//	}
//		return listaZonas;
//	}
////	public StreamedContent getFile() {
////		return null;
////	}
////	public StreamedContent getFile() {
////		//System.out.println("PanelUsuario.getFile() llego al metodo");
////		try {
////		    byte[] reportPdf = GenRepJasper.getReporte();
////			InputStream fis = new ByteArrayInputStream(reportPdf);
////			return new DefaultStreamedContent(fis,
////					"application/pdf; charset=UTF-8", "INFORME - xxx.pdf");
////		} catch (Exception e) {
////			System.out.println("error catch");
////		}
////		return null;
////	}
//	
//	//trae las unidades desde la b.d
//	
//	public List<SelectItem> getUnidadesName() {
//        List<SelectItem> uni = new ArrayList<SelectItem>();
//        try {
//            Connection con = ConexionBD.obtenerCon();
//            Statement st = con.createStatement();
//            ResultSet rs = null;
//            String myQuery = "select nombre_unidad from unidad6";
// 
//            rs = st.executeQuery(myQuery);
//            while (rs.next()) {
//                uni.add(new SelectItem(rs.getString("nombre_unidad")));
//            }
// 
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
// 
//        return uni;
//    }
//	
//	public List<SelectItem> getUnidadesName2() {
//        List<SelectItem> uni = new ArrayList<SelectItem>();
//        try {
//            Connection con = ConexionBD.obtenerConeNomina();
//            Statement st = con.createStatement();
//            ResultSet rs = null;
//            //String myQuery = "select nombre_unidad from unidad6";
//            String myQuery="SELECT DISTINCT DESCRIP FROM NOMINA_DGAC.TABLAS WHERE ID_TABLA = 69 AND CODIGO = 11701000 "+ 
////	            		TRAE LAS UNIDADES POR NOMBRE Y LAS BUSCA POR CODIGO						   
//	            								   "OR CODIGO = 11702000"+  
//	            								   "OR CODIGO = 11703000"+  
//	            								   "OR CODIGO = 20005060"+
//	            								   "OR CODIGO = 11700000"+  
//	            								   "OR CODIGO = 11708000"+   
//	            								   "OR CODIGO = 11802000"+   
//	            								   "OR CODIGO = 11803000"+   
//	            								   "OR CODIGO = 11806000"+   
//	            								   "OR CODIGO = 11800000"+   
//	            								   "OR CODIGO = 11808000"+  
//	            								   "OR CODIGO = 11813000"+   
//	            								   "OR CODIGO = 20005057"+  
//	            								   "OR CODIGO = 10700000"+   
//	            								   "OR CODIGO = 11001000"+   
//	            								   "OR CODIGO = 10801400"+  
//	            								   "OR CODIGO = 11000000"+  
//	            								   "OR CODIGO = 11900000"+  
//	            								   "OR CODIGO = 20005027"+   
//	            								   "OR CODIGO = 11902000"+   
//	            								   "OR CODIGO = 11903000"+   
//	            								   "OR CODIGO = 11904000"+   
//	            								   "OR CODIGO = 11913000"+   
//	            								   "OR CODIGO = 12000000"+   
//	            								   "OR CODIGO = 12001000"+   
//	            								   "OR CODIGO = 10904300"+   
//	            								   "OR CODIGO = 10902200";
// 
//            rs = st.executeQuery(myQuery);
//            while (rs.next()) {
//                uni.add(new SelectItem(rs.getString("DESCRIP")));
//            }
// 
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
// 
//        return uni;
//    }
//	
//	public FacesMessage mensaje(){
//		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "error de prueba para cachar k onda.");
//		return message;
//	}
//	
////	public void cargarReporteParam(Integer tarea){
////		//Connection cone= ConexionBD.obtenerConViati();
////		JasperReport jr = null;
////		String ruta="C:\\Users\\michael.solis\\workspace3\\app\\app_web\\reportes\\repviaticos3_2.jasper";
////	
////		try {
////			Map parametro1= new HashMap();
////			parametro1.put("parameter1", tarea);
////			jr=(JasperReport) JRLoader.loadObjectFromFile(ruta);
////			
////					JasperPrint jp = JasperFillManager.fillReport(jr, parametro1,ConexionBD.obtenerConViati());
////					JasperViewer jv =new JasperViewer(jp);
////					jv.setVisible(true);
////					jv.setTitle("Reporte con parametros");
////		
////		} catch (JRException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
////		
////	}
//	
//	public void cargarDatosCombo(){
//		 Connection co=null;       
//		        try {
//	         Class.forName("oracle.jdbc.driver.OracleDriver");
//	         co=ConexionBD.obtenerConeNomina();
//	                 Statement st= co.createStatement();
//	                 java.sql.ResultSet rs=st.executeQuery("SELECT DISTINCT DESCRIP FROM NOMINA_DGAC.TABLAS WHERE ID_TABLA = 69 and" +
//	            								"CODIGO = 11701000"+  
//	            								"OR CODIGO = 11702000"+  
//	            								"OR CODIGO = 11703000"+  
//	            								"OR CODIGO = 20005060"+
//	            								"OR CODIGO = 11700000"+  
//	            								"OR CODIGO = 11708000"+   
//	            								"OR CODIGO = 11802000"+   
//	            								"OR CODIGO = 11803000"+   
//	            								"OR CODIGO = 11806000"+   
//	            								"OR CODIGO = 11800000"+   
//	            								"OR CODIGO = 11808000"+  
//	            								"OR CODIGO = 11813000"+   
//	            								"OR CODIGO = 20005057"+  
//	            								"OR CODIGO = 10700000"+   
//	            								"OR CODIGO = 11001000"+   
//	            								"OR CODIGO = 10801400"+  
//	            								"OR CODIGO = 11000000"+  
//	            								"OR CODIGO = 11900000"+  
//	            								"OR CODIGO = 20005027"+   
//	            								"OR CODIGO = 11902000"+   
//	            								"OR CODIGO = 11903000"+   
//	            								"OR CODIGO = 11904000"+   
//	            								"OR CODIGO = 11913000"+   
//	            								"OR CODIGO = 12000000"+   
//	            								"OR CODIGO = 12001000"+   
//	            								"OR CODIGO = 10904300"+   
//	            								"OR CODIGO = 10902200 ");
//	             zonas.remove(rs);  
//	             while(rs.next()){
//	            zonas.add(rs.getString(1));
//	            }
//	        } catch (ClassNotFoundException ex) {
//	            Logger.getLogger(PanelUsuario.class.getName()).log(Level.SEVERE, null, ex);
//	        } catch (SQLException ex) {
//	            Logger.getLogger(PanelUsuario.class.getName()).log(Level.SEVERE, null, ex);
//	        }
//	            
////	    }catch(ClassNotFoundException ex){
////	    	} catch (SQLException e) {
////			
////			e.printStackTrace();
////		}
//	    }
	
}