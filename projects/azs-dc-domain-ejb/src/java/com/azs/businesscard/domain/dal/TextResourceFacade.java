/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.dal;

import com.azs.businesscard.domain.entities.TextResource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author lordbacchus
 */
@Stateless
public class TextResourceFacade extends AbstractFacade<TextResource> implements TextResourceFacadeLocal {
    @PersistenceContext(unitName = "azs-businesscard-domainPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TextResourceFacade() {
        super(TextResource.class);
    }

    @Override
    public TextResource findByKey(String key) {
        TypedQuery<TextResource> q = getEntityManager().createNamedQuery("TextResource.findByTextresourcekey", TextResource.class);
        q.setParameter("textresourcekey", key);
        return q.getSingleResult();
    }
    
}
