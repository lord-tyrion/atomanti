/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.discountcard.application.exceptions;

/**
 *
 * @author lordbacchus
 */
public class AuthenticationFailedException extends ResourcefulException {
    public AuthenticationFailedException() {
        super("authenticationFailedExceptionLabel", "Authentication failed.");
    }
}
