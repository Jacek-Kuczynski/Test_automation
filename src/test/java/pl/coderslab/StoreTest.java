package pl.coderslab;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.model.*;
import java.time.Duration;
import static org.junit.Assert.*;

public class StoreTest {

    private final static String PERMANENT_LOGIN = "Franek@gmail.com";
    private final static String PERMANENT_PASSWORD = "12345";
    private WebDriver driver;

    @Before
    public void setUp() {
        //        Ustaw gdzie jest chromedriver -> STEROWNIK
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        //        Otworz przegladarke
        this.driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        this.driver.manage().window().maximize();
        //        Jesli test nie przechodzi poprawnie, to pewnie za wolno laduje sie strona -> Dodaj czekanie.
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.get("https://mystore-testlab.coderslab.pl/");

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

        StoreNewAddressForm storeNewAddressForm = new StoreNewAddressForm(this.driver);
        storeNewAddressForm.fillFormAndSave("Adres 1", "ul. Pelplińska 111", "Gdynia", "81-258", "United Kingdom", "123-123-123");


        String expectedNewAddressData = "Adres 1\n" + "Franek Dzbanek\n" + "ul. Pelplińska 111\n" + "Gdynia\n" + "81-258\n" + "United Kingdom\n" + "123-123-123";
        StoreAddressesPage storeAddressesPage1 = new StoreAddressesPage(driver);
        String newAddressData = storeAddressesPage1.getNewAddressData();
        assertEquals(expectedNewAddressData, newAddressData);

        storeAddressesPage.deleteAddress();

        String expectedAlertText = "Address successfully deleted!";
        String alertText = storeAddressesPage.getAlertText();
        assertEquals(expectedAlertText, alertText);

    }
}



