import org.testng.annotations.Test;
import po.LoginPage;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest{
        LoginPage login = new LoginPage();
        public String loginName = "RomanAQA";
        public String password = "Roman987654321";

        @Test
        void checkLoginName() {
                login.clickEnterPage();
                login.fillLogin(loginName);
                login.fillPassword(password);
                login.clickEnterLogin();
                assertEquals(loginName, login.getLogin());

        }
}
