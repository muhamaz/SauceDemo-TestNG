package com.saucedemo.pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage{
    private By verifyCart = By.xpath("//div[@id='cart_contents_container']");
    private By verifyCartItem = By.xpath("//div[@class='cart_item']");
    private By checkoutBtn = By.xpath("//button[@id='checkout']");
    private By contShopBtn = By.xpath("//button[@id='continue-shopping']");


    public boolean verifyContentCartPage(){
        return driver.findElement(verifyCart).isDisplayed();
    }

    public boolean verifyCartItem(){
        return driver.findElement(verifyCartItem).isDisplayed();
    }

    public boolean verifyCheckoutBtn(){
        return driver.findElement(checkoutBtn).isEnabled();
    }

    public boolean verifyContinueShopBtn(){
        return driver.findElement(contShopBtn).isEnabled();
    }

    public void clickContinueShopBtn(){
        clickBtn(contShopBtn);
    }

    public void clickCheckoutBtn(){
        clickBtn(checkoutBtn);
    }

}
