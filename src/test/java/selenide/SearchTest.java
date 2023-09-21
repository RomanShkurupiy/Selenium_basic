package selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenide.po.SearchPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.getWebDriverLogs;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class  SearchTest {

    @Test
    void shouldBeVisibleArticleOdessa() {
        open("https://ru.wikipedia.org/");
        getWebDriver().manage().window().maximize();
        new SearchPage()
                .fillSearch("Odesa")
                .clickEnter()
                .clickFirstArticle();

        assertThat(new SearchPage().getHeaderArticle().shouldBe(visible).getText())
                .as("The header of Odessa article was not found")
                .isEqualTo("Одесса");
    }

    @Test (dataProvider = "data-test")
    void shouldBeVisibleResultSeveral(String result) {
        open("https://ru.wikipedia.org/");
        getWebDriver().manage().window().maximize();
        new SearchPage()
                .fillSearch(result)
                .clickEnter();

        assertThat(new SearchPage().getHeaderArticle().shouldBe(visible).getText())
                .as("The header of Odessa article was not found")
                .isEqualTo("Одесса");
    }

    @DataProvider(name = "data-test")
    public  Object[][] getResult(){
        return new Object[][] {
                {"Одесса"},
                {"Ubisoft"},
                {"Результаты поиска2"}
        };
    }
}
