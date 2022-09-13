package pl.coderslab;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.model.StoreAddressesPage;
import pl.coderslab.model.StoreLoginPage;
import pl.coderslab.model.StoreMainPage;
import pl.coderslab.model.StoreMyAccountPage;

import java.time.Duration;
import java.util.Random;

import static org.junit.Assert.*;

public class StoreTest {

    private final static String PERMANENT_LOGIN = "Franek@gmail.com";
    private final static String PERMANENT_PASSWORD = "12345";
    private static WebDriver driver;

    @Before
    public void setUp() {
        //        Ustaw gdzie jest chromedriver -> STEROWNIK
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        //        Otworz przegladarke
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        //        Jesli test nie przechodzi poprawnie, to pewnie za wolno laduje sie strona -> Dodaj czekanie.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/");
    }

    @Test
    public void testAddingAddress() {
        StoreMainPage storeMainPage = new StoreMainPage(this.driver);
        storeMainPage.clickSignIn();

        StoreLoginPage storeLoginPage = new StoreLoginPage(this.driver);
        storeLoginPage.signInWithCredentials(PERMANENT_LOGIN, PERMANENT_PASSWORD);

        StoreMyAccountPage storeMyAccountPage = new StoreMyAccountPage(this.driver);
        storeMyAccountPage.goToAddresses();

        StoreAddressesPage storeAddressesPage = new StoreAddressesPage(this.driver);
        storeAddressesPage.goToCreateNewAddress();
    }
}
