/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.presentation.components.news;

import com.azs.businesscard.domain.entities.PieceOfNews;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 *
 * @author lordbacchus
 */
public final class NewsPanel extends Panel {

    public class PieceOfNewsFragment extends Fragment {

        public PieceOfNewsFragment(String id, IModel<PieceOfNews> model) {
            super(id, "pieceOfNewsPanel", NewsPanel.this, model);
            add(new Label("pieceOfNewsContent", new PropertyModel<PieceOfNews>(model, "content")));
        }
    }

    public NewsPanel(String id, IModel<List<PieceOfNews>> model) {
        super(id);

        add(new AjaxTabbedPanel("newsTabbedPanel", createTabs(5, model)));
    }

    private List<ITab> createTabs(int newsCount, IModel<List<PieceOfNews>> model) {
        List<ITab> tabs = new ArrayList<>();
        for (int i = 0; i < newsCount; i++) {
            if (i < model.getObject().size()) {
                tabs.add(createTab(new CompoundPropertyModel<PieceOfNews>(model.getObject().get(i))));
            }
        }
        return tabs;
    }

    private ITab createTab(final IModel<PieceOfNews> pieceOfNews) {
        return new AbstractTab(new PropertyModel<String>(pieceOfNews, "title")) {
            @Override
            public WebMarkupContainer getPanel(String id) {
                return new PieceOfNewsFragment(id, pieceOfNews);
            }
        };
    }
}
