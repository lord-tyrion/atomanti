/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.dal;

import com.azs.businesscard.domain.entities.ImageResource;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author lordbacchus
 */
@Local
public interface ImageResourceFacadeLocal {

    void create(ImageResource imageResource);

    void edit(ImageResource imageResource);

    void remove(ImageResource imageResource);

    ImageResource find(Object id);

    List<ImageResource> findAll();

    List<ImageResource> findRange(int[] range);

    int count();

    public ImageResource findByKey(String key);
    
}
