package pl.coderslab.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Store2_OrderSummaryPage {

    private WebDriver driver;

    @FindBy(name = "confirm-addresses")
    private WebElement confirmAddressWithContinueButton;

    @FindBy(xpath = "//*[@id=\"js-delivery\"]/div/div[1]/div[1]/div/span/span")
    private WebElement selectPickUpInStore;

    @FindBy(xpath = "/html/body/section/div/section/div/div[1]/section[3]/div/div[2]/form/button")
    private WebElement confirmShippingMethod;

    @FindBy(id = "payment-option-1")
    private WebElement selectPayByCheck;

    @FindBy(xpath = "/html/body/section/div/section/div/div[1]/section[4]/div/form/ul/li/div[1]/span/input")
    private WebElement selectAgreeToServiceTerms;

    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
    private WebElement orderWithAnObligationToPayButton;



    public Store2_OrderSummaryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void confirmAddress() {
        confirmAddressWithContinueButton.click();
    }

    public void selectShippingMethod() {
        selectPickUpInStore.click();
        confirmShippingMethod.click();
    }

    public void selectPaymentOption() {
        selectPayByCheck.click();
        selectAgreeToServiceTerms.click();
        orderWithAnObligationToPayButton.click();

    }
}
