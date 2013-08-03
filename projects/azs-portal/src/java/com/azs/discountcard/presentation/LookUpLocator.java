/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.discountcard.presentation;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author lordbacchus
 */
public class LookUpLocator<T> {
    
    private String name;
    private T bean;

    public LookUpLocator(String jndiName) {
        this.name = jndiName;
    }
    
    private T lookUp(String jndiName) throws NamingException {
        InitialContext context = new InitialContext();
        return (T) context.lookup(jndiName);
    }
    
    public T getBean() {
        if (bean == null) try {
            bean = lookUp(this.name);
        } catch (NamingException ex) {
            Logger.getLogger(LookUpLocator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bean;
    }
}
