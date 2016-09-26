
       import java.util.List;
	   import javax.annotation.PostConstruct;
	   import javax.faces.bean.ManagedBean;
	   import javax.faces.bean.ViewScoped;
	   import org.dgac.app.web.bean.Subt;
	   import org.dgac.app.web.bean.Conversor;

	 @ManagedBean
	 @ViewScoped
	    public class SubtMB {
	    private Subt selectedSubt;
	    private List<Subt> subts;
	    public Subt getSelectedSubt() {
	    return selectedSubt;
	}

	    public void setSelectedSubt(Subt selectedSubt) {
	        this.selectedSubt = selectedSubt;
	    }


	    public List<Subt> getSubts() {
	        return subts;
	    }


	    public void setSubts(List<Subt> subts) {
	        this.subts = subts;
	    }


	    
	
	@PostConstruct
	public void init(){
	    subts=Conversor.subtCon;
	}

	 }
	
	
	


