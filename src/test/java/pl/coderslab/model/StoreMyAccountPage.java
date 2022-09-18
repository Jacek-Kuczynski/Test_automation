package pl.coderslab.model;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreMyAccountPage {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div/div/a[2]/span/i")
    private WebElement addressesButton;

    @FindBy(xpath = "//*[@id=\"category-3\"]/a")
    private WebElement clothesFromTopMenuButton;

    public StoreMyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void goToAddresses() {
        addressesButton.click();
    }

    public void selectClothesFromTopMenuButton() {
        clothesFromTopMenuButton.click();
    }
}
