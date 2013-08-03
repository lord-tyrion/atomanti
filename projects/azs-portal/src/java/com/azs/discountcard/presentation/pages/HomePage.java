/*
 * HomePage.java
 *
 * Created on 2013. július 12., 18:31
 */

package com.azs.discountcard.presentation.pages;           

import com.azs.businesscard.presentation.components.news.NewsPanel;
import com.azs.businesscard.presentation.components.news.NewsViewModel;
import com.azs.businesscard.presentation.components.solutions.SpecialOffersPanel;
import com.azs.businesscard.presentation.components.solutions.SpecialOffersViewModel;
import com.azs.businesscard.presentation.components.suggestion.SuggestionPanel;
import com.azs.businesscard.presentation.components.suggestion.SuggestionViewModel;
import com.azs.discountcard.presentation.BasePage;

public class HomePage extends BasePage {

    public HomePage() {
        add(new NewsPanel("newsPanel", new NewsViewModel()));
        add(new SuggestionPanel("suggestionPanel", new SuggestionViewModel()));
        add(new SpecialOffersPanel("specialOffersPanel", new SpecialOffersViewModel()));
    }

}
