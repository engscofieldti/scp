package org.dgac.app.web.bean;

public class BusinessFactory {

	private static BusinessFactory instance;
	private BusinessFactory(){
		
	}
	
	public static BusinessFactory getInstance(){
		if (instance==null){
			instance = new BusinessFactory();
		}
		return instance;
	}
		

	public ZonaService getZonaService(){
		return new ZonaServiceImpl();
	}
	
	public RemuService getRemuService(){
		return new RemuServiceImpl();
	}
	public AsignacionService getAsignacionService(){
		return new AsignacionServiceImpl();
	}
}
