/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.dal;

import com.azs.businesscard.domain.entities.Content;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author lordbacchus
 */
@Local
public interface ContentFacadeLocal {

    void create(Content content);

    void edit(Content content);

    void remove(Content content);

    Content find(Object id);

    List<Content> findAll();

    List<Content> findRange(int[] range);

    int count();
}
