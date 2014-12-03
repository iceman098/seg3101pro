/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Del3.ejb.useraccount.beans;

import Del3.ejb.property.beans.Property;
import Del3.ejb.useraccount.beans.User;
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
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {
    @PersistenceContext(unitName = "Del3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

    @Override
    public boolean addUser(long id, String fn, String ln, String email, String accT, String un, String pass, String card, String ag) {
        User user= new User(id, fn, ln, email, accT, un, pass, card, ag);
        try {
            create(user);
        } catch (Exception e) {
            return false ;
        }
        return true;
    }
    
    @Override
    public List<User> findByType(String type) {
        try {
            Query query = em.createQuery(
                "SELECT u FROM User u" +
                " WHERE u.accType = :UserType");
            query.setParameter("UserType",type);

            List resultList = query.getResultList();
            return resultList;
        } catch (Exception e) {
        }
        return null;
    }    

    @Override
    public List<User> findByUname(String uName) {
        try {
            Query query = em.createQuery(
                "SELECT u FROM User u" +
                " WHERE u.uName = :UserName");
            query.setParameter("UserName",uName);

            List resultList = query.getResultList();
            return resultList;
        } catch (Exception e) {
        }
        return null;
    }
   @Override
   public List<User> findAll(){
       try {
            Query query = em.createQuery(
                "SELECT u FROM User u");
               List resultList = query.getResultList();
            return resultList;
        } catch (Exception e) {
        }
        return null;
    }
   
    @Override
   public boolean addVisit(long id, String iD) {
        Visit visit= new Visit(id, iD);
        try {
            create(visit);
        } catch (Exception e) {
            return false ;
        }
        return true;
    }
    public void create(Visit visit) {
        getEntityManager().persist(visit);
    }
   
    
}
