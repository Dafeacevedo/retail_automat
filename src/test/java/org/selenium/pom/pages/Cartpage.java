package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class Cartpage extends BasePage {
    private final By productName= By.cssSelector("td[class='product-name'] a");
    private final By checkoutBtn=By.cssSelector(".checkout-button.button.alt.wc-forward");


    public Cartpage(WebDriver driver) {
        super(driver);
    }
public String getProductName(){
return driver.findElement(productName).getText();

}
public CheckoutPage clickCheckoutBtn(){

        driver.findElement(checkoutBtn).click();
        return new CheckoutPage(driver);
}
}
