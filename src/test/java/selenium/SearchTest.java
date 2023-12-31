package selenium;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.po.ArticlePage;
import selenium.po.SearchPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends BaseTest {

//    ArticlePage article = new ArticlePage();


    @Test (groups = {"All"}, dataProvider = "data-test")
    void shouldBeVisibleResultText(String result) {
        driver.get("https://ru.wikipedia.org/");
        driver.manage().window().maximize();
        new SearchPage()
            .clickOnTabHistory()
            .fillText(result)
            .enterSearch();
        assertThat(new SearchPage().getTitle())
                .as("The result of test is appeared")
                .isEqualTo("Результаты поиска");
    }
        @Test(groups = {"All"})
        void shouldBeVisibleResultTextUbisoft() {
            driver.get("https://ru.wikipedia.org/");
            driver.manage().window().maximize();
            new SearchPage()
                .clickOnTabHistory()
                .fillText("Ubis")
                .enterSearch();
//        search.click("//div[@id='mw-content-text']//ul[@class='mw-search-results']/li[1]//div[@class='mw-search-result-heading']/a");



            SoftAssertions softly = new SoftAssertions();

            softly.assertThat(new SearchPage().getTitle())
                    .as("The result of test is appeared")
                    .isEqualTo("Результаты поиска");

            softly.assertAll();

    }


    @DataProvider(name = "data-test")
    public  Object[][] getResult(){
        return new Object[][] {
                {"Odessa"},
                {"Ubisoft"},
                {"Результаты поиска2"}
        };
    }
}
