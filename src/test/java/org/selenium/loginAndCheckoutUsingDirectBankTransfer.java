package org.selenium;

import org.openqa.selenium.By;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.Cartpage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginAndCheckoutUsingDirectBankTransfer extends BaseTest {

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {

        StorePage storePage=new HomePage(driver)
                .load()
                .navigateToStoreUsingMenu()
                .search("Blue");

        Assert.assertEquals(storePage.getTitle(),"Search results: “Blue”");
        storePage.getTitle();
        storePage.clickAddtoCartBtn("Blue Shoes");
        Thread.sleep(5000);

        Cartpage cartpage=storePage.clickViewCart();
        Assert.assertEquals(cartpage.getProductName(),"Blue Shoes");
        CheckoutPage checkoutPage=cartpage.clickCheckoutBtn();

        checkoutPage.loginAccount("demotest1234","1234");
        Thread.sleep(5000);
        Assert.assertEquals(checkoutPage.getConfirmation(),"Thank you. Your order has been received.");




    }
}
