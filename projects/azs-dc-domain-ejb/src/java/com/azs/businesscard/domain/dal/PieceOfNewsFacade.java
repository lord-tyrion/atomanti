/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.dal;

import com.azs.businesscard.domain.entities.PieceOfNews;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lordbacchus
 */
@Stateless
public class PieceOfNewsFacade extends AbstractFacade<PieceOfNews> implements PieceOfNewsFacadeLocal {
    @PersistenceContext(unitName = "azs-businesscard-domainPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PieceOfNewsFacade() {
        super(PieceOfNews.class);
    }
    
}
