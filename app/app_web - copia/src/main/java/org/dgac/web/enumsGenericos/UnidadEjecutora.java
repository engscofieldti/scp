package org.dgac.web.enumsGenericos;

public enum UnidadEjecutora {
RECURSOS_HUMANOS("178-Recursos_Humanos","178_rec_hum"),CAPACITACION("179-Capacitación","179_capa"),BENEFICIOS_MEDICOS("180-Beneficios Médicos","180_ben_med"),ETA("183-ETA","183_eta"),
SUBDEPARTAMENTO_PERSONAL("184-Subdepto.Personal","184_subdep_pers"),REMUNERACIONES("185-Remuneraciones","185_remu"),PREVENCION_DE_RIESGOS("187-Prevención de Riesgos","187_prev_ries");
private final String nombre;
private final String codigo;
private UnidadEjecutora(String nombre, String codigo) {
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
