package org.dgac.app.web.bean;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

@ManagedBean(name = "subtitulo")
@ViewScoped

public class Subtitulo implements Serializable {
private static final long serialVersionUID = 5600369132889054255L;
private Integer codigo;
private String nombreSubtitulo;
private List<Subtitulo>arrSubtitulo;
private List<Subtitulo>arrSubtituloSelected;

@PostConstruct
public void init(){
arrSubtitulo = new ArrayList<Subtitulo>();
arrSubtitulo.add(new Subtitulo(21, "Subtítulo 21"));
arrSubtitulo.add(new Subtitulo(22, "Subtítulo 22"));
arrSubtitulo.add(new Subtitulo(23, "Subtítulo 23"));
	
}

public Subtitulo() {
	super();
}

//public List<SelectItem> getArrSubtitulo(){
//    if (arrSubtitulo== null){
//    	arrSubtitulo = new ArrayList<SelectItem>();
//       
//        List<Subtitulo> subtituloList = arrSubtituloSelected();
//        for (Category cat : categoryList){
//            categorias.add(new SelectItem(
//                       cat
//                        , cat.getName()); // value, label, the value to choose and label to appear to the user
//        }
//    }
//    return categorias;
//}


public void recorre(){
	for (Subtitulo temp:arrSubtitulo) {
		System.out.println(temp);
	}
	}

public Subtitulo(Integer codigo, String nombreSubtitulo) {
	super();
	this.codigo = codigo;
	this.nombreSubtitulo = nombreSubtitulo;
}



public Subtitulo(Integer codigo, String nombreSubtitulo,
		List<Subtitulo> arrSubtitulo, List<Subtitulo> arrSubtituloSelected) {
	super();
	this.codigo = codigo;
	this.nombreSubtitulo = nombreSubtitulo;
	this.arrSubtitulo = arrSubtitulo;
	this.arrSubtituloSelected = arrSubtituloSelected;
}



public Integer getCodigo() {
	return codigo;
}



public void setCodigo(Integer codigo) {
	this.codigo = codigo;
}



public String getNombreSubtitulo() {
	return nombreSubtitulo;
}



public void setNombreSubtitulo(String nombreSubtitulo) {
	this.nombreSubtitulo = nombreSubtitulo;
}



public List<Subtitulo> getArrSubtitulo() {
	return arrSubtitulo;
}



public void setArrSubtitulo(List<Subtitulo> arrSubtitulo) {
	this.arrSubtitulo = arrSubtitulo;
}



public List<Subtitulo> getArrSubtituloSelected() {
	return arrSubtituloSelected;
}



public void setArrSubtituloSelected(List<Subtitulo> arrSubtituloSelected) {
	this.arrSubtituloSelected = arrSubtituloSelected;
}



public static long getSerialversionuid() {
	return serialVersionUID;
}





    



@Override
public String toString() {
	return "Subtitulo tostring [arrSubtitulo=" + arrSubtitulo + "]";
}




}
