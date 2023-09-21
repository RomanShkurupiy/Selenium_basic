package selenium.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static selenium.config.WebDriverInit.getDriver;

public class JSActions {
    public static void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
    }
}
