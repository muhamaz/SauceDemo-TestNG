package com.saucedemo.pages;


import org.openqa.selenium.By;

import java.text.DecimalFormat;

public class CheckoutSummaryPage extends BasePage{

    private By totalProdPrice = By.xpath("//div[@class='summary_subtotal_label']");
    private By totalProdPriceAndTax = By.xpath("//div[@class='summary_info_label summary_total_label']");

    private By finishBtn = By.xpath("//button[@id='finish']");


    /**
     * Getting product name on cart page
     * @param productName example : Sauce Labs Backpack
     */
    public String getProductName(String productName){
        return getText(By.xpath("//div[.='"+productName+"']"));
    }

    /**
     * Getting product price on cart page
     * @param index start at 3
     */
    public String getProductPrice(String index){
        return getText(By.cssSelector("div:nth-of-type("+index+") .inventory_item_price")).replace("$", "");
    }

    public boolean verifyProdPrice(){
        String getPriceProduct = getText(totalProdPrice).replace("Item total: $", ""); //Mendapatkan harga item total (actual)
        String getTotalPriceAndTax = getText(totalProdPriceAndTax).replace("Total: $", ""); //Mendapatkan harga total + tax

        Double getPrice = Double.valueOf(getProductPrice("3")); //konversi ke double
        Double taxBeforeRounding = getPrice*8/100; //hitung pajak sebesar 8% dari harga item total
        DecimalFormat df = new DecimalFormat("#0.00");
        String hasilBulat = df.format(taxBeforeRounding); //bulatkan pajak hasil akan berbentuk string
        Double Tax = Double.valueOf(hasilBulat); //konversi ke double

        Double totalPriceAndTax = getPrice+Tax; //tambahkan pajak dengan harga item total
        String konversiGetPrice = String.valueOf(getPrice); //konversi harga produk ke string (expected)
        String konversiTotalPriceAndTax = String.valueOf(totalPriceAndTax); //konversi total harga + tax ke string (expected)

        if(konversiGetPrice.equals(getPriceProduct) && konversiTotalPriceAndTax.equals(getTotalPriceAndTax)){
            return true;
        }else {
            return false;
        }
    }


    public void clickFinishBtn(){
        clickBtn(finishBtn);
    }

}
