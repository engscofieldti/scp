package org.dgac.app.web.bean;

import java.io.Serializable;

public class RemuResum implements Serializable {

	private String codRemuResum;
	private String descRemuResum;
	private static final long serialVersionUID = 1L;
	

	
	public String getCodRemuResum() {
		return codRemuResum;
	}



	public void setCodRemuResum(String codRemuResum) {
		this.codRemuResum = codRemuResum;
	}



	public String getDescRemuResum() {
		return descRemuResum;
	}



	public void setDescRemuResum(String descRemuResum) {
		this.descRemuResum = descRemuResum;
	}



	public RemuResum(String codRemuResum, String descRemuResum) {
		super();
		this.codRemuResum = codRemuResum;
		this.descRemuResum = descRemuResum;
	}



	public RemuResum() {
		super();
	}
	
	
	
	
}
