/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.dal;

import com.azs.businesscard.domain.entities.AzsRole;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author lordbacchus
 */
@Stateless
public class AzsRoleFacade extends AbstractFacade<AzsRole> implements AzsRoleFacadeLocal {
    @PersistenceContext(unitName = "azs-businesscard-domainPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AzsRoleFacade() {
        super(AzsRole.class);
    }

    @Override
    public List<AzsRole> findRolesForUser(long userId) {
        TypedQuery<AzsRole> q = getEntityManager().createNamedQuery("AzsRole.findRolesForUser", AzsRole.class);
        q.setParameter("userId", userId);
        return q.getResultList();
    }

    @Override
    public AzsRole createIfNotExists(AzsRole role) {
        try {
            return this.findByName(role.getName());
        } catch (NoResultException ex) {
            this.create(role);
            return role;
        }
    
    }

    @Override
    public AzsRole findByName(String roleName) {
        TypedQuery<AzsRole> q = getEntityManager().createNamedQuery("AzsRole.findByName", AzsRole.class);
        q.setParameter("roleName", roleName);
        return q.getSingleResult();
    }
    
}
