package com.saucedemo.tests;


import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HomePageTest extends BaseTest{

    @Test
    public void verifyHomePage(){
        loginPage.login("standard_user", "secret_sauce");
        boolean verify = homePage.verifyHomePage();
        assertTrue(verify, "HomePage not Displayed");
    }
    @Test
    public void addToCartButton(){
        String productName = "sauce-labs-backpack";
        loginPage.login("standard_user", "secret_sauce");
        homePage.addProduct(productName);
        assertTrue(homePage.verifyAddToCartBtn());
        homePage.clickCartIcon();
        assertTrue(cartPage.verifyContentCartPage());
        assertTrue(cartPage.verifyCartItem());
    }
    @Test
    public void cartIcon(){
        loginPage.login("standard_user", "secret_sauce");
        homePage.clickCartIcon();
        assertTrue(cartPage.verifyContentCartPage());
    }
    @Test
    public void logoutFromWebsite() throws InterruptedException {
        loginPage.login("standard_user", "secret_sauce");
        homePage.clickNavbar();
        Thread.sleep(1000);
        homePage.clickLogoutBtn();
        assertTrue(loginPage.verifyLogin());
    }

    @Test
    public void filterProduct(){
        loginPage.login("standard_user", "secret_sauce");
        homePage.selectFilter("Price (low to high)");
        assertEquals(homePage.verifyFilterName("Sauce Labs Onesie"), "Sauce Labs Onesie");
        assertEquals(homePage.verifyFilterPrice("1"), "$7.99");
    }
}
