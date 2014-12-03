/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Del3.war.beans;

import Del3.ejb.useraccount.beans.UserFacadeLocal;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Julien
 */
@Named(value = "addUserBean")
@RequestScoped
public class AddUserBean {
    @EJB
    private UserFacadeLocal userFacade;
    private Long id;
    private String fname;
    private String lname;
    private String email;
    private String accType;
    private String uName;
    private String password;
    private String ccard;
    private String agency;
    private String status;

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
    public String getuName() {
        return uName;
    }

    /**
     * @param uName the uName to set
     */
    public void setuName(String uName) {
        this.uName = uName;
    }

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
   
    public void addNewUser() {
        
        if (getUserFacade().addUser(getId(), getFname(), getLname(), getEmail(), getAccType(), getuName(), getPassword(), getCcard(), getAgency())) {
           setStatus("Successfully added user.");
        } else {
           setStatus("Failed to add user.");
        }
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
}
