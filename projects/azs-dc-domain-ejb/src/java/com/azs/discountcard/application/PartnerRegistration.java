/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azs.discountcard.application;

import java.io.Serializable;

/**
 *
 * @author lordbacchus
 */
public class PartnerRegistration implements Serializable {
    private String userName;
    private String password;
    private String passwordConfirm;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }
    
    public boolean isPasswordConfrimed() {
        if (password == null || passwordConfirm == null) return false;
        else return password.equals(passwordConfirm);
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
