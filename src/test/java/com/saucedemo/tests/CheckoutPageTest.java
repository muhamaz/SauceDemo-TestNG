package com.saucedemo.tests;


import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CheckoutPageTest extends BaseTest {

    @Test
    public void verifyCancelBtn(){
        loginPage.login("standard_user", "secret_sauce");
        homePage.addProduct("sauce-labs-backpack");
        homePage.clickCartIcon();
        cartPage.clickCheckoutBtn();
        assertTrue(checkoutPage.verifyCancelBtn());
        checkoutPage.clickCancelBtn();
        assertTrue(cartPage.verifyContentCartPage());
    }

    @Test
    public void verifyContinueBtn(){
        loginPage.login("standard_user", "secret_sauce");
        homePage.addProduct("sauce-labs-backpack");
        homePage.clickCartIcon();
        cartPage.clickCheckoutBtn();
        assertTrue(checkoutPage.verifyContinueBtn());
    }

    @Test
    public void setFormWithValidData(){
        String productName = "sauce-labs-backpack";
        String userName = "Humam";
        String lastName = "Zaky";
        String postalCode = "54321";

        loginPage.login("standard_user", "secret_sauce");
        homePage.addProduct(productName);
        homePage.clickCartIcon();
        cartPage.clickCheckoutBtn();
        checkoutPage.setFirstName(userName);
        checkoutPage.setLastName(lastName);
        checkoutPage.setPostalCode(postalCode);
        checkoutPage.clickContinueBtn();
        //verify checkout summary
    }

    @Test
    public void setFormWithFirstNameIsEmpty(){
        String productName = "sauce-labs-backpack";
        String userName = "";
        String lastName = "Zaky";
        String postalCode = "54321";
        String errorMsg = "Error: First Name is required";

        loginPage.login("standard_user", "secret_sauce");
        homePage.addProduct(productName);
        homePage.clickCartIcon();
        cartPage.clickCheckoutBtn();
        checkoutPage.setFirstName(userName);
        checkoutPage.setLastName(lastName);
        checkoutPage.setPostalCode(postalCode);
        checkoutPage.clickContinueBtn();
        assertEquals(checkoutPage.getErrorMsg(), errorMsg);
    }

    @Test
    public void setFormWithLastNameIsEmpty(){
        String productName = "sauce-labs-backpack";
        String userName = "Humam";
        String lastName = "";
        String postalCode = "54321";
        String errorMsg = "Error: Last Name is required";

        loginPage.login("standard_user", "secret_sauce");
        homePage.addProduct(productName);
        homePage.clickCartIcon();
        cartPage.clickCheckoutBtn();
        checkoutPage.setFirstName(userName);
        checkoutPage.setLastName(lastName);
        checkoutPage.setPostalCode(postalCode);
        checkoutPage.clickContinueBtn();
        assertEquals(checkoutPage.getErrorMsg(), errorMsg);
    }

    @Test
    public void setFormWithPostalCodeIsEmpty(){
        String productName = "sauce-labs-backpack";
        String userName = "Humam";
        String lastName = "Zaky";
        String postalCode = "";
        String errorMsg = "Error: Postal Code is required";

        loginPage.login("standard_user", "secret_sauce");
        homePage.addProduct(productName);
        homePage.clickCartIcon();
        cartPage.clickCheckoutBtn();
        checkoutPage.setFirstName(userName);
        checkoutPage.setLastName(lastName);
        checkoutPage.setPostalCode(postalCode);
        checkoutPage.clickContinueBtn();
        assertEquals(checkoutPage.getErrorMsg(), errorMsg);
    }

    @Test
    public void setFormWithAllFieldIsEmpty(){
        String productName = "sauce-labs-backpack";
        String userName = "";
        String lastName = "";
        String postalCode = "";
        String errorMsg = "Error: First Name is required";

        loginPage.login("standard_user", "secret_sauce");
        homePage.addProduct(productName);
        homePage.clickCartIcon();
        cartPage.clickCheckoutBtn();
        checkoutPage.setFirstName(userName);
        checkoutPage.setLastName(lastName);
        checkoutPage.setPostalCode(postalCode);
        checkoutPage.clickContinueBtn();
        assertEquals(checkoutPage.getErrorMsg(), errorMsg);
    }
}
