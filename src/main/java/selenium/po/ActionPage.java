package selenium.po;

import selenium.base.BaseMethod;
import selenium.base.Table;
import selenium.base.TableNew;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static selenium.util.JSActions.jsClick;

public class ActionPage extends BaseMethod {
    private final By doubleClick = By.xpath("//button[@id='doubleClickBtn']");
    private final By contextClick = By.xpath("//button[@id='rightClickBtn']");
    private final By getDoubleClickText = By.xpath("//p[@id='doubleClickMessage']");
    private final By getContextClickText = By.xpath("//p[@id='rightClickMessage']");
    private final By drag = By.xpath("//div[@id='draggable']");
    private final By drop =By.xpath("//div[@id='draggable']/following-sibling::div[@id='droppable']");
    private final By result = By.xpath("//div[@id='draggable']/following-sibling::div/p");

    private final By callAlert = By.xpath("//button[@id='alertButton']");

    private final By confirm = By.xpath("//button[@id='confirmButton']");
    private final By prompt = By.xpath("//button[@id='promtButton']");
    private final By textFromFrame = By.xpath("//h1[@id='sampleHeading']");

    private final By frameHeader = By.xpath("//div[@class='main-header']");
    private final By upload = By.xpath("//input[@id='uploadPicture']");
    private final By table = By.xpath("//div[@class='rt-tbody']");

    private final By tableNew = By.xpath(".//div[@class='rt-tbody']");

    private final By uploadNew = By.xpath("//input[@id='uploadFile']");
    private final By textFromFrameNew = By.xpath("//html/body/p");


    public ActionPage uploadFileNew(String path) {
        send(uploadNew, path);
        return this;
    }


    public String getTextFromTableNew(int row, int column) {
        WebElement tableTmpNew = getWait().until(d->d.findElement(tableNew));
        TableNew tableNew1 = new TableNew(tableTmpNew);
        return tableNew1.getValue(row-1, column);
    }

    public String getTextFromTable(int row, int column) {
        WebElement tableTmp = getWait().until(d->d.findElement(table));
        Table table1 = new Table(tableTmp);
        return table1.getValue(row-1, column);
    }

    public ActionPage uploadFile(String path) {
        send(upload, path);
        return this;
    }

    public String getFramesHeader() {
        return getTextFromElement(frameHeader);
    }

    public String getTextFromFrame() {
        return getTextFromElement(textFromFrame);
    }

    public String getTextFromFrameNew() {
        return getTextFromElement(textFromFrameNew);
    }

    public ActionPage callAlert() {
        click(callAlert);
        return this;
    }
    public ActionPage calConfirmAlert() {
        click(confirm);
        return this;
    }

    public ActionPage promptAlert() {
        WebElement element = getWait().until(d->d.findElement(prompt));
        jsClick(element);
        return this;
    }

    public ActionPage dragAndDropElement() {
        dragAndDrop(drag, drop);
        return this;
    }

    public String getDropped() {
        return getTextFromElement(result);
    }
    public ActionPage clickDoubleClick() {
        doubleClick(doubleClick);
        return this;
    }
    public ActionPage clickRigthClick() {
        contextClick(contextClick);
        return this;
    }
    public String getDoubleText() {
        return getTextFromElement(getDoubleClickText);
    }
    public String getRightText() {
        return getTextFromElement(getContextClickText);
    }

    }
