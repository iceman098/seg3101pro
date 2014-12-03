/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Del3.ejb.property.beans;

import Del3.ejb.property.beans.Property;
import Del3.ejb.useraccount.beans.Visit;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ssome
 */
@Stateless
public class PropertyFacade extends AbstractFacade<Property> implements PropertyFacadeLocal {
    @PersistenceContext(unitName = "Del3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PropertyFacade() {
        super(Property.class);
    }

    @Override
    public boolean addProperty(String id, String streetNum, String street, String city, String province, String country, String description, String oFn, String oLn) {
        Property property= new Property(id, streetNum, street, city, province, country, description, oFn, oLn);
        try {
            create(property);
        } catch (Exception e) {
            return false ;
        }
        return true;
    }
    @Override
    public List<Property> findAll(){
        Query query = em.createQuery(
                "SELECT p FROM Property p");
        List resultList = query.getResultList();
        return resultList;
    }
    
    @Override
    public List<Property> findByCity(String city) {
        try {
            Query query = em.createQuery(
                "SELECT u FROM Property u" +
                " WHERE u.city = :City");
            query.setParameter("City",city);

            List resultList = query.getResultList();
            return resultList;
        } catch (Exception e) {
        }
        return null;
    }    

    @Override
    public Property find(Property property) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Property> findByProv(String prov) {
        Query query = em.createQuery(
                "SELECT p FROM Property p" +
                        " WHERE p.province = :prov");
                query.setParameter("prov",prov);
        List resultList = query.getResultList();
        return resultList;
    }

    @Override
    public List<Property> findByCountry(String count) {
        Query query = em.createQuery(
                "SELECT p FROM Property p" +
                        " WHERE p.country = :count");
                query.setParameter("count",count);
        List resultList = query.getResultList();
        return resultList;
    }

    



    @Override
    public List<Property> findByOwner(String fn, String ln) {
        Query query = em.createQuery(
                "SELECT p FROM Property p" +
                        " WHERE p.ownerFname = :fn AND p.ownerLname = :ln");
                query.setParameter("fn",fn);
                query.setParameter("ln",ln);
        List resultList = query.getResultList();
        return resultList;
    }

    @Override
    public void delete(String id) {
        Query query = em.createQuery(
                "DELETE FROM Property p" +
                        " WHERE p.id = :id");
                query.setParameter("id",id).executeUpdate();
                
    }

    @Override
    public List<Property> findById(String id) {
        Query query = em.createQuery(
                "SELECT p FROM Property p" +
                        " WHERE p.id = :Id");
                
                query.setParameter("Id",id);
        List resultList = query.getResultList();
        return resultList;
    }
    
    @Override
    public List<Visit> getViewList(long id){
        Query query = em.createQuery(
        "SELECT p FROM Visit p" +
        " WHERE p.userId = :Id");
        query.setParameter("Id",id);
        List resultList = query.getResultList();
        return resultList;
    }
    @Override
    public void updateStreetNum(String num, String id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateProvince(String prov,String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateStreet(String street,String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCity(String city,String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCountry(String cou,String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateDescription(String desc,String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Property> findByStreet(String street) {
        Query query = em.createQuery(
                "SELECT p FROM Property p" +
                        " WHERE p.street = :street");
                query.setParameter("street",street);
        List resultList = query.getResultList();
        return resultList;
    }

    @Override
    public List<Property> findByStreetNum(String street) {
        Query query = em.createQuery(
                "SELECT p FROM Property p" +
                        " WHERE p.streetNum = :street");
                query.setParameter("street",street);
        List resultList = query.getResultList();
        return resultList;
    }
    
}
