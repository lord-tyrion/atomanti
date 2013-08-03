/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.dal;

import com.azs.businesscard.domain.entities.ContentItem;
import com.azs.businesscard.domain.entities.Resource;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author lordbacchus
 */
@Local
public interface ContentItemFacadeLocal {

    void create(ContentItem contentItem);

    void edit(ContentItem contentItem);

    void remove(ContentItem contentItem);

    ContentItem find(Object id);

    List<ContentItem> findAll();

    List<ContentItem> findRange(int[] range);

    int count();
    
    Resource findByContentAndKey(long contentId, String key);
    
    List<ContentItem> findByContent(long contentId);
}
