package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage{

    private By sideNavBar = By.xpath("//button[@id='react-burger-menu-btn']");

    private By filter = By.xpath("//select[@class='product_sort_container']");
    private By cartIcon = By.xpath("//div[@id='shopping_cart_container']/a[1]");
    private By logoutBtn = By.xpath("//a[contains(@id,'logout')]");
    private By verifyHome = By.xpath("//div[@class='inventory_container']");
    private By verifyAdd = By.xpath("//button[@id='remove-sauce-labs-backpack']");

    /**
     * Select Drop-down
     * @param filterBy Select filter option
     */
    public HomePage selectFilter(String filterBy){
        Select filterProduct = new Select(driver.findElement(filter));
        filterProduct.selectByVisibleText(filterBy);
        return this;
    }

    /**
     * @param productName example : Sauce Labs Onesie
     */
    public String verifyFilterName(String productName){
        return getText(By.xpath("//div[.='"+productName+"']"));
    }

    /**
     * @param index start at 1
     */
    public String verifyFilterPrice(String index){
        return getText(By.cssSelector(".inventory_list > div:nth-of-type("+index+") .inventory_item_price"));
    }

    public boolean verifyHomePage(){
        return driver.findElement(verifyHome).isDisplayed();
    }

    public boolean verifyAddToCartBtn(){
        return driver.findElement(verifyAdd).isEnabled();
    }
    public void clickNavbar(){
        clickBtn(sideNavBar);
    }

    public void clickCartIcon(){
        clickBtn(cartIcon);
    }

    public void clickLogoutBtn(){
        clickBtn(logoutBtn);
    }

    /**
     * @param productName example : sauce-labs-backpack
     */
    public HomePage addProduct(String productName){
        driver.findElement(By.xpath("//button[contains(@id,'"+productName+"')]")).click();
        return this;
    }
}
