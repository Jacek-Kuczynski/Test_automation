package pl.coderslab.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreAddressesPage {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[2]/article/div[1]")
    private WebElement expectedNewAddressData;

    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[3]/a")
    private WebElement createNewAddressButton;

    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[2]/article/div[2]/a[2]")
    private WebElement deleteAddressButton;

    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
    private WebElement deleteSuccessField;

    public StoreAddressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void goToCreateNewAddress() {
        createNewAddressButton.click();
    }

    public String getNewAddressData() {
        return expectedNewAddressData.getText();
    }
    public void deleteAddress() {
        deleteAddressButton.click();
    }
    public String getAlertText() {
        return deleteSuccessField.getText();
    }
}