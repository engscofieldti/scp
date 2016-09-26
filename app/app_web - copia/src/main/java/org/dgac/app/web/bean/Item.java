package org.dgac.app.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codItem;
	private String descItem;
	private boolean selected;
	private List<Item> item;

	public Item() {
		
	}

	private void inicializaItems() {
		item = new ArrayList<Item>();
		item.add(new Item(1, "Remuneración Variable"));
		item.add(new Item(2, "Otras Remuneraciones"));
		item.add(new Item(3, "Otros Gastos En Personal"));

	}
	
	public Item(int codItem, String descItem) {
		this(codItem, descItem,false);
	}
	
	public Item(int codItem, String descItem, boolean selected) {
		this.codItem = codItem;
		this.descItem = descItem;
		this.selected = selected;
	}

	public int getCodItem() {
		return codItem;
	}

	public void setCodItem(int codItem) {
		this.codItem = codItem;
	}

	public String getDescItem() {
		return descItem;
	}

	public void setDescItem(String descItem) {
		this.descItem = descItem;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean chequeado(){
		  if(Item.this.isSelected()==true){
			  return true;
		  }
		  return false;
	}
	
}
