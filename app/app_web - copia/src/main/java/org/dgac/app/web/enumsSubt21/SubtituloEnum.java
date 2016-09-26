package org.dgac.app.web.enumsSubt21;

public enum SubtituloEnum {
	SELECCION("00","Seleccione un Subtítulo"),SUBTITULO21("21","Subtítulo 21"),SUBTITULO22("22","Subtítulo 22"),SUBTITULO23("23","Subtítulo 23");
	private final String codigo;
	private final String nombre;
	private SubtituloEnum(String codigo, String nombre) {
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
