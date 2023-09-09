import org.testng.annotations.Test;
import po.ArticlePage;
import po.SearchPage;

import static org.testng.Assert.*;

public class SearchTest extends BaseTest {

    SearchPage search = new SearchPage();
    ArticlePage article = new ArticlePage();


    @Test
    void shouldBeVisibleResultText() {
        search.clickOnTabHistory();
        search.fillText("Odessa");
        search.enterSearch();
//        search.click("//div[@id='mw-content-text']//ul[@class='mw-search-results']/li[1]//div[@class='mw-search-result-heading']/a");

//        assertEquals("Ubisoft", article.getTitleArticle());
//        try {
//            assertEquals(search.getTitle(), "Ubisoft");
//        } catch (AssertionError e) {
//            search.clickOnFirstResult();
//            assertEquals(search.getTitle(), "Ubisoft");
//        }
    }
        @Test
        void shouldBeVisibleResultTextUbisoft() {
            search.clickOnTabHistory();
            search.fillText("Ubisoft");
            search.enterSearch();
//        search.click("//div[@id='mw-content-text']//ul[@class='mw-search-results']/li[1]//div[@class='mw-search-result-heading']/a");

            assertEquals("Ubisoft", article.getTitleArticle());
    }
}
