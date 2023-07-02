package com.saucedemo.tests;

import com.saucedemo.pages.BasePage;
import com.saucedemo.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.*;

public class BaseTest extends BasePage {

    protected LoginPage loginPage;
    @BeforeMethod
    public void setup(){
        assertTrue(goToHomePage(), "An error occurred while navigate to the HomePage");
         loginPage = new LoginPage();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        closeBrowser();
    }
}
