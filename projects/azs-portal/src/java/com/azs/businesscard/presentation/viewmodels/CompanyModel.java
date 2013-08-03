/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.presentation.viewmodels;

import com.azs.businesscard.domain.entities.AzsPartner;
import com.azs.discountcard.presentation.Application;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 *
 * @author lordbacchus
 */
public class CompanyModel extends LoadableDetachableModel<AzsPartner>{

    @Override
    protected AzsPartner load() {
        return Application.get().get
    }
    
}
