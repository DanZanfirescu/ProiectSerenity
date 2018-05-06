package com.dan.features.search;

import com.dan.steps.serenity.LoginSearchSelectRandomSteps;
import com.dan.steps.serenity.LoginSteps;
import com.dan.steps.serenity.SearchSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginSearchSelectRandomTest {
    @Managed(uniqueSession = true)
    public WebDriver driver;
    @Before
    public void maximiseWindow() {
        driver.manage().window().maximize();
    }
    @Steps
    private LoginSteps loginSteps;
    @Steps
    private LoginSearchSelectRandomSteps loginSearchSelectRandomSteps;
    @Steps
    private SearchSteps searchSteps;

    @Test
    public void loginSearchSelectRandom(){
        loginSteps.doLogin("danzanf@yahoo.com","abc123");
        loginSearchSelectRandomSteps.clickOnCookieAcceptButton();
        searchSteps.doSearch("aroma");
        loginSearchSelectRandomSteps.totalNumberOfPages();
        loginSearchSelectRandomSteps.randomPageNumber();
        loginSearchSelectRandomSteps.navigateToRandomPage();
        loginSearchSelectRandomSteps.checkThatIsAtLeastOneProductInStockOnPage();
        loginSearchSelectRandomSteps.randomProduct();
        loginSearchSelectRandomSteps.selectAndAddToCart();
        loginSearchSelectRandomSteps.navigateToCartPage();
        loginSearchSelectRandomSteps.checkCartPage();
        loginSearchSelectRandomSteps.compareSelectedProductWithCartProduct();
        loginSearchSelectRandomSteps.emptyCartBeforeExit();
    }

}
