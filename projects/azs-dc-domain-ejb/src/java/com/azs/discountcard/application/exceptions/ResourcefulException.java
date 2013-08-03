/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.discountcard.application.exceptions;

/**
 *
 * @author lordbacchus
 */
public class ResourcefulException extends Exception {

    public ResourcefulException(String key) {
        this.key = key;
    }

    public ResourcefulException(String key, String message) {
        super(message);
        this.key = key;
    }

    public ResourcefulException(String key, String message, Throwable cause) {
        super(message, cause);
        this.key = key;
    }

    public ResourcefulException(String key, Throwable cause) {
        super(cause);
        this.key = key;
    }

    public ResourcefulException(String key, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.key = key;
    }
    
    protected String key;
    
    public String getKey() {
        return key;
    }
}
