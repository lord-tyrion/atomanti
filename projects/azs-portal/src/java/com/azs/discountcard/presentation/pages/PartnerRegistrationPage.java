/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.discountcard.presentation.pages;

import com.azs.discountcard.application.PartnerRegistration;
import com.azs.discountcard.presentation.BasePage;
import com.azs.discountcard.presentation.DiscountCardSession;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;

/**
 * Együttműködö partner regisztrációs oldala (entry).
 *
 * @author lordbacchus
 */
public final class PartnerRegistrationPage extends BasePage {

    public class PartnerRegistrationForm extends Form<PartnerRegistration> {

        private PartnerRegistrationModel registrationModel;
        
        public PartnerRegistrationForm(PartnerRegistrationModel registrationModel) {
            super("registrationForm", registrationModel);
            this.registrationModel = registrationModel;
            setOutputMarkupId(true);
            add(new TextField<String>("userName"));
            add(new PasswordTextField("password"));
            add(new PasswordTextField("passwordConfirm"));
        }

        @Override
        protected void onSubmit() {
            registrationModel.registrate(DiscountCardSession.get());
            setResponsePage(MyCompanyPage.class);
            super.onSubmit();
        }
    }
    
    private Form<PartnerRegistration> registrationForm;

    public PartnerRegistrationPage() {
        super();
        this.initializeRegistrationForm(new PartnerRegistrationModel());
    }

    private void initializeRegistrationForm(final PartnerRegistrationModel model) {
        add(registrationForm = new PartnerRegistrationForm(model));
    }
}
