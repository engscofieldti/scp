package org.dgac.app.web.bean;

import java.io.Serializable;

public class UnidadesResum implements Serializable {

	private String codUniResum;
	private String descUniResum;
	private static final long serialVersionUID = 1L;
	
	public UnidadesResum(String codUniResum, String descUniResum) {
		super();
		this.codUniResum = codUniResum;
		this.descUniResum = descUniResum;
	}
	public UnidadesResum() {
		super();
	}
	//CAMBIE DE String A STRING, LUEGO VOLVER A STRING CODUNIRESUM
	public String getCodUniResum() {
		return codUniResum;
	}
	public void setCodUniResum(String codUniResum) {
		this.codUniResum = codUniResum;
	}
	public String getDescUniResum() {
		return descUniResum;
	}
	public void setDescUniResum(String descUniResum) {
		this.descUniResum = descUniResum;
	}

	
	
	
	
}
