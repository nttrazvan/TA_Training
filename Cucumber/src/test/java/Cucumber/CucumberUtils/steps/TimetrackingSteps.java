package Cucumber.CucumberUtils.steps;

import Cucumber.CucumberUtils.pages.TimetrackingPage;
import io.cucumber.java.et.Ja;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;

import static net.serenitybdd.core.Serenity.getDriver;

public class TimetrackingSteps{
    private TimetrackingPage timetrackingPage;
    private WebDriverWait wait = new WebDriverWait(getDriver(),60);

    private JavascriptExecutor js = (JavascriptExecutor) getDriver();

    public TimetrackingSteps() throws AWTException {
    }

    @Step
    public void setDates(String day, String month) {
        wait.until(ExpectedConditions.elementToBeClickable(timetrackingPage.viewClockingStatusBtn));
        timetrackingPage.viewClockingStatusBtn.click();
        timetrackingPage.openStartDateCalendar.click();
        wait.until(ExpectedConditions.visibilityOf(timetrackingPage.startDateCalendarHeading));
        timetrackingPage.startDateCalendarHeading.click();
        wait.until(ExpectedConditions.visibilityOf(timetrackingPage.startDateCalendarMonth(month)));
        timetrackingPage.startDateCalendarMonth(month).click();
        wait.until(ExpectedConditions.visibilityOf(timetrackingPage.startDateCalendarDay(day)));
        timetrackingPage.startDateCalendarDay(day).click();
        Select select = new Select(timetrackingPage.viewSelect);
        select.selectByIndex(1);
        timetrackingPage.searchBtn.click();
    }

    @Step
    public void login(String user, String pass) {
        wait.until(ExpectedConditions.elementToBeClickable(timetrackingPage.userField));
        timetrackingPage.userField.click();
        timetrackingPage.userField.sendKeys(user);
        timetrackingPage.pwdField.click();
        timetrackingPage.pwdField.sendKeys(pass);
        timetrackingPage.loginBtn.click();
    }

    @Step
    public void fillDays() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan((By.cssSelector("button.fixiconAlert")), 0));
        }catch (Exception e) {e.printStackTrace();}
        do{
            for(WebElement element : timetrackingPage.missingTimeEntries) {
                System.out.println("DEBUG:  " + timetrackingPage.missingTimeEntries.size());
                Thread.sleep(300);
                System.out.println(element.getCssValue("background-color"));
                if (element.getCssValue("background-color").contains("rgba(255, 148, 27, 1)")) {
                    js.executeScript("arguments[0].scrollIntoView(true);", element);
                    element.click();
                    timetrackingPage.newBtn.click();
                    wait.until(ExpectedConditions.visibilityOf(timetrackingPage.signInHoursInput));
                    timetrackingPage.signInHoursInput.clear();
                    timetrackingPage.signInHoursInput.click();
                    timetrackingPage.signInHoursInput.sendKeys(String.valueOf(8));
                    timetrackingPage.signInMinutesInput.clear();
                    timetrackingPage.signInMinutesInput.click();
                    timetrackingPage.signInMinutesInput.sendKeys(String.valueOf(0));
                    timetrackingPage.signOffHoursInput.clear();
                    timetrackingPage.signOffHoursInput.click();
                    timetrackingPage.signOffHoursInput.sendKeys(String.valueOf(16));
                    timetrackingPage.signOffMinutesInput.clear();
                    timetrackingPage.signOffMinutesInput.click();
                    timetrackingPage.signOffMinutesInput.sendKeys(String.valueOf(45));
                    timetrackingPage.saveBtn.click();
                    wait.until(ExpectedConditions.visibilityOf(timetrackingPage.savedEntry));
                    timetrackingPage.okBtn.click();
                    timetrackingPage.searchBtn.click();
                    try {
                        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan((By.cssSelector("button.fixiconAlert")), 0));
                    }catch (Exception e) {e.printStackTrace();}
                }
            }
            timetrackingPage.nextBtn.click();
        } while(!timetrackingPage.nextBtn.getAttribute("disabled").contains("true"));
    }
}
