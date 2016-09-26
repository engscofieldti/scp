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
	
	
	
	//private List<Integer> mes;
	
	public Filtro(){
		

	    System.out.println("pasa por filtro");
		
		item = new ArrayList<String>();
		subtitulo = new String();
		asignacion = new ArrayList<String>();
		unidadZona = new ArrayList<String>();
		unidadEjec = new ArrayList<String>();
		ano = 0;
		mes = new ArrayList<String>(); //cambiar a string
		//mes = new ArrayList<Integer>();
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
