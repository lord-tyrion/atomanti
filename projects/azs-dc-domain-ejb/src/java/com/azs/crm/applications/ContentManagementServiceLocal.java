/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.crm.applications;

import com.azs.businesscard.domain.entities.Resource;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author lordbacchus
 */
@Local
public interface ContentManagementServiceLocal {
    
    /**
     * Create content.
     * @param container 
     */
    void manage(IContentContainer container);
    /**
     * Delete content.
     * @param container 
     */
    void unManage(IContentContainer container);
    
    Resource load(long contentId, String key);
    
    Map<String, Resource> loadResources(long contentId);
    
    void saveResources(long contentId, Map<String, Resource> changedReosurces);
}
