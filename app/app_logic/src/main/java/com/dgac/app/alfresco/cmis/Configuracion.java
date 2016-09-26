package com.dgac.app.alfresco.cmis;

import java.util.Properties;

public class Configuracion {

	private Properties properties;

	private static Configuracion configuracion;
	
	public void configurar() {
				
		properties = new Properties();
		
		try {
			properties.load(this.getClass().getResourceAsStream("/META-INF/configuracion.properties"));
		} catch (Exception e) {
			System.out.println("No se encontr� el archivo de configuraci�n en el classpath");
		}
		
		configuracion = this;
	}

	public String getProperty(String name) {
		return properties.getProperty(name);
	}

	public static final class ConfiguracionException extends RuntimeException {

		private static final long serialVersionUID = -7275441103151870037L;

		public ConfiguracionException(String mensaje, Exception causa) {
			super(mensaje, causa);
		}
	}

	public static Configuracion getConfiguracion() {
		if (configuracion == null) {
			configuracion = new Configuracion();
			configuracion.configurar();
		}
		return configuracion;
	}
}
