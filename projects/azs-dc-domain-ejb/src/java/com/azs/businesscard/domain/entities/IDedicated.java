/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.businesscard.domain.entities;

/**
 *
 * @author lordbacchus
 */
public interface IDedicated<T> {
    T getId();
    void setId(T id);
    
    String getName();
    void setName(String name);
    
    String getDescription();
    void setDescription(String description);
}
