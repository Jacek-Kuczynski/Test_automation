package pl.coderslab.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class StoreNewAddressForm {

    private WebDriver driver;

    @FindBy(name = "alias")
    private WebElement aliasInput;

    @FindBy(name = "address1")
    private WebElement addressInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "postcode")
    private WebElement zipPostalCodeInput;

    @FindBy(name = "id_country")
    private WebElement countryDropDownList;

    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div/div/form/section/div[10]/div[1]/select/option[2]")
    private WebElement selectCountry;

    @FindBy(name = "phone")
    private WebElement phoneInput;

    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div/div/form/footer/button")
    private WebElement saveButton;

    public StoreNewAddressForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillFormAndSave(String alias, String address, String city, String zipPostalCode, String country, String phone) {

        aliasInput.clear();
        aliasInput.sendKeys(alias);

        addressInput.clear();
        addressInput.sendKeys(address);

        cityInput.clear();
        cityInput.sendKeys(city);

        zipPostalCodeInput.clear();
        zipPostalCodeInput.sendKeys(zipPostalCode);

        countryDropDownList.click();
        selectCountry.click();

        phoneInput.clear();
        phoneInput.sendKeys(phone);

        saveButton.click();

    }
}