/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.discountcard.presentation.pages;

import com.azs.businesscard.domain.entities.Content;
import com.azs.businesscard.domain.entities.Resource;
import com.azs.discountcard.presentation.BasePage;
import java.util.Map;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author lordbacchus
 */
@AuthorizeInstantiation(value = "CUSTOMER_ROLE")
public final class MyCompanyPage extends ContentManagerPage {

    public MyCompanyPage(IModel<Content> contentModel, IModel<Map<String, ? super Resource>> resourcesModel) {
        super(contentModel, resourcesModel);
    }
    
    public MyCompanyPage(PageParameters params) {
        super();
        long companyId = params.get("company").toLong();
        
    }
}
