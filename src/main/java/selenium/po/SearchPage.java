package selenium.po;

import selenium.base.BaseMethod;
import org.openqa.selenium.By;

public class SearchPage extends BaseMethod {
    private final By history = By.xpath("//span[text()='Просмотр кода']/../../../li[3]");
    private final By search = By.xpath("//input[@name=\"search\"]");
    private final By result = By.xpath("//h1[@id='firstHeading']");

    private final By tabFirst = By.xpath("//div[@id='mw-content-text']//ul[@class='mw-search-results']/li[1]//div[@class='mw-search-result-heading']/a");

    public void click(String loc) {
        click(By.xpath(loc), 10);
    }


    public SearchPage clickOnTabHistory() {
        click(history, 10);
        return this;
    }

    public SearchPage clickOnFirstResult() {
        click(tabFirst, 10);
        return this;
    }

    public SearchPage fillText(String text) {
        send(search, text);
        return this;
    }

    public SearchPage enterSearch() {
        clickEnter(search);
        return this;
    }
    public String getTitle() {
        return getTextFromElement(result);
    }
}
