package Del3.war.beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Julien
 */

public class PropertyData {
    private Long id;
    private String streetNum;
    private String street;
    private String city;
    private String province;
    private String country;        
    private String description;
    /**
     * Creates a new instance of PropertyData
     */
    public PropertyData(long id, String streetNum, String street, String city, String prov, String coun, String description ) {
    this.id=id;
    this.streetNum=streetNum;
    this.street = street;
    this.city = city;
    this.province=prov;
    this.country=coun;
    this.description = description;
            
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
    
}
