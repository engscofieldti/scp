import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.dgac.app.web.bean.UnidadesZonas;
import org.dgac.app.web.bean.ConversorUnidadesZonas;
@ManagedBean
	 @ViewScoped
public class UnidadesZonasMB {
	private UnidadesZonas selectedUnidad;
    private List<String>unidadSelected;
    private List<UnidadesZonas> unidades;
	public UnidadesZonas getSelectedUnidad() {
		return selectedUnidad;
	}
	public void setSelectedUnidad(UnidadesZonas selectedUnidad) {
		this.selectedUnidad = selectedUnidad;
	}
	public List<String> getUnidadSelected() {
		return unidadSelected;
	}
	public void setUnidadSelected(List<String> unidadSelected) {
		this.unidadSelected = unidadSelected;
	}
	public List<UnidadesZonas> getUnidades() {
		return unidades;
	}
	public void setUnidades(List<UnidadesZonas> unidades) {
		this.unidades = unidades;
	}
    
	
	
	public boolean unidadesZonasSelectedMethod(){
		
		for(UnidadesZonas uz : getUnidades()){
			
			if(uz.isSelected()==true){
		      	return true;
			}
		}
		return false;
	}

	
	 
	
	
    @PostConstruct
    public void init(){
    	unidades=ConversorUnidadesZonas.arrUni;
    	    	
    }
          
    
}
