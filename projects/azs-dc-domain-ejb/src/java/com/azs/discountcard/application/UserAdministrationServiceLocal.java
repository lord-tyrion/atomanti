/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.discountcard.application;

import com.azs.businesscard.domain.entities.AzsRole;
import com.azs.discountcard.application.exceptions.AuthenticationFailedException;
import com.azs.discountcard.application.exceptions.PasswordConfirmationException;
import com.azs.discountcard.application.exceptions.UserNameReservedException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author lordbacchus
 */
@Local
public interface UserAdministrationServiceLocal {
    
    Long signOn(PartnerRegistration partnerRegistration) throws PasswordConfirmationException, UserNameReservedException;
    long signOff(String userName, String password) throws AuthenticationFailedException;
    List<AzsRole> getRoles(long userId);
}
