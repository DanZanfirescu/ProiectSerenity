package com.dan.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;


import java.util.List;

@DefaultUrl("https://substitute.ro/catalogsearch/result/")
public class SearchResultPage extends PageObject{

    @FindBy(css = ".base")
    private WebElementFacade searchPageTitle;
    @FindBy(css = ".toolbar-products:last-child .pages-item-next")
    private WebElementFacade nextPageButton;
    @FindBy(css = ".toolbar-products:last-child .pages-item-previous")
    private WebElementFacade previousPageButton;
    @FindBy(css = "#btn-cookie-allow")
    private WebElementFacade cookieAcceptBtn;
    @FindBy(css = ".toolbar-products:first-child #toolbar-amount span:nth-of-type(3)")
    private WebElementFacade totalNumberOfProductsFound;
    @FindBy(css = ".toolbar-products:last-child #limiter ")
    private WebElementFacade numberOfProductsDisplayedOnPage;
    @FindBy(css = ".products.list .item")
    public List<WebElementFacade> productList;
    @FindBy(css = ".minicart-wrapper")
    private WebElementFacade cart;
    @FindBy(css = ".action.viewcart")
    private WebElementFacade viewCart;

    public void moveToElementViewCart(){
        waitFor(viewCart);
        moveTo(".action.viewcart");
    }
    public void clickOnViewCart(){
        waitForTimeoutInMilliseconds();
        clickOn(viewCart);
    }
    public void moveToElementCart(){
        waitFor(cart);
        moveTo(".minicart-wrapper");
    }
    public void clickOnCart(){
        clickOn(cart);
    }
    public int setTotalNumberOfProductsFound(){
        waitFor(totalNumberOfProductsFound);
        return Integer.valueOf(totalNumberOfProductsFound.getText());
    }
    public int setNumberOfProductsDisplayedOnPage(){
        waitFor(numberOfProductsDisplayedOnPage);
        return Integer.valueOf(numberOfProductsDisplayedOnPage.getSelectedValue());
    }

    public boolean searchIsWorking(){
        waitFor(searchPageTitle);
        return  searchPageTitle.isDisplayed();
    }
    public void clickNextPageButton(){
        waitFor(nextPageButton);
        clickOn(nextPageButton);
    }
    public void clickPreviousPageButton(){
        waitFor(previousPageButton);
        clickOn(previousPageButton);
    }
    public boolean nextButtonIsDisplayed(){
        return nextPageButton.isCurrentlyVisible();
    }
    public void moveToElementNextButton(){
        moveTo(".toolbar-products:last-child .pages-item-next");
    }
    public void moveToElementPreviousButton(){
        moveTo(".toolbar-products:last-child .pages-item-previous");
}
    public void cookieAcceptBtn(){
        clickOn(cookieAcceptBtn);
    }
    public boolean cookieAcceptBtnIsDisplayed(){
        return cookieAcceptBtn.isCurrentlyVisible();
    }
    public void moveToCookieAcceptBtn(){
        moveTo("#btn-cookie-allow");
    }
}
