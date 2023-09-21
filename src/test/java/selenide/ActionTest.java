package selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import selenide.po.ActionPage;

import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static com.codeborne.selenide.Selenide.$$x;

public class ActionTest {

    @Test
    public void doubleClickAndContextClickCheck() {
        open("https://demoqa.com/buttons");
        getWebDriver().manage().window().maximize();

        new ActionPage()
                .clickDoubleButton()
                .clickContextButton();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(new ActionPage().getDoubleClickText().shouldBe(visible).getText())
                .as("The text of clicked double was not found")
                .isEqualTo("You have done a double click");
        softly.assertThat(new ActionPage().getContextClickText().shouldBe(visible).getText())
                .as("The text of clicked context was not found")
                .isEqualTo("You have done a right click");

        softly.assertAll();
    }

    @Test
    public void dragAndDropElementTest() {
        open("https://demoqa.com/droppable");
        getWebDriver().manage().window().maximize();

        new ActionPage()
                .dragAndDropElement();

        assertThat(new ActionPage().dropped().shouldBe(visible).getText())
                .as("The text was not visible")
                .isEqualTo("Dropped!");
    }

    @Test
    public void gettextFromElement() {
        open("https://demoqa.com/automation-practice-form");
        getWebDriver().manage().window().maximize();

        ElementsCollection collection = $$x("//div[@class='custom-control custom-checkbox custom-control-inline']");

        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
        System.out.println(collection.texts().stream().filter(t->t.startsWith("S")).collect(Collectors.toList()));
    }

    @Test
    public void uploadFile() {
        open("https://demoqa.com/upload-download");
        getWebDriver().manage().window().maximize();

        new ActionPage()
                .chooseUpload("D:\\QA Automation\\Projects\\Selenium_basic\\textNew.txt");
        assertThat(new ActionPage().uploadedFile().shouldBe(visible).getText())
                .as("File was not uploaded")
                .isNotEmpty();
    }
}
