/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author lordbacchus
 */
@Entity
@DiscriminatorValue("image")
@Table(name="resource")
public class ImageResource extends Resource {

    @Basic(fetch = FetchType.EAGER, optional = true)
    private byte[] resourceData;
    @Basic(fetch = FetchType.EAGER, optional = true)
    private int width;
    @Basic(fetch = FetchType.EAGER, optional = true)
    private int height;

    public ImageResource() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
    
    public byte[] getResourceData() {
        return resourceData;
    }

    public void setResourceData(byte[] resourceData) {
        this.resourceData = resourceData;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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
        if (!(object instanceof ImageResource)) {
            return false;
        }
        ImageResource other = (ImageResource) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.azs.crm.domain.entities.ImageResource[ id=" + id + " ]";
    }
    
}
