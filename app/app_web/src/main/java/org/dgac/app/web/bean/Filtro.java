package org.dgac.app.web.bean;

import java.util.ArrayList;
import java.util.List;

public class Filtro {

	private List<String> item;
	private String subtitulo;
	private List<String> asignacion;
	private List<String> unidadZona;
	private List<String> unidadEjec;
	private int ano;
	private List<String> mes;
	private String tipo;
	private List<String>remuVar;
	private List<String>remuResum;
	private List<String> unidadTodas;
	private List<String> unidadZonaNorte;
	private List<String> unidadZonaCentro;
	private List<String> unidadDmc;
	private List<String> unidadAmb;
	private List<String> unidadLogistica;
	private List<String> unidadDasa;
	private List<String> unidadZonaSur;
	private List<String> unidadZonaAustral;
	private List<String> unidadOtras;
	private List<String> uniResum;
	private List<String> especialidades;
	private List<String>unidHHEE;
	private LoginBean2 logBean2= new LoginBean2();
	private SistemaBean sistemaBean=null;
	LoginBean2 loginBean2= new LoginBean2(logBean2.getUser());
	private Boolean renderBool;
	
	
	// private String user="";

	
	//private List<Integer> mes;
	
	public Filtro(){
		versionPF();
			String pal="hola mundo"; 
			System.out.println("1"+pal);
			pal= "\'hola mundo\'";
			System.out.println("2"+pal);
			System.out.println("pasa por filtro");
		
	    System.out.println("usuario conectado x2:"+loginBean2.getsession2());
	 	item = new ArrayList<String>();
		subtitulo = new String();
		asignacion = new ArrayList<String>();
		unidadZona = new ArrayList<String>();
		unidadEjec = new ArrayList<String>();
		ano = 0;
		mes = new ArrayList<String>(); //cambiar a string
		tipo= new String();
		unidadZonaNorte=new ArrayList<String>();
		unidadZonaCentro=new ArrayList<String>();
		unidadDmc=new ArrayList<String>();
		unidadAmb=new ArrayList<String>();
		unidadLogistica=new ArrayList<String>();
		unidadDasa=new ArrayList<String>();
		unidadZonaSur=new ArrayList<String>();
		unidadZonaAustral=new ArrayList<String>();
		unidadOtras=new ArrayList<String>();
		uniResum=new ArrayList<String>();
		especialidades = new ArrayList<String>();
		unidHHEE=new ArrayList<String>(); 
		remuVar= new ArrayList<String>();
		remuResum= new ArrayList<String>();
		unidadTodas = new ArrayList<String>();
		renderBool = new Boolean(false);
		//renderFiltro();
		}

	
	
	public List<String> getUniResum() {
		return uniResum;
	}



	public void setUniResum(List<String> uniResum) {
		this.uniResum = uniResum;
	}



	public List<String> getUnidHHEE() {
		return unidHHEE;
	}



	public void setUnidHHEE(List<String> unidHHEE) {
		this.unidHHEE = unidHHEE;
	}



	public List<String> getRemuResum() {
		return remuResum;
	}



	public void setRemuResum(List<String> remuResum) {
		this.remuResum = remuResum;
	}



	public List<String> getremuVar() {
		return remuVar;
	}

	public void setremuVar(List<String> remuVar) {
		this.remuVar = remuVar;
	}

	public void versionPF(){
	System.out.println("la version de primefaces : "+Package.getPackage("com.sun.faces").getImplementationVersion());
	}
	
	
	public Boolean renderFiltro(){
//	if(this.getAsignacion().isEmpty()){
//		return false;
//		}
//	else if(!this.getAsignacion().isEmpty()){
//		 return true;
//		}
//	return getRenderBool();
		
		if(this.getAsignacion().contains("1")){
				return true;
		}
		else if (!this.getAsignacion().contains("1")){ 
				return false;
		}
			  return (Boolean) null;
		}
	
	
	public List<String> getUnidadTodas(){
		return unidadTodas;
	}

	public void setUnidadTodas(List<String> unidadTodas) {
		this.unidadTodas = unidadTodas;
	}

	public Boolean getRenderBool() {
		return renderFiltro();
	}
	
	public void setRenderBool(Boolean renderBool) {
		this.renderBool = renderBool;
	}


		public LoginBean2 getLogBean2() {
		return logBean2;
	}

	public void setLogBean2(LoginBean2 logBean2) {
		this.logBean2 = logBean2;
	}

	public LoginBean2 getLoginBean2() {
		return loginBean2;
	}


	public void setLoginBean2(LoginBean2 loginBean2) {
		this.loginBean2 = loginBean2;
	}

		public SistemaBean getSistemaBean() {
		return sistemaBean;
	}

	public void setSistemaBean(SistemaBean sistemaBean) {
		this.sistemaBean = sistemaBean;
	}


		public String getSubtitulo() {
		return subtitulo;
	}
	
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}
	public List<String> getItem() {
		return item;
	}
	public void setItem(List<String> item) {
		this.item = item;
	}
	public List<String> getAsignacion() {
		return asignacion;
	}
	public void setAsignacion(List<String> asignacion) {
		this.asignacion = asignacion;
	}
	public List<String> getUnidadZona() {
		return unidadZona;
	}
	public void setUnidadZona(List<String> unidadZona) {
		this.unidadZona = unidadZona;
	}
	public List<String> getUnidadEjec() {
		return unidadEjec;
	}
	public void setUnidadEjec(List<String> unidadEjec) {
		this.unidadEjec = unidadEjec;
			
	}
	
		
	public List<String> getEspecialidades() {
		return especialidades;
	}
	
	
	public void setEspecialidades(List<String> especialidades) {
		this.especialidades = especialidades;
	}


	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public List<String> getMes() {
		return mes;
	}
	public void setMes(List<String> mes) {
		this.mes = mes;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<String> getUnidadZonaNorte() {
		return unidadZonaNorte;
	}


	public void setUnidadZonaNorte(List<String> unidadZonaNorte) {
		this.unidadZonaNorte = unidadZonaNorte;
	}


	public List<String> getUnidadZonaCentro() {
		return unidadZonaCentro;
	}


	public void setUnidadZonaCentro(List<String> unidadZonaCentro) {
		this.unidadZonaCentro = unidadZonaCentro;
	}


	public List<String> getUnidadDmc() {
		return unidadDmc;
	}


	public void setUnidadDmc(List<String> unidadDmc) {
		this.unidadDmc = unidadDmc;
	}


	public List<String> getUnidadAmb() {
		return unidadAmb;
	}


	public void setUnidadAmb(List<String> unidadAmb) {
		this.unidadAmb = unidadAmb;
	}


	public List<String> getUnidadLogistica() {
		return unidadLogistica;
	}


	public void setUnidadLogistica(List<String> unidadLogistica) {
		this.unidadLogistica = unidadLogistica;
	}


	public List<String> getUnidadDasa() {
		return unidadDasa;
	}


	public void setUnidadDasa(List<String> unidadDasa) {
		this.unidadDasa = unidadDasa;
	}


	public List<String> getUnidadZonaSur() {
		return unidadZonaSur;
	}


	public void setUnidadZonaSur(List<String> unidadZonaSur) {
		this.unidadZonaSur = unidadZonaSur;
	}


	public List<String> getUnidadZonaAustral() {
		return unidadZonaAustral;
	}


	public void setUnidadZonaAustral(List<String> unidadZonaAustral) {
		this.unidadZonaAustral = unidadZonaAustral;
	}


	public List<String> getUnidadOtras() {
		return unidadOtras;
	}


	public void setUnidadOtras(List<String> unidadOtras) {
		this.unidadOtras = unidadOtras;
	}


	public List<String> getuniResum() {
		return uniResum;
	}


	public void setuniResum(List<String> uniResum) {
		this.uniResum = uniResum;
	}
	
		
}
