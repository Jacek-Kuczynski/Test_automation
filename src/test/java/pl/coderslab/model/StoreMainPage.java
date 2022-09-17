package pl.coderslab.model;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class StoreMainPage {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/main/header/nav/div/div/div[1]/div[2]/div[2]/div/a/i")
    private WebElement signInButton;

    public StoreMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickSignIn() {
        signInButton.click();
    }
}


