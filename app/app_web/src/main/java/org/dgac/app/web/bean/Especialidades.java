package org.dgac.app.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Especialidades implements Serializable {
	private static final long serialVersionUID = 1L;
		private String descEspecialidades;
	private String codEspecialidades;
	private boolean selected;
	private List<Especialidades> Especialidades;

	public Especialidades() {
		
	}

//	private void inicializaEspecialidadess() {
//		Especialidades = new ArrayList<Especialidades>();
//		Especialidades.add(new Especialidades(1, "Avsec"));
//		Especialidades.add(new Especialidades(2, "SSEI"));
//		Especialidades.add(new Especialidades(3, "Controlador de Transito Aereo(CTA)"));
//		Especialidades.add(new Especialidades(4, "xxxxx"));
//	}
	
	public Especialidades( String descEspecialidades,String codEspecialidades) {
		this(codEspecialidades, descEspecialidades,false);
	}
	
	public Especialidades(String codEspecialidades, String descEspecialidades, boolean selected) {
		this.codEspecialidades = codEspecialidades;
		this.descEspecialidades = descEspecialidades;
		this.selected = selected;
	}

	public String getCodEspecialidades() {
		return codEspecialidades;
	}

	public void setCodEspecialidades(String codEspecialidades) {
		this.codEspecialidades = codEspecialidades;
	}

	public String getDescEspecialidades() {
		return descEspecialidades;
	}

	public void setDescEspecialidades(String descEspecialidades) {
		this.descEspecialidades = descEspecialidades;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean chequeado(){
		  if(Especialidades.this.isSelected()==true){
			  return true;
		  }
		  return false;
	}
	
}
