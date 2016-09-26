package org.dgac.web.enumsGenericos;

public enum Tipo {
SELECCIONE_UNA_OPCION("Seleccione una opción","sel_opc"),
PRESUPUESTO_APROBADO_POR_LEY("Presupuesto Aprobado Por Ley","pres_apro_ley"),
EJECUCION_PRESUPUESTARIA("Ejecución Presupuestaria","eje_pres");
private final String nombre;
private final String codigo;
private Tipo(String nombre, String codigo) {
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
