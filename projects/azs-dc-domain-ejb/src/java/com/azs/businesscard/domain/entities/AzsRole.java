/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author lordbacchus
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "AzsRole.findRolesForUser", query = "SELECT u.roles FROM AzsUser u WHERE u.id = :userId"),
    @NamedQuery(name = "AzsRole.findByName", query = "SELECT r FROM AzsRole r WHERE r.name = :roleName")
})
public class AzsRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic
    private String name;
    @Basic
    @ManyToMany(mappedBy = "roles")
    private List<AzsUser> users;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AzsUser> getUsers() {
        return users;
    }

    public void setUsers(List<AzsUser> users) {
        this.users = users;
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
        if (!(object instanceof AzsRole)) {
            return false;
        }
        AzsRole other = (AzsRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.azs.businesscard.domain.entities.AzsRole[ id=" + id + " ]";
    }
    
}
