/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.presentation.components.suggestion;

import com.azs.discountcard.domain.Suggestion;
import com.azs.discountcard.presentation.Application;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 *
 * @author lordbacchus
 */
public class SuggestionViewModel extends LoadableDetachableModel<Suggestion> {

    @Override
    protected Suggestion load() {
        return Application.get().getSuggestionFacade().load();
    }
    
}
