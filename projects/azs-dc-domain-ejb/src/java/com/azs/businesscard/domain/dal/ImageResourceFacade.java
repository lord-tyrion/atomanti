/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.dal;

import com.azs.businesscard.domain.entities.ImageResource;
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
public class ImageResourceFacade extends AbstractFacade<ImageResource> implements ImageResourceFacadeLocal {
    @PersistenceContext(unitName = "azs-businesscard-domainPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImageResourceFacade() {
        super(ImageResource.class);
    }

    @Override
    public ImageResource findByKey(String key) {
        TypedQuery<ImageResource> q = getEntityManager().createNamedQuery("ImageResource.findByImageresourcekey", ImageResource.class);
        q.setParameter("imageresourcekey", key);
        return q.getSingleResult();
    }
    
}
