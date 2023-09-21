package selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;
import static selenium.config.WebDriverInit.getDriver;

public class BaseMethod {

    protected WebDriverWait getWait() {
       return new WebDriverWait(getDriver(), ofSeconds(10));
    }

    protected Actions getActions() {
        return new Actions(getDriver());
    }
    protected void click(By locator) {
        getWait().until(d->d.findElement(locator)).click();
    }

    protected void doubleClick(By locator) {
            WebElement doubleElement = getWait().until(d->d.findElement(locator));
            getActions().doubleClick(doubleElement).build().perform();
    }
    protected void contextClick(By locator) {
        WebElement contextClick = getWait().until(d->d.findElement(locator));
        getActions().contextClick(contextClick).build().perform();
    }

    protected void dragAndDrop(By drag, By drop) {
        WebElement dragElement = getWait().until(d->d.findElement(drag));
        WebElement dropElement = getWait().until(d->d.findElement(drop));
        getActions().dragAndDrop(dragElement, dropElement).build().perform();
    }



    protected void send(By locator, String text) {
        getWait().until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
    }
    protected void clickEnter(By locator) {
        getWait().until(d -> d.findElement(locator)).sendKeys(Keys.ENTER);
    }

    protected String getTextFromElement(By locator) {
        return getWait().until(d -> d.findElement(locator)).getText();
    }



    protected WebDriverWait getWait(int time) {
        return new WebDriverWait(getDriver(), ofSeconds(time));    }
    protected void click(By locator, int time) {
        getWait(time).until(d->d.findElement(locator)).click();
    }

    protected void send(By locator, String text, int time) {
        getWait(time).until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
    }
    protected void clickEnter(By locator, int time) {
        getWait(time).until(d -> d.findElement(locator)).sendKeys(Keys.ENTER);
    }

    protected String getTextFromElement(By locator, int time) {
        return getWait(time).until(d -> d.findElement(locator)).getText();
    }


}
