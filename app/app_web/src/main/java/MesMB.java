
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.dgac.app.web.bean.ConversorMes;
import org.dgac.app.web.bean.Mes;
import org.dgac.app.web.bean.UnidadesZonas;
	   

	 @ManagedBean
	 @ViewScoped
	    public class MesMB {
	    private Mes selectedMes;
	    private List<String>mesSelected;
	   
    	    public Mes getSelectedMes() {
	    return selectedMes;
	}

	    public void setSelectedMes(Mes selectedMes) {
	        this.selectedMes = selectedMes;
	    }


	    public List<Mes> getmeses() {
	        return meses;
	    }


	    public void setMeses(List<Mes> meses) {
	        this.meses = meses;
	    }

	    private List<Mes> meses;
	
     	public List<String> getMesSelected() {
			return mesSelected;
		}

		public void setMesSelected(List<String> mesSelected) {
			this.mesSelected = mesSelected;
		}

		public List<Mes> getMeses() {
			return meses;
		}
				
//		public void mesesSelected(){
//			
//			for(Mes m :getMeses()){
//				
//				if(m.isSelected())
//				{
//					System.out.println(m.getDescMes());
//				}
//			}
//		}
//
//		public boolean mesesSelectedMethod(){
//			
//			for(Meses me : getMeses()){
//				
//				if(me.isSelected()==true){
//			      	return true;
//				}
//			}
//			return false;
//		}
		
	
			@PostConstruct
					public void init(){
					meses=ConversorMes.mesCon;
	 	          }
	    	    
	    	}

	 
	