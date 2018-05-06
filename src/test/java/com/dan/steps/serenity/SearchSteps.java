package com.dan.steps.serenity;

import com.dan.pages.HomePage;
import com.dan.pages.SearchResultPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import org.junit.Before;

public class SearchSteps extends ScenarioSteps {

    private HomePage homePage;
    private SearchResultPage searchResultPage;


    @Step
    public void navigateToHomePage(){
        homePage.open();
    }

    @Step
    public void setSearchWord(String searchWord){
        homePage.setSearchField(searchWord);
    }

    @Step
    public void clickSearchButton(){
        homePage.clickSearchButton();
    }

    @Step
    public void searchResultIsDisplayed(){
        waitFor(3 );
        Assert.assertTrue(searchResultPage.searchIsWorking());
    }
    @StepGroup
    public void doSearch(String searchWord){
        setSearchWord(searchWord);
        clickSearchButton();
        searchResultIsDisplayed();
    }


}
