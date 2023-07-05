package com.saucedemo.tests;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CartPageTest extends BaseTest{

    @Test
    public void verifyCartpage(){
        loginPage.login("standard_user", "secret_sauce");
        homePage.clickCartIcon();
        assertTrue(cartPage.verifyContentCartPage());
    }

    @Test
    public void verifyContinueBtn(){
        loginPage.login("standard_user", "secret_sauce");
        homePage.clickCartIcon();
        assertTrue(cartPage.verifyContinueShopBtn());
        cartPage.clickContinueShopBtn();
        assertTrue(homePage.verifyHomePage());
    }

    @Test
    public void verifyCheckoutBtn(){
        loginPage.login("standard_user", "secret_sauce");
        homePage.clickCartIcon();
        assertTrue(cartPage.verifyCheckoutBtn());
        cartPage.clickCheckoutBtn();
        assertTrue(checkoutPage.verifyCheckoutPage());
        assertEquals(checkoutPage.getTitlePage(), "Checkout: Your Information");
    }
}
