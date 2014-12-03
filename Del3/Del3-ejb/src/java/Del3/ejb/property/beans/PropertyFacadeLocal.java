/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Del3.ejb.property.beans;

import Del3.ejb.property.beans.Property;
import Del3.ejb.useraccount.beans.Visit;
import java.util.List;
import javax.ejb.Local;



@Local
public interface PropertyFacadeLocal {

    void create(Property property);

    void edit(Property property);

    void remove(Property property);

    Property find(Property property);

    List<Property> findAll();

    List<Property> findRange(int[] range);

    int count();
    
    public boolean addProperty(String id, String streetNum, String street, String city, String province, String country, String description, String oFn, String oLn);
    
    public List<Property> findByCity(String city);
    public List<Property> findByStreet(String street);
    public List<Property> findByStreetNum(String street);
    public List<Property> findById(String id);
    
    public List<Property> findByProv(String prov);
    
    public List<Property> findByCountry(String count);
    
    public List<Property> findByOwner(String fn, String ln);
    
    public void delete(String id);
    
    public void updateProvince(String prov,String id);

    
    public void updateStreet(String street,String id);

    
    public void updateCity(String city,String id); 

    
    public void updateCountry(String cou,String id);
    public void updateDescription(String desc,String id);
    public void updateStreetNum(String num, String id);
    public List<Visit> getViewList(long id);
    
    
    
    
}
