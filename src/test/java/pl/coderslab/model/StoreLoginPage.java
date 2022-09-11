package pl.coderslab.model;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreLoginPage {

    private WebDriver driver;

    @FindBy(name = "email")
    private WebElement signInEmailAddressInput;
    @FindBy(name = "password")
    private WebElement signInPasswordInput;
    @FindBy(id = "submit-login")
    private WebElement signInButton;

    public StoreLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void signInWithCredentials(String email, String password) {
        signInEmailAddressInput.clear();
        signInEmailAddressInput.sendKeys(email);

        signInPasswordInput.clear();
        signInPasswordInput.sendKeys(password);

        signInButton.click();
    }
}
