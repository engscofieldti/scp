package org.dgac.app.web.enumsSubt21;

public enum RemuVarEnum {

	TODAS ("0","TODAS"),SUELDO("1","SUELDO"),BENEF_MODER("2","BENEF_MODER"),GRADO_EFECTIVO("3","GRADO_EFECTIVO"),CRECIM_VEGE("4","CRECIM_VEGE"),HORAS_EXTRAS("5","HORAS_EXTRAS"),
	ESP_NOCIV_PELI("6","ESP_NOCIV_PELI"),MAQUINA("7","MAQUINA"),BONOS("8","BONOS"),ISLA_DE_PASCUA("9","ISLA_DE_PASCUA"),
	ZONA_EXTREMA("10","ZONA_EXTREMA"),ANTARTICA("11","ANTARTICA"),HONORARIOS("12","HONORARIOS"),HORAS_PROFE_ETA("13","HORAS_PROFE_ETA"),MEDICOS("14","MEDICOS");
	
	
	private final String codRemuVar;
	private final String descRemuVar;
	
	
	
	public final String getCodRemuVar() {
		return codRemuVar;
	}
	public final String getDescRemuVar() {
		return descRemuVar;
	}
	public static final RemuVarEnum remuVariableEnumByCod(String codigoRemu) {
		for (RemuVarEnum rv : RemuVarEnum.values()){
			if(rv.getCodRemuVar().equals(codigoRemu)){
				return rv;
			}
		}
		return SUELDO;
	}
	private RemuVarEnum(String codRemuVar, String descRemuVar) {
		this.codRemuVar = codRemuVar;
		this.descRemuVar = descRemuVar;
	}

	
	
	
	}
