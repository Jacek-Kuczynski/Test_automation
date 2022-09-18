package pl.coderslab.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Store2_ClothesPage {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article[2]/div/div[1]/h2/a")
    private WebElement hummingbirdPrintedSweater;

    public Store2_ClothesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectSweater() {
        hummingbirdPrintedSweater.click();
    }
}

