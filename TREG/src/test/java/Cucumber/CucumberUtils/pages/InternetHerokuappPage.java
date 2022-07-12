package Cucumber.CucumberUtils.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

import static jxl.biff.FormatRecord.logger;

public class InternetHerokuappPage extends PageObject {

    @FindBy(xpath = "//div/p")
    public WebElementFacade contentParagraph;

    @FindBy(css = "a[class='button']")
    public WebElementFacade blueButton;

    @FindBy(css = "a[class='button alert']")
    public WebElementFacade redButton;

    @FindBy(css = "a[class='button success']")
    public WebElementFacade greenButton;

    @FindBy(xpath = "//thead")
    public List<WebElement> tableHeader;

    @FindBy(css = "a[href='http://elementalselenium.com/']")
    public WebElementFacade bottomRedirect;

    @FindBy(xpath = "//img[@alt='Fork me on GitHub']")
    public WebElementFacade topRedirect;

    public List<List> tableRetrieveValues() {
        List<WebElement> tableRows = getDriver().findElements(By.xpath("//tbody/tr")); //numbering the rows
        List<List> item = new ArrayList<>(); // create empty list of objects
        logger.info(String.valueOf(tableRows.size()) + " elements found.");
        for (WebElement element : tableRows) {
            List<WebElement> listOfDataCells = element.findElements(By.xpath(".//td")); //retrieve all td within tr (works only using xpath)
            List row = new ArrayList(); //create object in order to populate it
            row.add(listOfDataCells.get(0).getText()); //set value for first field of the object (the item (the value list) has three fields: name, type and button)
            row.add(listOfDataCells.get(1).getText()); //set value for second field of the object
            row.add(listOfDataCells.get(2).getText());
            row.add(listOfDataCells.get(3).getText());
            row.add(listOfDataCells.get(4).getText());
            row.add(listOfDataCells.get(5).getText());
            item.add(row); //we add the object to the list of objects. After the first for we have one object elementsFromTable that has 4 properties (BW, Typ, ViewButton and Edit Button)
            logger.info("Object added to list.");
        }
        for (List i : item) {
            logger.info(i.get(0) + " - " + i.get(1) + " - " + i.get(2) + " - " + i.get(3) + " - " + i.get(4) + " - " + i.get(5));
        }
        return item;
    }
}
