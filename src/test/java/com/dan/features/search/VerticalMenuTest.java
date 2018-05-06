package com.dan.features.search;


import com.dan.steps.serenity.VerticalMenu;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class VerticalMenuTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximiseWindow() {
        driver.manage().window().maximize();
    }
    @Steps
    private VerticalMenu verticalMenu;

    @Test
    public void verticalMenuButtonFunction(){
        verticalMenu.navigateToHomePage();
        verticalMenu.verticalMenuButtonIsDysplayed();
        verticalMenu.clickVerticalMenuButton();
        verticalMenu.verticalMenuContentIsDisplayed();
    }
    @Test
    public void navigateToBazaEPotionPage(){
        verticalMenu.navigateToHomePage();
        verticalMenu.clickOnBazeEpotion();
        verticalMenu.bazaEPotionPageIsDisplayed();
    }
    @Test
    public void showSubMenu() {
        verticalMenu.navigateToHomePage();
        verticalMenu.moveToElementBazeEPotion();
        verticalMenu.subMenuIsDisplayed();
    }

    @Test
    public void navigateToBazaOptimPage(){
        verticalMenu.navigateToHomePage();
        verticalMenu.moveToElementBazeEPotion();
        verticalMenu.clickOnBazaOptim();
        verticalMenu.pageBazaOptimIsDisplayed();

    }
    @Test
    public void navigateToBazaFullVGPage(){
        verticalMenu.navigateToHomePage();
        verticalMenu.moveToElementBazeEPotion();
        verticalMenu.clickOnBazaFullVG();
        verticalMenu.pageBazaFullVGIsDisplayed();
    }
    @Test
    public void navigateToBazaFullPGPage(){
        verticalMenu.navigateToHomePage();
        verticalMenu.moveToElementBazeEPotion();
        verticalMenu.clickOnBazaFullPG();
        verticalMenu.pageBazaFullPGIsDisplayed();
    }
    @Test
    public void navigateToBaza500Page(){
        verticalMenu.navigateToHomePage();
        verticalMenu.moveToElementBazeEPotion();
        verticalMenu.clickOnBaza500();
        verticalMenu.pageBaza500IsDisplayed();
    }
}
