/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Del3.ejb.query.beans;

import Del3.ejb.property.beans.Property;
import Del3.ejb.property.beans.PropertyFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author Julien
 */
@Stateful
public class QueryEJB implements QueryEJBLocal {
    @EJB
    PropertyFacadeLocal QueryEJB;

    @Override
    public List<Property> viewProperties() {
        return QueryEJB.findAll();
    }
    
    

   
}
