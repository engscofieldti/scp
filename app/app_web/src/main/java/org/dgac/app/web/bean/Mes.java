package org.dgac.app.web.bean;

import java.io.Serializable;

public class Mes implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codMes;
	private String descMes;
	private boolean selected;
	
	
	
	public Mes() {
		super();
	}



	public Mes(int codMes, String descMes) {
		super();
		this.codMes = codMes;
		this.descMes = descMes;
	}



	public int getCodMes() {
		return codMes;
	}



	public void setCodMes(int codMes) {
		this.codMes = codMes;
	}



	public String getDescMes() {
		return descMes;
	}



	public void setDescMes(String descMes) {
		this.descMes = descMes;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public boolean isSelected() {
		return selected;
	}



	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
	

}
