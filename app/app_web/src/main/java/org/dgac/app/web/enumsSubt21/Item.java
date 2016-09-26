package org.dgac.app.web.enumsSubt21;

public enum Item {
	REMUNERACION_VARIABLE("1","Remuneración Variable"),OTRAS_REMUNERACIONES("2","Otras Remuneraciones")
	,OTROS_GASTOS_EN_PERSONAL("3","Otros Gastos En Personal"); 
	
	private final String codigo;
	private final String nombre;
	private Item(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	
	
	

}
