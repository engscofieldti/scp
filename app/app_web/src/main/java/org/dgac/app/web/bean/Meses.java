package org.dgac.app.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "meses")
@ViewScoped
public class Meses implements Serializable {

	private static final long serialVersionUID = 5600369132889054255L;
	private String mes;
	private Integer mesNumero;
    private List<Meses>mesDecode;
    private List<String>mesDecodeSelected;
    public List<Integer>numeroTest;
    @PostConstruct
	public void init() {
    	mesDecode= new ArrayList<Meses>();
    	mesDecode.add(new Meses("Enero",1));
    	mesDecode.add(new Meses("Febrero",2));
    	mesDecode.add(new Meses("Marzo",3));
    	mesDecode.add(new Meses("Abril",4));
    	mesDecode.add(new Meses("Mayo",5));
    	mesDecode.add(new Meses("Junio",6));
    	mesDecode.add(new Meses("Julio",7));
    	mesDecode.add(new Meses("Agosto",8));
    	mesDecode.add(new Meses("Septiembre",9));
    	mesDecode.add(new Meses("Octubre",10));
    	mesDecode.add(new Meses("Noviembre",11));
    	mesDecode.add(new Meses("Diciembre",12));
    	numeroTest= new ArrayList<Integer>();
    	numeroTest.add(1);
    	numeroTest.add(2);
    	numeroTest.add(3);
    	
    	
    }
    
    	public Meses() {
		super();
	}



	public Meses(String mes, Integer mesNumero, List<Meses> mesDecode,
				List<String> mesDecodeSelected, List<Integer> numeroTest) {
			super();
			this.mes = mes;
			this.mesNumero = mesNumero;
			this.mesDecode = mesDecode;
			this.mesDecodeSelected = mesDecodeSelected;
			this.numeroTest = numeroTest;
		}

	public Meses(String mes, Integer mesNumero) {
		super();
		this.mes = mes;
		this.mesNumero = mesNumero;
	}



	public Meses(String mes, Integer mesNumero, List<Meses> mesDecode) {
		super();
		this.mes = mes;
		this.mesNumero = mesNumero;
		this.mesDecode = mesDecode;
	}



	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public Integer getMesNumero() {
		return mesNumero;
	}

	public void setMesNumero(Integer mesNumero) {
		this.mesNumero = mesNumero;
	}



	public List<Meses> getMesDecode() {
		return mesDecode;
	}


	public void setMesDecode(List<Meses> mesDecode) {
		this.mesDecode = mesDecode;
	}



	public List<String> getMesDecodeSelected() {
		return mesDecodeSelected;
	}

	public void setMesDecodeSelected(List<String> mesDecodeSelected) {
		this.mesDecodeSelected = mesDecodeSelected;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Integer> getNumeroTest() {
		return numeroTest;
	}

	public void setNumeroTest(List<Integer> numeroTest) {
		this.numeroTest = numeroTest;
	}
	
    
    
	
}
