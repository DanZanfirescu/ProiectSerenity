package com.dan.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@DefaultUrl("https://substitute.ro/")

public class HomePage extends PageObject {

    @FindBy(css = "#search")
    private WebElementFacade searchField;
    @FindBy(css = ".field.search button")
    private  WebElementFacade searchButton;
    @FindBy(css = ".verticalmenu-container.visible-lg.visible-md .megamenu-title")
    private WebElementFacade verticalMenuButton;
    @FindBy(css = "#pt_vmegamenu")
    private WebElementFacade verticalMenuContent;
    @FindBy(css = "#pt_menu10")
    private WebElementFacade bazeEPotion;
    @FindBy(css = "#popup10")
    private WebElementFacade submenu1;
    @FindBy(css = "#popup10 a:nth-child(1)")
    private WebElementFacade subMenu1BazaOptim;
    @FindBy(css = "#popup10 a:nth-child(2)")
    private WebElementFacade subMenu1BazaFullVG;
    @FindBy(css = "#popup10 a:nth-child(3)")
    private WebElementFacade subMenu1BazaFullPG;
    @FindBy(css = "#popup10 a:nth-child(4)")
    private WebElementFacade subMenu1Baza500;

    public void setSearchField(String searchWord){
        typeInto(searchField, searchWord);
    }
    public boolean verticalMenuButtonIsDisplayed(){
        return verticalMenuButton.isDisplayed();
    }
    public void clickSearchButton(){
        clickOn(searchButton);
    }
    public void clickVerticalMenuButton(){
        clickOn(verticalMenuButton);
    }
    public boolean verticalMenuConent(){
        return verticalMenuContent.isCurrentlyVisible();
    }
    public boolean bazeEPotion(){
        return bazeEPotion.isDisplayed();
    }
    public void clickOnBazeEPotion(){
        clickOn(bazeEPotion);
    }
    public boolean subMenu1IsDisplayed(){
        waitFor(submenu1);
        return submenu1.isCurrentlyVisible();
    }
    public boolean subMenu1BazaOptimIsDisplayed(){
        return subMenu1BazaOptim.isDisplayed();
    }
    public void clickOnBazaOptim(){
        clickOn(subMenu1BazaOptim);
    }
    public boolean subMenu1BazaFullIVGIsDisplayed(){
        return subMenu1BazaFullVG.isDisplayed();
    }
    public void clickOnBazaFullVG(){
        clickOn(subMenu1BazaFullVG);
    }
    public boolean subMenu1BazaFullIPGIsDisplayed(){
        return subMenu1BazaFullPG.isDisplayed();
    }
    public void clickOnBazaFullPG(){
        clickOn(subMenu1BazaFullPG);
    }
    public boolean subMenu1Baza500IsDisplayed(){
        return subMenu1Baza500.isDisplayed();
    }
    public void clickOnBaza500(){
        clickOn(subMenu1Baza500);
    }
}
