package pl.coderslab.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Store2_ProductAddedPopUp {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/a")
    private WebElement proceedToCheckOutButton;

    public Store2_ProductAddedPopUp(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void proceedToCheckOut() {
        proceedToCheckOutButton.click();
    }
}
