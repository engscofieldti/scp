package org.dgac.app.web.bean;

import java.io.Serializable;

public class Remuneracion implements Serializable {
private String codigoRemu;
private String remuDesc;
private static final long serialVersionUID = 1L;




public Remuneracion() {
	super();
}



public Remuneracion(String codigoRemu, String remuDesc) {
	super();
	this.codigoRemu = codigoRemu;
	this.remuDesc = remuDesc;
}



public String getCodigoRemu() {
	return codigoRemu;
}
public void setCodigoRemu(String codigoRemu) {
	this.codigoRemu = codigoRemu;
}
public String getRemuDesc() {
	return remuDesc;
}
public void setRemuDesc(String remuDesc) {
	this.remuDesc = remuDesc;
}




	
	
}
