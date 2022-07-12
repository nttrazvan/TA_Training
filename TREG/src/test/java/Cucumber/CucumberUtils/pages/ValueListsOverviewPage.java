package Cucumber.CucumberUtils.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

import static jxl.biff.FormatRecord.logger;

public class ValueListsOverviewPage extends PageObject {

    //Table title
    @FindBy(css = "span.isy-panel-title")
    public WebElementFacade tableTitle;
    // Table Header
    @FindBy(xpath = "//span[text()=' Bezeichnung Werteliste']")
    public WebElementFacade tableHeaderFirstColumn;

    @FindBy(xpath = "//span[text()=' Typ']")
    public WebElementFacade tableHeaderSecondColumn;

    @FindBy(xpath = "//span[contains(text(),' Aktionen')]")
    public WebElementFacade tableHeaderActions;

    //Table Data
    @FindBy(xpath = "//span[text()='Adressmuster und -hinweise']")
    public WebElementFacade addressList;

    @FindBy(css = "a[href='/tpr/tpr/values-lists-management/view/26']")
    public WebElementFacade viewAddressButton;

    @FindBy(css = "a[href='/tpr/tpr/values-lists-management/edit/26']")
    public WebElementFacade editAddressButton;

    @FindBy(xpath = "//span[text()='Faxnummer']")
    public WebElementFacade faxnummerList;

    @FindBy(css = "a[href='/tpr/tpr/values-lists-management/view/2']")
    public WebElementFacade viewFaxnummerButton;

    @FindBy(css = "a[href='/tpr/tpr/values-lists-management/edit/2']")
    public WebElementFacade editFaxnummerButton;

    // Table standard design
    @FindBy(xpath = "//div[text()='Treffer pro Seite']")
    public WebElementFacade paginator;

    @FindBy(xpath = "//span[text()=' Bezeichnung Werteliste']")
    public WebElementFacade sortingButton;

    @FindBy(css = "div.table-buttons isy-icon-button button")
    public WebElementFacade filteringButton;

    @FindBy(css = "tpr-table-filter-cell")
    public WebElementFacade filterLine;

    @FindBy(css = "input")
    public WebElementFacade inputFilterLine;

    @FindBy(css = "div.table-buttons button:nth-child(2)")
    public WebElementFacade resetFilteringButton;

    public List<List> tableRetrieveValues() throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> tableRows = getDriver().findElements(By.cssSelector("p-table table tbody tr")); //numbering the rows
        List<List> item = new ArrayList<>(); //create object in order to populate it
        logger.info(String.valueOf(tableRows.size()) + " elements found.");
        for (WebElement element : tableRows) {
            List<WebElement> listOfDataCells = element.findElements(By.xpath(".//td")); //retrieve all td within tr (works only using xpath)
            Thread.sleep(1000);
            List row = new ArrayList<>();
            row.add(listOfDataCells.get(0).getText()); //set value for first field of the object (the item (the value list) has three fields: name, type and button)
            row.add(listOfDataCells.get(1).getText()); //set value for second field of the object
            row.add(listOfDataCells.get(2).findElement(By.xpath(".//span[@class='fa-eye fas icon']"))); //set value for third field of the object
            if (row.get(1).equals("Dynamisch")) {
                row.add(listOfDataCells.get(2).findElement(By.xpath(".//span[@class='fa-pen fas icon']"))); //set value for forth field of the object
            }
            item.add(row);
           logger.info("Object added to list.");
        }
        for (List i : item) {
            logger.info(i.get(0) + " - " + i.get(1));
            WebElement viewButton = (WebElement) i.get(2);
            viewButton.isEnabled();
        }
//        elementsFromTable.get(0).EditButton.click();
        Thread.sleep(5000);
        return item;
    }
}


