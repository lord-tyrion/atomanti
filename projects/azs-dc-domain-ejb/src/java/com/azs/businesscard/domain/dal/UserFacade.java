/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.dal;

import com.azs.businesscard.domain.entities.AzsUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lordbacchus
 */
@Stateless
public class UserFacade extends AbstractFacade<AzsUser> implements UserFacadeLocal {
    @PersistenceContext(unitName = "azs-businesscard-domainPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(AzsUser.class);
    }
    
}
