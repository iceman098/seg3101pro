/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Del3.war.beans;

import Del3.ejb.property.beans.PropertyFacadeLocal;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Julien
 */
@Named(value = "addPropertyBean")
@RequestScoped
public class AddPropertyBean {
    @EJB
    private PropertyFacadeLocal propertyFacade;
    private String id;
    private String streetNum;
    private String street;
    private String city;
    private String province;
    private String country;        
    private String description;
    private String fname;
    private String lname;
    private String status;

    /**
     * @return the id
     */
   
   
    public void addNewProperty() {
        
        if (getPropertyFacade().addProperty(getId(), getStreetNum(), getStreet(), getCity(), getProvince(), getCountry(), getDescription(), getFname(),getLname())) {
            setStatus("Successfully added property.");
        } else {
            setStatus("Failed to add property.");
        }
    }

    /**
     * @return the propertyFacade
     */
    public PropertyFacadeLocal getPropertyFacade() {
        return propertyFacade;
    }

    /**
     * @param propertyFacade the propertyFacade to set
     */
    public void setPropertyFacade(PropertyFacadeLocal propertyFacade) {
        this.propertyFacade = propertyFacade;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the streetNum
     */
    public String getStreetNum() {
        return streetNum;
    }

    /**
     * @param streetNum the streetNum to set
     */
    public void setStreetNum(String streetNum) {
        this.streetNum = streetNum;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

}
