package selenium.Builder;

import selenium.po.LoginNewPage;

public class LoginPageBuilder {
    private String username;
    private String password;
    public LoginPageBuilder withUsername (String username) {
        this.username = username;
        return this;
    }

    public LoginPageBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public LoginNewPage build() {
        return new LoginNewPage()
                .enterUserName(username)
                .enterPassword(password);
    }
//    public LoginPage build() {
//        return new LoginPage()
//                .enterUserName(username)
//                .enterPassword(password);
//    }
}
