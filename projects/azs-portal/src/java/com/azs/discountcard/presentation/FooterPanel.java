/*
 * FooterPanel.java
 *
 * Created on 2013. július 20., 1:43
 */
 
package com.azs.discountcard.presentation;           

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

/** 
 *
 * @author lordbacchus
 * @version 
 */

public final class FooterPanel extends Panel {

    public FooterPanel(String id, String text) {
        super(id);
        add(new Label("footerpanel_text", text));
    }

}
