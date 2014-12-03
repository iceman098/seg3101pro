/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Del3.war.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Julien
 */
@ManagedBean
@RequestScoped
public class UserData {

    private Long id;
    private String fname;
    private String lname;
    private String email;
    private String accType;
    private String uName;
    private String password;
    private String ccard;
    private String agency;
    /**
     * Creates a new instance of UserData
     */
    public UserData(long id, String fn, String ln, String email, String accT, String un, String pass, String card, String ag) {
        this.id = id;
        this.fname=fn;
        this.lname=ln;
        this.email=email;
        this.accType=accT;
        this.uName = un;
        this.password = pass;
        this.ccard = card;
        this.agency = ag;
    }

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
    
}
