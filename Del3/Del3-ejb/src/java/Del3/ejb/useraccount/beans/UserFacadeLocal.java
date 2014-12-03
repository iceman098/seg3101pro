/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Del3.ejb.useraccount.beans;

import Del3.ejb.useraccount.beans.User;
import java.util.List;
import javax.ejb.Local;



@Local
public interface UserFacadeLocal {

    void create(User user);
   

    void edit(User user);

    void remove(User user);

    User find(Object id);

    List<User> findAll();

    List<User> findRange(int[] range);

    int count();
    
    public boolean addUser(long id, String fn, String ln, String email, String accT, String un, String pass, String card, String ag);
    
    public List<User> findByType(String type);
    public List<User> findByUname(String uName);
    

    public boolean addVisit(long id, String propertyId);
    public void create(Visit visit);
}
