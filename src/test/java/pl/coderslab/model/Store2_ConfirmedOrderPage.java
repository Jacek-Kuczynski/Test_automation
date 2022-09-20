package pl.coderslab.model;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class Store2_ConfirmedOrderPage {

    private WebDriver driver;


    @FindBy(className = "container")
    private WebElement screenshotContainer;

    public Store2_ConfirmedOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}




