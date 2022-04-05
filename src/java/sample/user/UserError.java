/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

/**
 *
 * @author Admin
 */
public class UserError {
    private String userIDError;
    private String fullNameError;
    private String roleIDError;
    private String passwordError;
    private String confirmPasswordError;
     private String messageError;
     private String addressError;
     private String phoneNumberError;
     private String statusIDError;
     private String email;
    public UserError() {
        this.userIDError="";
        this.fullNameError="";
        this.roleIDError="";
        this.passwordError="";
        this.confirmPasswordError="";
        this.messageError="";
        this.addressError="";
        this.phoneNumberError="";
        this.statusIDError="";
        this.email="";
    }

    public UserError(String userIDError, String fullNameError, String roleIDError, String passwordError, String confirmPasswordError, String messageError, String addressError, String phoneNumberError, String statusIDError, String email) {
        this.userIDError = userIDError;
        this.fullNameError = fullNameError;
        this.roleIDError = roleIDError;
        this.passwordError = passwordError;
        this.confirmPasswordError = confirmPasswordError;
        this.messageError = messageError;
        this.addressError = addressError;
        this.phoneNumberError = phoneNumberError;
        this.statusIDError = statusIDError;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public String getStatusIDError() {
        return statusIDError;
    }

    public void setStatusIDError(String statusIDError) {
        this.statusIDError = statusIDError;
    }

    

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public String getPhoneNumberError() {
        return phoneNumberError;
    }

    public void setPhoneNumberError(String phoneNumberError) {
        this.phoneNumberError = phoneNumberError;
    }

   
   

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    public String getRoleIDError() {
        return roleIDError;
    }

    public void setRoleIDError(String roleIDError) {
        this.roleIDError = roleIDError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getConfirmPasswordError() {
        return confirmPasswordError;
    }

    public void setConfirmPasswordError(String confirmPasswordError) {
        this.confirmPasswordError = confirmPasswordError;
    }
    
}
