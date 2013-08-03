/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.discountcard.application;

import com.azs.businesscard.domain.dal.AzsRoleFacadeLocal;
import com.azs.businesscard.domain.dal.AzsUserFacadeLocal;
import com.azs.businesscard.domain.entities.AzsRole;
import com.azs.businesscard.domain.entities.AzsUser;
import com.azs.discountcard.application.exceptions.AuthenticationFailedException;
import com.azs.discountcard.application.exceptions.PasswordConfirmationException;
import com.azs.discountcard.application.exceptions.UserNameReservedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author lordbacchus
 */
@Stateless
public class UserAdministrationService implements UserAdministrationServiceLocal {

    @EJB
    private AzsUserFacadeLocal userFacade;
    @EJB
    private AzsRoleFacadeLocal roleFacade;
    
    protected static final String CUSTOMER_ROLE_NAME = "CUSTOMER_ROLE";
    
    /**
     * Kódolja a megadott üzenetet.
     * @param message
     * @return 
     */
    protected String encode(String message) {
        // TODO: encode
        return message;
    }
    
    protected AzsUser newPartnerRoles(AzsUser user) {
        List<AzsRole> roles = new ArrayList<>();
        
        AzsRole customerRole = new AzsRole();
        customerRole.setName(CUSTOMER_ROLE_NAME);
        customerRole = roleFacade.createIfNotExists(customerRole);
        
        roles.add(customerRole);
        
        user.setRoles(roles);
        userFacade.edit(user);
        return user;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Long signOn(PartnerRegistration partnerRegistration) throws PasswordConfirmationException, UserNameReservedException {
        // Felhasználó elkészítése.
        AzsUser user = new AzsUser();
        
        // Ha a jelszó és a jelszó megerősítés nem egyezik hibát dobunk, különben kódoljuk és beállítjuk a jelszót.
        if (!partnerRegistration.isPasswordConfrimed()) {
            throw new PasswordConfirmationException();
        } else {
            user.setPassword(encode(partnerRegistration.getPassword()));
        }
        // A felhasználónév egyediségét ellenőrizzük, ha nem egyedi nem engedjük tovább.
        if (!userFacade.isReserved(partnerRegistration.getUserName())) {
            user.setName(partnerRegistration.getUserName());
        } else {
            throw new UserNameReservedException();
        }
        userFacade.create(user);
        // Kapcsolat elkészítése
        // Vásárló elkészítése
        // Jogosultságok beállítása.
        newPartnerRoles(user);
        
        return user.getId();
    }

    @Override
    public long signOff(String userName, String password) throws AuthenticationFailedException {
        AzsUser user = userFacade.findByName(userName);
        if (encode(password).equals(user.getPassword())) return user.getId();
        else throw new AuthenticationFailedException();
    }

    @Override
    public List<AzsRole> getRoles(long userId) {
        return roleFacade.findRolesForUser(userId);
    }

}
