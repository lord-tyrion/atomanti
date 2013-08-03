/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.discountcard.presentation;

import com.azs.businesscard.domain.entities.AzsRole;
import com.azs.businesscard.domain.entities.AzsUser;
import com.azs.discountcard.application.exceptions.AuthenticationFailedException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.request.Request;

/**
 *
 * @author lordbacchus
 */
public class DiscountCardSession extends AuthenticatedWebSession {

    private Long userId;

    public static DiscountCardSession get() {
        return (DiscountCardSession) AuthenticatedWebSession.get();
    }

    public DiscountCardSession(Request request) {
        super(request);
    }
    
    

    @Override
    public boolean authenticate(String userName, String password) {
        try {
            userId = Application.get().getUserAdministrationService().signOff(userName, password);
        } catch (AuthenticationFailedException ex) {
            Logger.getLogger(DiscountCardSession.class.getName()).log(Level.SEVERE, null, ex);
            error(ex.getMessage());
        } finally {
            return userId != null;
        }
    }

    private String[] convertRoleSet(List<AzsRole> roles) {
        String[] result = new String[roles.size()];
        for (int i = 0; i < roles.size(); i++) {
            result[i] = roles.get(i).getName();
        }
        return result;
    }
    
    @Override
    public Roles getRoles() {
        return new Roles(convertRoleSet(Application.get().getUserAdministrationService().getRoles(userId)));
    }

    public IModel<AzsUser> createUserModel() {
        return new LoadableDetachableModel<AzsUser>() {
            @Override
            protected AzsUser load() {
                // TODO: security leak.
                return Application.get().getUserFacade().find(userId);
            }
        };
    }
    
    
}
