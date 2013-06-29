/*
 * FooterPanel.java
 *
 * Created on 2013. június 25., 20:46
 */
 
package com.azs.businesscard.presentation;           

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
