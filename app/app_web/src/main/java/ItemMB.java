import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.dgac.app.web.bean.Item;
import org.dgac.app.web.bean.ConversorItem;

	   

	 @ManagedBean
	 @ViewScoped
public class ItemMB {
		 	private Item selectedItem;
		    private List<String>itemSelected;
		    private List<Item> items;
			
		   
			
			public Item getSelectedItem() {
				return selectedItem;
			}



			public void setSelectedItem(Item selectedItem) {
				this.selectedItem = selectedItem;
			}



			public List<String> getItemSelected() {
				return itemSelected;
			}



			public void setItemSelected(List<String> itemSelected) {
				this.itemSelected = itemSelected;
			}



			public List<Item> getItems() {
				return items;
			}



			public void setItems(List<Item> items) {
				this.items = items;
			}



			@PostConstruct
			public void init(){
			    items=ConversorItem.itemCon;
			}
			

		
		    
	
		    
}