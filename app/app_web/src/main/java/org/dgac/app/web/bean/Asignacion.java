package org.dgac.app.web.bean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Asignacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private String codAsig;
	private String descAsig;
	private boolean selected;
	private List<Asignacion>asignacion;
	
	public Asignacion() {
		super();
	}

	private void inicializaAsignacion() {
		asignacion = new ArrayList<Asignacion>();
	//	asignacion.add(new Asignacion(0, "Todas"));
		asignacion.add(new Asignacion("1", "Horas Extras"));
		asignacion.add(new Asignacion("2", "Viáticos"));
		asignacion.add(new Asignacion("3", "Honorarios"));
		asignacion.add(new Asignacion("4", "Remuneraciones"));
		asignacion.add(new Asignacion("5", "Asignación Traslado"));
	}
	

	public Asignacion(String codAsig, String descAsig) {
		super();
		this.codAsig = codAsig;
		this.descAsig = descAsig;
		
	}


	public String getCodAsig() {
		return codAsig;
	}


	public void setCodAsig(String codAsig) {
		this.codAsig = codAsig;
	}


	public String getDescAsig() {
		return descAsig;
	}


	public void setDescAsig(String descAsig) {
		this.descAsig = descAsig;
	}


	public boolean isSelected() {
		return selected;
	}


	public void setSelected(boolean selected) {
		this.selected = selected;
	}




}
