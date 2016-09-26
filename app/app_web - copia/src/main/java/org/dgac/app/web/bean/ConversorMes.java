package org.dgac.app.web.bean;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


	    @FacesConverter(forClass = org.dgac.app.web.bean.Mes.class,value="mes")
	   
	     public class ConversorMes implements Converter {
	      public static List<Mes> mesCon;

	      static {
	    	  mesCon = new ArrayList<Mes>();
	    	  mesCon.add(new Mes(1,"Enero" ));
	    	  mesCon.add(new Mes(2,"Febrero"));
	    	  mesCon.add(new Mes(3,"Marzo"));
	    	  mesCon.add(new Mes(4,"Abril"));
	    	  mesCon.add(new Mes(5,"Mayo"));
	    	  mesCon.add(new Mes(6,"Junio"));
	    	  mesCon.add(new Mes(7,"Julio"));
	    	  mesCon.add(new Mes(8,"Agosto"));
	    	  mesCon.add(new Mes(9,"Septiembre"));
	    	  mesCon.add(new Mes(10,"Octubre"));
	    	  mesCon.add(new Mes(11,"Noviembre"));
	    	  mesCon.add(new Mes(12,"Diciembre"));
	 	          }
	    
	         

	      public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
	          if (submittedValue.trim().equals("")) {
	              return null;
	          } else {
	              try {
	                  int number2 = Integer.parseInt(submittedValue);

	                  for (Mes m : mesCon) {
	                      if (m.getCodMes() == number2) {
	                          return m;
	                      }
	                  }

	              } catch(NumberFormatException exception) {
	                  throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "error de conversion", "Mes no valido"));
	              }
	          }

	          return null;
	      }

	      public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
	          if (value == null || value.equals("")) {
	              return "";
	          } else {
	              return String.valueOf(((Mes)value).getCodMes());
	          }
	      }
	      
	      
	      
	  }
	    
	
