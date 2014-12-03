/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Del3.ejb.query.beans;

import Del3.ejb.property.beans.Property;
import Del3.ejb.useraccount.beans.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ssome
 */
@Local
public interface QueryEJBLocal {


    public List<Property> viewProperties();

    
    
}
