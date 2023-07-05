package com.saucedemo.pages;

import org.openqa.selenium.By;

public class CheckoutPage extends BasePage{
    private By firstNameField = By.xpath("//input[@id='first-name']");
    private By lastNameField = By.xpath("//input[@id='last-name']");
    private By postalCodeField = By.xpath("//input[@id='postal-code']");
    private By cancelBtn = By.xpath("//button[@id='cancel']");
    private By continueBtn = By.xpath("//input[@id='continue']");
    private By title = By.xpath("//span[@class='title']");
    private By errMsg = By.cssSelector("h3");


    public CheckoutPage setFirstName(String firstName){
        setText(firstNameField, firstName);
        return null;
    }

    public CheckoutPage setLastName(String lastName){
        setText(lastNameField, lastName);
        return null;
    }

    public CheckoutPage setPostalCode(String postalCode){
        setText(postalCodeField, postalCode);
        return null;
    }

    public void clickContinueBtn(){
        clickBtn(continueBtn);
    }

    public void clickCancelBtn(){
        clickBtn(cancelBtn);
    }

    public boolean verifyCheckoutPage(){
        return driver.findElement(firstNameField).isDisplayed();
    }

    public boolean verifyCancelBtn(){
        return driver.findElement(cancelBtn).isEnabled();
    }

    public boolean verifyContinueBtn(){
        return driver.findElement(continueBtn).isEnabled();
    }

    public String getTitlePage(){
        return getText(title);
    }

    public String getErrorMsg(){
        return getText(errMsg);
    }
}
