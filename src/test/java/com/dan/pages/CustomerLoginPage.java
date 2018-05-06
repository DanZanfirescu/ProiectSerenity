package com.dan.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://substitute.ro/customer/account/login/")
public class CustomerLoginPage extends PageObject {
    @FindBy(css = "#email")
    private WebElementFacade userEmailField;
    @FindBy(css = "#pass")
    private WebElementFacade userPasswordField;
    @FindBy(css = "#send2")
    private WebElementFacade loginButton;
    @FindBy(css = ".message-error.error.message")
    private WebElementFacade notLogedInMessage;
    @FindBy(css = ".message-error.error.message")
    private WebElementFacade invalidUserName;
    @FindBy(css = "#email-error")
    private WebElementFacade invalidEmailFormat;
    @FindBy(css = "#email-error")
    private WebElementFacade emptyUserNameFieldMessage;
    @FindBy(css = "#pass-error")
    private WebElementFacade emptyPasswordFieldMessage;
    @FindBy(css = ".action.remind")
    private WebElementFacade forgotPasswordLink;


    public void setUserEmailField(String userName){
        typeInto(userEmailField, userName);
    }
    public void setUserPasswordField(String password){
        typeInto(userPasswordField, password);
    }
    public void clickLoginButton(){
        clickOn(loginButton);
    }
    public boolean invalidEmailFormat(){
       return invalidEmailFormat.containsText("Please enter a valid email address (Ex: johndoe@domain.com).");
    }
    public boolean notLogedInMessage(){
        return notLogedInMessage.containsText("You did not sign in correctly or your account is temporarily disabled.");
    }
    public boolean invalidUserName(){
        return invalidUserName.containsText("You did not sign in correctly or your account is temporarily disabled.");
    }
    public boolean emptyUserNameFieldMessage(){
        return emptyUserNameFieldMessage.containsText("This is a required field.");
    }
    public boolean emptyPasswordFieldMessage(){
        return emptyPasswordFieldMessage.containsText("This is a required field.");
    }
    public void clickForgotPasswordLink(){
        clickOn(forgotPasswordLink);
    }



}
