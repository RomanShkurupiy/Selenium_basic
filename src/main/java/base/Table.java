package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Table extends BaseMethod {
    WebElement elementTable;

    public Table(WebElement elementTable) {
        this.elementTable = elementTable;
    }

    private List<WebElement> getRows() {
        List<WebElement> rows = elementTable.findElements(By.xpath(".//div[@role='row']"));
        rows.remove(0);
        return rows;
    }

    private List<List<WebElement>> getRowsAndColumns() {
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsAndColumns = new ArrayList<>();
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.xpath(".//div[@role='gridcell']"));
            rowsAndColumns.add(columns);
        }
        return rowsAndColumns;
    }

    public String getValue(int row, int column) {
        List<List<WebElement>> rowAndColumn = getRowsAndColumns();
        WebElement cell = rowAndColumn.get(row-1).get(column-1);
        return cell.getText();
    }
}
