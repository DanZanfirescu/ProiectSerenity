package com.dan.steps.serenity;

import com.dan.pages.*;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class VerticalMenu extends ScenarioSteps {
    private HomePage homePage;
    private BazaOptim bazaOptim;
    private BazaFullVG bazaFullVG;
    private BazaFullPG bazaFullPG;
    private Baza500 baza500;
    private BazaEPotion bazaEPotion;
    @Step
    public void navigateToHomePage(){
        homePage.open();
    }
    @Step
    public void verticalMenuButtonIsDysplayed(){
        Assert.assertTrue(homePage.verticalMenuButtonIsDisplayed());
    }
    @Step
    public void clickVerticalMenuButton(){
        homePage.clickVerticalMenuButton();
    }
    @Step
    public void verticalMenuContentIsDisplayed(){
        Assert.assertFalse(homePage.verticalMenuConent());
    }
    @Step
    public void clickOnBazeEpotion(){
        homePage.clickOnBazeEPotion();
    }
    @Step
    public void bazaEPotionPageIsDisplayed(){
        Assert.assertTrue(bazaEPotion.isPageTitleDisplayed());
    }
    @Step
    public void moveToElementBazeEPotion(){
        homePage.moveTo("#pt_menu10");
    }
    @Step
    public void subMenuIsDisplayed(){
        Assert.assertTrue(homePage.subMenu1IsDisplayed());
    }
    @Step
    public void clickOnBazaOptim(){
        homePage.clickOnBazaOptim();
    }
    @Step
    public void pageBazaOptimIsDisplayed(){
        Assert.assertTrue(bazaOptim.isPageTitleDisplayed());
    }
    @Step
    public void clickOnBazaFullVG(){
        homePage.clickOnBazaFullVG();
    }
    @Step
    public void pageBazaFullVGIsDisplayed(){
        Assert.assertTrue(bazaFullVG.isPageTitleDisplayed());
    }
    @Step
    public void clickOnBazaFullPG(){
        homePage.clickOnBazaFullPG();
    }
    @Step
    public void pageBazaFullPGIsDisplayed(){
        Assert.assertTrue(bazaFullPG.isPageTitleDisplayed());
    }
    @Step
    public void clickOnBaza500(){
        homePage.clickOnBaza500();
    }
    @Step
    public void pageBaza500IsDisplayed(){
        Assert.assertTrue(baza500.isPageTitleDisplayed());
    }
}
