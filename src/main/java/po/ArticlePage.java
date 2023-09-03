package po;

import base.BaseMethod;
import org.openqa.selenium.By;

public class ArticlePage extends BaseMethod {
    private final By title = By.xpath("//h1[@id='firstHeading']/span");
    public String getTitleArticle() {
        return getTextFromElement(title);
    }
}
