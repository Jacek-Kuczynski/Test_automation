package pl.coderslab;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.model.StoreMainPage;

import java.time.Duration;

public class StoreTest {

//    private final static String PERMANENT_LOGIN = "Franek@gmail.com";
//    private final static String PERMANENT_PASSWORD = "12345";
    private WebDriver driver;

    @Before
    public void setUp() {
        //        Ustaw gdzie jest chromedriver -> STEROWNIK
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        //        Otworz przegladarke
        this.driver = new ChromeDriver();
        //        Jesli test nie przechodzi poprawnie, to pewnie za wolno laduje sie strona -> Dodaj czekanie.
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.get("https://mystore-testlab.coderslab.pl/");

    }

    @Test
    public void testAddingAddress() {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        StoreMainPage storeMainPage = new StoreMainPage(this.driver);
        storeMainPage.clickSignIn();

//        StoreMainPage storeMainPage = new StoreMainPage(this.driver);
//        storeMainPage.signInWithCredentials(PERMANENT_LOGIN, PERMANENT_PASSWORD);
    }
}

////        HotelLoginPage hotelLoginPage = new HotelLoginPage(this.driver);
////        hotelLoginPage.createAnAccountWithEmail(email);
////
////        HotelCreateAnAccountPage hotelCreateAnAccountPage = new HotelCreateAnAccountPage(this.driver);
////        hotelCreateAnAccountPage.fillFormAndSubmit("Janusz", "Januszewski", "12345");
////
////        HotelMyAccountPage hotelMyAccountPage = new HotelMyAccountPage(driver);
////        String alertText = hotelMyAccountPage.getAlertText();
////        assertEquals(expectedAlertText, alertText);
////
////        String pageTitle = hotelMyAccountPage.getPageTitle();
////        assertEquals("My account - MyBooking", pageTitle);
////
////    }
////
////    @Test
////    public void testSearchAnyHotel() {
////        HotelMainPage hotelMainPage = new HotelMainPage(this.driver);
////        hotelMainPage.clickSignIn();
////
////        HotelLoginPage hotelLoginPage = new HotelLoginPage(this.driver);
////        hotelLoginPage.signInWithCredentials(PERMANENT_LOGIN, PERMANENT_PASSWORD);
////
////        HotelMyAccountPage hotelMyAccountPage = new HotelMyAccountPage(this.driver);
////        hotelMyAccountPage.goToHomePage();
////
////        hotelMainPage.searchForHotelRoomsBetweenDates("The Hotel Prime", "22-09-2022", "29-09-2022");
////
////        HotelSearchRoomResultsPage searchRoomResultsPage = new HotelSearchRoomResultsPage(this.driver);
////        assertTrue(searchRoomResultsPage.getAvailableRoomNumber() > 0);
////
////    }
////
//    }
//}
