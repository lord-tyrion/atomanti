/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.dal;

import com.azs.businesscard.domain.entities.CustomerCategory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author lordbacchus
 */
@Local
public interface CustomerCategoryFacadeLocal {

    void create(CustomerCategory customerCategory);

    void edit(CustomerCategory customerCategory);

    void remove(CustomerCategory customerCategory);

    CustomerCategory find(Object id);

    List<CustomerCategory> findAll();

    List<CustomerCategory> findRange(int[] range);

    int count();
    
}
