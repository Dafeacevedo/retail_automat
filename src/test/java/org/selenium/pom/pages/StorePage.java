package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

import java.security.PublicKey;

public class StorePage extends BasePage {
    private final By searchBox= By.id("woocommerce-product-search-field-0");
    private final By searchbtn = By.cssSelector("button[value='Search']");
    private final By title= By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By viewCartLink=(By.cssSelector("a[title='View cart']"));

    public StorePage(WebDriver driver) {
        super(driver);
    }




private StorePage enterTextInSeachbox(String txt){
    driver.findElement(searchBox).sendKeys(txt);
    return this;

}

public StorePage search(String txt){
        enterTextInSeachbox(txt).clickSearchbtn();
        return this;
}

private StorePage clickSearchbtn(){
        driver.findElement(searchbtn).click();
        return this;
}

public String getTitle() {
        return driver.findElement(title).getText();
}

//AQUI ESTA HACIENDO EL METODO QUE PERMITE USAR LA FLEXIBILIZACION DEL INPUT EN CUALQUIER LUGAR

    private By getAddCartBtnElement(String productName){
        return By.cssSelector("a[aria-label='Add “"+ productName +"” to your cart']");



}
//AQUI ESTA INVOCANDO EL METODO
public  StorePage clickAddtoCartBtn(String productName){
    By addToCartBtn= By.cssSelector("a[aria-label='Add “"+ productName +"” to your cart']");
    driver.findElement(addToCartBtn).click();
    return this;
}

public Cartpage clickViewCart(){
driver.findElement(viewCartLink).click();
return new Cartpage(driver);
}


}
