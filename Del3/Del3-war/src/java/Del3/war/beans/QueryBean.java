/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Del3.war.beans;

import Del3.ejb.property.beans.Property;
import Del3.ejb.property.beans.PropertyFacadeLocal;
import Del3.ejb.query.beans.QueryEJB;
import Del3.ejb.query.beans.QueryEJBLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Julien
 */
@Named(value = "queryBean")
@SessionScoped                    
public class QueryBean implements Serializable {
    @EJB
    private QueryEJBLocal queryEJB;
    @EJB
    private PropertyFacadeLocal propertyFacade;
    private String id;
    private String streetNum;
    private String street;
    private String city;
    private String province;
    private String country;        
    private String description;
    private String status;
    private String searchType;
    private String searchValue;
    private ArrayList<Property> viewProperties;
    private ArrayList<Property> searchProperties;
    /**
     * Creates a new instance of QueryBean
     */
    public QueryBean() {
    }

    /**
     * @return the QueryEJB
     */
    public QueryEJBLocal getQueryEJB() {
        return queryEJB;
    }

    /**
     * @param QueryEJB the QueryEJB to set
     */
    public void setQueryEJB(QueryEJBLocal QueryEJB) {
        this.queryEJB = QueryEJB;
    }

    /**
     * @return the properties
     */
    
    
    public String viewProperties(){
        
        viewProperties=(new ArrayList<>());
        List<Property> resultList = getPropertyFacade().findAll();
        if (resultList != null) {
            for (Property resultList1 : resultList) {
                Property x = (Property) resultList1;
                getViewProperties().add(new Property(x.getId(),x.getStreetNum(),x.getStreet(), x.getCity(),x.getProvince(),x.getCountry(),x.getDescription(),x.getOwnerFname(), x.getOwnerLname()));
            }
        }
        return "viewProperties";
    }
    
    
    public ArrayList<Property> search(){
        searchProperties=(new ArrayList<>());
        List<Property> resultList;
        switch (getSearchType()) {
            case "street":
                resultList = getPropertyFacade().findByStreet(getSearchValue());
                if (resultList != null) {
            for (Property resultList1 : resultList) {
                Property x = (Property) resultList1;
                getSearchProperties().add(new Property(x.getId(),x.getStreetNum(),x.getStreet(), x.getCity(),x.getProvince(),x.getCountry(),x.getDescription(),x.getOwnerFname(),x.getOwnerLname()));
            }
        }
                break;
            case "streetNum":
                resultList = getPropertyFacade().findByStreetNum(getSearchValue());
                if (resultList != null) {
            for (Property resultList1 : resultList) {
                Property x = (Property) resultList1;
                getSearchProperties().add(new Property(x.getId(),x.getStreetNum(),x.getStreet(), x.getCity(),x.getProvince(),x.getCountry(),x.getDescription(),x.getOwnerFname(),x.getOwnerLname()));
            }
        }
                break;
            case "city":
                resultList = getPropertyFacade().findByCity(getSearchValue());
                if (resultList != null) {
            for (Property resultList1 : resultList) {
                Property x = (Property) resultList1;
                getSearchProperties().add(new Property(x.getId(),x.getStreetNum(),x.getStreet(), x.getCity(),x.getProvince(),x.getCountry(),x.getDescription(),x.getOwnerFname(),x.getOwnerLname()));
            }
        }
                break;
            case "province":
                resultList = getPropertyFacade().findByProv(getSearchValue());
                if (resultList != null) {
            for (Property resultList1 : resultList) {
                Property x = (Property) resultList1;
                getSearchProperties().add(new Property(x.getId(),x.getStreetNum(),x.getStreet(), x.getCity(),x.getProvince(),x.getCountry(),x.getDescription(),x.getOwnerFname(),x.getOwnerLname()));
            }
        }
                break;
            case "country":
                resultList = getPropertyFacade().findByCountry(getSearchValue());
                if (resultList != null) {
            for (Property resultList1 : resultList) {
                Property x = (Property) resultList1;
                getSearchProperties().add(new Property(x.getId(),x.getStreetNum(),x.getStreet(), x.getCity(),x.getProvince(),x.getCountry(),x.getDescription(),x.getOwnerFname(),x.getOwnerLname()));
            }
        }
                break;
            case "propID":
                resultList = getPropertyFacade().findById(getSearchValue());
                if (resultList != null) {
            for (Property resultList1 : resultList) {
                Property x = (Property) resultList1;
                getSearchProperties().add(new Property(x.getId(),x.getStreetNum(),x.getStreet(), x.getCity(),x.getProvince(),x.getCountry(),x.getDescription(),x.getOwnerFname(),x.getOwnerLname()));
            }
        }
                break;
        }
  
        
        return searchProperties;

    }
    
    public String update(){
        getPropertyFacade().updateStreetNum(getStreetNum(), getId());
        return "ownerViewProperties";
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
     * @return the viewProperties
     */
    public ArrayList<Property> getViewProperties() {
        return viewProperties;
    }

    /**
     * @param viewProperties the viewProperties to set
     */
    public void setViewProperties(ArrayList<Property> viewProperties) {
        this.viewProperties = viewProperties;
    }

    /**
     * @return the searchProperties
     */
    public ArrayList<Property> getSearchProperties() {
        return searchProperties;
    }

    /**
     * @param searchProperties the searchProperties to set
     */
    public void setSearchProperties(ArrayList<Property> searchProperties) {
        this.searchProperties = searchProperties;
    }

    /**
     * @return the searchType
     */
    public String getSearchType() {
        return searchType;
    }

    /**
     * @param searchType the searchType to set
     */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    /**
     * @return the searchValue
     */
    public String getSearchValue() {
        return searchValue;
    }

    /**
     * @param searchValue the searchValue to set
     */
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
    
}
