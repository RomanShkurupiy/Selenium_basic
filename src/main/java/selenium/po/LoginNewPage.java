package selenium.po;

import selenium.base.BaseMethod;
import org.openqa.selenium.By;

public class LoginNewPage extends BaseMethod {
    public String username;
    public String password;
    public final By loginName = By.xpath("//li[@id='pt-userpage']//span");
    public final By login = By.xpath("//li[@id='pt-login']/a");
    public final By username_field = By.xpath("//input[@id='wpName1']");
    public final By password_field = By.xpath("//input[@id='wpPassword1']");
    public final By enter = By.xpath("//button[@id='wpLoginAttempt']");

    public final By errorMessage = By.xpath("//div[@class='cdx-message__content']");

    public final By errorWindow = By.xpath("//span[@class='cdx-message__icon']");


    public LoginNewPage clicklogin() {
        click(login);
        return this;
    }
    public LoginNewPage enterUserName(String username) {
        this.username = username;
        send(username_field, username);
        return this;
    }
    public LoginNewPage enterPassword(String password) {
        this.password=password;
        send(password_field, password);
        return this;
    }
    public void clickEnter() {
        click(enter);
    }

    public String getLogin() {
        return getTextFromElement(loginName);
    }

    public String getError() { return getTextFromElement(errorMessage);}
}
