/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.presentation.components.solutions;

import com.azs.businesscard.domain.entities.SolutionCategory;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.request.resource.UrlResourceReference;

/**
 *
 * @author lordbacchus
 */
public final class SpecialOffersPanel extends Panel {

    public SpecialOffersPanel(String id, IModel<List<SolutionCategory>> model) {
        super(id, model);
        
        add(new ListView<SolutionCategory>("specialCategoryRepeater", model) {

            @Override
            protected void populateItem(ListItem<SolutionCategory> li) {
                
                ResourceReference icon = new UrlResourceReference(Url.parse(li.getModelObject().getImageResource()));
                li.add(new Image("categoryIcon", icon));
                li.add(new Label("categoryName", new PropertyModel<String>(li.getModel(), "name")));
                li.add(new Label("categoryDescription", new PropertyModel<String>(li.getModel(), "description")));
            }
        });
    }
}
