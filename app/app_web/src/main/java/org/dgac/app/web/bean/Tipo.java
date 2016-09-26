package org.dgac.app.web.bean;

public class Tipo {
private int codTipo;
private String descTipo;



public Tipo(int codTipo, String descTipo) {
	super();
	this.codTipo = codTipo;
	this.descTipo = descTipo;
}
public int getCodTipo() {
	return codTipo;
}
public void setCodTipo(int codTipo) {
	this.codTipo = codTipo;
}
public String getDescTipo() {
	return descTipo;
}
public void setDescTipo(String descTipo) {
	this.descTipo = descTipo;
}


	
}
