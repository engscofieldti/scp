package org.dgac.app.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

public class UnidadEjecutora implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer codUniEje;
	private String descUniEje;
	private List<UnidadEjecutora>uniEjec;
	
	@PostConstruct
	public void init(){
		uniEjec= new ArrayList<UnidadEjecutora>();
		uniEjec.add(new UnidadEjecutora(178, "178 - Recursos Humanos"));
		uniEjec.add(new UnidadEjecutora(179, "179 - Capacitación"));
		uniEjec.add(new UnidadEjecutora(180, "180 - Beneficios Médicos"));
		uniEjec.add(new UnidadEjecutora(183, "183 - ETA"));
		uniEjec.add(new UnidadEjecutora(184, "184 - Subdepto.Personal"));
		uniEjec.add(new UnidadEjecutora(185, "185 - Remuneraciones"));
		uniEjec.add(new UnidadEjecutora(187, "187 - Prevención de Riesgos"));
	}
	
	public UnidadEjecutora(Integer codUniEje, String descUniEje) {
		super();
		this.codUniEje = codUniEje;
		this.descUniEje = descUniEje;
	}


	public Integer getCodUniEje() {
		return codUniEje;
	}


	public void setCodUniEje(Integer codUniEje) {
		this.codUniEje = codUniEje;
	}


	public String getDescUniEje() {
		return descUniEje;
	}


	public void setDescUniEje(String descUniEje) {
		this.descUniEje = descUniEje;
	}
	
	
	
	

}
