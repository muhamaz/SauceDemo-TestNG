package com.saucedemo.tests;

import com.saucedemo.pages.BasePage;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.*;

public class BaseTest extends BasePage {

    protected LoginPage loginPage;
    protected HomePage homePage;
    protected CartPage cartPage;
    @BeforeMethod
    public void setup(){
        assertTrue(goToHomePage(), "An error occurred while navigate to the HomePage");
         loginPage = new LoginPage();
         homePage = new HomePage();
         cartPage = new CartPage();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        closeBrowser();
    }
}
