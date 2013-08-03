/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.presentation.components.suggestion;

import com.azs.discountcard.domain.Suggestion;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 *
 * @author lordbacchus
 */
public final class SuggestionPanel extends Panel {

    public SuggestionPanel(String id, IModel<Suggestion> model) {
        super(id, model);
        
        add(new Label("suggestionTitle", model.getObject().getMainTitle()));
        
        ListView<String> suggestionItems = new ListView<String>("suggestionRepeater", model.getObject().getSuggestionItem()) {
            @Override
            protected void populateItem(ListItem<String> li) {
                li.add(new Label("suggestionItem", li.getModel()));
            }
        };
        add(suggestionItems);
    }
}
