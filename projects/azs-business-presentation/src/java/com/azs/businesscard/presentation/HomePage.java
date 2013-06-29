/*
 * HomePage.java
 *
 * Created on 2013. június 25., 20:46
 */

package com.azs.businesscard.presentation;           

import org.apache.wicket.markup.html.basic.Label;

public class HomePage extends BasePage {

    public HomePage() {
        add(new Label("message", "Hello, World!"));
    }

}
