/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.discountcard.application.exceptions;

/**
 *
 * @author lordbacchus
 */
public class PasswordConfirmationException extends ResourcefulException {
    

    public PasswordConfirmationException() {
        super("passwordConfirmationExceptionLabel", "Password confirmation failed.");
    }

    
    
}
