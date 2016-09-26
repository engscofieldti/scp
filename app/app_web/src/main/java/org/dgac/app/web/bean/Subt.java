package org.dgac.app.web.bean;

import java.io.Serializable;

public class Subt implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer cod;
	private String nomSub;
	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	public String getNomSub() {
		return nomSub;
	}
	public void setNomSub(String nomSub) {
		this.nomSub = nomSub;
	}
	
	
	
	public Subt() {
		super();
	}
	public Subt(Integer cod, String nomSub) {
		super();
		this.cod = cod;
		this.nomSub = nomSub;
	}
	
		
	
}
