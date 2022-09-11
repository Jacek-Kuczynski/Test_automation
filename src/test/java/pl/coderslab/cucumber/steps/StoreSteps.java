package pl.coderslab.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StoreSteps {

    private WebDriver driver;

    @Given("an open browser with {}")
    public void openBrowser(String url) {
        //        Ustaw gdzie jest chromedriver -> STEROWNIK
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        //        Otworz przegladarke
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        //        Jesli test nie przechodzi poprawnie, to pewnie za wolno laduje sie strona -> Dodaj czekanie.
//        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        WebElement signInButton = this.driver.findElement(By.cssSelector("#_desktop_user_info > div > a > span"));
        signInButton.click();

    }

    @And("logged in")
    public void logInWithEmail() {


        WebElement logInEmailInput = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/section/form/section/div[1]/div[1]/input"));
        logInEmailInput.clear();
        logInEmailInput.sendKeys("Franek@gmail.com");
        WebElement logInPasswordInput = this.driver.findElement(By.name("password"));
        logInPasswordInput.clear();
        logInPasswordInput.sendKeys("12345");
        WebElement signInButtonSubmit = this.driver.findElement(By.id("submit-login"));
        signInButtonSubmit.click(); // #  logowanie do systemu
    }
}

//
//
//
//
//    @Then("an account is created")
//    public void accountIsCreated() {
//        String expectedAlertText = "Your account has been created.";
//
//        // Sprawdz czy konto poprawnie zalozone
//        WebElement successAlertField = this.driver.findElement(By.className("alert-success"));
//
//        // Pobierz informacje o poprawnym zalozeniu konta
//        String alertText = successAlertField.getText();
//
//        // Zweryfikuj komunikat.
//        assertEquals(expectedAlertText, alertText);
//    }
//
//
//    @When("adding a new address")
//    public void newAddress() {
//        // #  zakładka Accounts (rozwiń nazwę użytkownika)
//        WebElement dropdownList = this.driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[7]/ul/li/button/span[1]"));
//        dropdownList.click();
//        WebElement accountsTab = this.driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[7]/ul/li/ul/li[1]/a"));
//        accountsTab.click();
//        // #  przycisk My addresses
//        WebElement myAddress = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/ul/li[3]/a/span"));
//        myAddress.click();
//        // #  przycisk Add new address
//        WebElement addNewAddressButton = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/ul/li[3]/a/span"));
//        addNewAddressButton.click();
//    }
//
//    @And("new address form filling")
//    public void formFilling() {
//        // #  wypełnienie i zapisanie formularza.
//        WebElement newAddressInput = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/div[5]/input"));
//        newAddressInput.clear();
//        newAddressInput.sendKeys("ul. Pelplińska 111");
//
//        WebElement newPostalCodeInput = this.driver.findElement(By.id("postcode"));
//        newPostalCodeInput.clear();
//        newPostalCodeInput.sendKeys("81-258");
//
//        WebElement newCityInput = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/div[8]/input"));
//        newCityInput.clear();
//        newCityInput.sendKeys("Gdynia");
//
//        WebElement newCountrySelection = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/div[9]/div/select"));
//        newCountrySelection.click();
//
//        WebElement newMobilePhoneInput = this.driver.findElement(By.id("phone"));
//        newMobilePhoneInput.clear();
//        newMobilePhoneInput.sendKeys("123-123-123");
//
//        WebElement newAddressTitleInput = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/div[17]/input"));
//        newAddressTitleInput.clear();
//        newAddressTitleInput.sendKeys("Adres 1");
//
//        WebElement saveNewAddressButton = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/p[2]/button/span"));
//        saveNewAddressButton.click();
//    }
//
//    @Then("new address is added")
//    public void addingNewAddressConfirmation() {
////        WebElement addANewAddressButtonSelection = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[2]/a/span"));
////        addANewAddressButtonSelection.click();
//
//        try {
//            WebElement webElement = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/div"));
//            assertTrue(webElement.isDisplayed());
//            System.out.println("NOWYY ADRES ZOSTAŁ DODANY !!!! ! ! ! !");
//        } catch (NoSuchElementException ignored) {
//            fail();
//        }
//    }
//}
//
//
//
//
//
//
