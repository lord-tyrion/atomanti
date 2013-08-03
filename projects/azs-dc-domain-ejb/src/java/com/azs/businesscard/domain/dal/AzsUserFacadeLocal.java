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
public interface AzsUserFacadeLocal {

    void create(AzsUser azsUser);

    void edit(AzsUser azsUser);

    void remove(AzsUser azsUser);

    AzsUser find(Object id);

    List<AzsUser> findAll();

    List<AzsUser> findRange(int[] range);

    int count();

    boolean isReserved(String userName);
    
    AzsUser findByName(String userName);
}
