package org.dgac.app.web.bean;

import java.beans.Statement;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.util.logging.Level;



//import java.io.*;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dgac.app.logic.ejb.sistema.SistemaEJBLocal;
import org.dgac.app.logic.ejb.sistema.SistemaEJBRemote;
import org.dgac.app.web.security.LoginBean;
import org.dgac.app.web.util.FacesAccesor;
import org.dgac.app.web.util.UtilSession;
import org.dgac.common.dto.LogDTO;
import org.dgac.common.dto.ResultActiveDirectoryDTO;
import org.dgac.common.dto.RolDTO;
import org.dgac.common.enums.LevelEnum;
import org.dgac.common.enums.RolEnum;
import org.dgac.common.util.ServiceLocator;
import org.dgac.common.util.ServiceLocatorRemote;
import org.primefaces.context.RequestContext;

import com.sun.mail.iap.Response;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


// TODO: Auto-generated Javadoc
/**
 * The Class SistemaBean.
 */
@ManagedBean(name = "sistemaBean")
@SessionScoped
public class SistemaBean extends BeanGenerico implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	private static final Log LOGGER = LogFactory.getLog(SistemaBean.class);

	/** The sistema ejb. */
	private SistemaEJBRemote sistemaEJB;	

	/** The txt password. */
	private String txtPassword;
	
	/** The txt usr name. */
	private String txtUsrName;
	
	private List<RolDTO>listaRoles;
	
	
	
	/**
	 * Inits the.
	 */
	@PostConstruct
	public void init() {

		sistemaEJB = (SistemaEJBRemote) ServiceLocatorRemote.getInstance().getEjb(SistemaEJBRemote.class);
		listaRoles=new ArrayList<RolDTO>();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("busquedaBean", null);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cargaBean", null);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("mantenedorBean", null);
		//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sistemaBean", null);
	}

	/**
	 * Redirect bandeja.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	

	public void loginMu() throws IOException{
		if(txtUsrName != null && txtUsrName.equals("admin") && txtPassword != null && txtPassword.equals("admin")) {
		FacesContext.getCurrentInstance().getExternalContext().redirect("panelUsuario.jsf");
		}
	else{
		FacesContext.getCurrentInstance().getExternalContext().redirect("sinAcceso.jsf");
	}
	}
	
	
	
	
	public void loginMula() {
	
		try
		{
						
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Haz ingresado al sistema como usuario invitado. Solo tienes privilegios para visualizar los documentos.");
	        RequestContext.getCurrentInstance().showMessageInDialog(message);
			LoginBean loginBean = (LoginBean) FacesAccesor.getManagedBean("loginBean");
			HttpSession session = UtilSession.getSession();
			session.setAttribute("rol", "USUARIO");
			loginBean.setToViewMenu("menu_usuario.xhtml");
			loginBean.setToViewMenu("menu_usuario.xhtml"); loginBean.setToViewMenu("panelUsuario.xhtml");
			loginBean.navigateTo("/portal/consultaUsuario.xhtml");
	     	FacesContext.getCurrentInstance().getExternalContext().redirect("panelUsuario.jsf");
			
		}
		catch(Exception e)
		{
			//FacesContext.getCurrentInstance().getExternalContext().redirect("sinAcceso.jsf");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ha ocurrido un error al ingresar al sistema.");
	         
	        RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
	}
	
	public void loginMensaje() throws IOException {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
         
        if(txtUsrName != null && txtUsrName.equals("admin") && txtPassword != null && txtPassword.equals("admin")) {
            loggedIn = true;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ingreso Correcto", "Bienvenido."));
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", txtUsrName);
            FacesContext.getCurrentInstance().getExternalContext().redirect("panelUsuario.jsf");
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error de ingreso", "Clave invalida");
            FacesContext.getCurrentInstance().getExternalContext().redirect("sinAcceso.jsf");
            //            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ingreso Incorrecto", "Vuelva a ingresar."));
//            return;
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
      
    }   
	
	public void enviar() {
			try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("testsub21tablasColorSigerh2.jsf");	
		} catch (IOException e) {
		}
			}
	
	
	public void loginMula2() {
		try
		{
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Haz ingresado al sistema como usuario invitado. Solo tienes privilegios para visualizar los documentos.");
	        RequestContext.getCurrentInstance().showMessageInDialog(message);
			LoginBean loginBean = (LoginBean) FacesAccesor.getManagedBean("loginBean");
			HttpSession session = UtilSession.getSession();
			session.setAttribute("rol", "USUARIO");
			loginBean.setToViewMenu("menuSeleccionSubt21.xhtml");
	        //loginBean.setToViewMenu("menu_usuario.xhtml");
			loginBean.navigateTo("/portal/consultaUsuario.xhtml");
			FacesContext.getCurrentInstance().getExternalContext().redirect("common.jsf");
			//HttpServletRequest request = ((HttpServletRequest) (FacesContext.getCurrentInstance().getExternalContext().getRequest()));
			//HttpServletResponse response = ((HttpServletResponse) (FacesContext.getCurrentInstance().getExternalContext().getResponse()));
			//request.getRequestDispatcher("faces/menuSeleccion.xhtml").forward(request, response);
		}
		catch(Exception e)
		{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ha ocurrido un error al ingresar al sistema.");
	         
	        RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
	}
	
	/*
	public void loginn(ActionEvent actionEvent){
	
			RequestContext context = RequestContext.getCurrentInstance();
			FacesMessage msg = null;
			if (txtUsrName != null && txtUsrName.equals("admin") && txtPassword != null
				     && txtPassword.equals("admin")) {
				     logeado = true;
				      msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", txtUsrName);
				      } 
			 else {
			logeado = false;
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error",
			"Credenciales no válidas");
			}
			FacesContext.getCurrentInstance().addMessage(null, msg);
			context.addCallbackParam("estaLogeado", logeado);
			if (logeado)
			context.addCallbackParam("view", "gauge.xhtml");
			}
		*/
		
	
	public String cancel() {
		 FacesContext.getCurrentInstance().addMessage(null,
		  new FacesMessage("BIENVENIDO"));
		// return "/app_web/src/main/webapp/menuSeleccion.xhtml";
		 return "portal/cargar.xhtml";
		}
	


	
	public void buttonAction(ActionEvent actionEvent) {
        addMessage("Welcome to Primefaces!!");
    }
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public void login() throws IOException {
		
		try
		{
			ResultActiveDirectoryDTO adirectory=new ResultActiveDirectoryDTO();
			adirectory=sistemaEJB.loginActiveDirectory(txtUsrName.trim(), txtPassword.trim());
			List<RolDTO>rolesConsulta=new ArrayList<RolDTO>();
			listaRoles=sistemaEJB.returnRolesTramites(txtUsrName);
			if(adirectory.isStatus())
			{
				for(String grupo:adirectory.getNombreGrupos())
				{
					
					for(RolDTO rol:listaRoles)
					{
						if(grupo.equals(rol.getRol_nombre()))
						{
							rolesConsulta.add(rol);
						}
					}
					

				}
				
				
				if(rolesConsulta.size()>0)
				{
					LoginBean loginBean = (LoginBean) FacesAccesor.getManagedBean("loginBean");

					for(RolDTO r:rolesConsulta)
					{
						if(r.getRol_nombre().equals(RolEnum.ADMIN.getId()))
						{
							HttpSession session = UtilSession.getSession();
							session.setAttribute("rol", String.valueOf(r.getRol_nombre()));
							loginBean.setToViewMenu("menu_admin.xhtml");
							loginBean.navigateTo("/portal/inicio.xhtml");
							FacesContext.getCurrentInstance().getExternalContext().redirect("common.jsf");
						}
						else
						{
							if(r.getRol_nombre().equals(RolEnum.SUPERADMIN.getId()))
							{
								HttpSession session = UtilSession.getSession();
								session.setAttribute("rol", String.valueOf(r.getRol_id()));
								loginBean.setToViewMenu("menu_admin.xhtml");
								loginBean.navigateTo("/portal/inicio.xhtml");
								FacesContext.getCurrentInstance().getExternalContext().redirect("common.jsf");
							}
							else
							{
								FacesContext.getCurrentInstance().getExternalContext().redirect("sinAcceso.jsf");
							}
							
						}
					}
					HttpSession session = UtilSession.getSession();
					session.setAttribute("usuario", txtUsrName);
					HttpSession sessionFuncionario = UtilSession.getSession();
					sessionFuncionario.setAttribute("funcionario", adirectory.getFuncionario());	
				}
				else
				{
					FacesContext.getCurrentInstance().getExternalContext().redirect("sinAcceso.jsf");

				}
				
							
			}
			else
			{
				FacesContext.getCurrentInstance().getExternalContext().redirect("sinAcceso.jsf");
			}

		}
		catch(Exception e)
		{
			sistemaEJB.registroLog(new LogDTO(txtUsrName, SistemaBean.class.getSimpleName()+"[CatchLogin]", LevelEnum.ERR.getId(), e.getMessage()));
			LOGGER.error("Error al ejecutar el loginActiveDirectory [redirectBandeja]",e);
		}
	}


	public void redirectNoLogin()
	{
		try
		{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Haz ingresado al sistema como usuario invitado. Solo tienes privilegios para visualizar los documentos.");
	        RequestContext.getCurrentInstance().showMessageInDialog(message);
			LoginBean loginBean = (LoginBean) FacesAccesor.getManagedBean("loginBean");
			HttpSession session = UtilSession.getSession();
			session.setAttribute("rol", "USUARIO");
			loginBean.setToViewMenu("menu_usuario.xhtml");
			loginBean.navigateTo("/app_web/src/main/webapp/portal/consultaUsuario.xhtml");
			//loginBean.navigateTo("/portal/consultaUsuario.xhtml");
			FacesContext.getCurrentInstance().getExternalContext().redirect("common.jsf");
			
		}
		catch(Exception e)
		{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ha ocurrido un error al ingresar al sistema.");
	         
	        RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
		
	}
	public void redirectTo(String url)
	{
		try
		{
			LoginBean loginBean = (LoginBean) FacesAccesor.getManagedBean("loginBean");
			loginBean.setToViewMenu("menu_admin.xhtml");
			loginBean.navigateTo(url);
			FacesContext.getCurrentInstance().getExternalContext().redirect("common.jsf");
		}
		catch(Exception e)
		{
			sistemaEJB.registroLog(new LogDTO(txtUsrName, SistemaBean.class.getSimpleName()+"[redirectTo]", LevelEnum.ERR.getId(), e.getMessage()));

		}
	}
	
	public void redirectToNoLogin(String url)
	{
		try
		{
			LoginBean loginBean = (LoginBean) FacesAccesor.getManagedBean("loginBean");
			loginBean.setToViewMenu("menu_usuario.xhtml");
			loginBean.navigateTo(url);
			FacesContext.getCurrentInstance().getExternalContext().redirect("common.jsf");
		}
		catch(Exception e)
		{
			sistemaEJB.registroLog(new LogDTO(txtUsrName, SistemaBean.class.getSimpleName()+"[redirectTo]", LevelEnum.ERR.getId(), e.getMessage()));

		}
	}
	
	public void cerrarSession()
	{
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if(session!=null){
			session.invalidate();
		}
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("login.jsf");	
		} catch (IOException e) {
			
		}
	}

	/**
	 * Gets the txt password.
	 *
	 * @return the txt password
	 */
	public String getTxtPassword() {
		return txtPassword;
	}

	/**
	 * Sets the txt password.
	 *
	 * @param txtPassword the new txt password
	 */
	public void setTxtPassword(String txtPassword) {
		this.txtPassword = txtPassword;
	}

	/**
	 * Gets the txt usr name.
	 *
	 * @return the txt usr name
	 */
	public String getTxtUsrName() {
		return txtUsrName;
	}

	/**
	 * Sets the txt usr name.
	 *
	 * @param txtUsrName the new txt usr name
	 */
	public void setTxtUsrName(String txtUsrName) {
		this.txtUsrName = txtUsrName;
	}
}