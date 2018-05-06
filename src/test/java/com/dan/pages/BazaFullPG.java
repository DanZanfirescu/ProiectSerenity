package com.dan.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://substitute.ro/baza-e-potion/baza-full-pg.html")
public class BazaFullPG extends PageObject {
    @FindBy(css = ".base")
    private WebElementFacade pageTitle;

    public boolean isPageTitleDisplayed(){
        waitFor(pageTitle);
        return pageTitle.containsText("Baza Full PG");
    }


}
