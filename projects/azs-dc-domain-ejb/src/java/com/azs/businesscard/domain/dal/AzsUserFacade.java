/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.dal;

import com.azs.businesscard.domain.entities.AzsUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author lordbacchus
 */
@Stateless
public class AzsUserFacade extends AbstractFacade<AzsUser> implements AzsUserFacadeLocal {
    @PersistenceContext(unitName = "azs-businesscard-domainPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AzsUserFacade() {
        super(AzsUser.class);
    }

    @Override
    public boolean isReserved(String userName) {
        TypedQuery<AzsUser> q = getEntityManager().createNamedQuery("AzsUser.findByName", AzsUser.class);
        q.setParameter("userName", userName);
        return !q.getResultList().isEmpty();
    }

    @Override
    public AzsUser findByName(String userName) {
        TypedQuery<AzsUser> q = getEntityManager().createNamedQuery("AzsUser.findByName", AzsUser.class);
        q.setParameter("userName", userName);
        return q.getSingleResult();
    }
    
}
