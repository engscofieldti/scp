package org.dgac.web.enumsGenericos;

public enum Periodo {
	SELECCIONE_UN_PERIODO("Seleccione un período","sel_per"),MENSUAL("Mensual","per_mens"),ANUAL("Anual","per_anu");
	private final String nombre;
	private final String codigo;
	private Periodo(String nombre, String codigo) {
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
