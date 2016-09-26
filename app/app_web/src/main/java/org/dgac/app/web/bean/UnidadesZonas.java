package org.dgac.app.web.bean;

import java.io.Serializable;

public class UnidadesZonas implements Serializable {
private String codigoUni;
private String uniDes;
private static final long serialVersionUID = 1L;
private boolean selected;


public UnidadesZonas() {
	super();
}
public UnidadesZonas(String codigoUni, String uniDes) {
	super();
	this.codigoUni = codigoUni;
	this.uniDes = uniDes;
}



public String getCodigoUni() {
	return codigoUni;
}
public void setCodigoUni(String codigoUni) {
	this.codigoUni = codigoUni;
}
public String getUniDes() {
	return uniDes;
}
public void setUniDes(String uniDes) {
	this.uniDes = uniDes;
}
public boolean isSelected() {
	return selected;
}
public void setSelected(boolean selected) {
	this.selected = selected;
}

	
	
}
