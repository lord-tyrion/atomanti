/*
 * WicketExamplePage.java
 *
 * Created on 2013. június 25., 20:46
 */
 
package com.azs.businesscard.presentation;           

import org.apache.wicket.markup.html.WebPage;

/** 
 *
 * @author lordbacchus
 * @version 
 */

public abstract class BasePage extends WebPage {

    public BasePage() { 
        super(); 
        add(new HeaderPanel("headerpanel", "Welcome To Wicket")); 
        add(new FooterPanel("footerpanel", "Powered by Wicket and the NetBeans Wicket Plugin"));
    } 

}
