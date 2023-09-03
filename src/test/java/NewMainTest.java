import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.Assert.*;

public class NewMainTest {
    public static void main(String[] args) {

       // By history = By.xpath("//span[text()='Просмотры']/../following-sibling::div/li[3]");
        By search = By.xpath("//input[@name=\"search\"]");
        By result = By.xpath("//h1[@id='firstHeading']");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://ru.wikipedia.org/");
        driver.manage().window().maximize();

        clickElement(driver, search);
        sendElements(driver, search, "Ubisof");
        clickEnter(driver, search);

        try {
            assertEquals(getTextFromElement(driver, result), "Ubisoft");
        } catch (AssertionError e) {
            clickElement(driver, By.xpath("//div[@id='mw-content-text']//ul[@class='mw-search-results']/li[1]//div[@class='mw-search-result-heading']/a"));
            assertEquals(getTextFromElement(driver, result), "Ubisoft");
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    static void clickElement(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(d->d.findElement(locator)).click();
    }

    static void sendElements(WebDriver driver, By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
    }
    static void clickEnter(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(d -> d.findElement(locator)).sendKeys(Keys.ENTER);
    }

    static String getTextFromElement(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(d -> d.findElement(locator)).getText();
    }
}
