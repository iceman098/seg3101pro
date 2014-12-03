/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Del3.ejb.property.beans;


import Del3.ejb.useraccount.beans.User;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Julien
 */
@Entity
@Table(name="Property")
public class Property implements Serializable {
    private static long serialVersionUID = 1L;
    

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @Id
    private String id;
    private String streetNum;
    private String street;
    private String city;
    private String province;
    private String country;        
    private String description;
    private String ownerFname;
    private String ownerLname;
    
    public Property(){
        
    }    
    public Property(String id, String streetNum, String street, String city, String province, String country, String description, String ownerFname, String ownerLname) {
    this.id=id;
    this.streetNum=streetNum;
    this.street = street;
    this.city = city;
    this.province=province;
    this.country=country;
    this.description = description;
    this.ownerFname=ownerFname;
    this.ownerLname=ownerLname;
            
    }
    
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Property)) {
            return false;
        }
        Property other = (Property) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Del3.war.property.beans.Property[ id=" + getId() + " ]";
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
     * @return the ownerFname
     */
    public String getOwnerFname() {
        return ownerFname;
    }

    /**
     * @param ownerFname the ownerFname to set
     */
    public void setOwnerFname(String ownerFname) {
        this.ownerFname = ownerFname;
    }

    /**
     * @return the ownerLname
     */
    public String getOwnerLname() {
        return ownerLname;
    }

    /**
     * @param ownerLname the ownerLname to set
     */
    public void setOwnerLname(String ownerLname) {
        this.ownerLname = ownerLname;
    }

    
    
}
