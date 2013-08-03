/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.dal;

import com.azs.businesscard.domain.entities.ContentItem;
import com.azs.businesscard.domain.entities.Resource;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author lordbacchus
 */
@Stateless
public class ContentItemFacade extends AbstractFacade<ContentItem> implements ContentItemFacadeLocal {

    @PersistenceContext(unitName = "azs-businesscard-domainPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContentItemFacade() {
        super(ContentItem.class);
    }

    @Override
    public Resource findByContentAndKey(long contentId, String key) {
        TypedQuery<? extends Resource> q = getEntityManager().createNamedQuery("ContentItem.findByKey", Resource.class)
                .setParameter("contentId", contentId)
                .setParameter("key", key);
        return q.getSingleResult();
    }

    @Override
    public List<ContentItem> findByContent(long contentId) {
        TypedQuery<ContentItem> q = getEntityManager().createNamedQuery("ContentItem.findByContent", ContentItem.class)
                .setParameter("contentId", contentId);
        return q.getResultList();
    }
}
