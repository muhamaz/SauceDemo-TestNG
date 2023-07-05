package com.saucedemo.tests;

import com.saucedemo.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.*;

public class BaseTest extends BasePage {

    protected LoginPage loginPage;
    protected HomePage homePage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    @BeforeMethod
    public void setup(){
        assertTrue(goToHomePage(), "An error occurred while navigate to the HomePage");
         loginPage = new LoginPage();
         homePage = new HomePage();
         cartPage = new CartPage();
         checkoutPage = new CheckoutPage();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        closeBrowser();
    }
}
