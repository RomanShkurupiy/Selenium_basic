package selenide.po;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static selenide.js.JSActions.click;

public class LoginPage {
    private final SelenideElement loginEnter = $x("//li[@id='pt-login']/a");
    private final SelenideElement loginField = $x("//input[@id='wpName1']");
    private final SelenideElement passwordField = $x("//input[@id='wpPassword1']");
    private final SelenideElement loginButton = $x("//button[@id='wpLoginAttempt']");
    public SelenideElement errorMessage() { return $x("//div[@class='mw-message-box cdx-message cdx-message--block mw-message-box-error cdx-message--error']");}

    public SelenideElement getLoginName() { return $x("//li[@id='pt-userpage']//span");}

    public LoginPage clickLogin() {
        loginEnter.shouldBe(visible, enabled);
        click(loginEnter);
        return page(LoginPage.class);
    }
    public LoginPage fillLoginName(String text) {
        loginField.shouldBe(visible).sendKeys(text);
        return page(LoginPage.class);
    }
    public LoginPage fillPassword(String text) {
        passwordField.shouldBe(visible).sendKeys(text);
        return page(LoginPage.class);
    }
    public LoginPage clickButtonEnter() {
        loginButton.shouldBe(visible, enabled);
        click(loginButton);
        return page(LoginPage.class);
    }
}
