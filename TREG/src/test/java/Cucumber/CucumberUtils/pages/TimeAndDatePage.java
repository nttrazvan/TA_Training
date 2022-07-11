package Cucumber.CucumberUtils.pages;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import java.util.List;

public class TimeAndDatePage extends PageObject {
    @FindBy(css = ".qc-cmp2-summary-buttons button:nth-child(2)")
    public WebElement policyButton;
    @FindBy(xpath = "//*[@id='f']/div[1]/div[1]/div/div[4]/button")
    public WebElement startDatePicker;
    @FindBy(className = "picked-year")
    public WebElement year;
    @FindBy(css = ".prev[onclick='Picker.stepYear(-1);']")
    public WebElement prevArrowYear;
    @FindBy(css = ".next[onclick='Picker.stepYear(1);']")
    public WebElement nextArrowYear;
    @FindBy(className = "picked-month")
    public WebElement month;
    @FindBy(css = ".next[onclick='Picker.stepMonth(1);']")
    public WebElement nextArrowMonth;
    @FindBy(xpath = "//div[@data-view-id='days']//tbody//a")
    public List<WebElement> days;
    @FindBy(id = "d1")
    public WebElement startDateInputDay;
    @FindBy(id = "m1")
    public WebElement startDateInputMonth;
    @FindBy(id = "y1")
    public WebElement startDateInputYear;
    @FindBy(xpath = "//*[@id='f']/div[1]/div[3]/div/div[4]/button")
    public WebElement endDatePicker;
    @FindBy(id = "d2")
    public WebElement endDateInputDay;
    @FindBy(id = "m2")
    public WebElement endDateInputMonth;
    @FindBy(id = "y2")
    public WebElement endDateInputYear;
    @FindBy(id = "ti")
    public WebElement checkboxEndDateInclusion;
    @FindBy(xpath = "//h2[contains(text(),'Result')]")
    public WebElement result;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitButton;
    @FindBy(id = "linkwork")
    public WebElement countOnlyWorkdays;
    @FindBy(id = "ach")
    public WebElement dayTypesSelectButton;
    @FindBy(xpath = "//option[contains(@value,'1') and text()='Weekends']")
    public WebElement dayTypeWeekends;
    @FindBy(id = "atyp")
    public WebElement includeExcludeSelect;
    @FindBy(xpath = "//option[contains(@value,'1') and text()='Include only']")
    public WebElement selectIncludeOnly;
    @FindBy(xpath = "//option[contains(@value,'2') and text()='Public holidays (not in weekends)']")
    public WebElement selectPublicHolidays;
}



