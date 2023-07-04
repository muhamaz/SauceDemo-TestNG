package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {
    protected static WebDriver driver;

    public String browser;
    public String baseUrl;
    public Properties properties;

    private void loadProperties(){
        FileInputStream fis = null;

        //Exception handling
        try{
            properties = new Properties();
            fis = new FileInputStream("D:\\Java\\SauceDemo-TestNG\\src\\main\\java\\com\\saucedemo\\config\\config.properties");
            properties.load(fis);

            browser = properties.getProperty("browser");
            baseUrl = properties.getProperty("baseUrl");

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
        }
    }

    private void openBrowser(){
        if (browser.equals("chrome")){
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
    }

    public void closeBrowser(){
        driver.quit();
    }

    public boolean goToHomePage(){
        try {
            loadProperties();
            openBrowser();
            driver.get(baseUrl);
        }catch (Exception e){
            System.out.println("Unable to Navigate the HomePage");
            e.printStackTrace();
            return false;
        }
       return true;
    }

    public void setText(By locator, String text){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
        tab(locator);
    }

    public String getText(By locator){
        String getText = driver.findElement(locator).getText();
        if (getText.isEmpty()){
            return driver.findElement(locator).getAttribute("value");
        }else{
            return getText;
        }
    }

    public void tab(By locator){
        driver.findElement(locator).sendKeys(Keys.TAB);
    }
    public void clickBtn(By locator){
        driver.findElement(locator).click();
    }


}
