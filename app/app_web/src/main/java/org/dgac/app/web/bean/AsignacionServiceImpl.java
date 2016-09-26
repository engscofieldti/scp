package org.dgac.app.web.bean;
import java.util.ArrayList;
import java.util.List;
import org.dgac.app.web.enumsSubt21.AsignacionEnum;

public class AsignacionServiceImpl implements AsignacionService {

	@Override
	public List<UnidadesResum> getZonaResumPorAsig(String codAsig) { 
		AsignacionEnum ae = AsignacionEnum.asignacionEnumByCod(codAsig);
		switch(ae){
		case HORAS_EXTRAS :{
			return getListaActivacionZonasPorHHEE();
				      
		}
		case VIATICOS:{
			return getListaVia();
			
		}
		case HONORARIOS:{
			return getListaHono();
			
		}
		case REMUNERACIONES:{
			return getListaRemu();
			
		}
		case ASIG_TRAS:{
			return getListaTraslado();
			
		}
		case TEST:{
			return getTest();
		}
		
		default:
			return new ArrayList<UnidadesResum>();
		}
	}

	private List<UnidadesResum> getTest() {
		List<UnidadesResum> test = new ArrayList<UnidadesResum>();
		test.removeAll(getListaActivacionZonasPorHHEE());
		return test;
	}

	private List<UnidadesResum> getListaActivacionZonasPorHHEE() {
		List<UnidadesResum> unidHHEE = new ArrayList<UnidadesResum>();
		unidHHEE.add(new UnidadesResum("0","Todas"));
		unidHHEE.add(new UnidadesResum("1","Zona Norte"));
		unidHHEE.add(new UnidadesResum("2","Zona Centro"));
		unidHHEE.add(new UnidadesResum("3","AMB"));
		unidHHEE.add(new UnidadesResum("4","DMC"));
		unidHHEE.add(new UnidadesResum("5","Logística"));
		unidHHEE.add(new UnidadesResum("6","DASA"));
		unidHHEE.add(new UnidadesResum("7","Zona Sur"));
		unidHHEE.add(new UnidadesResum("8","Zona Austral"));
		return unidHHEE;
	}
	
	private List<UnidadesResum> getListaVia() {
		List<UnidadesResum> unidvia = new ArrayList<UnidadesResum>();
		
		unidvia.add(new UnidadesResum("2","viaticos"));
//		unidvia.add(new UnidadesResum("",""));
//		unidvia.add(new UnidadesResum("",""));
//		unidvia.add(new UnidadesResum("",""));
//		unidvia.add(new UnidadesResum("",""));
//		unidvia.add(new UnidadesResum("",""));
//		unidvia.add(new UnidadesResum("",""));
//		unidvia.add(new UnidadesResum("",""));
		return unidvia;
	
	}

	private List<UnidadesResum> getListaHono() {
		List<UnidadesResum>unidHono= new ArrayList<UnidadesResum>();
		unidHono.add(new UnidadesResum("3","hono"));
		return unidHono;
	}
	private List<UnidadesResum> getListaRemu() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<UnidadesResum> getListaTraslado() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
