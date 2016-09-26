package org.dgac.app.web.bean;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


	    @FacesConverter(forClass = org.dgac.app.web.bean.UnidadesZonas.class,value="unidadesZonas")
	   
	     public class ConversorUnidadesZonas implements Converter {
	      public static List<UnidadesZonas> arrUni;

	      static {
	    	  	arrUni = new ArrayList<UnidadesZonas>();
	    	  	arrUni.add(new UnidadesZonas("11702000","AEROPUERTO GENERAL DIEGO ARACENA"));
		  		arrUni.add(new UnidadesZonas("11702000","IQUIQUE/ AP. DIEGO ARACENA"));
		  		arrUni.add(new UnidadesZonas("11703000","CALAMA/ AD. EL LOA"));
		  		arrUni.add(new UnidadesZonas("11703000","AERODROMO EL LOA"));
		  		arrUni.add(new UnidadesZonas("20005060","AEROPUERTO ANDRES SABELLA"));
		  		arrUni.add(new UnidadesZonas("11700000","SUBDEPARTAMENTO ZONA AEROPORTUARIA NORTE COMERCIAL"));
		  		arrUni.add(new UnidadesZonas("11700000","SUBDPTO. ZONA AEROPORTUARIA NORTE"));
		  		arrUni.add(new UnidadesZonas("11708000","ATACAMA/ AD. DESIERTO DE ATACAMA"));
		  		arrUni.add(new UnidadesZonas("11708000","AERODROMO DESIERTO DE ATACAMA"));
		  		arrUni.add(new UnidadesZonas("11802000","AERODROMO LA FLORIDA"));
		  		arrUni.add(new UnidadesZonas("11802000","LA SERENA/ AD. LA FLORIDA"));
		  		arrUni.add(new UnidadesZonas("11803000","AERODROMO MATAVERI"));
		  		arrUni.add(new UnidadesZonas("11803000","ISLA DE PASCUA/ AP. MATAVERI"));
		  		arrUni.add(new UnidadesZonas("11806000","VIÑA DEL MAR/ AD. VIÑA DEL MAR"));
		  		arrUni.add(new UnidadesZonas("11806000","AERODROMO VIÑA DEL MAR"));
		  		arrUni.add(new UnidadesZonas("11800000","SUBDPTO. ZONA AEROPORTUARIA CENTRAL"));
		  		arrUni.add(new UnidadesZonas("11800000","SUBDEPARTAMENTO ZONA AEROPORTTUARIA CENTRAL"));
		  		arrUni.add(new UnidadesZonas("11808000","SANTIAGO/ AD. EULOGIO SÁNCHEZ"));
		  		arrUni.add(new UnidadesZonas("11808000","AERODROMO EULOGIO SANCHEZ"));
		  		arrUni.add(new UnidadesZonas("11813000","CONCEPCIÓN/ AD. CARRIEL SUR"));
		  		arrUni.add(new UnidadesZonas("11813000","AERODROMO CARRIEL SUR"));
		  		arrUni.add(new UnidadesZonas("10700000","DEPARTAMENTO METEOROLOGICA DE CHILE"));
		  		arrUni.add(new UnidadesZonas("11001000","AEROPUERTO ARTURO MERINO BENITEZ"));
		  		arrUni.add(new UnidadesZonas("11001000","SANTIAGO/ AMB"));
		  		arrUni.add(new UnidadesZonas("10801400","SECCION SERVICIOS GENERALES LOGISTICA"));
		  		arrUni.add(new UnidadesZonas("11000000","SANTIAGO/ DASA"));
		  		arrUni.add(new UnidadesZonas("11000000","DEPARTAMENTO AERODROMOS Y SERVICIOS AERONAUTICOS"));
		  		arrUni.add(new UnidadesZonas("11900000","SECCION ZONA AEROPORTUARIA SUR"));
		  		arrUni.add(new UnidadesZonas("11900000","SUBDPTO. ZONA AEROPORTUARIA SUR"));
		  		arrUni.add(new UnidadesZonas("20005027","AERODROMO LA ARAUCANIA"));
		  		arrUni.add(new UnidadesZonas("20005027","TEMUCO/ AD. LA ARAUCANÍA"));
		  		arrUni.add(new UnidadesZonas("11902000","AERODROMO PICHOY"));
		  		arrUni.add(new UnidadesZonas("11902000","VALDIVIA/ AD. PICHOY"));
		  		arrUni.add(new UnidadesZonas("11903000","OSORNO/ AD. CAÑAL BAJO"));
		  		arrUni.add(new UnidadesZonas("11903000","AERODROMO CAÑAL BAJO"));
		  		arrUni.add(new UnidadesZonas("11904000","PTO. MONTT / AP. EL TEPUAL"));
		  		arrUni.add(new UnidadesZonas("11904000","AEROPUERTO EL TEPUAL"));
		  		arrUni.add(new UnidadesZonas("11913000","BALMACEDA/ AD. BALMACEDA"));
		  		arrUni.add(new UnidadesZonas("11913000","AERODROMO BALMACEDA"));
		  		arrUni.add(new UnidadesZonas("12000000","SUBDPTO. ZONA AEROPORTUARIA AUSTRAL"));
		  		arrUni.add(new UnidadesZonas("12000000","SECCION ZONA AEROPORTUARIA AUSTRAL"));
		  		arrUni.add(new UnidadesZonas("12001000","AEROPUERTO CARLOS IBAÑEZ DEL CAMPO"));
		  		arrUni.add(new UnidadesZonas("12001000","PTA. ARENAS/ AP. CARLOS IBAÑEZ DEL CAMPO"));
		  		arrUni.add(new UnidadesZonas("10904300","OFICINA BIENESTAR B. SOCIAL"));
		  		arrUni.add(new UnidadesZonas("10902200","OFICINA DOCENTE ETA"));
	      }
	    	  
	    	    	  
	    
	         

	      public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
	          if (submittedValue.trim().equals("")) {
	              return null;
	          } else {
	              try {
	                  String pal =(submittedValue);

	                  for (UnidadesZonas uz : arrUni) {
	                      if (uz.getCodigoUni() == pal) {
	                          return uz;
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
	              return String.valueOf(((UnidadesZonas)value).getCodigoUni());
	          }
	      }
	      	  
	    
	      
	  }
	    
	
