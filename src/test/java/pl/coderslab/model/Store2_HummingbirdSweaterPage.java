package pl.coderslab.model;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Store2_HummingbirdSweaterPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"group_1\"]")
    private WebElement expandSizeList;

    @FindBy(xpath = "//*[@id=\"group_1\"]/option[2]")
    private WebElement selectSizeM;

    @FindBy(name = "qty")
    private WebElement quantityTextField;

    @FindBy(className = "add")
    private WebElement addToCartButton;

    public Store2_HummingbirdSweaterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void addToCartWithSizeAndQuantity(String quantity) {
        expandSizeList.click();
        selectSizeM.click();

        quantityTextField.click();
        quantityTextField.clear();
        quantityTextField.sendKeys(Keys.CONTROL, "a");
        quantityTextField.sendKeys(Keys.BACK_SPACE);
        quantityTextField.sendKeys(quantity);
        addToCartButton.click();

    }
}

// nextPage >>> ProductAddedPOPup