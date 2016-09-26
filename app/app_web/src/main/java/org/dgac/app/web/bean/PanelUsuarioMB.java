package org.dgac.app.web.bean;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.SelectItem;

import org.dgac.app.web.util.GenRepJasper;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.Visibility;

@ManagedBean(name = "panelUsuarioMB")
@ViewScoped
public class PanelUsuarioMB implements Serializable {

	private static final String CODIGO_REMUNERACION = "185";
	private static final long serialVersionUID = 5600369132889054255L;
	private List<Subt> availableSubtitulo;
	private Filtro selectedValues;
	private List<Item> item;
	private List<Asignacion> asignacion;
	private List<UnidadesZonas> unidadZona;
	private List<UnidadesResum> uniResum;
	private List<RemuVariables> remuVar;
	private List<RemuResum> remuResum;
	private List<SelectItem> unidadZonaSI;
	private List<UnidadEjecutora> unidadEjec;
	// private List<String> unidadEjec;
	private List<Integer> ano;
	private List<Mes> mesList;
	private List<Tipo> avalaibleTipo;
	private List<UnidadZonaNorte> unidadZonaNorte;
	private List<UnidadesZonas> unidadTodas;
	private List<UnidadesZonas> unidadZonaCentro;
	private List<UnidadesZonas> unidadDmc;
	private List<UnidadesZonas> unidadAmb;
	private List<UnidadesZonas> unidadLogistica;
	private List<UnidadesZonas> unidadDasa;
	private List<UnidadesZonas> unidadZonaSur;
	private List<UnidadesZonas> unidadZonaAustral;
	private List<UnidadesZonas> unidadOtras; 
	private List<UnidadesResum> unidHHEE; 
	
	private List<Especialidades> especialidades;
	private boolean selecNoSelec;
	private SistemaBean sistemaBean ;
	private LoginBean2 logBean2= new LoginBean2();
	private LoginBean2 loginBean2 = new LoginBean2(logBean2);
	public boolean disab=false;
	private List<Boolean> list;
	
	
	
	
	public List<Boolean> getList() {
		return list;
	}

	public void setList(List<Boolean> list) {
		this.list = list;
	}

	public List<UnidadesResum> getUnidHHEE() {
		return unidHHEE;
	}

	public void setUnidHHEE(List<UnidadesResum> unidHHEE) {
		this.unidHHEE = unidHHEE;
	}

	public List<RemuResum> getRemuResum() {
		return remuResum;
	}

	public void setRemuResum(List<RemuResum> remuResum) {
		this.remuResum = remuResum;
	}

	public List<RemuVariables> getRemuVar() {
		return remuVar;
	}

	public void setRemuVar(List<RemuVariables> remuVar) {
		this.remuVar = remuVar;
	}

	public List<UnidadesZonas> getUnidadTodas() {
		return unidadTodas;
	}

	public void setUnidadTodas(List<UnidadesZonas> unidadTodas) {
		this.unidadTodas = unidadTodas;
	}

//	public boolean render(){
//		if(selectedValues.getAsignacion().contains("1")){
//		this.setDisab(true);
//		return true;
//		}
//		else if (!selectedValues.getAsignacion().contains("1")){ 
//			this.setDisab(false);
//			return false;
//		}
//	this.setDisab(true);
//		  return (Boolean) null;
//		return true;
//		}
	
	public boolean render(){
		for(int x=0;x<selectedValues.getAsignacion().size()-1;x++){
		if(selectedValues.getAsignacion().equals("1")){
				return true;
				}
	
		} 
		return false;
		}
	
	public boolean isDisab() {
		return render();
	}
	public void setDisab(boolean disab) {
		this.disab=disab;
	}
	
	public boolean renderSize(){
		if(selectedValues.getAsignacion().size()<=0){
			return false;
			}
			else if (selectedValues.getAsignacion().size()>=0){ // CODIGO HHEE
				return true;
			}
			return render();
			}
		
	
	public boolean renderFalse(){
		return false;
		}
	
	
	
	
	public void inactivo() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, 
                                        "Usuario inactivo.", "Esta usted usando la aplicación?"));
    }
 
    public void activo() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                                        "Bienvenido", "Bueno, esa fue una buena pausa...a seguir trabajando"));
    }
	

	
	 public void handleToggle(ToggleEvent event) {
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Primera Etapa", "Visible:" + event.getVisibility());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }

	public List<Especialidades> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidades> especialidades) {
		this.especialidades = especialidades;
	}

	public boolean isSelecNoSelec() {
		return selecNoSelec;
	}

	public void setSelecNoSelec(boolean selecNoSelec) {
		this.selecNoSelec = selecNoSelec;
	}

	public List<Tipo> getAvalaibleTipo() {
		return avalaibleTipo;
	}

	public void setAvalaibleTipo(List<Tipo> avalaibleTipo) {
		this.avalaibleTipo = avalaibleTipo;
	}

	public List<SelectItem> getUnidadZonaSI() {
		return unidadZonaSI;
	}

	public void setUnidadZonaSI(List<SelectItem> unidadZonaSI) {
		this.unidadZonaSI = unidadZonaSI;
	}

	public void setMesList(List<Mes> mesList) {
		this.mesList = mesList;
	}

	public List<UnidadesResum> getUniResum() {
		return uniResum;
	}

	public void setUniResum(List<UnidadesResum> uniResum) {
		this.uniResum = uniResum;
	}

	public PanelUsuarioMB() {
		this.selectedValues = new Filtro();
		inicializaSubs();
		inicializaItems();
		inicializaAsignacion();
		//inicializaResum();
	    //inicializaUnidadesZona();
		inicializaUnidadEjecutora();
		inicializaMes();
		inicializaAnos();
		inicializaTipo();
		inicializaRemuVarResum();
		// inicializaUnidadesZonaNorte();
		inicializaEspecialidades();
		selectedValues.setSistemaBean(sistemaBean);
		selectedValues.loginBean2.getUser();
		loginBean2.getUser(); 
	    //isDisab();
	}


//	private void inicializaEspecialidades() {
//		especialidades = new ArrayList<Especialidades>();
//		especialidades.add(new Especialidades("1280","CONTROLADOR DE TRANSITO AEREO"));
//		especialidades.add(new Especialidades("1290","CONTROLADOR DE TRANSITO AEREO"));
//		especialidades.add(new Especialidades("1300","CONTROLADOR DE TRANSITO AEREO"));
//		especialidades.add(new Especialidades("1310","CONTROLADOR DE TRANSITO AEREO"));
//		especialidades.add(new Especialidades("2680","ESPEC. S.S.E.I."));
//		especialidades.add(new Especialidades("2690","ESPEC. S.S.E.I."));
//		especialidades.add(new Especialidades("2700","ESPEC. S.S.E.I."));
//		especialidades.add(new Especialidades("2710","ESPEC. S.S.E.I."));
//		especialidades.add(new Especialidades("1970","INSTRUMENTISTA METEOROLOGICO"));
//		especialidades.add(new Especialidades("2260","METEOROLOGO"));
//		especialidades.add(new Especialidades("2300","OBSERVADOR MET."));
//		especialidades.add(new Especialidades("2310","OBSERVADOR MET."));
//		especialidades.add(new Especialidades("2320","OBSERVADOR MET."));
//		especialidades.add(new Especialidades("2330","OBSERVADOR MET."));
//		especialidades.add(new Especialidades("2340","OBSERVADOR MET."));
//		especialidades.add(new Especialidades("2440","OPERADOR SERVICIOS VUELO"));
//		especialidades.add(new Especialidades("1220","CHOFER"));
//		especialidades.add(new Especialidades("2880","TELECOMUNICADOR AERONAUTICO (AMS)"));
//		especialidades.add(new Especialidades("2890","TELECOMUNICADOR AERONAUTICO (O.AV)"));
//		especialidades.add(new Especialidades("2900","TELECOMUNICADOR AERONAUTICO (OPER)"));
//		especialidades.add(new Especialidades("2910","TELECOMUNICADOR AERONAUTICO (SUPE)"));
//		especialidades.add(new Especialidades("1420","ELECTRONICO"));
//		especialidades.add(new Especialidades("1430","ELECTRONICO AERONAUTICO"));
//		especialidades.add(new Especialidades("1720","INGENIERO CIVIL ELECTRONICO"));
//		especialidades.add(new Especialidades("1830","INGENIERO EJEC. ELECTRONICO"));
//		especialidades.add(new Especialidades("2850","TECNICO ELECTRONICO"));
//		especialidades.add(new Especialidades("2650","PROTECCION Y VIGILANCIA"));
//		especialidades.add(new Especialidades("1400","ELECTRICISTA AEROPORTUARIO"));
//		especialidades.add(new Especialidades("1120","AUXILIAR"));
//		especialidades.add(new Especialidades("1880","INGENIERO EJECUCION"));
//		especialidades.add(new Especialidades("1060","ADMINISTRATIVO"));
//		especialidades.add(new Especialidades("2860","TECNICO UNIVERSITARIO"));
//		especialidades.add(new Especialidades("2040","MANIPULADOR DE ALIMENTOS"));
//		especialidades.add(new Especialidades("2440","OPERADOR SERVICIOS VUELO"));
//		especialidades.add(new Especialidades("2830","TECNICO AERONAUTICO"));
//		especialidades.add(new Especialidades("1450","ESPEC. SEG. AEROPOR."));
//	}
//	

	
	private void inicializaEspecialidades() {
		especialidades = new ArrayList<Especialidades>();
		especialidades.add(new Especialidades("'TODAS'","0"));
		especialidades.add(new Especialidades("'CONTROLADOR DE TRANSITO AEREO'","1280"));
//		especialidades.add(new Especialidades("CONTROLADOR DE TRANSITO AEREO","1290"));
//		especialidades.add(new Especialidades("CONTROLADOR DE TRANSITO AEREO","1300"));
//		especialidades.add(new Especialidades("CONTROLADOR DE TRANSITO AEREO","1310"));
		especialidades.add(new Especialidades("'ESPEC. S.S.E.I.'","2680"));
//		especialidades.add(new Especialidades("ESPEC. S.S.E.I.","2690"));
//		especialidades.add(new Especialidades("ESPEC. S.S.E.I.","2700"));
//		especialidades.add(new Especialidades("ESPEC. S.S.E.I.","2710"));
		especialidades.add(new Especialidades("'ESPEC. SEG. AEROPOR.'","1450"));
		especialidades.add(new Especialidades("'INSTRUMENTISTA METEOROLOGICO'","1970"));
		especialidades.add(new Especialidades("'METEOROLOGO'","2260"));
		especialidades.add(new Especialidades("'OBSERVADOR MET.'","2300"));
//		especialidades.add(new Especialidades("'OBSERVADOR MET.'","2310"));
//		especialidades.add(new Especialidades("'OBSERVADOR MET.'","2320"));
//		especialidades.add(new Especialidades("'OBSERVADOR MET.'","2330"));
//		especialidades.add(new Especialidades("'OBSERVADOR MET.'","2340"));
		especialidades.add(new Especialidades("'OPERADOR SERVICIOS VUELO'","2440"));
		especialidades.add(new Especialidades("'CHOFER'","1220"));
		especialidades.add(new Especialidades("'TELECOMUNICADOR AERONAUTICO (AMS)'","2880"));
		especialidades.add(new Especialidades("'TELECOMUNICADOR AERONAUTICO (O.AV)'","2890"));
		especialidades.add(new Especialidades("'TELECOMUNICADOR AERONAUTICO (OPER)'","2900"));
		especialidades.add(new Especialidades("'TELECOMUNICADOR AERONAUTICO (SUPE)'","2910"));
		especialidades.add(new Especialidades("'ELECTRONICO'","1420"));
		especialidades.add(new Especialidades("'ELECTRONICO AERONAUTICO'","1430"));
		especialidades.add(new Especialidades("'INGENIERO CIVIL ELECTRONICO'","1720"));
		especialidades.add(new Especialidades("'INGENIERO EJEC. ELECTRONICO'","1830"));
		especialidades.add(new Especialidades("'TECNICO ELECTRONICO'","2850"));
		especialidades.add(new Especialidades("'PROTECCION Y VIGILANCIA'","2650"));
		especialidades.add(new Especialidades("'ELECTRICISTA AEROPORTUARIO'","1400"));
		especialidades.add(new Especialidades("'AUXILIAR'","1120"));
		especialidades.add(new Especialidades("'INGENIERO EJECUCION'","1880"));
		especialidades.add(new Especialidades("'ADMINISTRATIVO'","1060"));
		especialidades.add(new Especialidades("'TECNICO UNIVERSITARIO'","2860"));
		especialidades.add(new Especialidades("'MANIPULADOR DE ALIMENTOS'","2040"));
		especialidades.add(new Especialidades("'OPERADOR SERVICIOS VUELO'","2440"));
		especialidades.add(new Especialidades("'TECNICO AERONAUTICO'","2830"));
		
	}
	
	
	
	
	
	public void inicializaResum() {
		uniResum = new ArrayList<UnidadesResum>();
//		uniResum.add(new UnidadesResum("0", "Todas"));
//		uniResum.add(new UnidadesResum("1", "Zona Norte"));
//		uniResum.add(new UnidadesResum("2", "Zona Centro"));
//		uniResum.add(new UnidadesResum("3", "AMB"));
//		uniResum.add(new UnidadesResum("4", "DMC"));
//		uniResum.add(new UnidadesResum("5", "Logística"));
//		uniResum.add(new UnidadesResum("6", "DASA"));
//		uniResum.add(new UnidadesResum("7", "Zona Sur"));
//		uniResum.add(new UnidadesResum("8", "Zona Austral"));
		// uniResum.add(new UnidadesResum(9,"Otras"));
	}
	
	public void inicializaRemuVarResum() {
		remuResum = new ArrayList<RemuResum>();
		remuResum.add(new RemuResum("0", "TODAS"));
		remuResum.add(new RemuResum("1", "SUELDO"));
		remuResum.add(new RemuResum("2", "BENEFICIO DE MODERNIZACION"));
		remuResum.add(new RemuResum("3", "GRADO EFECTIVO"));
		remuResum.add(new RemuResum("4", "CRECIEMIENTO VEGETATIVO"));
		remuResum.add(new RemuResum("5", "HORAS EXTRAORDINARIAS"));
		remuResum.add(new RemuResum("6", "ESPECIALIDADES NOCIVAS PELIGROSAS"));
		remuResum.add(new RemuResum("7", "MAQUINA"));
		remuResum.add(new RemuResum("8", "BONOS"));
		remuResum.add(new RemuResum("9", "ISLA DE PASCUA"));
		remuResum.add(new RemuResum("10", "ZONA EXTREMA"));
		remuResum.add(new RemuResum("11", "ANTARTICA"));
		remuResum.add(new RemuResum("12", "HONORARIOS"));
		remuResum.add(new RemuResum("13", "HORAS PROFESOR (ETA)"));
		remuResum.add(new RemuResum("14", "MEDICOS"));
		
		// uniResum.add(new UnidadesResum(9,"Otras"));
	}
	public void inicializaUnidadesZonaNorte() {
//		unidadZonaNorte = new ArrayList<UnidadZonaNorte>();
//		unidadZonaNorte.add(new UnidadZonaNorte("11702000",
//				"AEROPUERTO GENERAL DIEGO ARACENA"));
//		unidadZonaNorte.add(new UnidadZonaNorte("11702000",
//				"IQUIQUE/ AP. DIEGO ARACENA"));
//		unidadZonaNorte.add(new UnidadZonaNorte("11703000",
//				"CALAMA/ AD. EL LOA"));
//		unidadZonaNorte
//				.add(new UnidadZonaNorte("11703000", "AERODROMO EL LOA"));
//		unidadZonaNorte.add(new UnidadZonaNorte("20005060",
//				"AEROPUERTO ANDRES SABELLA"));
//		unidadZonaNorte.add(new UnidadZonaNorte("11700000",
//				"SUBDEPARTAMENTO ZONA AEROPORTUARIA NORTE COMERCIAL"));
//		unidadZonaNorte.add(new UnidadZonaNorte("11700000",
//				"SUBDPTO. ZONA AEROPORTUARIA NORTE"));
//		unidadZonaNorte.add(new UnidadZonaNorte("11708000",
//				"ATACAMA/ AD. DESIERTO DE ATACAMA"));
//		unidadZonaNorte.add(new UnidadZonaNorte("11708000",
//				"AERODROMO DESIERTO DE ATACAMA"));

	}

	private void inicializaTipo() {
		avalaibleTipo = new ArrayList<Tipo>();
		avalaibleTipo.add(new Tipo(1, "Ejecución Presupuestaria"));
		//avalaibleTipo.add(new Tipo(2, "Presupuesto Aprobado Por Ley"));

	}

	private void inicializaAnos() {
		ano = new ArrayList<Integer>();
		int currYear = Calendar.getInstance().get(Calendar.YEAR);

		for (int i = 0; i < 2; i++) {
			ano.add(currYear - i);
		}
	}

	private void inicializaMes() {
		mesList = new ArrayList<Mes>();
		//mesList.add(new Mes(0, "Todos"));
		mesList.add(new Mes(1, "Enero"));
		mesList.add(new Mes(2, "Febrero"));
		mesList.add(new Mes(3, "Marzo"));
		mesList.add(new Mes(4, "Abril"));
		mesList.add(new Mes(5, "Mayo"));
		mesList.add(new Mes(6, "Junio"));
		mesList.add(new Mes(7, "Julio"));
		mesList.add(new Mes(8, "Agosto"));
		mesList.add(new Mes(9, "Septiembre"));
		mesList.add(new Mes(10, "Octubre"));
		mesList.add(new Mes(11, "Noviembre"));
		mesList.add(new Mes(12, "Diciembre"));
	}

//	public boolean mesesDisabled() {
//		boolean flag = false;
//		int fechaDia = Calendar.getInstance().get(Calendar.DATE);
//		int fechaMes = Calendar.getInstance().get(Calendar.MONTH);
//		int fechaAno = Calendar.getInstance().get(Calendar.YEAR);
//		int fechaCom = 0;
//
//		return flag;
//	}

	public void inicializaUnidadEjecutora() {
		unidadEjec = new ArrayList<UnidadEjecutora>();
		// unidadEjec.add(new UnidadEjecutora(0, "Todas"));
		unidadEjec.add(new UnidadEjecutora(178, "178 - Recursos Humanos"));
		unidadEjec.add(new UnidadEjecutora(179, "179 - Capacitación"));
		unidadEjec.add(new UnidadEjecutora(180, "180 - Beneficios Médicos"));
		unidadEjec.add(new UnidadEjecutora(183, "183 - ETA"));
		unidadEjec.add(new UnidadEjecutora(184, "184 - Subdepto.Personal"));
		unidadEjec.add(new UnidadEjecutora(185, "185 - Remuneraciones"));
		unidadEjec.add(new UnidadEjecutora(187, "187 - Prevención de Riesgos"));

	}

	public void function() {
		System.out.println("paso por metodo function");
		inicializaUnidadesZonaNorte();

	}

	public void inicializaUnidadesZona() {

		//System.out.println("carga unidades zona");
		

//		List<UnidadesZonas> unidadZonaNorte = new ArrayList<UnidadesZonas>();
//		unidadZonaNorte.add(new UnidadesZonas("11702000",
//				"AEROPUERTO GENERAL DIEGO ARACENA"));
//		
//		unidadZonaNorte.add(new UnidadesZonas("11703000", "AERODROMO EL LOA"));
//		unidadZonaNorte.add(new UnidadesZonas("20005060",
//				"AEROPUERTO ANDRES SABELLA"));
//		unidadZonaNorte.add(new UnidadesZonas("11700000",
//				"SUBDEPARTAMENTO ZONA AEROPORTUARIA NORTE COMERCIAL"));
//		unidadZonaNorte.add(new UnidadesZonas("11700000",
//				"SUBDPTO. ZONA AEROPORTUARIA NORTE"));
//		unidadZonaNorte.add(new UnidadesZonas("11708000",
//				"ATACAMA/ AD. DESIERTO DE ATACAMA"));
//		unidadZonaNorte.add(new UnidadesZonas("11708000",
//				"AERODROMO DESIERTO DE ATACAMA"));
//
//		List<UnidadesZonas> unidadZonaCentro = new ArrayList<UnidadesZonas>();
//		unidadZonaCentro.add(new UnidadesZonas("11802000",
//				"AERODROMO LA FLORIDA"));
//		unidadZonaCentro.add(new UnidadesZonas("11802000",
//				"LA SERENA/ AD. LA FLORIDA"));
//		unidadZonaCentro
//				.add(new UnidadesZonas("11803000", "AERODROMO MATAVERI"));
//		unidadZonaCentro.add(new UnidadesZonas("11803000",
//				"ISLA DE PASCUA/ AP. MATAVERI"));
//		unidadZonaCentro.add(new UnidadesZonas("11806000",
//				"VIÑA DEL MAR/ AD. VIÑA DEL MAR"));
//		unidadZonaCentro.add(new UnidadesZonas("11806000",
//				"AERODROMO VIÑA DEL MAR"));
//		unidadZonaCentro.add(new UnidadesZonas("11800000",
//				"SUBDPTO. ZONA AEROPORTUARIA CENTRAL"));
//		unidadZonaCentro.add(new UnidadesZonas("11800000",
//				"SUBDEPARTAMENTO ZONA AEROPORTTUARIA CENTRAL"));
//		unidadZonaCentro.add(new UnidadesZonas("11808000",
//				"SANTIAGO/ AD. EULOGIO SÁNCHEZ"));
//		unidadZonaCentro.add(new UnidadesZonas("11808000",
//				"AERODROMO EULOGIO SANCHEZ"));
//		unidadZonaCentro.add(new UnidadesZonas("11813000",
//				"CONCEPCIÓN/ AD. CARRIEL SUR"));
//		unidadZonaCentro.add(new UnidadesZonas("11813000",
//				"AERODROMO CARRIEL SUR"));
//		unidadZonaCentro.add(new UnidadesZonas("20005057",
//				"AERODROMO ROBINSON CRUSOE"));

	

//		List<UnidadesZonas> unidadDmc = new ArrayList<UnidadesZonas>();
//		unidadDmc.add(new UnidadesZonas("10700000",
//				"DEPARTAMENTO METEOROLOGICA DE CHILE"));
//		unidadDmc.add(new UnidadesZonas("10701100",
//				"SECCION METEOROLOGIA AERONAUTICA METEO CHILE"));
//		unidadDmc.add(new UnidadesZonas("10701200",
//				"SECCION INSTALACIONES METEOROLOGICA METEO CHILE"));
//		unidadDmc.add(new UnidadesZonas("10701300",
//				"SECCION CENTRO NACIONAL DE ANALISIS METEO CHILE"));
//		unidadDmc.add(new UnidadesZonas("10702100",
//				"SECCION CLIMATOLOGIA METEO CHILE"));
//
//		List<UnidadesZonas> unidadAmb = new ArrayList<UnidadesZonas>();
//		unidadAmb.add(new UnidadesZonas("11001000",
//				"AEROPUERTO ARTURO MERINO BENITEZ"));
//		unidadAmb.add(new UnidadesZonas("11001095",
//				"SECCION PLANIFICACION Y CONTROL, LOGISTICA AMB"));
//		unidadAmb.add(new UnidadesZonas("11001110",
//				"SECCION SERVICIOS AERONAUTICOS AMB"));
//		unidadAmb.add(new UnidadesZonas("11001120", "SECCION SSEI AMB"));
//		unidadAmb.add(new UnidadesZonas("11001200",
//				"SECCION SEGURIDAD DE AVIACION AMB"));
//		unidadAmb.add(new UnidadesZonas("11001210", "SECCION AVSEC AMB"));
//		unidadAmb.add(new UnidadesZonas("11001410", "OFICINA LOGISTICA AMB"));
//		unidadAmb.add(new UnidadesZonas("11001700",
//				"SECCION PLANIFICACION Y CONTROL AMB"));
//		unidadAmb.add(new UnidadesZonas("11002200", "SECCION SSEI AMB"));
//		unidadAmb.add(new UnidadesZonas("11002300",
//				"SECCION SEGURIDAD DE AVIACION AMB"));
//		unidadAmb.add(new UnidadesZonas("11003100",
//				"SECCION SERVICIOS TRANSITO AEREO AMB"));
//		unidadAmb.add(new UnidadesZonas("11001130", "SECCION MOVIMIENTOS AMB"));
//		unidadAmb.add(new UnidadesZonas("11001920", "SECCION OPERACIONES AMB"));
//
//		List<UnidadesZonas> unidadLogistica = new ArrayList<UnidadesZonas>();
//		unidadLogistica.add(new UnidadesZonas("10801400",
//				"SECCION SERVICIOS GENERALES LOGISTICA"));
//		unidadLogistica.add(new UnidadesZonas("10801000",
//				"SUBDEPARTAMENTO SOPORTE LOGISTICO LOGISTICA"));
//		unidadLogistica.add(new UnidadesZonas("10801100",
//				"SECCION ADQUISICIONES LOGISTICA"));
//		unidadLogistica.add(new UnidadesZonas("10801200",
//				"SECCION ABASTECIMIENTO LOGISTICA"));
//		unidadLogistica.add(new UnidadesZonas("10801300",
//				"SECCION INFRAESTRUCTURA LOGISTICA"));
//		unidadLogistica.add(new UnidadesZonas("10801500",
//				"SECCION TRANSPORTE TERRESTRE Y SISTEMAS RODANTES LOGISTICA"));
//
//		unidadLogistica.add(new UnidadesZonas("10801200",
//				"SECCION ABASTECIMIENTO LOGISTICA"));
//		unidadLogistica.add(new UnidadesZonas("10801300",
//				"SECCION INFRAESTRUCTURA LOGISTICA"));
//		unidadLogistica.add(new UnidadesZonas("10801500",
//				"SECCION TRANSPORTE TERRESTRE Y SISTEMAS RODANTES LOGISTICA"));
//
//		List<UnidadesZonas> unidadDasa = new ArrayList<UnidadesZonas>();
//		unidadDasa.add(new UnidadesZonas("11000000", "SANTIAGO/ DASA"));
//		unidadDasa.add(new UnidadesZonas("11000000",
//				"DEPARTAMENTO AERODROMOS Y SERVICIOS AERONAUTICOS"));
//		unidadDasa.add(new UnidadesZonas("11000110",
//				"SUBDEPARTAMENTO SERVICIOS DE TRANSITO AEREO DASA"));
//		unidadDasa.add(new UnidadesZonas("11000130",
//				"SECCION SERVICIOS TELECOMUNICACION AERONATICA DASA"));
//		unidadDasa.add(new UnidadesZonas("11000140",
//				"SECCION SERV. TELEC. AERO.CCAM DASA"));
//		unidadDasa.add(new UnidadesZonas("11000190", "SECCION AIS-MAP DASA"));
//		unidadDasa.add(new UnidadesZonas("11000600",
//				"SECCION CENTRO DE CONTROL UNIFICADO DASA"));
//		unidadDasa
//				.add(new UnidadesZonas("11000605",
//						"SECC. CENTRO DE CONTROL UNIF. DASA OF. NOTAM INTER Y CCAM/AMHS"));
//		unidadDasa.add(new UnidadesZonas("11000610",
//				"OFICINA CENTRO DE CONTROL AEREA OCEANICO DASA"));
//		unidadDasa.add(new UnidadesZonas("11000100",
//				"SUBDEPARTAMENTO PLANIFICACION Y CONTROL DASA"));
//		unidadDasa.add(new UnidadesZonas("11000860", "SECCION AVSEC DASA"));
//		unidadDasa.add(new UnidadesZonas("11000800",
//				"SUBDEPARTAMENTO SERVICIOS DE AERODROMOS DASA"));
//
//		List<UnidadesZonas> unidadZonaSur = new ArrayList<UnidadesZonas>();
//		unidadZonaSur.add(new UnidadesZonas("11001000", "SANTIAGO/ AMB"));
//		unidadZonaSur.add(new UnidadesZonas("11900000",
//				"SECCION ZONA AEROPORTUARIA SUR"));
//		unidadZonaSur.add(new UnidadesZonas("11900000",
//				"SUBDPTO. ZONA AEROPORTUARIA SUR"));
//		unidadZonaSur.add(new UnidadesZonas("20005027",
//				"AERODROMO LA ARAUCANIA"));
//		unidadZonaSur.add(new UnidadesZonas("20005027",
//				"TEMUCO/ AD. LA ARAUCANÍA"));
//		unidadZonaSur.add(new UnidadesZonas("11902000", "AERODROMO PICHOY"));
//		unidadZonaSur
//				.add(new UnidadesZonas("11902000", "VALDIVIA/ AD. PICHOY"));
//		unidadZonaSur.add(new UnidadesZonas("11903000",
//				"OSORNO/ AD. CAÑAL BAJO"));
//		unidadZonaSur
//				.add(new UnidadesZonas("11903000", "AERODROMO CAÑAL BAJO"));
//		unidadZonaSur.add(new UnidadesZonas("11904000",
//				"PTO. MONTT / AP. EL TEPUAL"));
//		unidadZonaSur
//				.add(new UnidadesZonas("11904000", "AEROPUERTO EL TEPUAL"));
//		unidadZonaSur.add(new UnidadesZonas("11913000",
//				"BALMACEDA/ AD. BALMACEDA"));
//		unidadZonaSur.add(new UnidadesZonas("11913000", "AERODROMO BALMACEDA"));
//
//
//		List<UnidadesZonas> unidadZonaAustral = new ArrayList<UnidadesZonas>();
//		unidadZonaAustral.add(new UnidadesZonas("12000000",
//				"SUBDPTO. ZONA AEROPORTUARIA AUSTRAL"));
//		unidadZonaAustral.add(new UnidadesZonas("12000000",
//				"SECCION ZONA AEROPORTUARIA AUSTRAL"));
//		unidadZonaAustral.add(new UnidadesZonas("12001000",
//				"AEROPUERTO CARLOS IBAÑEZ DEL CAMPO"));
//		unidadZonaAustral.add(new UnidadesZonas("12001000",
//				"PTA. ARENAS/ AP. CARLOS IBAÑEZ DEL CAMPO"));
//
//		List<UnidadesZonas> unidadOtros = new ArrayList<UnidadesZonas>();
//		unidadOtros.add(new UnidadesZonas("10904300",
//				"OFICINA BIENESTAR B. SOCIAL"));
//		unidadOtros.add(new UnidadesZonas("10902200", "OFICINA DOCENTE ETA"));
//
//		unidadZona = new ArrayList<UnidadesZonas>();
//		unidadZona.addAll(unidadZonaNorte);
//		unidadZona.addAll(unidadZonaCentro);
//		unidadZona.addAll(unidadDmc);
//		unidadZona.addAll(unidadAmb);
//		unidadZona.addAll(unidadLogistica);
//		unidadZona.addAll(unidadDasa);
//		unidadZona.addAll(unidadZonaSur);
//		unidadZona.addAll(unidadZonaAustral);
//
//
//		System.out.println("uidades zona tiene: " + unidadZona.size());

	}

	private void inicializaAsignacion() {
		asignacion = new ArrayList<Asignacion>();

		asignacion.add(new Asignacion("1", "Horas Extras"));
		asignacion.add(new Asignacion("2", "Viáticos"));
		asignacion.add(new Asignacion("3", "Honorarios"));
		asignacion.add(new Asignacion("4", "Remuneraciones"));
		asignacion.add(new Asignacion("5", "Asignación Traslado"));
	}

	private void inicializaItems() {
		item = new ArrayList<Item>();
		item.add(new Item(1, "Remuneración Variable"));
		item.add(new Item(2, "Otras Remuneraciones"));
		item.add(new Item(3, "Otros Gastos En Personal"));
	}

	private void inicializaSubs() {
		availableSubtitulo = new ArrayList<Subt>();
		availableSubtitulo.add(new Subt(21, "Subtítulo 21"));
		// availableSubtitulo.add(new Subt(22, "Subtítulo 22"));
		// availableSubtitulo.add(new Subt(23, "Subtítulo 23"));
	}
	// DESHABILITAR ASIGNACIONES
	public boolean asignacionDisabled(String asignacion) {
		if (selectedValues.getAsignacion() == null) {
			return true;
		}
		List<String> itemHabilita = getItemHabilitador(asignacion);

		for (String match : selectedValues.getItem()) {
			if (itemHabilita.contains(match)) {
				return false;
			}
		}
		return true;
	}

	private List<String> getItemHabilitador(String asignacion) {
		List<String> listaItems = new ArrayList<String>();
		if ("Horas Extras".equals(asignacion)) {
			listaItems.add("1");//AGREGA CODIGO DE LOS ITEMS
			//listaItems.add("2");
			//else if ("Viáticos".equals(asignacion)) {
		//	listaItems.add("1");//AGREGA CODIGO DE LOS ITEMS
	} else if ("Honorarios".equals(asignacion)) {
			listaItems.add("2");//AGREGA CODIGO DE LOS ITEMS
		} else if ("Remuneraciones".equals(asignacion)) {
			listaItems.add("2");//AGREGA CODIGO DE LOS ITEMS
		} 
//		else if ("Asignación Traslado".equals(asignacion)) {
//			listaItems.add("3");//AGREGA CODIGO DE LOS ITEMS
//		} 
		return listaItems;
	}

	public boolean remuDisabled(String remuneracion) {
		if (selectedValues.getremuVar() == null) {//CAMBIAR A REMURESUM IR PROBANDO
			return true;
		}
		List<String> asigHabilita = getAsigHabilitadorRemu(remuneracion);

		for (String match : selectedValues.getItem()) {
			if (asigHabilita.contains(match)) {
				return false;
			}
		}
		return true;
	}

	private List<String> getAsigHabilitadorRemu(String asignacion) {
		List<String> listaItems = new ArrayList<String>();
		if ("Remuneraciones".equals(asignacion)) {
			listaItems.add("2");//AGREGA CODIGO DE LOS ITEMS
		} 
		return listaItems;
	}
	
	// CAMBIAR A ASIGNACION EN VEZ DE ITEM HABILITA TODOS....
	public boolean asignacionDisabled2(String asignacion) {
		if (selectedValues.getAsignacion() == null) {
			return true;
		}
		List<String> asigHabilita = getAsigHabilitador2(asignacion);

		for (String match : selectedValues.getAsignacion()) {
			if (asigHabilita.contains(match)) {
				return false;
			}
		}
		return true;
	}

	private List<String> getAsigHabilitador2(String asignacion) {
		List<String> listaAsig = new ArrayList<String>();
		if ("Horas Extras".equals(asignacion) ) {
			listaAsig.add("1");//AGREGA CODIGO DE LOS ITEMS
		} else if ("Viáticos".equals(asignacion)) {
			listaAsig.add("2");//AGREGA CODIGO DE LOS ITEMS
				} 
		return listaAsig;
	}
	
	
	
//	public void asignacionAmbas(String asignacion) {
//		List<String> listaItems = new ArrayList<String>();
//		if ("Horas Extras".equals(asignacion)
//				&& ("Viáticos".equals(asignacion))) {
//					listaItems.add("1");
//			  FacesContext context = FacesContext.getCurrentInstance();
//		        context.addMessage(null, new FacesMessage("Correcto",  "Mensaje : " + mensajeError));
//		        context.addMessage(null, new FacesMessage("Mensaje extra", "Mensaje extra def"));
//		}
//	}

	public void mensajeAmbasAsig() {
		String mens = selecNoSelec ? "Ingrese solo una asignacion"
				: "ingreso ok";
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(mens));
	}

	public boolean unidadEjDisabled(String unidadEjec) {
		if (selectedValues.getUnidadEjec() == null) {
			return true;
		}
		List<String> asigHabilita = getAsigHabilitador(unidadEjec);

		for (String match : selectedValues.getAsignacion()) {
			if (asigHabilita.contains(match)) {
				return false;
			}
		}
		return true;
	}
	//HABILITA SOLO UNIDAD EJECUTORA AL PRESIONAR LA ASIGNACION HORAS EXTRAS
	private List<String> getAsigHabilitador(String unidadEjec) {
		List<String> listaAsig = new ArrayList<String>();
		if (CODIGO_REMUNERACION.equals(unidadEjec)) {
			listaAsig.add("1");//HORAS EXTRAS
			//listaAsig.add("3");//HONORARIOS
		}
		return listaAsig;
	}

	public List<Subt> getAvailableSubtitulo() {
		return availableSubtitulo;
	}

	public void setAvailableSubtitulo(List<Subt> availableSubtitulo) {
		this.availableSubtitulo = availableSubtitulo;
	}

	public Filtro getSelectedValues() {
		return selectedValues;
	}

	public void setSelectedValues(Filtro selectedValues) {
		this.selectedValues = selectedValues;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public List<Asignacion> getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(List<Asignacion> asignacion) {
		this.asignacion = asignacion;
	}

	public List<UnidadesZonas> getUnidadZona() {
		return unidadZona;
	}

	public void setUnidadZona(List<UnidadesZonas> unidadZona) {
		this.unidadZona = unidadZona;
	}

	public List<UnidadEjecutora> getUnidadEjec() {
		return unidadEjec;
	}

	public void setUnidadEjec(List<UnidadEjecutora> unidadEjec) {
		this.unidadEjec = unidadEjec;
	}

	public List<Integer> getAno() {
		return ano;
	}

	public void setAno(List<Integer> ano) {
		this.ano = ano;
	}

	public List<Mes> getMesList() {
		return mesList;
	}

	public void setMes(List<Mes> mesList) {
		this.mesList = mesList;
	}

	public List<UnidadZonaNorte> getUnidadZonaNorte() {
		return unidadZonaNorte;
	}

	public void setUnidadZonaNorte(List<UnidadZonaNorte> unidadZonaNorte) {
		this.unidadZonaNorte = unidadZonaNorte;
	}

	public List<UnidadesZonas> getUnidadZonaCentro() {
		return unidadZonaCentro;
	}

	public void setUnidadZonaCentro(List<UnidadesZonas> unidadZonaCentro) {
		this.unidadZonaCentro = unidadZonaCentro;
	}

	public List<UnidadesZonas> getUnidadDmc() {
		return unidadDmc;
	}

	public void setUnidadDmc(List<UnidadesZonas> unidadDmc) {
		this.unidadDmc = unidadDmc;
	}

	public List<UnidadesZonas> getUnidadAmb() {
		return unidadAmb;
	}

	public void setUnidadAmb(List<UnidadesZonas> unidadAmb) {
		this.unidadAmb = unidadAmb;
	}

	public List<UnidadesZonas> getUnidadLogistica() {
		return unidadLogistica;
	}

	public void setUnidadLogistica(List<UnidadesZonas> unidadLogistica) {
		this.unidadLogistica = unidadLogistica;
	}

	public List<UnidadesZonas> getUnidadDasa() {
		return unidadDasa;
	}

	public void setUnidadDasa(List<UnidadesZonas> unidadDasa) {
		this.unidadDasa = unidadDasa;
	}

	public List<UnidadesZonas> getUnidadZonaSur() {
		return unidadZonaSur;
	}

	public void setUnidadZonaSur(List<UnidadesZonas> unidadZonaSur) {
		this.unidadZonaSur = unidadZonaSur;
	}

	public List<UnidadesZonas> getUnidadZonaAustral() {
		return unidadZonaAustral;
	}

	public void setUnidadZonaAustral(List<UnidadesZonas> unidadZonaAustral) {
		this.unidadZonaAustral = unidadZonaAustral;
	}

	public List<UnidadesZonas> getUnidadOtras() {
		return unidadOtras;
	}

	public void setUnidadOtras(List<UnidadesZonas> unidadOtras) {
		this.unidadOtras = unidadOtras;
	}

	public StreamedContent getFile() {
		
	  try {
			byte[] reportPdf = GenRepJasper.getReporte(selectedValues);
			InputStream fis = new ByteArrayInputStream(reportPdf);
		return new DefaultStreamedContent(fis,
					"application/pdf; charset=UTF-8", "INFORME - xxx.pdf");
		} catch (Exception e) {
			System.out.println("error no logro construirse el reporte(presupuesto inicial vacio)");
		}
		return null;
	}

	public StreamedContent getFile2() {
		try {
			byte[] reportXls = GenRepJasper.getReporteXLS(selectedValues);
			InputStream fis = new ByteArrayInputStream(reportXls);
			return new DefaultStreamedContent(fis,
					"application/xls; charset=UTF-8", "INFORME - xxx.xls");
		} catch (Exception e) {
			System.out.println("error no logro construirse el reporte(presupuesto inicial vacio)");
		}
		return null;
	}

//	public void cargaZonasPorAsignacion() { // METODO NUEVO PARA EJECUTAR AJAX DE ACTIVACION 
//		setUniResum(new ArrayList<UnidadesResum>());
//		AsignacionService service = BusinessFactory.getInstance().getAsignacionService();
//		for (String codAsig : selectedValues.getAsignacion()) {
//			if(codAsig.contains("1")){
//				getUniResum().addAll(service.getZonaResumPorAsig(codAsig));
//			}	else if(selectedValues.getAsignacion().size()==0){
//				getUniResum().clear();
//			}
////			else if(!codAsig.contains("1")){
////				getUniResum().clear();
////			}
//			}
//		System.out.println("entro y salio del metodo : cargaZonasPorAsignacion()");
//	}
	
	public void cargaZonasPorAsignacion() { // METODO NUEVO PARA EJECUTAR AJAX DE ACTIVACION 
		setUniResum(new ArrayList<UnidadesResum>());
		AsignacionService service = BusinessFactory.getInstance().getAsignacionService();
		for (String codAsig : selectedValues.getAsignacion()) {
			
			getUniResum().addAll(service.getZonaResumPorAsig(codAsig));
			}
			System.out.println("entro y salio del metodo xzasdasdasdaassad : cargaZonasPorAsignacion()");
				
			}
	public void cargaZonasPorAsignacionxx(AjaxBehaviorEvent event) {
	  // cargaZonasPorAsignacion();
		setUniResum(new ArrayList<UnidadesResum>());
		AsignacionService service = BusinessFactory.getInstance().getAsignacionService();
		for (String codAsig : selectedValues.getAsignacion()) {
			
			getUniResum().addAll(service.getZonaResumPorAsig(codAsig));
			}
			System.out.println("entro y salio del metodo : cargaZonasPorAsignacion()");
				
	}
	

	public void cargaUnidadesPorZona() {
		setUnidadZona(new ArrayList<UnidadesZonas>());
		ZonaService service = BusinessFactory.getInstance().getZonaService();
		for (String codZona : selectedValues.getuniResum()) {
			getUnidadZona().addAll(service.getUnidadesPorZona(codZona));
		}
	}

	public void cargaEspecialidadesPorZona() {

		setEspecialidades(new ArrayList<Especialidades>());
		ZonaService service = BusinessFactory.getInstance().getZonaService();

		for (String codZona : selectedValues.getuniResum()) {
			getUnidadZona().addAll(service.getUnidadesPorZona(codZona));
		}
	}

	public void cargaRemuPorVariable() {
		setRemuVar(new ArrayList<RemuVariables>());
		RemuService service = BusinessFactory.getInstance().getRemuService();
		for (String codRemu : selectedValues.getRemuResum()) {
			getRemuVar().addAll(service.getVariablesRemuPorCod(codRemu));
		}
	}

	
	public boolean isHorasExtraSelected() {
   		if (selectedValues != null && selectedValues.getAsignacion() != null) {
			for (String asig : selectedValues.getAsignacion()) {
				if ("1".equals(asig)) {// CODIGO DE HORAS EXTRAS QUE LLENA LAS
										// ZONAS RESUMIDAS
					return true;
				}
			}
		}

		if (getUnidadZona() != null) {
			getUnidadZona().clear();
		}
		return false;
	}

	public boolean isZonasSelected() {
		if (selectedValues != null && selectedValues.getuniResum() != null) {
			for (String zonas : selectedValues.getuniResum()) {
				if ("0".equals(zonas) || ("1".equals(zonas))
						|| ("2".equals(zonas)) || ("3".equals(zonas))
						|| ("4".equals(zonas)) || ("5".equals(zonas))
						|| ("6".equals(zonas)) || ("7".equals(zonas))
						|| ("8".equals(zonas))) {// CODIGO DE ZONAS RESUMIDAS
					return true;
				}
				else if ("0".equals(zonas) && ("1".equals(zonas))
						&& ("2".equals(zonas)) && ("3".equals(zonas))
						&& ("4".equals(zonas)) && ("5".equals(zonas))
						&& ("6".equals(zonas)) && ("7".equals(zonas))
						&& ("8".equals(zonas))) {// CODIGO DE ZONAS RESUMIDAS
					return true;
				}
			}
		}
		if (getUnidadZona() != null) {
			getUnidadZona().clear();
		}
		return false;
	}

	/*
	 * Metodo Calendar.getInstance().get(Calendar.MONTH) entrega mes en basse 0,
	 * se agrega 1 para coincidir con base de datos local
	 */
	public int getCurrentMonth() {
		int mesActual = Calendar.getInstance().get(Calendar.MONTH);
		return mesActual;
	}

	public int getCurrentYear() {
		int currYear = Calendar.getInstance().get(Calendar.YEAR);
		return currYear;
	}

//	public void addMessage() {
//		String mens = selecNoSelec ? "Todo seleccionado" : "Nada seleccionado";
//		FacesContext.getCurrentInstance().addMessage(null,
//				new FacesMessage(mens));
//	}

//	public void selectAllMeses() {
//		System.out.println("llego...");
//		
//		if (selectedValues.getMes().contains("0") && selectedValues.getMes().size()<13){
//			if ((mesList.size() - 1) == selectedValues.getMes().size()) {
//				
//				for (Mes mes : mesList) {
//					selectedValues.getMes().add(mes.getCodMes(),mes.getDescMes());
//				}
//			}
//		}else if(!selectedValues.getMes().contains("0") && selectedValues.getMes().size()==12){
//			selectedValues.setMes(new ArrayList<String>());
//			return;
//		}
//	}
//	public void grabarMensajeError(String asignacion) {
//				if ("Horas Extras".equals(asignacion)
//				&& ("Viáticos".equals(asignacion))) {
//				 FacesContext context = FacesContext.getCurrentInstance();
//				        context.addMessage(null, new FacesMessage("Selección incorrecta",  "Marque solo una opción : " + mensajeError));
//		}
//    }
	
	public void selectAllMeses2(){
				if (mesList.size() == selectedValues.getMes().size()) {
				selectedValues.setMes(new ArrayList<String>());
				return;
			}
			if (selectedValues.getMes().contains("0")){
			for (Mes mes : mesList) {
				selectedValues.getMes().add(mes.getCodMes() + "");
			}
			}
		}	
	
	public void selectAllZonas(){
		if (uniResum.size()-1== selectedValues.getuniResum().size()&&(!selectedValues.getuniResum().contains("0"))) {
		selectedValues.setuniResum(new ArrayList<String>());
		return;
	}
	if (selectedValues.getuniResum().contains("0")){
	for (UnidadesResum uResum : uniResum) {
		selectedValues.getuniResum().add(uResum.getCodUniResum() + "");
		}
	}
}	

	public void selectAllUnidades(){    
		if (unidadZona.size()-1 == selectedValues.getUnidadZona().size()&&(!selectedValues.getUnidadZona().contains("0"))){
			selectedValues.setUnidadZona(new ArrayList<String>());//LIMPIA LA LISTA DE UNIDADES
			return;
		}
		if (selectedValues.getUnidadZona().contains("0")){//AGREGA TODOS LOS ELEM DE LA LISTA
		for (UnidadesZonas uniTodas : unidadZona) {
			selectedValues.getUnidadZona().add(uniTodas.getCodigoUni() + "");//
//			if(selectedValues.getUnidadZona().equals("0")){
//				selectedValues.getUnidadZona().removeAll(unidadZona);
//			}
		//	System.out.println("contenido del array :"+selectedValues.getUnidadZona());
			}
		
		}
	}
		
		public void selectAllEspecialidades(){
		if (especialidades.size()-1 == selectedValues.getEspecialidades().size()&&(!selectedValues.getEspecialidades().contains("'TODAS'"))) {
			selectedValues.setEspecialidades(new ArrayList<String>());
			return;
		}
		if (selectedValues.getEspecialidades().contains("'TODAS'")){
		for (Especialidades espe : especialidades) {
			selectedValues.getEspecialidades().add(espe.getDescEspecialidades() + "");
			}
		}
}	
	

	
//	public void selectAllUnidades(){    
//	if (unidadTodas.size() -1 == selectedValues.getUnidadTodas().size()){
//		selectedValues.setUnidadTodas(new ArrayList<String>());
//		return;
//	}
//	if (selectedValues.getUnidadTodas().contains("0")){
//	for (UnidadesZonas uniTodas : unidadTodas) {
//		selectedValues.getUnidadTodas().add(uniTodas.getCodigoUni() + "");
//		}
//	}
//}	
	 
	public void verificarEnvio() {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Correcto");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void onToggle(ToggleEvent e) {
        list.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
    }
	
	
	public void largoArregloMes(){
		//Mes mes;
		System.out.println("largo de arreglo mes:"+selectedValues.getMes().size());
	}
	
}
