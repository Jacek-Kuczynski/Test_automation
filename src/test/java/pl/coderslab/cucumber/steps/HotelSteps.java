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

public class HotelSteps {

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

    @When("new user register")
    public void newUserRegister() {
        String email = new Random().nextInt(100000000) + "TEA26@test.com";

        // Wyszukaj przycisk do logowania
        WebElement signInButton = this.driver.findElement(By.className("user_login"));
        signInButton.click(); // Kliknij na przycisk SignIn

        WebElement registerEmailInput = this.driver.findElement(By.id("email_create"));
        registerEmailInput.clear(); // Wyczysc pole tekstowe przed wpisaniem
        registerEmailInput.sendKeys(email);
        registerEmailInput.submit(); // Potwierdz email do rejestracji

        // Wyszukaj podstawowe elementy do zalozenia uzytkownika
        WebElement customerFirstNameInput = this.driver.findElement(By.id("customer_firstname"));
        WebElement customerLastNameInput = this.driver.findElement(By.id("customer_lastname"));
//        WebElement customerEmail = driver.findElement(By.id("email"));
        WebElement customerPassword = this.driver.findElement(By.id("passwd"));

        // Wypelnij brakujace informacje o uzytkowniku
        customerFirstNameInput.clear();
        customerFirstNameInput.sendKeys("Janusz");
        customerLastNameInput.clear();
        customerLastNameInput.sendKeys("Januszewski");

        customerPassword.clear();
        customerPassword.sendKeys("12345");

        // Zaloz konto
        WebElement submitButton = this.driver.findElement(By.id("submitAccount"));
        submitButton.click();
    }


    @When("a user with {} and {} is registered")
    public void newUserRegister(String name, String lastName) {
        String email = new Random().nextInt(100000000) + "TEA26@test.com";

        WebElement signInButton = this.driver.findElement(By.className("user_login"));
        signInButton.click(); // Kliknij na przycisk SignIn

        WebElement registerEmailInput = this.driver.findElement(By.id("email_create"));
        registerEmailInput.clear(); // Wyczysc pole tekstowe przed wpisaniem
        registerEmailInput.sendKeys(email);
        registerEmailInput.submit(); // Potwierdz email do rejestracji

        // Wyszukaj podstawowe elementy do zalozenia uzytkownika
        WebElement customerFirstNameInput = this.driver.findElement(By.id("customer_firstname"));
        WebElement customerLastNameInput = this.driver.findElement(By.id("customer_lastname"));
//        WebElement customerEmail = driver.findElement(By.id("email"));
        WebElement customerPassword = this.driver.findElement(By.id("passwd"));

        // Wypelnij brakujace informacje o uzytkowniku
        customerFirstNameInput.clear();
        customerFirstNameInput.sendKeys(name);
        customerLastNameInput.clear();
        customerLastNameInput.sendKeys(lastName);

        customerPassword.clear();
        customerPassword.sendKeys("12345");

        // Zaloz konto
        WebElement submitButton = this.driver.findElement(By.id("submitAccount"));
        submitButton.click();
    }

    @Then("an account is created")
    public void accountIsCreated() {
        String expectedAlertText = "Your account has been created.";

        // Sprawdz czy konto poprawnie zalozone
        WebElement successAlertField = this.driver.findElement(By.className("alert-success"));

        // Pobierz informacje o poprawnym zalozeniu konta
        String alertText = successAlertField.getText();

        // Zweryfikuj komunikat.
        assertEquals(expectedAlertText, alertText);
    }

    @And("close browser")
    public void closeBrowser() {
        this.driver.quit();
    }


    @Given("an opened browser with {}")
    public void openedBrowser(String url) {
        //        Ustaw gdzie jest chromedriver -> STEROWNIK
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        //        Otworz przegladarke
        this.driver = new ChromeDriver();
        //        Jesli test nie przechodzi poprawnie, to pewnie za wolno laduje sie strona -> Dodaj czekanie.
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.get(url);
        WebElement signInButton = this.driver.findElement(By.className("user_login"));
        signInButton.click(); // Kliknij na przycisk SignIn
    }

    @And("logged in")
    public void loginWithEmail() {
        WebElement loginEmailInput = this.driver.findElement(By.id("email"));
        loginEmailInput.clear();
        loginEmailInput.sendKeys("Franek@gmail.com");
        WebElement loginPasswordInput = this.driver.findElement(By.id("passwd"));
        loginPasswordInput.clear();
        loginPasswordInput.sendKeys("12345");
        WebElement submitButton = this.driver.findElement(By.id("SubmitLogin"));
        submitButton.click(); // #  logowanie do systemu
    }

    @When("adding a new address")
    public void newAddress() {
        // #  zakładka Accounts (rozwiń nazwę użytkownika)
        WebElement dropdownList = this.driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[7]/ul/li/button/span[1]"));
        dropdownList.click();
        WebElement accountsTab = this.driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[7]/ul/li/ul/li[1]/a"));
        accountsTab.click();
        // #  przycisk My addresses
        WebElement myAddress = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/ul/li[3]/a/span"));
        myAddress.click();
        // #  przycisk Add new address
        WebElement addNewAddressButton = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/ul/li[3]/a/span"));
        addNewAddressButton.click();
    }

    @And("new address form filling")
    public void formFilling() {
        // #  wypełnienie i zapisanie formularza.
        WebElement newAddressInput = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/div[5]/input"));
        newAddressInput.clear();
        newAddressInput.sendKeys("ul. Pelplińska 111");

        WebElement newPostalCodeInput = this.driver.findElement(By.id("postcode"));
        newPostalCodeInput.clear();
        newPostalCodeInput.sendKeys("81-258");

        WebElement newCityInput = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/div[8]/input"));
        newCityInput.clear();
        newCityInput.sendKeys("Gdynia");

        WebElement newCountrySelection = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/div[9]/div/select"));
        newCountrySelection.click();

        WebElement newMobilePhoneInput = this.driver.findElement(By.id("phone"));
        newMobilePhoneInput.clear();
        newMobilePhoneInput.sendKeys("123-123-123");

        WebElement newAddressTitleInput = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/div[17]/input"));
        newAddressTitleInput.clear();
        newAddressTitleInput.sendKeys("Adres 1");

        WebElement saveNewAddressButton = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/p[2]/button/span"));
        saveNewAddressButton.click();
    }

    @Then("new address is added")
    public void addingNewAddressConfirmation() {
//        WebElement addANewAddressButtonSelection = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[2]/a/span"));
//        addANewAddressButtonSelection.click();

        try {
            WebElement webElement = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/div"));
            assertTrue(webElement.isDisplayed());
            System.out.println("NOWYY ADRES ZOSTAŁ DODANY !!!! ! ! ! !");
        } catch (NoSuchElementException ignored) {
            fail();
        }
    }
}






