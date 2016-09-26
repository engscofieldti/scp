package org.dgac.app.web.bean;
//import java.beans.Statement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
	
	  List<String> zonas;
	
	

	PanelUsuario pa = new PanelUsuario();
	
	public static Connection obtenerCon() {
		Connection co=null;
	 try{
	        String driver = "org.postgresql.Driver";
	        String con = "jdbc:postgresql://localhost:5433/horas_extra";
	        String user = "postgres";
	        String pass = "canshee";            
	        Class.forName(driver);
	       
	             co=DriverManager.getConnection(con,user,pass);
	         
	        	            
	       }catch(Exception e) {
	    	   e.printStackTrace();
	       }
	     return co;    
	       }
	public static Connection obtenerConViati() {
		Connection co=null;
	 try{
	        String driver = "org.postgresql.Driver";
	        String con = "jdbc:postgresql://localhost:5433/viaticos";
	        String user = "postgres";
	        String pass = "canshee";            
	        Class.forName(driver);
	       
	             co=DriverManager.getConnection(con,user,pass);
	         
	        	            
	       }catch(Exception e) {
	    	   e.printStackTrace();
	       }
	     return co;    
	       }
	
	public static Connection obtenerConeNomina() {
		Connection co=null;
	 try{
	        String driver="oracle.jdbc.driver.OracleDriver";
	        String con="jdbc:oracle:thin:@172.24.2.106:1521:sigerh";
	        String user="consulta_scp";
	        String pass="scp";            
	       Class.forName(driver);
	         co=DriverManager.getConnection(con,user,pass);
	       
	        	            
	       }catch(Exception e) {
	    	   
	       }
	     return co;    
	       }
	
	public static Connection obtenerConeNominaSigerh() {
		Connection co=null;
	 try{
	        String driver="oracle.jdbc.driver.OracleDriver";
	        String con="jdbc:oracle:thin:@172.42.0.24:1521:sigerh1";
	        String user="consulta_scp";
	        String pass="scp";            
	       Class.forName(driver);
	         co=DriverManager.getConnection(con,user,pass);
	       
	        	            
	       }catch(Exception e) {
	    	   
	       }
	     return co;    
	       }
	
	
	
}
