/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.entities;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author lordbacchus
 */
@Entity
public class CustomerCategory {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic
    private String name;
    @Basic
    private Boolean special;
    @OneToMany(mappedBy = "customerCategory", fetch = FetchType.LAZY)
    private List<Customer> elements;

    public CustomerCategory() {
    }

    public CustomerCategory(String name, boolean special, List<Customer> customers) {
        this.name = name;
        this.special = special;
        this.elements = customers;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public List<Customer> getElements() {
        return elements;
    }

    public void setElements(List<Customer> customer) {
        this.elements = customer;
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
        CustomerCategory other = (CustomerCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.azs.businesscard.domain.CustomerCategory[ id=" + id + " ]";
    }
}
