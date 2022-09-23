package pl.coderslab.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.model.StoreAddressesPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

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

    @When("reached new address creation page")
    public void reachNewAddressForm() {
        WebElement addressesButton = this.driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/a[2]/span/i"));
        addressesButton.click();

        WebElement createNewAddressButton = this.driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[3]/a"));
        createNewAddressButton.click();

    }

    @Then("filled form with new address data: {}, {}, {}, {}, {}, {}")
    public void fillNewAddressForm(String alias, String address, String city, String zipPostalCode, String country, String phone) {

        WebElement aliasInput = this.driver.findElement(By.name("alias"));
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        WebElement addressInput = this.driver.findElement(By.name("address1"));
        addressInput.clear();
        addressInput.sendKeys(address);

        WebElement cityInput = this.driver.findElement(By.name("city"));
        cityInput.clear();
        cityInput.sendKeys(city);

        WebElement zipPostalCodeInput = this.driver.findElement(By.name("postcode"));
        zipPostalCodeInput.clear();
        zipPostalCodeInput.sendKeys(zipPostalCode);

        WebElement countryDropDownList = this.driver.findElement(By.name("id_country"));
        countryDropDownList.click();
        WebElement selectCountry = this.driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/section/div[10]/div[1]/select/option[2]"));
        selectCountry.click();

        WebElement phoneInput = this.driver.findElement(By.name("phone"));
        phoneInput.clear();
        phoneInput.sendKeys(phone);

        WebElement saveButton = this.driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/footer/button"));
        saveButton.click();

    }

    @And("confirmed added data")
    public void confirmedAddedData() {
        String expectedNewAddressData = "Adres 1\n" + "Franek Dzbanek\n" + "ul. Pelplińska 111\n" + "Gdynia\n" + "81-258\n" + "United Kingdom\n" + "123-123-123";
        StoreAddressesPage storeAddressesPage = new StoreAddressesPage(driver);
        String addressesListFieldText = storeAddressesPage.getNewAddressData();

    }

    @And("deleted added address")
    public void deletedAddedAddress() {
        WebElement deleteAddressButton = this.driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[2]/article/div[2]/a[2]"));
        deleteAddressButton.click();

        String expectedAlertText = "Address successfully deleted!";
        StoreAddressesPage storeAddressesPage = new StoreAddressesPage(driver);
        String alertText = storeAddressesPage.getAlertText();
        assertEquals(expectedAlertText, alertText);
        System.out.println(alertText);
    }
}



