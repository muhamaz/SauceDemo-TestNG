package com.saucedemo.tests;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginPageTest extends BaseTest{

    @Test(description = "Verify LoginPage")
    public void verifyLoginPage() {
        boolean verify = loginPage.verifyLogin();
        assertTrue(verify);
    }
    @Test(description = "Login With Valid Username and Password")
    public void loginWithValidCredentials(){
        String userName = "standard_user";
        String password = "secret_sauce";
        loginPage.login(userName, password);
    }
    @Test
    public void loginWithInvalidUserName(){
        String userName = "lalala";
        String password = "secret_sauce";
        String errorMessage = "Epic sadface: Username and password do not match any user in this service";
        loginPage.login(userName, password);
        assertEquals(loginPage.getErrorMessage(), errorMessage);
    }

    @Test
    public void loginWithInvalidPassword(){
        String userName = "standard_user";
        String password = "lululu";
        String errorMessage = "Epic sadface: Username and password do not match any user in this service";
        loginPage.login(userName, password);
        assertEquals(loginPage.getErrorMessage(), errorMessage);
    }

    @Test
    public void loginWithInvalidUserNameAndPassword(){
        String userName = "lalala";
        String password = "lululu";
        String errorMessage = "Epic sadface: Username and password do not match any user in this service";
        loginPage.login(userName, password);
        assertEquals(loginPage.getErrorMessage(), errorMessage);
    }

    @Test
    public void loginWithUserNameFieldIsEmpty(){
        String userName = "";
        String password = "secret_sauce";
        String errorMessage = "Epic sadface: Username is required";
        loginPage.login(userName, password);
        assertEquals(loginPage.getErrorMessage(), errorMessage);
    }

    @Test
    public void loginWithPasswordFieldIsEmpty(){
        String userName = "standard_user";
        String password = "";
        String errorMessage = "Epic sadface: Password is required";
        loginPage.login(userName, password);
        assertEquals(loginPage.getErrorMessage(), errorMessage);
    }

    @Test
    public void loginWithAllFieldIsEmpty(){
        String userName = "";
        String password = "";
        String errorMessage = "Epic sadface: Username is required";
        loginPage.login(userName, password);
        assertEquals(loginPage.getErrorMessage(), errorMessage);
    }

}
