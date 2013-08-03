/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.dal;

import com.azs.businesscard.domain.entities.BusinessService;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author lordbacchus
 */
@Local
public interface BusinessServiceFacadeLocal {

    void create(BusinessService businessService);

    void edit(BusinessService businessService);

    void remove(BusinessService businessService);

    BusinessService find(Object id);

    List<BusinessService> findAll();

    List<BusinessService> findRange(int[] range);

    int count();
    
}
