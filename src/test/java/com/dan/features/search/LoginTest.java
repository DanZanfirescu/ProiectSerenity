package com.dan.features.search;

import com.dan.steps.serenity.LoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;
    @Before
    public void maximiseWindow() {
        driver.manage().window().maximize();
    }
    @Steps
    private LoginSteps loginSteps;

    @Test
    public void checkLoginFunctionValidCredentilas(){
        loginSteps.navigateToCustomerLoginPage();
        loginSteps.setCredentials("danzanf@yahoo.com", "abc123");
        loginSteps.clickLogin();
        loginSteps.userIsLoggedIn();
    }

    @Test
    public void checkLoginFunctionInvalidPassword(){
        loginSteps.navigateToCustomerLoginPage();
        loginSteps.setCredentials("danzanf@yahoo.com", "parola");
        loginSteps.clickLogin();
        loginSteps.userIsNotLoggedIn();
    }
    @Test
    public void checkLoginFunctionInvalidUserName() {
        loginSteps.navigateToCustomerLoginPage();
        loginSteps.setCredentials("sadd@sad.com", "abc1234");
        loginSteps.clickLogin();
        loginSteps.wrongUserName();
    }
    @Test
    public void checkLoginFunctionInvalidUserNameFormat(){
        loginSteps.navigateToCustomerLoginPage();
        loginSteps.setCredentials("sad", "abc123");
        loginSteps.clickLogin();
        loginSteps.wrongEmailFormat();
    }
    @Test
    public void checkLoginFunctionEmptyUserNameField(){
        loginSteps.navigateToCustomerLoginPage();
        loginSteps.setCredentials("", "abc123");
        loginSteps.clickLogin();
        loginSteps.emptyEmailField();
    }
    @Test
    public void checkLoginFunctionEmptyPasswordField(){
        loginSteps.navigateToCustomerLoginPage();
        loginSteps.setCredentials("danzanf@yahoo.com", "");
        loginSteps.clickLogin();
        loginSteps.emptyPasswordField();
    }
    @Test
    public void forgotPasswordLink(){
        loginSteps.navigateToCustomerLoginPage();
        loginSteps.forgotPassword();
    }
}

