package org.dgac.app.web.enumsSubt21;

public enum Asignacion {
	HORAS_EXTRAS("1","Horas Extras"),VIATICOS("2","Viáticos"),HONORARIOS("3","Honorarios")
	,REMUNERACIONES("4","Remuneraciones"),ASIGNACION_TRASLADO("5","Asignación Traslado");
	
	private final String codigo;
	private final String nombre;
	private Asignacion(String codigo,String nombre) {
		
		this.codigo = codigo;
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	
		

}
