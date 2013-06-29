/*
 * HeaderPanel.java
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

public class HeaderPanel extends Panel {

    /**
     * Construct.
     * @param componentName name of the component
     * @param exampleTitle title of the example
     */

    public HeaderPanel(String componentName, String exampleTitle)
    {
        super(componentName);
        add(new Label("exampleTitle", exampleTitle));
    }

}
