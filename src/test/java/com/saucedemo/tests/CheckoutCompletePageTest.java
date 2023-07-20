package com.saucedemo.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CheckoutCompletePageTest extends BaseTest{
    @Test
    public void verifyProductPrice() {
        String productName = "sauce-labs-backpack";
        String userName = "Humam";
        String lastName = "Zaky";
        String postalCode = "54321";
        String getCompleteText = "Thank you for your order!";

        loginPage.login("standard_user", "secret_sauce");
        homePage.addProduct(productName);
        homePage.clickCartIcon();
        cartPage.clickCheckoutBtn();
        checkoutPage.setFirstName(userName);
        checkoutPage.setLastName(lastName);
        checkoutPage.setPostalCode(postalCode);
        checkoutPage.clickContinueBtn();
        assertTrue(checkoutSummaryPage.verifyProdPrice());
        checkoutSummaryPage.clickFinishBtn();
        assertEquals(checkoutCompletePage.verifyGetCompleteText(), getCompleteText);
        checkoutCompletePage.clickBackHomeBtn();
        assertTrue(homePage.verifyHomePage());
    }
}
