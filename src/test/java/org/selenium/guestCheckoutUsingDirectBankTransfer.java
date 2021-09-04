package org.selenium;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.Cartpage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class guestCheckoutUsingDirectBankTransfer extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {

        driver.get("https://askomdch.com/");

        HomePage homePage=new HomePage(driver);
        StorePage storePage= homePage.navigateToStoreUsingMenu();

        storePage.search("Blue");
        Assert.assertEquals(storePage.getTitle(),"Search results: “Blue”");
        storePage.getTitle();
        storePage.clickAddtoCartBtn("Blue Shoes");
        Thread.sleep(5000);

        Cartpage cartpage=storePage.clickViewCart();
        Assert.assertEquals(cartpage.getProductName(),"Blue Shoes");
        CheckoutPage checkoutPage=cartpage.clickCheckoutBtn();

        checkoutPage.fillFormat("Demo","Test","Kr 1 #12-34","Bogota","94118","test@test.com");
        Thread.sleep(5000);

        Assert.assertEquals(checkoutPage.getConfirmation(),"Thank you. Your order has been received.");







}

}
