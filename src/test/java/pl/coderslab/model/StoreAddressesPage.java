package pl.coderslab.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreAddressesPage {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[3]/a")
    private WebElement createNewAddressButton;

    public StoreAddressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void goToCreateNewAddress() {
        createNewAddressButton.click();
    }
}
