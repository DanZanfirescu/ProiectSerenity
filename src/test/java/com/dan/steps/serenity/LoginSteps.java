package com.dan.steps.serenity;


import com.dan.pages.CustomerLoginPage;
import com.dan.pages.ForgotPasswordPage;
import com.dan.pages.MyAccountPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class LoginSteps extends ScenarioSteps {

    private CustomerLoginPage customerLoginPage;
    private MyAccountPage myAccountPage;
    private ForgotPasswordPage forgotPasswordPage;

    @Step
    public void navigateToCustomerLoginPage(){
        customerLoginPage.open();
    }
    @Step
    public void setCredentials(String userName, String password){
        customerLoginPage.setUserEmailField(userName);
        customerLoginPage.setUserPasswordField(password);
    }
    @Step
    public void clickLogin(){
        customerLoginPage.clickLoginButton();
    }
    @Step
    public void userIsLoggedIn(){
        Assert.assertTrue(myAccountPage.isLoggedIn());
    }

    @StepGroup
    public void doLogin(String userName, String password){
        navigateToCustomerLoginPage();
        setCredentials(userName, password);
        clickLogin();
        userIsLoggedIn();
    }


    @Step
    public void userIsNotLoggedIn(){
        Assert.assertTrue(customerLoginPage.notLogedInMessage());
    }
    @Step
    public void wrongUserName(){
        Assert.assertTrue(customerLoginPage.invalidUserName());
    }
    @Step
    public void wrongEmailFormat(){
        Assert.assertTrue(customerLoginPage.invalidEmailFormat());
    }
    @Step
    public void emptyEmailField(){
        Assert.assertTrue(customerLoginPage.emptyUserNameFieldMessage());
    }
    @Step
    public void emptyPasswordField(){
        Assert.assertTrue(customerLoginPage.emptyPasswordFieldMessage());
    }
    @Step
    public void forgotPassword(){
        customerLoginPage.clickForgotPasswordLink();
        Assert.assertTrue(forgotPasswordPage.pageTitle());
    }
}
