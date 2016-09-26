package org.dgac.app.web.bean;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.dgac.app.web.util.GenRepJasper;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

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
	private List<SelectItem> unidadZonaSI;
    private List<UnidadEjecutora>unidadEjec;
	//private List<String> unidadEjec;
	private List<Integer> ano;
	private List<Mes> mesList;
	private List<Tipo>avalaibleTipo;
	private List<UnidadZonaNorte> unidadZonaNorte;
	private List<UnidadesZonas> unidadZonaCentro;
	private List<UnidadesZonas> unidadDmc;
	private List<UnidadesZonas> unidadAmb;
	private List<UnidadesZonas> unidadLogistica;
	private List<UnidadesZonas> unidadDasa;
	private List<UnidadesZonas> unidadZonaSur;
	private List<UnidadesZonas> unidadZonaAustral;
	private List<UnidadesZonas> unidadOtras;
	private List<UnidadesResum>uniResum;
	private boolean selecNoSelec;


	
	
	
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
		inicializaResum();
		//inicializaUnidadesZona();
		inicializaUnidadEjecutora();
		inicializaMes();
		inicializaAnos();
		inicializaTipo();
		//inicializaUnidadesZonaNorte();
		
		
	}
	

	public void inicializaResum() {
			
		uniResum= new ArrayList<UnidadesResum>();
		uniResum.add(new UnidadesResum(1,"Zona Norte"));
		uniResum.add(new UnidadesResum(2,"Zona Centro"));
		uniResum.add(new UnidadesResum(3,"AMB"));
		uniResum.add(new UnidadesResum(4,"DMC"));
		uniResum.add(new UnidadesResum(5,"Logística"));
		uniResum.add(new UnidadesResum(6,"DASA"));
		uniResum.add(new UnidadesResum(7,"Zona Sur"));
		uniResum.add(new UnidadesResum(8,"Zona Austral"));
		//uniResum.add(new UnidadesResum(9,"Otras"));
					
	}
	
	

	public void inicializaUnidadesZonaNorte() {
		    unidadZonaNorte = new ArrayList<UnidadZonaNorte>();
	        unidadZonaNorte.add(new UnidadZonaNorte("11702000","AEROPUERTO GENERAL DIEGO ARACENA"));
	  		unidadZonaNorte.add(new UnidadZonaNorte("11702000","IQUIQUE/ AP. DIEGO ARACENA"));
	  		unidadZonaNorte.add(new UnidadZonaNorte("11703000","CALAMA/ AD. EL LOA"));
	  		unidadZonaNorte.add(new UnidadZonaNorte("11703000","AERODROMO EL LOA"));
	  		unidadZonaNorte.add(new UnidadZonaNorte("20005060","AEROPUERTO ANDRES SABELLA"));
	  		unidadZonaNorte.add(new UnidadZonaNorte("11700000","SUBDEPARTAMENTO ZONA AEROPORTUARIA NORTE COMERCIAL"));
	  		unidadZonaNorte.add(new UnidadZonaNorte("11700000","SUBDPTO. ZONA AEROPORTUARIA NORTE"));
	  		unidadZonaNorte.add(new UnidadZonaNorte("11708000","ATACAMA/ AD. DESIERTO DE ATACAMA"));
	  		unidadZonaNorte.add(new UnidadZonaNorte("11708000","AERODROMO DESIERTO DE ATACAMA"));
				
	}

	private void inicializaTipo() {
		avalaibleTipo= new ArrayList<Tipo>();
		avalaibleTipo.add(new Tipo(1, "Ejecución Presupuestaria"));
		avalaibleTipo.add(new Tipo(2, "Presupuesto Aprobado Por Ley"));
		
		
	}

	private void inicializaAnos() {
		ano = new ArrayList<Integer>();
		int currYear = Calendar.getInstance().get(Calendar.YEAR);
		
		for(int i=0; i<2; i++){
			ano.add(currYear-i);
		}
	}

	private void inicializaMes() {
	  mesList = new ArrayList<Mes>();
		  mesList.add(new Mes(1,"Enero" ));
	  	  mesList.add(new Mes(2,"Febrero"));
	  	  mesList.add(new Mes(3,"Marzo"));
	  	  mesList.add(new Mes(4,"Abril"));
	  	  mesList.add(new Mes(5,"Mayo"));
	  	  mesList.add(new Mes(6,"Junio"));
	  	  mesList.add(new Mes(7,"Julio"));
	  	  mesList.add(new Mes(8,"Agosto"));
	  	  mesList.add(new Mes(9,"Septiembre"));
	  	  mesList.add(new Mes(10,"Octubre"));
	  	  mesList.add(new Mes(11,"Noviembre"));
	  	  mesList.add(new Mes(12,"Diciembre"));
	}
	public boolean mesesDisabled(){
		boolean flag=false;
		int fechaDia= Calendar.getInstance().get(Calendar.DATE);
		int fechaMes= Calendar.getInstance().get(Calendar.MONTH);
		int fechaAno= Calendar.getInstance().get(Calendar.YEAR);
		int fechaCom=0;
				
		return flag;
	}

	public void inicializaUnidadEjecutora() {
		unidadEjec= new ArrayList<UnidadEjecutora>();
		unidadEjec.add(new UnidadEjecutora(178, "178 - Recursos Humanos"));
		unidadEjec.add(new UnidadEjecutora(179, "179 - Capacitación"));
		unidadEjec.add(new UnidadEjecutora(180, "180 - Beneficios Médicos"));
		unidadEjec.add(new UnidadEjecutora(183, "183 - ETA"));
		unidadEjec.add(new UnidadEjecutora(184, "184 - Subdepto.Personal"));
		unidadEjec.add(new UnidadEjecutora(185, "185 - Remuneraciones"));
		unidadEjec.add(new UnidadEjecutora(187, "187 - Prevención de Riesgos"));
		
	}
	
	public void function(){
	    System.out.println("paso por metodo function");
	    inicializaUnidadesZonaNorte();
	    
	}

	public void inicializaUnidadesZona() {

	    System.out.println("carga unidades zona");
//		unidadZonaSI = new ArrayList<SelectItem>();
//        SelectItemGroup groupNorte = new SelectItemGroup("ZONA NORTE");
//        SelectItemGroup groupCentro = new SelectItemGroup("ZONA CENTRO");
//        SelectItemGroup groupSur = new SelectItemGroup("ZONA SUR");
//        SelectItemGroup groupAustral = new SelectItemGroup("ZONA AUSTRAL");
       
//  		SelectItem[] uzNorte = new SelectItem[unidadZonaNorte.size()];
//  		for(int i=0; i< unidadZonaNorte.size();i++){
//  			uzNorte[i] = new SelectItem(unidadZonaNorte.get(i).getCodigoUni(), unidadZonaNorte.get(i).getUniDes());
//  		}
//
//  		groupNorte.setSelectItems(uzNorte);
		
		 List<UnidadesZonas> unidadZonaNorte = new ArrayList<UnidadesZonas>();
	        unidadZonaNorte.add(new UnidadesZonas("11702000","AEROPUERTO GENERAL DIEGO ARACENA"));
	  		//unidadZonaNorte.add(new UnidadesZonas("11702000","IQUIQUE/ AP. DIEGO ARACENA"));
	  		//unidadZonaNorte.add(new UnidadesZonas("11703000","CALAMA/ AD. EL LOA"));
	  		unidadZonaNorte.add(new UnidadesZonas("11703000","AERODROMO EL LOA"));
	  		unidadZonaNorte.add(new UnidadesZonas("20005060","AEROPUERTO ANDRES SABELLA"));
	  		unidadZonaNorte.add(new UnidadesZonas("11700000","SUBDEPARTAMENTO ZONA AEROPORTUARIA NORTE COMERCIAL"));
	  		unidadZonaNorte.add(new UnidadesZonas("11700000","SUBDPTO. ZONA AEROPORTUARIA NORTE"));
	  		unidadZonaNorte.add(new UnidadesZonas("11708000","ATACAMA/ AD. DESIERTO DE ATACAMA"));
	  		unidadZonaNorte.add(new UnidadesZonas("11708000","AERODROMO DESIERTO DE ATACAMA"));
		 
		
		
  		
  		List<UnidadesZonas> unidadZonaCentro = new ArrayList<UnidadesZonas>();
  		unidadZonaCentro.add(new UnidadesZonas("11802000","AERODROMO LA FLORIDA"));
  		unidadZonaCentro.add(new UnidadesZonas("11802000","LA SERENA/ AD. LA FLORIDA"));
  		unidadZonaCentro.add(new UnidadesZonas("11803000","AERODROMO MATAVERI"));
  		unidadZonaCentro.add(new UnidadesZonas("11803000","ISLA DE PASCUA/ AP. MATAVERI"));
  		unidadZonaCentro.add(new UnidadesZonas("11806000","VIÑA DEL MAR/ AD. VIÑA DEL MAR"));
  		unidadZonaCentro.add(new UnidadesZonas("11806000","AERODROMO VIÑA DEL MAR"));
  		unidadZonaCentro.add(new UnidadesZonas("11800000","SUBDPTO. ZONA AEROPORTUARIA CENTRAL"));
  		unidadZonaCentro.add(new UnidadesZonas("11800000","SUBDEPARTAMENTO ZONA AEROPORTTUARIA CENTRAL"));
  		unidadZonaCentro.add(new UnidadesZonas("11808000","SANTIAGO/ AD. EULOGIO SÁNCHEZ"));
  		unidadZonaCentro.add(new UnidadesZonas("11808000","AERODROMO EULOGIO SANCHEZ"));
  		unidadZonaCentro.add(new UnidadesZonas("11813000","CONCEPCIÓN/ AD. CARRIEL SUR"));
  		unidadZonaCentro.add(new UnidadesZonas("11813000","AERODROMO CARRIEL SUR"));
  		unidadZonaCentro.add(new UnidadesZonas("20005057","AERODROMO ROBINSON CRUSOE"));
  		
//  		SelectItem[] uzCentro = new SelectItem[unidadZonaCentro.size()];
//  		for(int i=0; i< unidadZonaCentro.size();i++){
//  			uzCentro[i] = new SelectItem(unidadZonaCentro.get(i).getCodigoUni(), unidadZonaCentro.get(i).getUniDes());
//  		}
//  		groupCentro.setSelectItems(uzCentro);
  		
  		List<UnidadesZonas>unidadDmc= new ArrayList<UnidadesZonas>();
  		unidadDmc.add(new UnidadesZonas("10700000","DEPARTAMENTO METEOROLOGICA DE CHILE"));
  		unidadDmc.add(new UnidadesZonas("10701100","SECCION METEOROLOGIA AERONAUTICA METEO CHILE"));
  		unidadDmc.add(new UnidadesZonas("10701200","SECCION INSTALACIONES METEOROLOGICA METEO CHILE"));
  		unidadDmc.add(new UnidadesZonas("10701300","SECCION CENTRO NACIONAL DE ANALISIS METEO CHILE"));
  		unidadDmc.add(new UnidadesZonas("10702100","SECCION CLIMATOLOGIA METEO CHILE"));
  		
  		List<UnidadesZonas>unidadAmb= new ArrayList<UnidadesZonas>();
  		unidadAmb.add(new UnidadesZonas("11001000","AEROPUERTO ARTURO MERINO BENITEZ"));
  		unidadAmb.add(new UnidadesZonas("11001095","SECCION PLANIFICACION Y CONTROL, LOGISTICA AMB"));
  		unidadAmb.add(new UnidadesZonas("11001110","SECCION SERVICIOS AERONAUTICOS AMB"));
  		unidadAmb.add(new UnidadesZonas("11001120","SECCION SSEI AMB"));
  		unidadAmb.add(new UnidadesZonas("11001200","SECCION SEGURIDAD DE AVIACION AMB"));
  		unidadAmb.add(new UnidadesZonas("11001210","SECCION AVSEC AMB"));
  		unidadAmb.add(new UnidadesZonas("11001410","OFICINA LOGISTICA AMB"));
  		unidadAmb.add(new UnidadesZonas("11001700","SECCION PLANIFICACION Y CONTROL AMB"));
  		unidadAmb.add(new UnidadesZonas("11002200","SECCION SSEI AMB"));
  		unidadAmb.add(new UnidadesZonas("11002300","SECCION SEGURIDAD DE AVIACION AMB"));
  		unidadAmb.add(new UnidadesZonas("11003100","SECCION SERVICIOS TRANSITO AEREO AMB"));
  		unidadAmb.add(new UnidadesZonas("11001130","SECCION MOVIMIENTOS AMB"));
  		unidadAmb.add(new UnidadesZonas("11001920","SECCION OPERACIONES AMB"));
  		
  		
  		List<UnidadesZonas> unidadLogistica = new ArrayList<UnidadesZonas>();
  		unidadLogistica.add(new UnidadesZonas("10801400","SECCION SERVICIOS GENERALES LOGISTICA"));
  		unidadLogistica.add(new UnidadesZonas("10801000","SUBDEPARTAMENTO SOPORTE LOGISTICO LOGISTICA"));
  		unidadLogistica.add(new UnidadesZonas("10801100","SECCION ADQUISICIONES LOGISTICA"));
  		unidadLogistica.add(new UnidadesZonas("10801200","SECCION ABASTECIMIENTO LOGISTICA"));
  		unidadLogistica.add(new UnidadesZonas("10801300","SECCION INFRAESTRUCTURA LOGISTICA"));
  		unidadLogistica.add(new UnidadesZonas("10801500","SECCION TRANSPORTE TERRESTRE Y SISTEMAS RODANTES LOGISTICA"));
  		//unidadLogistica.add(new UnidadesZonas("10801100","SECCION ADQUISICIONES LOGISTICA"));CODIGO Y NOMBRE REPETIDO
  		unidadLogistica.add(new UnidadesZonas("10801200","SECCION ABASTECIMIENTO LOGISTICA"));
  		unidadLogistica.add(new UnidadesZonas("10801300","SECCION INFRAESTRUCTURA LOGISTICA"));
  		unidadLogistica.add(new UnidadesZonas("10801500","SECCION TRANSPORTE TERRESTRE Y SISTEMAS RODANTES LOGISTICA"));
  			
  			
  		List<UnidadesZonas> unidadDasa = new ArrayList<UnidadesZonas>();
  		unidadDasa.add(new UnidadesZonas("11000000","SANTIAGO/ DASA"));
  		unidadDasa.add(new UnidadesZonas("11000000","DEPARTAMENTO AERODROMOS Y SERVICIOS AERONAUTICOS"));
  		unidadDasa.add(new UnidadesZonas("11000110","SUBDEPARTAMENTO SERVICIOS DE TRANSITO AEREO DASA"));
  		unidadDasa.add(new UnidadesZonas("11000130","SECCION SERVICIOS TELECOMUNICACION AERONATICA DASA"));
  		unidadDasa.add(new UnidadesZonas("11000140","SECCION SERV. TELEC. AERO.CCAM DASA"));
  		unidadDasa.add(new UnidadesZonas("11000190","SECCION AIS-MAP DASA"));
  		unidadDasa.add(new UnidadesZonas("11000600","SECCION CENTRO DE CONTROL UNIFICADO DASA"));
  		unidadDasa.add(new UnidadesZonas("11000605","SECC. CENTRO DE CONTROL UNIF. DASA OF. NOTAM INTER Y CCAM/AMHS"));
  		unidadDasa.add(new UnidadesZonas("11000610","OFICINA CENTRO DE CONTROL AEREA OCEANICO DASA"));
  		unidadDasa.add(new UnidadesZonas("11000100","SUBDEPARTAMENTO PLANIFICACION Y CONTROL DASA"));
  		unidadDasa.add(new UnidadesZonas("11000860","SECCION AVSEC DASA"));
  		unidadDasa.add(new UnidadesZonas("11000800","SUBDEPARTAMENTO SERVICIOS DE AERODROMOS DASA"));
  									
  		  		
  		List<UnidadesZonas> unidadZonaSur = new ArrayList<UnidadesZonas>();
  		unidadZonaSur.add(new UnidadesZonas("11001000","SANTIAGO/ AMB"));
   		unidadZonaSur.add(new UnidadesZonas("11900000","SECCION ZONA AEROPORTUARIA SUR"));
  		unidadZonaSur.add(new UnidadesZonas("11900000","SUBDPTO. ZONA AEROPORTUARIA SUR"));
  		unidadZonaSur.add(new UnidadesZonas("20005027","AERODROMO LA ARAUCANIA"));
  		unidadZonaSur.add(new UnidadesZonas("20005027","TEMUCO/ AD. LA ARAUCANÍA"));
  		unidadZonaSur.add(new UnidadesZonas("11902000","AERODROMO PICHOY"));
  		unidadZonaSur.add(new UnidadesZonas("11902000","VALDIVIA/ AD. PICHOY"));
  		unidadZonaSur.add(new UnidadesZonas("11903000","OSORNO/ AD. CAÑAL BAJO"));
  		unidadZonaSur.add(new UnidadesZonas("11903000","AERODROMO CAÑAL BAJO"));
  		unidadZonaSur.add(new UnidadesZonas("11904000","PTO. MONTT / AP. EL TEPUAL"));
  		unidadZonaSur.add(new UnidadesZonas("11904000","AEROPUERTO EL TEPUAL"));
  		unidadZonaSur.add(new UnidadesZonas("11913000","BALMACEDA/ AD. BALMACEDA"));
  		unidadZonaSur.add(new UnidadesZonas("11913000","AERODROMO BALMACEDA"));
//  		SelectItem[] uzSur = new SelectItem[unidadZonaSur.size()];
//  		for(int i=0; i< unidadZonaSur.size();i++){
//  			uzSur[i] = new SelectItem(unidadZonaSur.get(i).getCodigoUni(), unidadZonaSur.get(i).getUniDes());
//  		}
//  		groupSur.setSelectItems(uzSur);
  		
  		List<UnidadesZonas> unidadZonaAustral = new ArrayList<UnidadesZonas>();
  		unidadZonaAustral.add(new UnidadesZonas("12000000","SUBDPTO. ZONA AEROPORTUARIA AUSTRAL"));
  		unidadZonaAustral.add(new UnidadesZonas("12000000","SECCION ZONA AEROPORTUARIA AUSTRAL"));
  		unidadZonaAustral.add(new UnidadesZonas("12001000","AEROPUERTO CARLOS IBAÑEZ DEL CAMPO"));
  		unidadZonaAustral.add(new UnidadesZonas("12001000","PTA. ARENAS/ AP. CARLOS IBAÑEZ DEL CAMPO"));
  		
  		List<UnidadesZonas>unidadOtros = new ArrayList<UnidadesZonas>();
  		unidadOtros.add(new UnidadesZonas("10904300","OFICINA BIENESTAR B. SOCIAL"));
  		unidadOtros.add(new UnidadesZonas("10902200","OFICINA DOCENTE ETA"));
//  		SelectItem[] uzAustral = new SelectItem[unidadZonaAustral.size()];
//  		for(int i=0; i< unidadZonaAustral.size();i++){
//  			uzAustral[i] = new SelectItem(unidadZonaAustral.get(i).getCodigoUni(), unidadZonaAustral.get(i).getUniDes());
//  		}
//  		groupAustral.setSelectItems(uzAustral);
//  		
//  		unidadZonaSI.add(groupNorte);
//  		unidadZonaSI.add(groupCentro);
//  		unidadZonaSI.add(groupSur);
//  		unidadZonaSI.add(groupAustral);
  		
  		unidadZona = new ArrayList<UnidadesZonas>();
  		unidadZona.addAll(unidadZonaNorte);
  		unidadZona.addAll(unidadZonaCentro);
  		unidadZona.addAll(unidadDmc);
  		unidadZona.addAll(unidadAmb);
  		unidadZona.addAll(unidadLogistica);
  		unidadZona.addAll(unidadDasa);
  		unidadZona.addAll(unidadZonaSur);
  		unidadZona.addAll(unidadZonaAustral);
  		//unidadZona.addAll(unidadOtros);
  		

	    System.out.println("uidades zona tiene: " + unidadZona.size());
	
	}

	private void inicializaAsignacion() {
		asignacion = new ArrayList<Asignacion>();
		asignacion.add(new Asignacion(1, "Horas Extras"));
		asignacion.add(new Asignacion(2, "Viáticos"));
		asignacion.add(new Asignacion(3, "Honorarios"));
		asignacion.add(new Asignacion(4, "Remuneraciones"));
		asignacion.add(new Asignacion(5, "Asignación Traslado"));
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
//		availableSubtitulo.add(new Subt(22, "Subtítulo 22"));
//		availableSubtitulo.add(new Subt(23, "Subtítulo 23"));
	}

	//DESHABILITAR ASIGNACIONES
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
		listaItems.add("1");
	} else if ("Viáticos".equals(asignacion)) {
		listaItems.add("1");
	} else if ("Honorarios".equals(asignacion)) {
		listaItems.add("2");
	}else if("Remuneraciones".equals(asignacion)){
		listaItems.add("2");
	}
	else if("Asignación Traslado".equals(asignacion)){
		listaItems.add("3");
	}
	return listaItems;
	}
  
  
  public Boolean asignacionAmbas(String asig){
	boolean selecc=false;
	  if("Horas Extras".equals(asig)&&("Viáticos".equals(asig)) ){
		  selecc=true;
	}  
	  
	  return selecc;
    }
	public void mensajeAmbasAsig(){
		String mens  = selecNoSelec ? "verdadero" : "falso";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mens));
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
	
private List<String> getAsigHabilitador(String unidadEjec) {
	List<String> listaAsig = new ArrayList<String>();
	if (CODIGO_REMUNERACION.equals(unidadEjec)) {
		listaAsig.add("1");
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
//	
	
	public  void cargaUnidadesPorZona(){
		
		setUnidadZona(new ArrayList<UnidadesZonas>());
		ZonaService service = BusinessFactory.getInstance().getZonaService();
		
		for(String codZona : selectedValues.getuniResum()){
			getUnidadZona().addAll(service.getUnidadesPorZona(codZona));
		}
	}
	public boolean isHorasExtraSelected(){

		if(selectedValues!=null && selectedValues.getAsignacion()!=null){
			for(String asig : selectedValues.getAsignacion()){
				if("1".equals(asig)){
					return true;
				}
			}
		}
		if(getUnidadZona()!=null){
			getUnidadZona().clear();
		}
		return false;
	}
	/*
	 * Metodo Calendar.getInstance().get(Calendar.MONTH) entrega mes en basse 0, se agrega 1 para coincidir con base de datos local
	 */
	public int getCurrentMonth(){
		int mesActual = Calendar.getInstance().get(Calendar.MONTH);
		return mesActual;
	}
	
	public int getCurrentYear(){
		int currYear = Calendar.getInstance().get(Calendar.YEAR);
		return currYear;
	}
	public void addMessage(){
		String mens  = selecNoSelec ? "Todo seleccionado" : "Nada seleccionado";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mens));
	}
}
