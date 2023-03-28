package Cucumber.CucumberUtils.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TimetrackingPage extends PageObject {
    public TimetrackingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    public WebElement userField;

    @FindBy(id = "password")
    public WebElement pwdField;

    @FindBy(css = "button[type='submit']")
    public WebElement loginBtn;

    @FindBy(css= "a[title='VIEW CLOCKING STATUS']")
    public WebElement viewClockingStatusBtn;

    @FindBy(css ="[ng-click='openDateStartFilter($event)']")
    public WebElement openStartDateCalendar;

    @FindBy(xpath = "//*[@id='startDate']/parent::* //button[@role='heading']")
    public WebElement startDateCalendarHeading;

    @FindBy(id ="view")
    public WebElement viewSelect;

    @FindBy(css = "input[value='Search']")
    public WebElement searchBtn;

    @FindBy(css="div[ng-show='dayMode'] button[ng-click='paginationApi.nextPage()']")
    public WebElement nextBtn;

    @FindBy(css = "button.fixiconAlert")
    public List<WebElement> missingTimeEntries;

    @FindBy(css = "button[ng-click='New()']")
    public WebElement newBtn;

    @FindBy(css = "#signIn input[ng-model='hours']")
    public WebElement signInHoursInput;

    @FindBy(css = "#signIn input[ng-model='minutes']")
    public WebElement signInMinutesInput;

    @FindBy(css = "[ng-model='editSession.checkOut'] input[ng-model='minutes']")
    public WebElement signOffMinutesInput;

    @FindBy(css = "[ng-model='editSession.checkOut'] input[ng-model='hours']")
    public WebElement signOffHoursInput;

    @FindBy(css="button[ng-click='Save()']")
    public WebElement saveBtn;

    @FindBy(css="div.modal-content tr.ng-scope")
    public WebElement savedEntry;

    @FindBy(css = "button[ng-click='ok()']")
    public WebElement okBtn;

    public WebElement startDateCalendarMonth(String month){
        return getDriver().findElement(By.xpath("//button[.='"+month+"']"));
    }

    public WebElement startDateCalendarDay(String day){
        return getDriver().findElement(By.xpath("(//button[.='"+day+"'][@ng-click='select(dt.date)'])[1]"));
    }
}

