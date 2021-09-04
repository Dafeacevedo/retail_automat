package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class CheckoutPage extends BasePage {
    private final By first_Name= By.id("billing_first_name");
    private final By last_Name=By.id("billing_last_name");
    private final By Address=By.id("billing_address_1");
    private final By City=By.id("billing_city");
    private final By PostCode=By.id("billing_postcode");
    private final By Email=By.id("billing_email");
    private final By placeOrderBtn=By.id("place_order");
    private final By confirmation=By.cssSelector(".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received");
    private final By clickToLoginLink=  By.cssSelector(".showlogin");
    private final By username= By.cssSelector("#username");
    private final By password=By.cssSelector("#password");
    private final By loginButton=By.cssSelector("button[value='Login']");
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private CheckoutPage enterFirstName(String firstname){
        driver.findElement(first_Name).sendKeys(firstname);
        return this;
    }

    private CheckoutPage enterLastName(String lastname){
        driver.findElement(last_Name).sendKeys(lastname);
        return this;
    }
    private CheckoutPage Address(String address){
        driver.findElement(Address).sendKeys(address);
        return this;
    }
    private CheckoutPage City(String city){
        driver.findElement(City).sendKeys(city);
        return this;
    }
    private CheckoutPage PostCode(String postcode){
        driver.findElement(PostCode).sendKeys(postcode);
        return this;
    }

    private CheckoutPage Email(String email){
        driver.findElement(Email).sendKeys(email);
        return this;
    }

    private CheckoutPage clickPlaceOrderBtn(){

        driver.findElement(placeOrderBtn).click();
        return new CheckoutPage(driver);
    }

    public String getConfirmation(){

        return driver.findElement(  By.cssSelector(".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received")).getText();
    }

    private CheckoutPage clickPlaceOrder(){
        driver.findElement(placeOrderBtn).click();
        return this;
    };

    private CheckoutPage clickToLoginLink(){
      driver.findElement(clickToLoginLink).click();
      return this;
    };
    private CheckoutPage enterUsername(String usrname){
        driver.findElement(username).sendKeys(usrname);
        return this;
    };
    private CheckoutPage enterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
        return this;
    };
    private CheckoutPage pressTologin(){
        driver.findElement(loginButton).click();
        return this;
    }




    public CheckoutPage fillFormat(String first,String last,String address,String city,String postcode,String email){
        enterFirstName(first);
        enterLastName(last);
        Address(address);
        City(city);
        PostCode(postcode);
        Email(email);
        clickPlaceOrder();
        return this;
    }



    public CheckoutPage loginAccount(String username,String password) throws InterruptedException {
        clickToLoginLink();
       Thread.sleep(3000);
        enterUsername(username);
        enterPassword(password);
        pressTologin();
        Thread.sleep(3000);
        clickPlaceOrder();
        return this;
    };



}
