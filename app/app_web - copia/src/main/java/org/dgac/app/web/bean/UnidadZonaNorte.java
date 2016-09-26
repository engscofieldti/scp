package org.dgac.app.web.bean;

import java.io.Serializable;

public class UnidadZonaNorte implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String codZonaNorte;
	private String descZonaNorte;
	public String getcodZonaNorte() {
		return codZonaNorte;
	}
	public void setcodZonaNorte(String codZonaNorte) {
		this.codZonaNorte = codZonaNorte;
	}
	public String getdescZonaNorte() {
		return descZonaNorte;
	}
	public void setdescZonaNorte(String descZonaNorte) {
		this.descZonaNorte = descZonaNorte;
	}
	
	
	
	public UnidadZonaNorte() {
		super();
	}
	public UnidadZonaNorte(String codZonaNorte, String descZonaNorte) {
		super();
		this.codZonaNorte = codZonaNorte;
		this.descZonaNorte = descZonaNorte;
	}
	
		
	
}
