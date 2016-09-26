package org.dgac.app.web.bean;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = org.dgac.app.web.bean.Item.class,value="item")
public class ConversorItem implements Converter {
	public static List<Item> itemCon;
	
	  static {
    	  itemCon = new ArrayList<Item>();
    	  itemCon.add(new Item(1,"Remuneración Variable",false));
    	  itemCon.add(new Item(2,"Otras Remuneraciones",false));
    	  itemCon.add(new Item(3,"Otros Gastos En Personal",false));
    	  	  }
	  
	   public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
	          if (submittedValue.trim().equals("")) {
	              return null;
	          } else {
	              try {
	                  int number3 = Integer.parseInt(submittedValue);

	                  for (Item i : itemCon) {
	                      if (i.getCodItem() == number3) {
	                          return i;
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
	              return String.valueOf(((Item)value).getCodItem());
	          }
	      }
    
	

}
