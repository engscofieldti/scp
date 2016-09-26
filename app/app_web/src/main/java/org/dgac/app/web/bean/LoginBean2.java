package org.dgac.app.web.bean;

import java.io.IOException;





import javax.annotation.ManagedBean;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped 
public class LoginBean2 {

	private String user;
	private String pass;
	
	
	
	public LoginBean2(String user) {
		super();
		this.user = user;
	}

	public LoginBean2() {
		super();
	}

	public LoginBean2(LoginBean2 logBean2) {
		super();
	}
	
	public String getUser() {
	
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String loguearse(){
		if(user != null && user.equals("admin") && pass != null && pass.equals("admin")){
			HttpSession hs=SistemaBean.getSession();
			hs.setAttribute("user", user);
			return  "webapp/panelUsuario.xhtml";
		}else{
			FacesMessage fm= new FacesMessage("error de sesion","ERROR");
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, fm);
			return "webapp/sinAcceso.xhtml";
		}
	}
	
	public void isAdmin(ComponentSystemEvent event){
		
					FacesContext fc = FacesContext.getCurrentInstance();
					if (!(user != null && user.equals("admin") && pass != null && pass.equals("admin"))){
						ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler)fc.getApplication().getNavigationHandler();
						nav.performNavigation("sinAcceso");
						
					}
			 }
	
	public void loginMensaje2() throws IOException {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
         
        if(user != null && user.equals("admin") && pass != null && pass.equals("admin")
        		|| user != null && user.equals("Carlos Ortiz") && pass != null && pass.equals("Carlos")) {
            loggedIn = true;
            HttpSession hs=SistemaBean.getSession();
			hs.setAttribute("user", user);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ingreso Correcto", "Bienvenido."));
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", user);
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
	
	public void cerrarSessionLB2()
	{
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if(session!=null){
			session.invalidate();
			//session.setMaxInactiveInterval(5);//TIEMPO EN SEGUNDOS
			try{
			FacesContext.getCurrentInstance().getExternalContext().redirect("login.jsf");
			
			
			}catch (IOException e){
				
			}}}

	public void closeSession() throws IOException {
	    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.invalidateSession();
	    setUser("");
	    setPass("");
	    ec.redirect(ec.getRequestContextPath() + "/login.jsf");
	   
	}
			
	
	public void redirectToLogin(){
		 // FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Correcto");
	       // FacesContext.getCurrentInstance().addMessage(null, msg);
			try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("login.jsf");	
		} catch (IOException e) {
		}
	}
	
		public void getUserMethod(){
		System.out.println("usuario conectado :"+ getUser());
	}
		
		public String getUserMethod2(){
			return user;
		}
		
		
		    public void execute() {
		        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		        String inputUser = request.getParameter("dataForm:txt_username");
		    		        System.out.println("metodo execute :"+inputUser);
		      
		    }
		    
		public Object getObjetoSession(){
			FacesContext fc = FacesContext.getCurrentInstance();
			@SuppressWarnings("deprecation")
			String user = (String)fc.getApplication().createValueBinding("#{SessionScope.user}").getValue(fc);
			return user;
		}
		
		public Object getsession2(){//ESTE SI LO TRAE BIEN
			return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		}
	}
