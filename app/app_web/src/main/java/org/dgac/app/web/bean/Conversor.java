package org.dgac.app.web.bean;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

	    @FacesConverter(forClass = org.dgac.app.web.bean.Subt.class,value="subt")
	   
	     public class Conversor implements Converter{
	      public static List<Subt> subtCon;

	      static {
	          subtCon = new ArrayList<Subt>();
	          subtCon.add(new Subt(21, "Subtítulo 21"));
	          subtCon.add(new Subt(22, "Subtítulo 22"));
	          subtCon.add(new Subt(23, "Subtítulo 23"));
	 	          }

	      public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
	          if (submittedValue.trim().equals("")) {
	              return null;
	          } else {
	              try {
	                  int number = Integer.parseInt(submittedValue);

	                  for (Subt s : subtCon) {
	                      if (s.getCod() == number) {
	                          return s;
	                      }
	                  }

	              } catch(NumberFormatException exception) {
	                  throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "error de conversion", "Subtitulo no valido"));
	              }
	          }

	          return null;
	      }

	      public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
	          if (value == null || value.equals("")) {
	              return "";
	          } else {
	              return String.valueOf(((Subt) value).getCod());
	          }
	      }
	  }
	
	
	
	

