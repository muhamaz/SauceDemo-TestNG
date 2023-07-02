package com.saucedemo.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private By loginBtn = By.xpath("//input[@id='login-button']");
    private By userNameField = By.xpath("//input[@id='user-name']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By errorMessage = By.cssSelector("h3");


    public boolean verifyLogin(){
        return driver.findElement(loginBtn).isEnabled();
    }

    public LoginPage setUsername(String userName){
        setText(userNameField, userName);
        return null;
    }
    public LoginPage setPassword(String password){
        setText(passwordField, password);
        return null;
    }
    public void clickLoginBtn(){
        clickBtn(loginBtn);
    }

    public String getErrorMessage(){
        return getText(errorMessage);
    }

    public void login(String userName, String password){
        setUsername(userName);
        setPassword(password);
        clickLoginBtn();
    }


}
