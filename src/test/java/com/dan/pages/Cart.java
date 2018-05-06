package com.dan.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://substitute.ro/checkout/cart/")
public class Cart extends PageObject{

    @FindBy(css = ".base")
    private WebElementFacade cartPageTitle;
    @FindBy(css = "#empty_cart_button")
    private WebElementFacade emptyCartButton;
    @FindBy(css = ".cart .product-item-name")
    private WebElementFacade productInCart;

    public String productInCartName(){
        return productInCart.getText();
    }

    public void moveToElementEmptyCart(){
        waitFor(emptyCartButton);
        moveTo("#empty_cart_button");
    }
    public void clickEmtyCartButton(){
        clickOn(emptyCartButton);
    }

    public boolean cartIsDidplayed(){
        waitFor(cartPageTitle);
        return cartPageTitle.containsText("Cosul de cumparaturi");
    }


}
