/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.presentation.components.solutions;

import com.azs.businesscard.domain.entities.SolutionCategory;
import com.azs.discountcard.presentation.Application;
import java.util.List;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 *
 * @author lordbacchus
 */
public class SpecialOffersViewModel extends LoadableDetachableModel<List<SolutionCategory>>{

    @Override
    protected List<SolutionCategory> load() {
        return Application.get().getSolutionCategoryFacade().findAll();
    }
    
}
