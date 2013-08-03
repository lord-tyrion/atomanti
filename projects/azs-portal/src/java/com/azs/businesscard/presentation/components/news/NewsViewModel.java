/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.presentation.components.news;

import com.azs.businesscard.domain.entities.PieceOfNews;
import com.azs.discountcard.presentation.Application;
import java.util.List;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 *
 * @author lordbacchus
 */
public class NewsViewModel extends LoadableDetachableModel<List<PieceOfNews>>{

    @Override
    protected List<PieceOfNews> load() {
        return Application.get().getPieceOfNewsFacade().findAll();
    }
}
