package org.dgac.app.web.enumsSubt21;

public enum ZonaResumEnum {

	NORTE("1","ZONA_NORTE"),CENTRO("2","ZONA_CENTRO"),AMB("3","AMB"),DMC("4","DMC"),LOGISTICA("5","LOGISTICA"),
	DASA("6","DASA"),SUR("7","ZONA_SUR"),AUSTRAL("8","ZONA_AUSTRAL"),OTRAS("9","OTRAS");
	
	
	private final String codZonaResum;
	private final String descZonaResum;
	
	public final String getCodZonaResum() {
		return codZonaResum;
	}
	public final String getDescZonaResum() {
		return descZonaResum;
	}
	public static final ZonaResumEnum zonaResumenEnumByCod(String codigoZona) {
		for (ZonaResumEnum zr : ZonaResumEnum.values()){
			if(zr.getCodZonaResum().equals(codigoZona)){
				return zr;
			}
		}
		return NORTE;
	}
	private ZonaResumEnum(String codZonaResum, String descZonaResum) {
		this.codZonaResum = codZonaResum;
		this.descZonaResum = descZonaResum;
	}
	}
