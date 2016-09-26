package org.dgac.app.web.bean;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "unidades")
@ViewScoped
public class Unidades implements Serializable {
	private static final long serialVersionUID = 5600369132889054255L;
	private String codigo;
	private String nombreUni;
	private List<Unidades>arrUni;
	private List<Unidades>arrUniSelected;
	
	
	@PostConstruct
	public void init(){
		arrUni=new ArrayList<Unidades>();
		arrUni.add(new Unidades("11701000","AEROPUERTO CHACALLUTA"));
		arrUni.add(new Unidades("11702000","AEROPUERTO GENERAL DIEGO ARACENA"));
		arrUni.add(new Unidades("11702000","IQUIQUE/ AP. DIEGO ARACENA"));
		arrUni.add(new Unidades("11703000","CALAMA/ AD. EL LOA"));
		arrUni.add(new Unidades("11703000","AERODROMO EL LOA"));
		arrUni.add(new Unidades("20005060","AEROPUERTO ANDRES SABELLA"));
		arrUni.add(new Unidades("11700000","SUBDEPARTAMENTO ZONA AEROPORTUARIA NORTE COMERCIAL"));
		arrUni.add(new Unidades("11700000","SUBDPTO. ZONA AEROPORTUARIA NORTE"));
		arrUni.add(new Unidades("11708000","ATACAMA/ AD. DESIERTO DE ATACAMA"));
		arrUni.add(new Unidades("11708000","AERODROMO DESIERTO DE ATACAMA"));
		arrUni.add(new Unidades("11802000","AERODROMO LA FLORIDA"));
		arrUni.add(new Unidades("11802000","LA SERENA/ AD. LA FLORIDA"));
		arrUni.add(new Unidades("11803000","AERODROMO MATAVERI"));
		arrUni.add(new Unidades("11803000","ISLA DE PASCUA/ AP. MATAVERI"));
		arrUni.add(new Unidades("11806000","VIÑA DEL MAR/ AD. VIÑA DEL MAR"));
		arrUni.add(new Unidades("11806000","AERODROMO VIÑA DEL MAR"));
		arrUni.add(new Unidades("11800000","SUBDPTO. ZONA AEROPORTUARIA CENTRAL"));
		arrUni.add(new Unidades("11800000","SUBDEPARTAMENTO ZONA AEROPORTTUARIA CENTRAL"));
		arrUni.add(new Unidades("11808000","SANTIAGO/ AD. EULOGIO SÁNCHEZ"));
		arrUni.add(new Unidades("11808000","AERODROMO EULOGIO SANCHEZ"));
		arrUni.add(new Unidades("11813000","CONCEPCIÓN/ AD. CARRIEL SUR"));
		arrUni.add(new Unidades("11813000","AERODROMO CARRIEL SUR"));
		arrUni.add(new Unidades("10700000","DEPARTAMENTO METEOROLOGICA DE CHILE"));
		arrUni.add(new Unidades("11001000","AEROPUERTO ARTURO MERINO BENITEZ"));
		arrUni.add(new Unidades("11001000","SANTIAGO/ AMB"));
		arrUni.add(new Unidades("10801400","SECCION SERVICIOS GENERALES LOGISTICA"));
		arrUni.add(new Unidades("11000000","SANTIAGO/ DASA"));
		arrUni.add(new Unidades("11000000","DEPARTAMENTO AERODROMOS Y SERVICIOS AERONAUTICOS"));
		arrUni.add(new Unidades("11900000","SECCION ZONA AEROPORTUARIA SUR"));
		arrUni.add(new Unidades("11900000","SUBDPTO. ZONA AEROPORTUARIA SUR"));
		arrUni.add(new Unidades("20005027","AERODROMO LA ARAUCANIA"));
		arrUni.add(new Unidades("20005027","TEMUCO/ AD. LA ARAUCANÍA"));
		arrUni.add(new Unidades("11902000","AERODROMO PICHOY"));
		arrUni.add(new Unidades("11902000","VALDIVIA/ AD. PICHOY"));
		arrUni.add(new Unidades("11903000","OSORNO/ AD. CAÑAL BAJO"));
		arrUni.add(new Unidades("11903000","AERODROMO CAÑAL BAJO"));
		arrUni.add(new Unidades("11904000","PTO. MONTT / AP. EL TEPUAL"));
		arrUni.add(new Unidades("11904000","AEROPUERTO EL TEPUAL"));
		arrUni.add(new Unidades("11913000","BALMACEDA/ AD. BALMACEDA"));
		arrUni.add(new Unidades("11913000","AERODROMO BALMACEDA"));
		arrUni.add(new Unidades("12000000","SUBDPTO. ZONA AEROPORTUARIA AUSTRAL"));
		arrUni.add(new Unidades("12000000","SECCION ZONA AEROPORTUARIA AUSTRAL"));
		arrUni.add(new Unidades("12001000","AEROPUERTO CARLOS IBAÑEZ DEL CAMPO"));
		arrUni.add(new Unidades("12001000","PTA. ARENAS/ AP. CARLOS IBAÑEZ DEL CAMPO"));
		arrUni.add(new Unidades("10904300","OFICINA BIENESTAR B. SOCIAL"));
		arrUni.add(new Unidades("10902200","OFICINA DOCENTE ETA"));
	}

		public Unidades() {
		super();
	}



	public Unidades(String codigo, String nombreUni, List<Unidades> arrUni,
			List<Unidades> arrUniSelected) {
		super();
		this.codigo = codigo;
		this.nombreUni = nombreUni;
		this.arrUni = arrUni;
		this.arrUniSelected = arrUniSelected;
	}



	public Unidades(String codigo, String nombreUni) {
		super();
		this.codigo = codigo;
		this.nombreUni = nombreUni;
	}



	public Unidades(String codigo, String nombreUni, List<Unidades> arrUni) {
		super();
		this.codigo = codigo;
		this.nombreUni = nombreUni;
		this.arrUni = arrUni;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombreUni() {
		return nombreUni;
	}

	public void setNombreUni(String nombreUni) {
		this.nombreUni = nombreUni;
	}

	public List<Unidades> getArrUni() {
		return arrUni;
	}

	public void setArrUni(List<Unidades> arrUni) {
		this.arrUni = arrUni;
	}

	public List<Unidades> getArrUniSelected() {
		return arrUniSelected;
	}

	public void setArrUniSelected(List<Unidades> arrUniSelected) {
		this.arrUniSelected = arrUniSelected;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
