import org.assertj.core.api.ProxyableObjectAssert;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import po.ActionPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ActionTest extends BaseTest{

    @Test
    public void checkDoubleAndContextClick() {
        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();
        new ActionPage()
                .clickDoubleClick()
                .clickRigthClick();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(new ActionPage().getDoubleText())
                .as("The text is not visible")
                .isEqualTo("You have done a double click");

        softly.assertThat(new ActionPage().getRightText())
                .as("The text is not visible")
                .isEqualTo("You have done a right click");

        softly.assertAll();
    }

    @Test
    public void dragAndDropElementTest() {
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();

        new ActionPage()
                .dragAndDropElement();

        assertThat(new ActionPage().getDropped())
                .as("the element is not dropped")
                .isEqualTo("Dropped!");
    }

    @Test
    public void acceptAlert() {
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();



        new ActionPage().promptAlert();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.switchTo().alert().sendKeys("Prompt");
        driver.switchTo().alert().accept();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getTextFromFrame(){
        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();

        WebElement frame = driver.findElement(By.xpath("//iframe[@id='frame1']"));
        driver.switchTo().frame(frame);

        assertThat(new ActionPage().getTextFromFrame())
                .as("Selenium locator not in the frame")
                .isEqualTo("This is a sample page");

        driver.switchTo().defaultContent();

        assertThat(new ActionPage().getFramesHeader())
                .as("Selenium locator in the frame")
                .isEqualTo("Frames");
    }

    @Test
    public void getTextFromFrameNew() {
        driver.get("https://demoqa.com/nestedframes");
        driver.manage().window().maximize();

        WebElement frame = driver.findElement(By.xpath("//iframe[@id='frame1']"));

        driver.switchTo().frame(frame);
        WebElement frameNew = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
        driver.switchTo().frame(frameNew);

        assertThat(new ActionPage().getTextFromFrameNew())
                .as("Selenium locator is not correct")
                .isEqualTo("Child Iframe");
    }

    @Test
    public void uploadFile() {
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        new ActionPage()
                .uploadFile("D:\\QA Automation\\Projects\\Selenium_basic\\text.txt");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void uploadFileNew() {
        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().maximize();

        new ActionPage()
                .uploadFileNew("D:\\QA Automation\\Projects\\Selenium_basic\\textNew.txt");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getTextFromTable() {
        driver.get("https://demoqa.com/books");
        driver.manage().window().maximize();

        assertThat(new ActionPage().getTextFromTable(2,3))
                .as("Selenium locator in the frame")
                .isEqualTo("Addy Osmani");
    }

    @Test
    public void getTextFromTableNew() {
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();

        assertThat(new ActionPage().getTextFromTableNew(2,4))
                .as("Selenium locator is out the frame")
                .isEqualTo("alden@example.com");
    }

}
