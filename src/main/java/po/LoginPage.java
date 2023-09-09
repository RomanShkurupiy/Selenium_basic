package po;

import base.BaseMethod;
import org.openqa.selenium.By;

public class LoginPage extends BaseMethod {

   public final By loginName = By.xpath("//li[@id='pt-userpage']//span");
   public final By enterLogin = By.xpath("//li[@id='pt-login']/a");
   public final By enterName = By.xpath("//input[@id='wpName1']");
   public final By enterPassword = By.xpath("//input[@id='wpPassword1']");
   public final By buttonEnter = By.xpath("//button[@id='wpLoginAttempt']");

   public String getLogin() {
      return getTextFromElement(loginName);
   }
      public void clickEnterPage() {
      click(enterLogin, 10);
   }
   public void clickEnterLogin() {
      click(buttonEnter, 10);
   }
   public void fillLogin(String loginName) {

      send(enterName, loginName);
   }
   public void fillPassword(String password) {

      send(enterPassword, password);
   }

}