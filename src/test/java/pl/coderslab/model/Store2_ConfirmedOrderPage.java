package pl.coderslab.model;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Store2_ConfirmedOrderPage {

    private WebDriver driver;


    @FindBy(xpath = "//*[@id=\"order-confirmation\"]")
    private WebElement orderConf;

    public Store2_ConfirmedOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

//    public TakesScreenshot getOrderConfScreenshot() {
//        return orderConf;
//    }
}





