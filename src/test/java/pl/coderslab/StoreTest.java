package pl.coderslab;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.model.*;

import java.time.Duration;

public class StoreTest {

    private final static String PERMANENT_LOGIN = "Franek@gmail.com";
    private final static String PERMANENT_PASSWORD = "12345";
    private WebDriver driver;

    @Before
    public void setUp() {
        //        Ustaw gdzie jest chromedriver -> STEROWNIK
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
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
    }
}
