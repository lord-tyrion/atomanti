/*
 * WicketExamplePage.java
 *
 * Created on 2013. július 20., 1:43
 */
 
package com.azs.discountcard.presentation;           

import com.azs.discountcard.presentation.components.HeaderPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/** 
 *
 * @author lordbacchus
 * @version 
 */

public abstract class BasePage extends WebPage {

    public BasePage() { 
        super(); 
        this.initialize();
    } 

    protected BasePage(PageParameters parameters) {
        super(parameters);
        this.initialize();
    }

    protected BasePage(IModel<?> model) {
        super(model);
        this.initialize();
    }
    
    private void initialize() {
        add(new HeaderPanel("headerpanel")); 
        add(new FooterPanel("footerpanel", "Powered by Wicket and the NetBeans Wicket Plugin"));
    }
}
