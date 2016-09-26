package org.dgac.app.web.bean;

import java.io.Serializable;

public class UnidadesResum implements Serializable {

	private int codUniResum;
	private String descUniResum;
	private static final long serialVersionUID = 1L;
	
	public int getCodUniResum() {
		return codUniResum;
	}
	public void setCodUniResum(int codUniResum) {
		this.codUniResum = codUniResum;
	}
	public String getDescUniResum() {
		return descUniResum;
	}
	public void setDescUniResum(String descUniResum) {
		this.descUniResum = descUniResum;
	}
	public UnidadesResum(int codUniResum, String descUniResum) {
		super();
		this.codUniResum = codUniResum;
		this.descUniResum = descUniResum;
	}
	public UnidadesResum() {
		super();
	}
	
	
	
	
}
