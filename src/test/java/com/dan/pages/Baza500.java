package com.dan.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://substitute.ro/baza-e-potion/baza-500-ml.html")
public class Baza500 extends PageObject{

    @FindBy(css = ".base")
    private WebElementFacade pageTitle;

    public boolean isPageTitleDisplayed(){
        waitFor(pageTitle);
        return pageTitle.containsText("Baza 500 ml");
    }

}
