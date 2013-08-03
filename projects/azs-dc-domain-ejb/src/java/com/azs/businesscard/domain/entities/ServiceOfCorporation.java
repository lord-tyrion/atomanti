/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.entities;

import com.azs.businesscard.domain.entities.Content;
import com.azs.crm.applications.IContentContainer;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author lordbacchus
 */
@Entity
public class ServiceOfCorporation implements Serializable, IContentContainer {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Content content;
    
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
        if (!(object instanceof ServiceOfCorporation)) {
            return false;
        }
        ServiceOfCorporation other = (ServiceOfCorporation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.azs.domain.ServiceOfCorporation[ id=" + id + " ]";
    }

    @Override
    public Content getContent() {
        return this.content;
    }

    @Override
    public void setContent(Content content) {
        this.content = content;
    }
    
}
