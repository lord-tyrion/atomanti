/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.dal;

import com.azs.businesscard.domain.entities.SolutionCategory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author lordbacchus
 */
@Local
public interface SolutionCategoryFacadeLocal {

    void create(SolutionCategory solutionCategory);

    void edit(SolutionCategory solutionCategory);

    void remove(SolutionCategory solutionCategory);

    SolutionCategory find(Object id);

    List<SolutionCategory> findAll();

    List<SolutionCategory> findRange(int[] range);

    int count();
    
}
