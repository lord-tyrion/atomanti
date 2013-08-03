/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.dal;

import com.azs.businesscard.domain.entities.AzsRole;
import java.util.List;
import java.util.Set;
import javax.ejb.Local;

/**
 *
 * @author lordbacchus
 */
@Local
public interface AzsRoleFacadeLocal {

    void create(AzsRole azsRole);

    void edit(AzsRole azsRole);

    void remove(AzsRole azsRole);

    AzsRole find(Object id);
    
    AzsRole findByName(String roleName);

    List<AzsRole> findAll();

    List<AzsRole> findRange(int[] range);

    int count();

    List<AzsRole> findRolesForUser(long userId);
    
    AzsRole createIfNotExists(AzsRole role);
}
