/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.discountcard.application.exceptions;

/**
 *
 * @author lordbacchus
 */
public class UserNameReservedException extends ResourcefulException {
    public UserNameReservedException() {
        super("userNameReservedExceptionLabel", "Username reserved.");
    }
}
