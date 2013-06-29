/*
 * Application.java
 *
 * Created on 2013. június 25., 20:46
 */
 
package com.azs.businesscard.presentation;           

import org.apache.wicket.protocol.http.WebApplication;
/** 
 *
 * @author lordbacchus
 * @version 
 */

public class Application extends WebApplication {

    public Application() {
    }

    public Class getHomePage() {
        return HomePage.class;
    }

}
