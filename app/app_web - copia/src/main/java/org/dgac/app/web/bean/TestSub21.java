package org.dgac.app.web.bean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;



 

@ManagedBean(name = "testSub21")
@ViewScoped
	
	public class TestSub21 implements Serializable {
	 
	    private boolean value1; 
	    private boolean value2;
	    private List<String>  itemSelec;
	    private String[]itemSelec2;
		private List<String> item;
		
		private static final long serialVersionUID = 5600369132889054255L;
	
		@PostConstruct
		public void init() {
			item= new ArrayList<String>();
			item.add("Remuneración Variable");
			item.add("Otras Remuneraciones");
			item.add("Otros Gastos En Personal");
		}
	     
	   
		

		public String[] getItemSelec2() {
			return itemSelec2;
		}




		public void setItemSelec2(String[] itemSelec2) {
			this.itemSelec2 = itemSelec2;
		}




		public static long getSerialversionuid() {
			return serialVersionUID;
		}




		public List<String> getItemSelec() {
			return itemSelec;
		}




		public void setItemSelec(List<String> itemSelec) {
			this.itemSelec = itemSelec;
		}




		public List<String> getItem() {
			return item;
		}




		public void setItem(List<String> item) {
			this.item = item;
		}




		public boolean isValue1() {
	        return value1;
	    }
	 
	    public void setValue1(boolean value1) {
	        this.value1 = value1;
	    }
	 
	    public boolean isValue2() {
	        return value2;
	    }
	 
	    public void setValue2(boolean value2) {
	        this.value2 = value2;
	    }
	    
	    
//	     
//	    @Override
//		public String toString() {
//			return "TestSub21 [item=" + item + "]";
//		}

		public void addMessage() {
	        String summary = value2 ? "Checked" : "Unchecked";
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
	    }
	}
	


