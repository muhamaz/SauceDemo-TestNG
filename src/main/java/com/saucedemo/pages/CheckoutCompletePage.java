package com.saucedemo.pages;

import org.openqa.selenium.By;

public class CheckoutCompletePage extends BasePage {

    private By getCompleteText = By.xpath("//h2[@class='complete-header']");

    private By BackBtn = By.xpath("//button[@id='back-to-products']");


    public String verifyGetCompleteText(){
        return getText(getCompleteText);
    }

    public void clickBackHomeBtn(){
        clickBtn(BackBtn);
    }
}
