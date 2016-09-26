import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.dgac.app.web.bean.Asignacion;
import org.dgac.app.web.bean.ConversorAsignacion;
import org.dgac.app.web.bean.UnidadesZonas;


	 @ManagedBean
	 @ViewScoped


public class AsignacionMB {
			private Asignacion selectedAsignacion;
		    private List<String>asignacionSelected;
		    private List<Asignacion> asignaciones;
		    
		    public Asignacion getSelectedAsignacion() {
				return selectedAsignacion;
			}
			public void setSelectedAsignacion(Asignacion selectedAsignacion) {
				this.selectedAsignacion = selectedAsignacion;
			}
			public List<String> getAsignacionSelected() {
				return asignacionSelected;
			}
			public void setAsignacionSelected(List<String> asignacionSelected) {
				this.asignacionSelected = asignacionSelected;
			}
			public List<Asignacion> getAsignaciones() {
				return asignaciones;
			}
			public void setAsignaciones(List<Asignacion> asignaciones) {
				this.asignaciones = asignaciones;
			}
		    

			public boolean asignacionesSelectedMethod(){
				
				for(Asignacion as : getAsignaciones()){
					
					if(as.isSelected()==true){
				      	return true;
					}
				}
				return false;
			}
			
			
			@PostConstruct
		    public void init(){
		    	asignaciones=ConversorAsignacion.asigCon;
		    	
		    }
		    

}
