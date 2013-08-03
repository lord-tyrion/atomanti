/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author lordbacchus
 */
@Entity
public class BusinessService implements Serializable, IDedicated<Long> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic
    private String imageResource;
    @Basic
    private String name;
    @Basic
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<SolutionCategory> categories;
    
    public BusinessService() {
    }

    public BusinessService(Long id, String imageResource, String name, String description, Customer customer, Set<SolutionCategory> categories) {
        this.id = id;
        this.imageResource = imageResource;
        this.name = name;
        this.description = description;
        this.customer = customer;
        this.categories = categories;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Set<SolutionCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<SolutionCategory> categories) {
        this.categories = categories;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getImageResource() {
        return imageResource;
    }

    public void setImageResource(String imageResource) {
        this.imageResource = imageResource;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof AzsUser)) {
            return false;
        }
        BusinessService other = (BusinessService) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.azs.businesscard.domain.CustomerService[ id=" + id + " ]";
    }
}
