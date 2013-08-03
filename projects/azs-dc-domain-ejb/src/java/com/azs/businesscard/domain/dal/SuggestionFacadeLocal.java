/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.dal;

import com.azs.discountcard.domain.Suggestion;
import javax.ejb.Local;

/**
 *
 * @author lordbacchus
 */
@Local
public interface SuggestionFacadeLocal {
    Suggestion load();
    void save(Suggestion suggestion);
}
