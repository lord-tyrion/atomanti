/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.dal;

import com.azs.businesscard.domain.entities.TextResource;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author lordbacchus
 */
@Local
public interface TextResourceFacadeLocal {

    void create(TextResource textResource);

    void edit(TextResource textResource);

    void remove(TextResource textResource);

    TextResource find(Object id);

    List<TextResource> findAll();

    List<TextResource> findRange(int[] range);

    int count();

    public TextResource findByKey(String key);
    
}
