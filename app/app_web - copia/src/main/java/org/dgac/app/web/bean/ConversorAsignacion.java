package org.dgac.app.web.bean;
import javax.faces.convert.Converter;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

	    @FacesConverter(forClass = org.dgac.app.web.bean.Asignacion.class,value="asignacion")
	   
public class ConversorAsignacion implements Converter {
	    	public static List<Asignacion>asigCon;
	    	
	    	 static {
	    		  asigCon = new ArrayList<Asignacion>();
	    		  asigCon.add(new Asignacion(1,"Horas Extras"));
		          asigCon.add(new Asignacion(2,"Viáticos"));
		          asigCon.add(new Asignacion(3,"Honorarios"));
		          asigCon.add(new Asignacion(4,"Remuneraciones"));
		          asigCon.add(new Asignacion(5,"Asignación Traslado"));
		             }
	    	
	    	 public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		          if (submittedValue.trim().equals("")) {
		              return null;
		          } else {
		              try {
		            	  int number4= Integer.parseInt(submittedValue);
		                  for (Asignacion a : asigCon) {
		                      if (a.getCodAsig()== number4) {
		                          return a;
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
		              return String.valueOf(((Asignacion) value).getCodAsig());
		          }
		      }
	    	

}
