package pl.coderslab;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.model.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.name;

public class StoreTest {

    private final static String PERMANENT_LOGIN = "Franek@gmail.com";
    private final static String PERMANENT_PASSWORD = "12345";
    private final static String quantity = "5";

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

        // przejdź ze strony głównej do strony logowania
        StoreMainPage storeMainPage = new StoreMainPage(this.driver);
        storeMainPage.clickSignIn();

        // zaloguj się na utworzonego użytkownika (z conajmniej 1 dodanym adresem)
        StoreLoginPage storeLoginPage = new StoreLoginPage(this.driver);
        storeLoginPage.signInWithCredentials(PERMANENT_LOGIN, PERMANENT_PASSWORD);

        // przejdź do adresów użytkownika (kafelek "ADDRESSES")
        StoreMyAccountPage storeMyAccountPage = new StoreMyAccountPage(this.driver);
        storeMyAccountPage.goToAddresses();

        // przejdź do strony tworzenia nowego adresu
        StoreAddressesPage storeAddressesPage = new StoreAddressesPage(this.driver);
        storeAddressesPage.goToCreateNewAddress();

        // wypełnij formularz i zapisz
        StoreNewAddressForm storeNewAddressForm = new StoreNewAddressForm(this.driver);
        storeNewAddressForm.fillFormAndSave("Adres 1", "ul. Pelplińska 111", "Gdynia", "81-258", "United Kingdom", "123-123-123");

        // sprawdź, czy nowy adres zawiera te same dane
        String expectedNewAddressData = "Adres 1\n" + "Franek Dzbanek\n" + "ul. Pelplińska 111\n" + "Gdynia\n" + "81-258\n" + "United Kingdom\n" + "123-123-123";
        StoreAddressesPage storeAddressesPage1 = new StoreAddressesPage(driver);
        String newAddressData = storeAddressesPage1.getNewAddressData();
        assertEquals(expectedNewAddressData, newAddressData);

        // usuń nowy adres
        storeAddressesPage.deleteAddress();

        // sprawdź, czy wyświetla się komunikat potwierdzający usunięcie adresu
        String expectedAlertText = "Address successfully deleted!";
        String alertText = storeAddressesPage.getAlertText();
        assertEquals(expectedAlertText, alertText);

    }

    @Test
    public void testBuyingClothes() {

        StoreMainPage storeMainPage = new StoreMainPage(this.driver);
        storeMainPage.clickSignIn();

        StoreLoginPage storeLoginPage = new StoreLoginPage(this.driver);
        storeLoginPage.signInWithCredentials(PERMANENT_LOGIN, PERMANENT_PASSWORD);

        // przejdź do kategorii z ubraniami przez zakładkę "CLOTHES" w górnym menu
        StoreMyAccountPage storeMyAccountPage = new StoreMyAccountPage(this.driver);
        storeMyAccountPage.selectClothesFromTopMenuButton();

        Store2_ClothesPage store2_clothesPage = new Store2_ClothesPage(this.driver);
        store2_clothesPage.selectSweater();

        Store2_HummingbirdSweaterPage store2_hummingbirdSweaterPage = new Store2_HummingbirdSweaterPage(this.driver);
        store2_hummingbirdSweaterPage.addToCartWithSizeAndQuantity(quantity);

        Store2_ProductAddedPopUp store2_popUpProductAdded = new Store2_ProductAddedPopUp(this.driver);
        store2_popUpProductAdded.proceedToCheckOut();

        Store2_ShoppingCartPage store2_shoppingCartPage = new Store2_ShoppingCartPage(this.driver);
        store2_shoppingCartPage.proceed2CheckOut();

        Store2_OrderSummaryPage store2_orderSummaryPage = new Store2_OrderSummaryPage(this.driver);
        store2_orderSummaryPage.confirmAddress();
        store2_orderSummaryPage.selectShippingMethod();
        store2_orderSummaryPage.selectPaymentOption();

        //screenshot potwierdzenia i kwoty
        File screenshot = driver.findElement(By.xpath("//*[@id=\"order-confirmation\"]")).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("C:/CodersLab/Test_automation/screenshot1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // screenshot całej strony
//        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
//        ImageIO.write(fpScreenshot.getImage(), "PNG", new File("C:/CodersLab/Test_automation/screenshot2.png"));

    }
}


// >>> wybierze do zakupu Hummingbird Printed Sweater (opcja dodatkowa: sprawdzi czy rabat na niego wynosi 20%),
// >>> wybierze rozmiar M (opcja dodatkowa: zrób tak żeby można było sparametryzować rozmiar i wybrać S,M,L,XL),
// >>> wybierze 5 sztuk według parametru podanego w teście (opcja dodatkowa: zrób tak żeby można było sparametryzować liczbę sztuk),

// Thread.sleep(2000); <--- odczekaj





