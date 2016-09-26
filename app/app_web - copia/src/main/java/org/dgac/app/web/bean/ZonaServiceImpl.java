package org.dgac.app.web.bean;
import java.util.ArrayList;
import java.util.List;

import org.dgac.app.web.enumsSubt21.ZonaResumEnum;


public class ZonaServiceImpl implements ZonaService {

	@Override
	public List<UnidadesZonas> getUnidadesPorZona(String codZona) {
		ZonaResumEnum zr = ZonaResumEnum.zonaResumenEnumByCod(codZona);
		switch(zr){
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

	private List<UnidadesZonas> getListaNorte() {
		List<UnidadesZonas> unidadZonaNorte = new ArrayList<UnidadesZonas>();
		unidadZonaNorte.add(new UnidadesZonas("11701000","AEROPUERTO CHACALLUTA"));
		unidadZonaNorte.add(new UnidadesZonas("11702000","AEROPUERTO GENERAL DIEGO ARACENA"));
          		//unidadZonaNorte.add(new UnidadesZonas("11702000","IQUIQUE/ AP. DIEGO ARACENA"));
  		//unidadZonaNorte.add(new UnidadesZonas("11703000","CALAMA/ AD. EL LOA"));
  		unidadZonaNorte.add(new UnidadesZonas("11703000","AERODROMO EL LOA"));
  		unidadZonaNorte.add(new UnidadesZonas("20005060","AEROPUERTO ANDRES SABELLA"));
  		unidadZonaNorte.add(new UnidadesZonas("11700000","SUBDEPARTAMENTO ZONA AEROPORTUARIA NORTE COMERCIAL"));
  		//unidadZonaNorte.add(new UnidadesZonas("11700000","OFICINA CENTRO METEOROLOGICO ZONAL Z. AERO NORTE"));
  		//unidadZonaNorte.add(new UnidadesZonas("11700000","SECCION CENTRO METEOROLOGICO Z. AERO NORTE"));
  		//unidadZonaNorte.add(new UnidadesZonas("11700000","SUBDPTO. ZONA AEROPORTUARIA NORTE"));
  		//unidadZonaNorte.add(new UnidadesZonas("11708000","ATACAMA/ AD. DESIERTO DE ATACAMA"));
  		unidadZonaNorte.add(new UnidadesZonas("11708000","AERODROMO DESIERTO DE ATACAMA"));
		return unidadZonaNorte;
	}
	private List<UnidadesZonas> getListaCentro() {
		List<UnidadesZonas> unidadZonaCentro = new ArrayList<UnidadesZonas>();
  		unidadZonaCentro.add(new UnidadesZonas("11802000","AERODROMO LA FLORIDA"));
  		//unidadZonaCentro.add(new UnidadesZonas("11802000","LA SERENA/ AD. LA FLORIDA"));
  		unidadZonaCentro.add(new UnidadesZonas("11803000","AERODROMO MATAVERI"));
  		//unidadZonaCentro.add(new UnidadesZonas("11803000","ISLA DE PASCUA/ AP. MATAVERI"));
  		//unidadZonaCentro.add(new UnidadesZonas("11806000","VIÑA DEL MAR/ AD. VIÑA DEL MAR"));
  		unidadZonaCentro.add(new UnidadesZonas("11806000","AERODROMO VIÑA DEL MAR"));
  		//unidadZonaCentro.add(new UnidadesZonas("11800000","SUBDPTO. ZONA AEROPORTUARIA CENTRAL"));
  		unidadZonaCentro.add(new UnidadesZonas("11800000","SUBDEPARTAMENTO ZONA AEROPORTTUARIA CENTRAL"));
  		//unidadZonaCentro.add(new UnidadesZonas("11800000","SECCION TELECOMUNICACION Y ELECTRONICA Z. AERO CENTRAL"));
  		
  		//unidadZonaCentro.add(new UnidadesZonas("11808000","SANTIAGO/ AD. EULOGIO SÁNCHEZ"));
  		unidadZonaCentro.add(new UnidadesZonas("11808000","AERODROMO EULOGIO SANCHEZ"));
  		//unidadZonaCentro.add(new UnidadesZonas("11813000","CONCEPCIÓN/ AD. CARRIEL SUR"));
  		unidadZonaCentro.add(new UnidadesZonas("11813000","AERODROMO CARRIEL SUR"));
  		unidadZonaCentro.add(new UnidadesZonas("20005057","AERODROMO ROBINSON CRUSOE"));
  		return unidadZonaCentro;
		
	}
	private List<UnidadesZonas> getListaAmb() {
		List<UnidadesZonas>unidadAmb= new ArrayList<UnidadesZonas>();
//  		unidadAmb.add(new UnidadesZonas("11001000","AEROPUERTO ARTURO MERINO BENITEZ"));
//  		unidadAmb.add(new UnidadesZonas("11001095","SECCION PLANIFICACION Y CONTROL, LOGISTICA AMB"));
//  		unidadAmb.add(new UnidadesZonas("11001110","SECCION SERVICIOS AERONAUTICOS AMB"));
//  		unidadAmb.add(new UnidadesZonas("11001120","SECCION SSEI AMB"));
//  		unidadAmb.add(new UnidadesZonas("11001200","SECCION SEGURIDAD DE AVIACION AMB"));
//  		unidadAmb.add(new UnidadesZonas("11001210","SECCION AVSEC AMB"));
//  		unidadAmb.add(new UnidadesZonas("11001410","OFICINA LOGISTICA AMB"));
//  		unidadAmb.add(new UnidadesZonas("11001700","SECCION PLANIFICACION Y CONTROL AMB"));
//  		unidadAmb.add(new UnidadesZonas("11002200","SECCION SSEI AMB"));
//  		unidadAmb.add(new UnidadesZonas("11002300","SECCION SEGURIDAD DE AVIACION AMB"));
//  		unidadAmb.add(new UnidadesZonas("11003100","SECCION SERVICIOS TRANSITO AEREO AMB"));
//  		unidadAmb.add(new UnidadesZonas("11001130","SECCION MOVIMIENTOS AMB"));
//  		unidadAmb.add(new UnidadesZonas("11001920","SECCION OPERACIONES AMB"));
		unidadAmb.add(new UnidadesZonas("11001000","AEROPUERTO ARTURO MERINO BENITEZ"));
//  		unidadAmb.add(new UnidadesZonas("11001000","SECCION PLANIFICACION Y CONTROL, LOGISTICA AMB"));
//  		unidadAmb.add(new UnidadesZonas("11001000","SECCION SERVICIOS AERONAUTICOS AMB"));
//  		unidadAmb.add(new UnidadesZonas("11001000","SECCION SSEI AMB"));
//  		unidadAmb.add(new UnidadesZonas("11001000","SECCION SEGURIDAD DE AVIACION AMB"));
//  		unidadAmb.add(new UnidadesZonas("11001000","SECCION AVSEC AMB"));
//  		unidadAmb.add(new UnidadesZonas("11001000","OFICINA LOGISTICA AMB"));
//  		unidadAmb.add(new UnidadesZonas("11001000","SECCION PLANIFICACION Y CONTROL AMB"));
//  		unidadAmb.add(new UnidadesZonas("11001000","SECCION SSEI AMB"));
//  		unidadAmb.add(new UnidadesZonas("11001000","SECCION SEGURIDAD DE AVIACION AMB"));
//  		unidadAmb.add(new UnidadesZonas("11001000","SECCION SERVICIOS TRANSITO AEREO AMB"));
//  		unidadAmb.add(new UnidadesZonas("11001000","SECCION MOVIMIENTOS AMB"));
//  		unidadAmb.add(new UnidadesZonas("11001000","SECCION OPERACIONES AMB"));
		return unidadAmb;
	}
	private List<UnidadesZonas> getListaDmc() {
		List<UnidadesZonas>unidadDmc= new ArrayList<UnidadesZonas>();
//  		unidadDmc.add(new UnidadesZonas("10700000","DEPARTAMENTO METEOROLOGICA DE CHILE"));
//  		unidadDmc.add(new UnidadesZonas("10701100","SECCION METEOROLOGIA AERONAUTICA METEO CHILE"));
//  		unidadDmc.add(new UnidadesZonas("10701200","SECCION INSTALACIONES METEOROLOGICA METEO CHILE"));
//  		unidadDmc.add(new UnidadesZonas("10701300","SECCION CENTRO NACIONAL DE ANALISIS METEO CHILE"));
//  		unidadDmc.add(new UnidadesZonas("10702100","SECCION CLIMATOLOGIA METEO CHILE"));
		unidadDmc.add(new UnidadesZonas("10700000","DEPARTAMENTO METEOROLOGICA DE CHILE"));
//  		unidadDmc.add(new UnidadesZonas("10700000","SECCION METEOROLOGIA AERONAUTICA METEO CHILE"));
//  		unidadDmc.add(new UnidadesZonas("10700000","SECCION INSTALACIONES METEOROLOGICA METEO CHILE"));
//  		unidadDmc.add(new UnidadesZonas("10700000","SECCION CENTRO NACIONAL DE ANALISIS METEO CHILE"));
//  		unidadDmc.add(new UnidadesZonas("10700000","SECCION CLIMATOLOGIA METEO CHILE"));
		return unidadDmc;
	}
	private List<UnidadesZonas> getListaLogistica() {
		List<UnidadesZonas> unidadLogistica = new ArrayList<UnidadesZonas>();
//  		unidadLogistica.add(new UnidadesZonas("10801400","SECCION SERVICIOS GENERALES LOGISTICA"));
//  		unidadLogistica.add(new UnidadesZonas("10801000","SUBDEPARTAMENTO SOPORTE LOGISTICO LOGISTICA"));
//  		unidadLogistica.add(new UnidadesZonas("10801100","SECCION ADQUISICIONES LOGISTICA"));
//  		unidadLogistica.add(new UnidadesZonas("10801200","SECCION ABASTECIMIENTO LOGISTICA"));
//  		unidadLogistica.add(new UnidadesZonas("10801300","SECCION INFRAESTRUCTURA LOGISTICA"));
//  		unidadLogistica.add(new UnidadesZonas("10801500","SECCION TRANSPORTE TERRESTRE Y SISTEMAS RODANTES LOGISTICA"));
  		//unidadLogistica.add(new UnidadesZonas("10801100","SECCION ADQUISICIONES LOGISTICA"));CODIGO Y NOMBRE REPETIDO
		unidadLogistica.add(new UnidadesZonas("10801400","SECCION SERVICIOS GENERALES LOGISTICA"));
//  		unidadLogistica.add(new UnidadesZonas("10801400","SUBDEPARTAMENTO SOPORTE LOGISTICO LOGISTICA"));
//  		unidadLogistica.add(new UnidadesZonas("10801400","SECCION ADQUISICIONES LOGISTICA"));
//  		unidadLogistica.add(new UnidadesZonas("10801400","SECCION ABASTECIMIENTO LOGISTICA"));
//  		unidadLogistica.add(new UnidadesZonas("10801400","SECCION INFRAESTRUCTURA LOGISTICA"));
//  		unidadLogistica.add(new UnidadesZonas("10801400","SECCION TRANSPORTE TERRESTRE Y SISTEMAS RODANTES LOGISTICA"));
  		
  		
		return unidadLogistica;
	}
	private List<UnidadesZonas> getListaDasa() {
		List<UnidadesZonas> unidadDasa = new ArrayList<UnidadesZonas>();
  		//unidadDasa.add(new UnidadesZonas("11000000","SANTIAGO/ DASA"));
//  		unidadDasa.add(new UnidadesZonas("11000000","DEPARTAMENTO AERODROMOS Y SERVICIOS AERONAUTICOS"));
//  		unidadDasa.add(new UnidadesZonas("11000110","SUBDEPARTAMENTO SERVICIOS DE TRANSITO AEREO DASA"));
//  		unidadDasa.add(new UnidadesZonas("11000130","SECCION SERVICIOS TELECOMUNICACION AERONATICA DASA"));
//  		unidadDasa.add(new UnidadesZonas("11000140","SECCION SERV. TELEC. AERO.CCAM DASA"));
//  		unidadDasa.add(new UnidadesZonas("11000190","SECCION AIS-MAP DASA"));
//  		unidadDasa.add(new UnidadesZonas("11000600","SECCION CENTRO DE CONTROL UNIFICADO DASA"));
//  		unidadDasa.add(new UnidadesZonas("11000605","SECC. CENTRO DE CONTROL UNIF. DASA OF. NOTAM INTER Y CCAM/AMHS"));
//  		unidadDasa.add(new UnidadesZonas("11000610","OFICINA CENTRO DE CONTROL AEREA OCEANICO DASA"));
//  		unidadDasa.add(new UnidadesZonas("11000100","SUBDEPARTAMENTO PLANIFICACION Y CONTROL DASA"));
//  		unidadDasa.add(new UnidadesZonas("11000860","SECCION AVSEC DASA"));
//  		unidadDasa.add(new UnidadesZonas("11000800","SUBDEPARTAMENTO SERVICIOS DE AERODROMOS DASA"));
		unidadDasa.add(new UnidadesZonas("11000000","DEPARTAMENTO AERODROMOS Y SERVICIOS AERONAUTICOS"));
//  		unidadDasa.add(new UnidadesZonas("11000000","SUBDEPARTAMENTO SERVICIOS DE TRANSITO AEREO DASA"));
//  		unidadDasa.add(new UnidadesZonas("11000000","SECCION SERVICIOS TELECOMUNICACION AERONATICA DASA"));
//  		unidadDasa.add(new UnidadesZonas("11000000","SECCION SERV. TELEC. AERO.CCAM DASA"));
//  		unidadDasa.add(new UnidadesZonas("11000000","SECCION AIS-MAP DASA"));
//  		unidadDasa.add(new UnidadesZonas("11000000","SECCION CENTRO DE CONTROL UNIFICADO DASA"));
//  		unidadDasa.add(new UnidadesZonas("11000000","SECC. CENTRO DE CONTROL UNIF. DASA OF. NOTAM INTER Y CCAM/AMHS"));
//  		unidadDasa.add(new UnidadesZonas("11000000","OFICINA CENTRO DE CONTROL AEREA OCEANICO DASA"));
//  		unidadDasa.add(new UnidadesZonas("11000000","SUBDEPARTAMENTO PLANIFICACION Y CONTROL DASA"));
//  		unidadDasa.add(new UnidadesZonas("11000000","SECCION AVSEC DASA"));
//  		unidadDasa.add(new UnidadesZonas("11000000","SUBDEPARTAMENTO SERVICIOS DE AERODROMOS DASA"));
  		return unidadDasa;							
		
	}
	private List<UnidadesZonas> getListaZonaSur() {
		List<UnidadesZonas> unidadZonaSur = new ArrayList<UnidadesZonas>();
   		unidadZonaSur.add(new UnidadesZonas("11900000","SECCION ZONA AEROPORTUARIA SUR"));
   		//unidadZonaSur.add(new UnidadesZonas("11900000","OFICINA CENTRO METEOROLOGICO Z. AERO SUR"));	
  		//unidadZonaSur.add(new UnidadesZonas("11900000","SUBDPTO. ZONA AEROPORTUARIA SUR"));
  		unidadZonaSur.add(new UnidadesZonas("20005027","AERODROMO LA ARAUCANIA"));
  		//unidadZonaSur.add(new UnidadesZonas("20005027","TEMUCO/ AD. LA ARAUCANÍA"));
  		unidadZonaSur.add(new UnidadesZonas("11902000","AERODROMO PICHOY"));
  		//unidadZonaSur.add(new UnidadesZonas("11902000","VALDIVIA/ AD. PICHOY"));
  		//unidadZonaSur.add(new UnidadesZonas("11903000","OSORNO/ AD. CAÑAL BAJO"));
  		unidadZonaSur.add(new UnidadesZonas("11903000","AERODROMO CAÑAL BAJO"));
  		//unidadZonaSur.add(new UnidadesZonas("11904000","PTO. MONTT / AP. EL TEPUAL"));
  		unidadZonaSur.add(new UnidadesZonas("11904000","AEROPUERTO EL TEPUAL"));
  		//unidadZonaSur.add(new UnidadesZonas("11913000","BALMACEDA/ AD. BALMACEDA"));
  		unidadZonaSur.add(new UnidadesZonas("11913000","AERODROMO BALMACEDA"));
		return unidadZonaSur;
	}
	private List<UnidadesZonas> getListaZonaAustral() {
		List<UnidadesZonas> unidadZonaAustral = new ArrayList<UnidadesZonas>();
  		//unidadZonaAustral.add(new UnidadesZonas("12000000","SUBDPTO. ZONA AEROPORTUARIA AUSTRAL"));
  		unidadZonaAustral.add(new UnidadesZonas("12000000","SECCION ZONA AEROPORTUARIA AUSTRAL"));
  		//unidadZonaAustral.add(new UnidadesZonas("12000000","OFICINA CENTRO METEOROLOGICO ZONAL Z. AERO AUSTRAL"));
  		//unidadZonaAustral.add(new UnidadesZonas("12000000","OFICINA CENTRO METEOROLOGICO Z. AERO AUSTRAL"));
  		unidadZonaAustral.add(new UnidadesZonas("12001000","AEROPUERTO CARLOS IBAÑEZ DEL CAMPO"));
  		//unidadZonaAustral.add(new UnidadesZonas("12001000","PTA. ARENAS/ AP. CARLOS IBAÑEZ DEL CAMPO"));
		return unidadZonaAustral;
	}

//	private List<UnidadesZonas> getListaOtras() {
//		List<UnidadesZonas>unidadOtros = new ArrayList<UnidadesZonas>();
//  		unidadOtros.add(new UnidadesZonas("10904000","SUBDEPARTAMENTO BIENESTAR SOCIAL"));
//  		unidadOtros.add(new UnidadesZonas("10902200","OFICINA DOCENTE ETA"));
//		return unidadOtros;
//	}
	
	
}
