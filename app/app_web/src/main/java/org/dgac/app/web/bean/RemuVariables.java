package org.dgac.app.web.bean;

import java.io.Serializable;

public class RemuVariables implements Serializable {
private String codigoRemu;
private String remuDes;
private static final long serialVersionUID = 1L;


public RemuVariables() {
	super();
}


public RemuVariables(String codigoRemu, String remuDes) {
	super();
	this.codigoRemu = codigoRemu;
	this.remuDes = remuDes;
}


public String getCodigoRemu() {
	return codigoRemu;
}


public void setCodigoRemu(String codigoRemu) {
	this.codigoRemu = codigoRemu;
}


public String getRemuDes() {
	return remuDes;
}


public void setRemuDes(String remuDes) {
	this.remuDes = remuDes;
}


	
	
}
