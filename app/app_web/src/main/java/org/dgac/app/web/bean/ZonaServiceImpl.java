package org.dgac.app.web.bean;
import java.util.ArrayList;
import java.util.List;

import org.dgac.app.web.enumsSubt21.ZonaResumEnum;


public class ZonaServiceImpl implements ZonaService {
//PanelUsuarioMB panMB= new PanelUsuarioMB();

	@Override 
	public List<UnidadesZonas> getUnidadesPorZona(String codZona) {
		ZonaResumEnum zr = ZonaResumEnum.zonaResumenEnumByCod(codZona);
		switch(zr){
		case TODAS :{
			return getListaTodas();	
			      
		}
		case NORTE:{
			return getListaNorte();
			
		}
		case CENTRO:{
			return getListaCentro();
			
		}
		case AMB:{
			return getListaAmb();
			
		}
		case DMC:{
			return getListaDmc();
			
		}
		case LOGISTICA:{
			return getListaLogistica();
			
		}
		case DASA:{
			return getListaDasa();
			
		}
		case SUR:{
			return getListaZonaSur();
			
		}
		case AUSTRAL:{
			return getListaZonaAustral();
			
		}
//		case OTRAS:{
//			return getListaOtras();
//			
//		}					
		default:
			return new ArrayList<UnidadesZonas>();
		}
	}
	
	private List<UnidadesZonas> getListaTodas() {
		List<UnidadesZonas> unidadTodas = new ArrayList<UnidadesZonas>();
		
		unidadTodas.add(new UnidadesZonas("0","TODAS"));
//		unidadTodas.addAll(getListaNorte());
//		unidadTodas.addAll(getListaCentro());
//		unidadTodas.addAll(getListaAmb());
//		unidadTodas.addAll(getListaDmc());
//		unidadTodas.addAll(getListaLogistica());
//		unidadTodas.addAll(getListaDasa());
//		unidadTodas.addAll(getListaZonaSur());
//		unidadTodas.addAll(getListaZonaAustral());
		unidadTodas.add(new UnidadesZonas("11701000","AEROPUERTO CHACALLUTA"));
		unidadTodas.add(new UnidadesZonas("11702000","AEROPUERTO GENERAL DIEGO ARACENA"));
  		unidadTodas.add(new UnidadesZonas("11703000","AERODROMO EL LOA"));
  		unidadTodas.add(new UnidadesZonas("20005060","AEROPUERTO ANDRES SABELLA"));
  		unidadTodas.add(new UnidadesZonas("11700000","SUBDEPARTAMENTO ZONA AEROPORTUARIA NORTE COMERCIAL"));
  		unidadTodas.add(new UnidadesZonas("11708000","AERODROMO DESIERTO DE ATACAMA"));
  			unidadTodas.add(new UnidadesZonas("11802000","AERODROMO LA FLORIDA"));
  			unidadTodas.add(new UnidadesZonas("11803000","AERODROMO MATAVERI"));
  			unidadTodas.add(new UnidadesZonas("11806000","AERODROMO VIÑA DEL MAR"));
  			unidadTodas.add(new UnidadesZonas("11800000","SUBDEPARTAMENTO ZONA AEROPORTTUARIA CENTRAL"));
  			unidadTodas.add(new UnidadesZonas("11808000","AERODROMO EULOGIO SANCHEZ"));
  			unidadTodas.add(new UnidadesZonas("11813000","AERODROMO CARRIEL SUR"));
  			unidadTodas.add(new UnidadesZonas("20005057","AERODROMO ROBINSON CRUSOE"));
  				unidadTodas.add(new UnidadesZonas("11001000","AEROPUERTO ARTURO MERINO BENITEZ"));
  					unidadTodas.add(new UnidadesZonas("10700000","DEPARTAMENTO METEOROLOGICA DE CHILE"));
  						unidadTodas.add(new UnidadesZonas("10801400","SECCION SERVICIOS GENERALES LOGISTICA"));
  							unidadTodas.add(new UnidadesZonas("11000000","DEPARTAMENTO AERODROMOS Y SERVICIOS AERONAUTICOS"));
  								unidadTodas.add(new UnidadesZonas("11900000","SECCION ZONA AEROPORTUARIA SUR"));
   		  				unidadTodas.add(new UnidadesZonas("20005027","AERODROMO LA ARAUCANIA"));
   		  				unidadTodas.add(new UnidadesZonas("11902000","AERODROMO PICHOY"));
   		  				unidadTodas.add(new UnidadesZonas("11903000","AERODROMO CAÑAL BAJO"));
   		  				unidadTodas.add(new UnidadesZonas("11904000","AEROPUERTO EL TEPUAL"));
   		  				unidadTodas.add(new UnidadesZonas("11913000","AERODROMO BALMACEDA"));
   		  					unidadTodas.add(new UnidadesZonas("12000000","SECCION ZONA AEROPORTUARIA AUSTRAL"));
   		   					unidadTodas.add(new UnidadesZonas("12001000","AEROPUERTO CARLOS IBAÑEZ DEL CAMPO"));
   		 return unidadTodas;
	}

	private List<UnidadesZonas> getListaNorte() {
		List<UnidadesZonas> unidadZonaNorte = new ArrayList<UnidadesZonas>();
				unidadZonaNorte.add(new UnidadesZonas("0","TODAS"));
				unidadZonaNorte.add(new UnidadesZonas("11701000","AEROPUERTO CHACALLUTA"));
				unidadZonaNorte.add(new UnidadesZonas("11702000","AEROPUERTO GENERAL DIEGO ARACENA"));
	   	  		unidadZonaNorte.add(new UnidadesZonas("11703000","AERODROMO EL LOA"));
	          	unidadZonaNorte.add(new UnidadesZonas("20005060","AEROPUERTO ANDRES SABELLA"));
	          	unidadZonaNorte.add(new UnidadesZonas("11700000","SUBDEPARTAMENTO ZONA AEROPORTUARIA NORTE COMERCIAL"));
  		 		unidadZonaNorte.add(new UnidadesZonas("11708000","AERODROMO DESIERTO DE ATACAMA"));
		return  unidadZonaNorte;
	}
	private List<UnidadesZonas> getListaCentro() {
		List<UnidadesZonas> unidadZonaCentro = new ArrayList<UnidadesZonas>();
		unidadZonaCentro.add(new UnidadesZonas("0","TODAS"));
  		unidadZonaCentro.add(new UnidadesZonas("11802000","AERODROMO LA FLORIDA"));
  	  	unidadZonaCentro.add(new UnidadesZonas("11803000","AERODROMO MATAVERI"));
  		unidadZonaCentro.add(new UnidadesZonas("11806000","AERODROMO VIÑA DEL MAR"));
  	  	unidadZonaCentro.add(new UnidadesZonas("11800000","SUBDEPARTAMENTO ZONA AEROPORTTUARIA CENTRAL"));
  	  	unidadZonaCentro.add(new UnidadesZonas("11808000","AERODROMO EULOGIO SANCHEZ"));
  		unidadZonaCentro.add(new UnidadesZonas("11813000","AERODROMO CARRIEL SUR"));
  		unidadZonaCentro.add(new UnidadesZonas("20005057","AERODROMO ROBINSON CRUSOE"));
  		  		return unidadZonaCentro;
		
	}
	private List<UnidadesZonas> getListaAmb() {
		List<UnidadesZonas>unidadAmb= new ArrayList<UnidadesZonas>();
		unidadAmb.add(new UnidadesZonas("0","TODAS"));
		unidadAmb.add(new UnidadesZonas("11001000","AEROPUERTO ARTURO MERINO BENITEZ"));

		return unidadAmb;
	}
	private List<UnidadesZonas> getListaDmc() {
		List<UnidadesZonas>unidadDmc= new ArrayList<UnidadesZonas>();
		unidadDmc.add(new UnidadesZonas("0","TODAS"));
		unidadDmc.add(new UnidadesZonas("10700000","DEPARTAMENTO METEOROLOGICA DE CHILE"));
		return unidadDmc;
	}
	private List<UnidadesZonas> getListaLogistica() {
		List<UnidadesZonas> unidadLogistica = new ArrayList<UnidadesZonas>();

		unidadLogistica.add(new UnidadesZonas("0","TODAS"));
		unidadLogistica.add(new UnidadesZonas("10801400","SECCION SERVICIOS GENERALES LOGISTICA"));
 		
		return unidadLogistica;
	}
	private List<UnidadesZonas> getListaDasa() {
		List<UnidadesZonas> unidadDasa = new ArrayList<UnidadesZonas>();
  			unidadDasa.add(new UnidadesZonas("0","TODAS"));
  			unidadDasa.add(new UnidadesZonas("11000000","DEPARTAMENTO AERODROMOS Y SERVICIOS AERONAUTICOS"));
  		return unidadDasa;							
		
	}
	private List<UnidadesZonas> getListaZonaSur() {
		List<UnidadesZonas> unidadZonaSur = new ArrayList<UnidadesZonas>();
		unidadZonaSur.add(new UnidadesZonas("0","TODAS"));
   		unidadZonaSur.add(new UnidadesZonas("11900000","SECCION ZONA AEROPORTUARIA SUR"));
   		  		unidadZonaSur.add(new UnidadesZonas("20005027","AERODROMO LA ARAUCANIA"));
  		  		
  		unidadZonaSur.add(new UnidadesZonas("11903000","AERODROMO CAÑAL BAJO"));
  		  		unidadZonaSur.add(new UnidadesZonas("11904000","AEROPUERTO EL TEPUAL"));
  		  		unidadZonaSur.add(new UnidadesZonas("11913000","AERODROMO BALMACEDA"));
		return unidadZonaSur;
	}
	private List<UnidadesZonas> getListaZonaAustral() {
		List<UnidadesZonas> unidadZonaAustral = new ArrayList<UnidadesZonas>();
  			unidadZonaAustral.add(new UnidadesZonas("0","TODAS"));
  		unidadZonaAustral.add(new UnidadesZonas("12000000","SECCION ZONA AEROPORTUARIA AUSTRAL"));
  		  		unidadZonaAustral.add(new UnidadesZonas("12001000","AEROPUERTO CARLOS IBAÑEZ DEL CAMPO"));
  				return unidadZonaAustral;
	}

//	private List<UnidadesZonas> getListaOtras() {
//		List<UnidadesZonas>unidadOtros = new ArrayList<UnidadesZonas>();
//  		unidadOtros.add(new UnidadesZonas("10904000","SUBDEPARTAMENTO BIENESTAR SOCIAL"));
//  		unidadOtros.add(new UnidadesZonas("10902200","OFICINA DOCENTE ETA"));
//		return unidadOtros;
//	}
	
	
}
