package org.dgac.app.web.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
 
 
@ManagedBean
public class DropdownView {
     
	private String option;
	private String[] selectedConsoles;
    private String[] selectedConsoles2;
    private String[] selectedCities;
    private String[] selectedCities2;
    private List<String> cities;
 
    @PostConstruct
    public void init() {
        cities = new ArrayList<String>();
        cities.add("Miami");
        cities.add("London");
        cities.add("Paris");
        cities.add("Istanbul");
        cities.add("Berlin");
        cities.add("Barcelona");
        cities.add("Rome");
        cities.add("Brasilia");
        cities.add("Amsterdam");
    }
 
    public String[] getSelectedConsoles() {
        return selectedConsoles;
    }
 
    public void setSelectedConsoles(String[] selectedConsoles) {
        this.selectedConsoles = selectedConsoles;
    }
 
    public String[] getSelectedCities() {
        return selectedCities;
    }
 
    public void setSelectedCities(String[] selectedCities) {
        this.selectedCities = selectedCities;
    }
 
    public String[] getSelectedCities2() {
        return selectedCities;
    }
 
   // public void setSelectedCities(String[] selectedCities2) {
    //   this.selectedCities2 = selectedCities2;
    //}
 
    public String[] getSelectedConsoles2() {
        return selectedConsoles2;
    }
 
    public void setSelectedConsoles2(String[] selectedConsoles2) {
        this.selectedConsoles2 = selectedConsoles2;
    }
 
    public List<String> getCities() {
        return cities;
    }
    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
    
}