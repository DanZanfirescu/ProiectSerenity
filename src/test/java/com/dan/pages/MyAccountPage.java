package com.dan.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://substitute.ro/customer/account/")
public class MyAccountPage extends PageObject {

    @FindBy(css = ".page-title")
    private WebElementFacade pageTitle;

    public boolean isLoggedIn(){
        waitFor(pageTitle);
        return pageTitle.containsText("Contul meu");
    }
}
