/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Del3.war.beans;

import Del3.ejb.property.beans.Property;
import Del3.ejb.property.beans.PropertyFacadeLocal;
import Del3.ejb.useraccount.beans.User;
import Del3.ejb.useraccount.beans.UserFacadeLocal;
import Del3.ejb.useraccount.beans.Visit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Julien
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable{
    @EJB
    private UserFacadeLocal userFacade;
    @EJB
    private PropertyFacadeLocal propertyFacade;
    private Long id;
    private String fname;
    private String lname;
    private String email;
    private String accType;
    private String uname;
    private String password;
    private String ccard;
    private String agency;
    
    private String status;
    private String propertyId;
    private ArrayList<User> user;
    private ArrayList<Property> ownerProperties;
    private ArrayList<Property> updateProperty;
    private ArrayList<Property> viewingList;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * @return the userFacade
     */
    public UserFacadeLocal getUserFacade() {
        return userFacade;
    }

    /**
     * @param userFacade the userFacade to set
     */
    public void setUserFacade(UserFacadeLocal userFacade) {
        this.userFacade = userFacade;
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

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the accType
     */
    public String getAccType() {
        return accType;
    }

    /**
     * @param accType the accType to set
     */
    public void setAccType(String accType) {
        this.accType = accType;
    }

    /**
     * @return the uName
     */
    

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the ccard
     */
    public String getCcard() {
        return ccard;
    }

    /**
     * @param ccard the ccard to set
     */
    public void setCcard(String ccard) {
        this.ccard = ccard;
    }

    /**
     * @return the agency
     */
    public String getAgency() {
        return agency;
    }

    /**
     * @param agency the agency to set
     */
    public void setAgency(String agency) {
        this.agency = agency;
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
    
    public String addToVisitList(){
        if(getUserFacade().addVisit(user.get(0).getId(),getPropertyId())){
            setStatus("Successfully added property "+getPropertyId()+" to visiting list.");
        }
        else{
            setStatus("Failed to add property "+getPropertyId()+" to visiting list.");
        }
       return "viewProperties";
    }

    /**
     * @return the propertyId
     */
    public String getPropertyId() {
        return propertyId;
    }

    /**
     * @param propertyId the propertyId to set
     */
    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }
    
    public String login(){
        
        user=(new ArrayList<>());
        List<User> resultList = getUserFacade().findByUname(getUname());
        if (resultList != null) {
            for (User resultList1 : resultList) {
                User x = (User) resultList1;
                getUser().add(new User(x.getId(),x.getFname(),x.getLname(), x.getEmail(),x.getAccType(),x.getuName(),x.getPassword(),getCcard(), getAgency()));
            }
        }
        if(!user.isEmpty()&&(getPassword().equals(user.get(0).getPassword()))&&user.get(0).getAccType().equals("Agent")){
            return "loginAgent";
        }
        else if(!user.isEmpty()&&(getPassword().equals(user.get(0).getPassword()))&&user.get(0).getAccType().equals("Owner")){
            return "loginOwner";
        }
        else if(!user.isEmpty()&&(getPassword().equals(user.get(0).getPassword()))&&user.get(0).getAccType().equals("User")){
            
            return "loginUser";
            }
        else{
            return "loginFailed";
            }
    }
    public String viewOwnerProperties(){
        
        ownerProperties=(new ArrayList<>());
        String fn=user.get(0).getFname();
        String ln=user.get(0).getLname();
        List<Property> resultList = getPropertyFacade().findByOwner(fn, ln);
        if (resultList != null) {
            for (Property resultList1 : resultList) {
                Property x = (Property) resultList1;
                getOwnerProperties().add(new Property(x.getId(),x.getStreetNum(),x.getStreet(), x.getCity(),x.getProvince(),x.getCountry(),x.getDescription(),x.getOwnerFname(), x.getOwnerLname()));
            }
        }
        return "ownerViewProperties";
    }
    public String viewVisitingList(){
        
        viewingList=(new ArrayList<>());
        List<Visit> resultList = getPropertyFacade().getViewList(user.get(0).getId());
        List<Property> resultList2;
        for(int i=0;i<resultList.size();i++){
            resultList2=getPropertyFacade().findById(resultList.get(i).getPropertyId());
            Property x = resultList2.get(0);
            getViewingList().add(new Property(x.getId(),x.getStreetNum(),x.getStreet(), x.getCity(),x.getProvince(),x.getCountry(),x.getDescription(),x.getOwnerFname(), x.getOwnerLname()));
            }
             
        return "viewVisitingList";
    }
    public String viewUpdateProperty(){
        
        updateProperty=(new ArrayList<>());
        List<Property> resultList = getPropertyFacade().findById(getPropertyId());
        if (resultList != null) {
            for (Property resultList1 : resultList) {
                Property x = (Property) resultList1;
                getUpdateProperty().add(new Property(x.getId(),x.getStreetNum(),x.getStreet(), x.getCity(),x.getProvince(),x.getCountry(),x.getDescription(),x.getOwnerFname(), x.getOwnerLname()));
            }
        }
        return "updateProperty";
    }
    public String deleteProperty(){
        
        for(int i=0;i<ownerProperties.size();i++){
            if(ownerProperties.get(i).getId().equals(getPropertyId())){
                getPropertyFacade().delete(getPropertyId());
                ownerProperties.remove(i);
            }
        }
        return "ownerViewProperties";
    }
      public String update(){
        
        return "ownerViewProperties";
    }
    public String logout(){
        user=(new ArrayList<>());
        setPassword("");
        setUname("");
        return "index";
    }
    
    public String back(){
        if(user==null){
            return "index";
        }
        else if(!user.isEmpty()&&user.get(0).getAccType().equals("Agent")){
            return "loginAgent";
        }
        else if(!user.isEmpty()&&user.get(0).getAccType().equals("Owner")){
            return "loginOwner";
        }
        else if(!user.isEmpty()&&user.get(0).getAccType().equals("User")){
            return "loginUser";
        }
        return "index";
    }

    /**
     * @return the user
     */
    public ArrayList<User> getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(ArrayList<User> user) {
        this.user = user;
    }

    /**
     * @return the uname
     */
    public String getUname() {
        return uname;
    }

    /**
     * @param uname the uname to set
     */
    public void setUname(String uname) {
        this.uname = uname;
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
     * @return the ownerProperties
     */
    public ArrayList<Property> getOwnerProperties() {
        return ownerProperties;
    }

    /**
     * @param ownerProperties the ownerProperties to set
     */
    public void setOwnerProperties(ArrayList<Property> ownerProperties) {
        this.ownerProperties = ownerProperties;
    }

    /**
     * @return the updateProperty
     */
    public ArrayList<Property> getUpdateProperty() {
        return updateProperty;
    }

    /**
     * @param updateProperty the updateProperty to set
     */
    public void setUpdateProperty(ArrayList<Property> updateProperty) {
        this.updateProperty = updateProperty;
    }

    /**
     * @return the viewingList
     */
    public ArrayList<Property> getViewingList() {
        return viewingList;
    }

    /**
     * @param viewingList the viewingList to set
     */
    public void setViewingList(ArrayList<Property> viewingList) {
        this.viewingList = viewingList;
    }
}
