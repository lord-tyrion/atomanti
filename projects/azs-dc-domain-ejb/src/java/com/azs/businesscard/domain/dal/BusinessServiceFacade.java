/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.dal;

import com.azs.businesscard.domain.entities.BusinessService;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lordbacchus
 */
@Stateless
public class BusinessServiceFacade extends AbstractFacade<BusinessService> implements BusinessServiceFacadeLocal {
    @PersistenceContext(unitName = "azs-businesscard-domainPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BusinessServiceFacade() {
        super(BusinessService.class);
    }
    
}
