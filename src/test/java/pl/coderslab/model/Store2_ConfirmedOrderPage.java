package pl.coderslab.model;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class Store2_ConfirmedOrderPage {

    private WebDriver driver;


    @FindBy(className = "container")
    private WebElement screenshotContainer;

    public Store2_ConfirmedOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void confirmationScreenshot() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenshot = screenshotContainer.getScreenshotAs(OutputType.FILE);
    }
}

    //Convert webdriver to TakeScreenshot
//    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//    WebElement logo = driver.findElement(By.xpath("//*[@id=\"app\"]/header/a/img"));
//
//    // capture screenshot with getScreenshotAs() of the WebElement class
//    File f = logo.getScreenshotAs(OutputType.FILE);
//
//        FileUtils.copyFile(f, new File("C:\\projectScreenshots\\logoScreeshot.png"));



