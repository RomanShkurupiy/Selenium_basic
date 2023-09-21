package selenide.po;

import com.codeborne.selenide.SelenideElement;


import java.io.File;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.actions;


public class ActionPage {
    private final SelenideElement doubleClickButton = $x("//button[@id='doubleClickBtn']");
    private final SelenideElement contextClickButton = $x("//button[@id='rightClickBtn']");

    private final SelenideElement dragArea = $x("//div[@id='draggable']");

    private final SelenideElement dropArea = $x ("//div[@id='draggable']/following-sibling::div[@id='droppable']");

    public SelenideElement dropped() {
        return $x("//div[@id='draggable']/following-sibling::div/p");
    }

    public SelenideElement getDoubleClickText() {
        return $x("//p[@id='doubleClickMessage']");
    }
    public SelenideElement getContextClickText(){
        return $x("//p[@id='rightClickMessage']");
    }

    private final SelenideElement chooseFileButton = $x("//input[@id='uploadFile']");
    public SelenideElement uploadedFile () {return $x("//p[@id='uploadedFilePath']");
    }

    public ActionPage chooseUpload(String path) {
        chooseFileButton.shouldBe(visible).uploadFile(new File(path));
        return page(ActionPage.class);
    }



    public ActionPage clickDoubleButton() {
        doubleClickButton.shouldBe(visible, enabled).doubleClick();
        return page(ActionPage.class);
    }
    public ActionPage clickContextButton() {
        contextClickButton.shouldBe(visible, enabled).contextClick();
        return page(ActionPage.class);
    }

    public ActionPage dragAndDropElement() {
        actions().dragAndDrop(dragArea.shouldBe(visible), dropArea.shouldBe(visible)).build().perform();
        return page(ActionPage.class);
    }
 }
