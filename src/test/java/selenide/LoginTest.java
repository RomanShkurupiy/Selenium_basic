package selenide;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import selenide.po.LoginPage;


public class LoginTest {

    String login = "RomanAQA";
    String password = "Roman987654321";
    @Test
    void loginAndCheckLogin() {

        open("https://ru.wikipedia.org/");
        getWebDriver().manage().window().maximize();

        new LoginPage()
                .clickLogin()
                .fillLoginName(login)
                .fillPassword(password)
                .clickButtonEnter();

        assertThat(new LoginPage().getLoginName().shouldBe(visible).getText())
                .as("The login name is not correct")
                .isEqualTo(login);
    }
    @Test(dataProvider = "data-login")
    void checkLoginInput(String text) {
        open("https://ru.wikipedia.org/");
        getWebDriver().manage().window().maximize();
        new LoginPage()
                .clickLogin()
                .fillLoginName(text)
                .fillPassword("Roman987654321")
                .clickButtonEnter();
        assertThat(new LoginPage().errorMessage().shouldBe(visible).getText())
                .as("The login name is not correct")
                .isNotEmpty();
    }
    @Test(dataProvider = "data-password")
    void checkPasswordInput(String text) {
        open("https://ru.wikipedia.org/");
        getWebDriver().manage().window().maximize();
        new LoginPage()
                .clickLogin()
                .fillLoginName("RomanAQA")
                .fillPassword(text)
                .clickButtonEnter();
        assertThat(new LoginPage().errorMessage().shouldBe(visible).getText())
                .as("The login name is not correct")
                .isNotEmpty();
    }
    @DataProvider(name = "data-login")
    public  Object[][] getLogin(){
        return new Object[][] {
                {"Rom"},
                {"r123"},
                {"Roman987654321"}
        };
    }
    @DataProvider(name = "data-password")
    public  Object[][] getPassword(){
        return new Object[][] {
                {"rom1 "},
                {"R!%&*("},
                {"r_="}
        };
    }
}
