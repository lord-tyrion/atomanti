/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.entities;

import java.util.Set;

/**
 *
 * @author lordbacchus
 */
public interface ICategory<T> {
    Set<T> getElements();
    void setElements(Set<T> elements);
}
