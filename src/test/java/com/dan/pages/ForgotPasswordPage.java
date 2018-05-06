package com.dan.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://substitute.ro/customer/account/forgotpassword/")
public class ForgotPasswordPage extends PageObject {

    @FindBy(css = ".page-title")
    private WebElementFacade pageTitle;

    public boolean pageTitle(){
        return pageTitle.containsText("Recuperare parola");
    }
}
