package org.dgac.app.web.enumsSubt21;

public enum AsignacionEnum {

	HORAS_EXTRAS("1","HORAS_EXTRAS"),VIATICOS("2","VIATICOS"),HONORARIOS("3","HONORARIOS"),REMUNERACIONES("4","REMUNERACIONES"),
	ASIG_TRAS("5","ASIGNACION_TRASLADO"),TEST("","LALALA");
	

	
	private final String codAsig;
	private final String descAsig;
	
	public final String getCodAsig() {
		return codAsig;
	}
	public final String getDescAsig() {
		return descAsig;
	}
	
	public static final AsignacionEnum asignacionEnumByCod(String codAsig) {
		for (AsignacionEnum ae : AsignacionEnum.values()){
			if(ae.getCodAsig().equals(codAsig)){
				return ae;
			}
//			else if(!ae.getCodAsig().equals(codAsig)){
//				return TEST;
//			}
		}
		return VIATICOS;
	}

	private AsignacionEnum(String codAsig, String descAsig) {
		this.codAsig = codAsig;
		this.descAsig = descAsig;
	}
	}
