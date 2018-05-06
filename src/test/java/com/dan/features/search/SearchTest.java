package com.dan.features.search;

import com.dan.steps.serenity.SearchSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WhenPageOpens;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SearchTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximiseWindow() {
        driver.manage().window().maximize();
    }
    @Steps
    private SearchSteps searchSteps;

    @Test
    public void checkSearchFunction(){
        searchSteps.navigateToHomePage();
        searchSteps.setSearchWord("aroma");
        searchSteps.clickSearchButton();
        searchSteps.searchResultIsDisplayed();
    }
}
