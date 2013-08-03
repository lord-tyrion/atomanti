/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.discountcard.presentation.pages;

import com.azs.discountcard.application.PartnerRegistration;
import com.azs.discountcard.application.exceptions.PasswordConfirmationException;
import com.azs.discountcard.application.exceptions.ResourcefulException;
import com.azs.discountcard.application.exceptions.UserNameReservedException;
import com.azs.discountcard.presentation.Application;
import com.azs.discountcard.presentation.DiscountCardSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.wicket.Session;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.StringResourceModel;

/**
 * Partner registration model. Create a model for registrate a partner.
 *
 * @author lordbacchus
 */
public class PartnerRegistrationModel extends CompoundPropertyModel<PartnerRegistration> {

    public PartnerRegistrationModel() {
        super(new PartnerRegistration());
    }

    /**
     * Registrate.
     */
    public void registrate(DiscountCardSession session) {
        try {
            Application.get().getUserAdministrationService().signOn(this.getObject());
            infoToSession(session, "autheticationSucceed");
            session.signIn(getObject().getUserName(), getObject().getPassword());
        } catch (PasswordConfirmationException | UserNameReservedException ex) {
            Logger.getLogger(PartnerRegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
            errorToSession(session, ex);
        }
    }
    
    private void errorToSession(Session session, ResourcefulException ex) {
        session.error(new StringResourceModel(ex.getKey(), null, new Object[]{}).getObject());
    }
    
    private void infoToSession(Session session, String key) {
        session.info(new StringResourceModel(key, null, new Object[]{}).getObject());
    }
}
