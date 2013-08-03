/*
 * HeaderPanel.java
 *
 * Created on 2013. július 12., 18:31
 */
 
package com.azs.discountcard.presentation.components;           

import com.azs.businesscard.domain.entities.AzsUser;
import com.azs.businesscard.domain.entities.Content;
import com.azs.businesscard.domain.entities.Resource;
import com.azs.discountcard.presentation.DiscountCardSession;
import com.azs.discountcard.presentation.pages.HomePage;
import com.azs.discountcard.presentation.pages.MyCompanyPage;
import java.util.HashMap;
import java.util.Map;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/** 
 *
 * @author lordbacchus
 * @version 
 */

public class HeaderPanel extends Panel {

    public class VisitorFragment extends Fragment {
        public VisitorFragment(String id) {
            super(id, "visitorFragment", HeaderPanel.this);
        }
    }
    
    public class UserFragment extends Fragment {
        public UserFragment(String id, IModel<AzsUser> userModel) {
            super(id, "userFragment", HeaderPanel.this, userModel);
            add(new Label("userName", userModel.getObject().getName()));
            add(new Link<AzsUser>("signOutLink") {

                @Override
                public void onClick() {
                    DiscountCardSession.get().signOut();
                    setResponsePage(HomePage.class);
                }
            });
        }
    }
    
    /**
     * Construct.
     * @param componentName name of the component
     * @param exampleTitle title of the example
     */

    public HeaderPanel(String componentName)
    {
        super(componentName);
        add(new FeedbackPanel("main-feedback"));
        add(createVisitorFragment("authenticationPanel", DiscountCardSession.get().isSignedIn()));
        WebMarkupContainer authorizedContent = new WebMarkupContainer("authorizedContent") {

            @Override
            public boolean isVisible() {
                return super.isVisible() && DiscountCardSession.get().isSignedIn();
            }
            
        };
        authorizedContent.add(new BookmarkablePageLink("myCompanyLink", ));
        add(authorizedContent);
    }

    private Fragment createVisitorFragment(String authenticationPanelId, boolean isSignedIn) {
        if (isSignedIn) return new UserFragment(authenticationPanelId, DiscountCardSession.get().createUserModel());
        else return new VisitorFragment(authenticationPanelId);
    }
}
