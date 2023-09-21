package selenium;

import selenium.Builder.LoginPageBuilder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.po.LoginNewPage;


import static org.assertj.core.api.Assertions.assertThat;

public class LoginNewTest extends BaseTest{

    @Test(groups = "Smoke")
    void shouldBeEnterToTheSystem() {
        driver.get("https://ru.wikipedia.org/");
        driver.manage().window().maximize();
        new LoginNewPage()
                .clicklogin();
        LoginNewPage login = new LoginPageBuilder()
                .withUsername("RomanAQA")
                .withPassword("Roman987654321")
                .build();

        login.clickEnter();
        assertThat(new LoginNewPage().getLogin())
                .as("Login failed")
                .isEqualTo("RomanAQA");
    }

    @Test(groups = "Regression", dataProvider = "password-verification")
    void testLoginCorrectPasswordWrong(String password) {
        driver.get("https://ru.wikipedia.org/");
        driver.manage().window().maximize();
        new LoginNewPage()
                .clicklogin();
        LoginNewPage loginPassword = new LoginPageBuilder()
                .withUsername("RomanAQA")
                .withPassword(password)
                .build();
        loginPassword.clickEnter();
        assertThat(new LoginNewPage().getError())
                .as("Login failed")
                .contains("Введены неверные имя участника или пароль.");

    }

    @Test(groups = "Regression", dataProvider = "login-verification")
    void testLoginWrongPasswordCorrect(String login) {
        driver.get("https://ru.wikipedia.org/");
        driver.manage().window().maximize();
        new LoginNewPage()
                .clicklogin();
        LoginNewPage loginPassword = new LoginPageBuilder()
                .withUsername(login)
                .withPassword("Roman987654321")
                .build();
        loginPassword.clickEnter();
        assertThat(new LoginNewPage().getError())
                .as("Login failed")
                .isNotEmpty();
//                .contains("Введены неверные имя участника или пароль.");
    }


    @DataProvider(name = "password-verification")
    public Object [][] getPassword() {
        return new Object[][] {
                {"Роман987654321"},
                {"     "},
                {"Roman+/*"},
                {"Roman1"}
        };
    }
    @DataProvider(name = "login-verification")
    public Object [][] getLogin() {
        return new Object[][] {
                {"           "},
                {"RomanAQ"},
                {"Roman+/*"},
                {"Roman1"}
        };
    }
}
