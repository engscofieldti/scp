package org.dgac.web.enumsGenericos;

public enum Mes {
ENERO("Enero","01_ene"),FEBRERO("Febrero","02_feb"),MARZO("Marzo","03_mar"),ABRIL("Abril","04_abr"),MAYO("Mayo","05_may"),JUNIO("Junio","06_jun"),
JULIO("Julio","07_jul"),AGOSTO("Agosto","08_ago"),SEPTIEMBRE("Septiembre","09_sep"),OCTUBRE("Octubre","10_oct"),NOVIEMBRE("Noviembre","11_nov"),DICIEMBRE("Diciembre","12_dic");
private final String nombre;
private final String codigo;
private Mes(String nombre, String codigo) {
	this.nombre = nombre;
	this.codigo = codigo;
}
public String getNombre() {
	return nombre;
}
public String getCodigo() {
	return codigo;
}





}
