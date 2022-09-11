package pl.coderslab.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Random;

import static org.junit.Assert.*;

public class StoreSteps {

    private WebDriver driver;

    @Given("an open browser with {}")
    public void openBrowser(String url) {
        //        Ustaw gdzie jest chromedriver -> STEROWNIK
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        //        Otworz przegladarke
        this.driver = new ChromeDriver();
        //        Jesli test nie przechodzi poprawnie, to pewnie za wolno laduje sie strona -> Dodaj czekanie.
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.get(url);
    }

    @And("logged in")
    public void logInWithEmail() {

        WebElement signInButton = this.driver.findElement(By.xpath("/html/body/main/header/nav/div/div/div[1]/div[2]/div[2]/div/a/span"));
        signInButton.click();

        WebElement logInEmailInput = this.driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/section/form/section/div[1]/div[1]/input"));
        logInEmailInput.clear();
        logInEmailInput.sendKeys("Franek@gmail.com");
        WebElement logInPasswordInput = this.driver.findElement(By.name("password"));
        logInPasswordInput.clear();
        logInPasswordInput.sendKeys("12345");
        WebElement signInButtonSubmit = this.driver.findElement(By.id("submit-login"));
        signInButtonSubmit.click(); // #  logowanie do systemu
    }
}

