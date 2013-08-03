/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.print.DocFlavor.STRING;

/**
 *
 * @author lordbacchus
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "ContentItem.findByKey", query = "SELECT c FROM ContentItem c WHERE c.key = :key AND c.content.id = :contentId"),
    @NamedQuery(name = "ContentItem.findByContent", query = "SELECT c FROM ContentItem c WHERE c.content.id = :contentId")
})
public class ContentItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic
    private String key;
    @ManyToOne
    private Content content;
    @ManyToOne
    private Resource resource;

    public enum ResourceType {
        THUMBNAIL,
        ICON,
        SHORT_DESCRIPTION,
        LONG_DESCRIPTION,
        BANNER_IMAGE
    }
    
    @Enumerated(EnumType.STRING)
    private ResourceType type;
    
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }
    
    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContentItem)) {
            return false;
        }
        ContentItem other = (ContentItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.azs.crm.domain.entities.ContentItem[ id=" + id + " ]";
    }
}
