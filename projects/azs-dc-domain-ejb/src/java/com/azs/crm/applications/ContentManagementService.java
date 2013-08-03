/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.crm.applications;

import com.azs.businesscard.domain.dal.ContentFacadeLocal;
import com.azs.businesscard.domain.dal.ContentItemFacadeLocal;
import com.azs.businesscard.domain.entities.Content;
import com.azs.businesscard.domain.entities.ContentItem;
import com.azs.businesscard.domain.entities.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author lordbacchus
 */
@Stateless
public class ContentManagementService implements ContentManagementServiceLocal {

    private static final Logger LOG = Logger.getLogger(ContentManagementService.class.getName());
    @EJB
    private ContentFacadeLocal contentRepository;
    @EJB
    private ContentItemFacadeLocal contentItemRepository;

    @Override
    public void manage(IContentContainer container) {
        LOG.info("Manage content ...");
        Content content = new Content();
        container.setContent(content);
        LOG.info("- Add content to container.");
        contentRepository.create(content);
        LOG.log(Level.INFO, "- New content created {0}.", content.toString());
    }

    @Override
    public void unManage(IContentContainer container) {
        LOG.info("Unmanage content ...");
        Content content = container.getContent();
        container.setContent(null);
        LOG.info("- Remove content from container.");
        contentRepository.remove(content);
        LOG.log(Level.INFO, "- Content deleted {0}.", content.toString());
    }

    @Override
    public Resource load(long contentId, String key) {
        return contentItemRepository.findByContentAndKey(contentId, key);
    }

    @Override
    public Map<String, Resource> loadResources(long contentId) {
        Map<String, Resource> result = new HashMap<>();
        Content content = contentRepository.find(contentId);
        LOG.log(Level.INFO, "Loading content resources for {0} ...", content.toString());
        for (ContentItem contentItem : contentItemRepository.findByContent(contentId)) {
            result.put(contentItem.getKey(), contentItemRepository.findByContentAndKey(contentId, contentItem.getKey()));
            LOG.log(Level.INFO, "Resource {0} loaded.", contentItem.getKey());
        }
        return result;
    }

    @Override
    public void saveResources(long contentId, Map<String, Resource> changedReosurces) {
        Content content = contentRepository.find(contentId);
        LOG.log(Level.INFO, "Saving content resources for {0} ...", content.toString());
        for (ContentItem contentItem : content.getContentItems()) {
            if (changedReosurces.get(contentItem.getKey()) != null) {
                contentItem.setResource(changedReosurces.get(contentItem.getKey()));
                LOG.log(Level.INFO, "Resource {0} modified.", contentItem.getKey());
            }
        }
        contentRepository.edit(content);
        LOG.log(Level.INFO, "Changes of {0} saved.", content.toString());
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
