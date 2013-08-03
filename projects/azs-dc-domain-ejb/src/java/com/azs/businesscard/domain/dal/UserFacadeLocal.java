/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.dal;

import com.azs.businesscard.domain.entities.AzsUser;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author lordbacchus
 */
@Local
public interface UserFacadeLocal {

    void create(AzsUser user);

    void edit(AzsUser user);

    void remove(AzsUser user);

    AzsUser find(Object id);

    List<AzsUser> findAll();

    List<AzsUser> findRange(int[] range);

    int count();
    
}
