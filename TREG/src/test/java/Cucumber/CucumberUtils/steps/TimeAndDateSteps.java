package Cucumber.CucumberUtils.steps;

import Cucumber.CucumberUtils.pages.TimeAndDatePage;
import Cucumber.TestDataContainer.TimeAndDateDataContainer;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeAndDateSteps {/*ToDo - please add spaces after class declaration*/
    private TimeAndDatePage timeAndDatePage;
    private TimeAndDateDataContainer timeAndDateDataContainer;
    private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    private SoftAssertions softly = new SoftAssertions();
    private String StartDate;
    private String EndDate;
    private Integer numberOfPublicHolidaysBetweenSixteenthONovemberAndThirteenthOfJanuary = 3;

    @Step()
    public void agreePrivacyPolicy() {
        timeAndDatePage.policyButton.click();
    }

    @Step()
    public void setStartDate(int startDay, String startMonth, int startYear) throws InterruptedException {
        Thread.sleep(5000);
        // Open Date picker
        timeAndDatePage.startDatePicker.click();
        //Grab year
        if (Integer.parseInt(timeAndDatePage.year.getText()) > startYear) {
            while (!(Integer.parseInt(timeAndDatePage.year.getText()) == startYear)) {
                timeAndDatePage.prevArrowYear.click();
            }
        } else {
            while (!(Integer.parseInt(timeAndDatePage.year.getText()) == startYear)) {
                timeAndDatePage.nextArrowYear.click();
            }
        }
        //Grab month
        {
            while (!timeAndDatePage.month.getText().contains(startMonth)) {
                timeAndDatePage.nextArrowMonth.click();
            }
        }
        //Grab days and iterate
        int startDaysCount = timeAndDatePage.days.size();
        for (int i = 0; i < startDaysCount; i++) {
            Integer startDays = Integer.valueOf(timeAndDatePage.days.get(i).getAttribute("outerText"));
            if (startDays == startDay) {
                timeAndDatePage.days.get(i).click();
            }
        }
        Integer actualInputStartDay = Integer.valueOf(timeAndDatePage.startDateInputDay.getAttribute("value"));
        Integer actualInputStartMonth = Integer.valueOf(String.valueOf(Integer.valueOf(timeAndDatePage.startDateInputMonth.getAttribute("value"))));
        Integer actualInputStartYear = Integer.valueOf(timeAndDatePage.startDateInputYear.getAttribute("value"));
        //Assert that the correct date was picked
        logger.info("I check that the day input " + actualInputStartDay + " is correct");
        Assert.assertTrue(actualInputStartDay == startDay);
        logger.info("I check that the month input " + actualInputStartMonth + " is correct");
        Assert.assertTrue(actualInputStartMonth == timeAndDateDataContainer.November);
        logger.info("I check that the year input " + actualInputStartYear + " is correct");
        Assert.assertTrue(actualInputStartYear == startYear);
        // Save the picked date in a string
        String startDate = actualInputStartDay + "-" + actualInputStartMonth + "-" + actualInputStartYear;
        System.out.println("The Start Date is: " + startDate);
        this.StartDate = startDate;
    }

    @Step()
    public void setEndDate(int endDay, String endMonth, int endYear) {
        // Open Date picker
        timeAndDatePage.endDatePicker.click();
        //Grab year
        if (Integer.parseInt(timeAndDatePage.year.getText()) > endYear) {
            while (!(Integer.parseInt(timeAndDatePage.year.getText()) == endYear)) {
                timeAndDatePage.prevArrowYear.click();
            }
        } else {
            while (!(Integer.parseInt(timeAndDatePage.year.getText()) == endYear)) {
                timeAndDatePage.nextArrowMonth.click();
            }
        }
        //Grab month
        {
            while (!timeAndDatePage.month.getText().contains(endMonth)) {
                timeAndDatePage.nextArrowMonth.click();
            }
        }
        //Grab days and iterate/*ToDo - please declare Integer as int and validate string comparisons by x.equals("") */
        int endDaysCount = timeAndDatePage.days.size();
        for (int i = 0; i < endDaysCount; i++) {
            Integer endDays = Integer.valueOf(timeAndDatePage.days.get(i).getAttribute("outerText"));
            if (endDays == endDay) {
                timeAndDatePage.days.get(i).click();
            }
        }
        Integer actualInputEndDay = Integer.valueOf(timeAndDatePage.endDateInputDay.getAttribute("value"));
        Integer actualInputEndMonth = Integer.valueOf(String.valueOf(Integer.valueOf(timeAndDatePage.endDateInputMonth.getAttribute("value"))));
        Integer actualInputEndYear = Integer.valueOf(timeAndDatePage.endDateInputYear.getAttribute("value"));
        //Assert that the correct date was picked
        logger.info("I check that the day input " + actualInputEndDay + " is correct");
        Assert.assertTrue(actualInputEndDay == endDay);
        logger.info("I check that the month input " + actualInputEndMonth + " is correct");
        Assert.assertTrue(actualInputEndMonth == timeAndDateDataContainer.January);
        logger.info("I check that the year input " + actualInputEndYear + " is correct");
        Assert.assertTrue(actualInputEndYear == endYear);
        // Save the picked date in a string
        String endDate = actualInputEndDay + "-" + actualInputEndMonth + "-" + actualInputEndYear;
        System.out.println("The End Date is: " + endDate);
        this.EndDate = endDate;
    }

    @Step()
    public void includeEndDate() {
        timeAndDatePage.checkboxEndDateInclusion.click();
    }

    @Step()
    public void submit() throws InterruptedException {
        timeAndDatePage.submitButton.click();
        Thread.sleep(3000);
    }

    @Step()
    public long calculateDifference(String considerEndDate) throws InterruptedException {
        //calculation of End Date, including or excluding the end day
        long differenceInDays = 0;
        String finalEndDate = null;
        if (considerEndDate.equals("including")) {
            Integer dayIncludingEndDay = Integer.valueOf(EndDate.substring(0, 2)) + 1;
            String restOfEndDate = EndDate.substring(2);
            String endDateDateIncludingEndDay = dayIncludingEndDay + restOfEndDate;
            finalEndDate = endDateDateIncludingEndDay;
        } else {
            finalEndDate = EndDate;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date d1 = sdf.parse(StartDate);
            Date d2 = sdf.parse(finalEndDate);
            long differenceInTime = d2.getTime() - d1.getTime();
            differenceInDays = TimeUnit.MILLISECONDS.toDays(differenceInTime);
            String result = "Result: " + differenceInDays + " days";
            System.out.println(result);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            System.out.println("This calculated the difference between start and end date.");
        }
        return differenceInDays;
    }

    @Step
    public void validateResult(String considerEndDay) throws InterruptedException {
        String calculatedResult = "Result: " + calculateDifference(considerEndDay) + " days";
        System.out.println("The expected " + calculatedResult);
        String actualResult = timeAndDatePage.result.getText();
        System.out.println("The actual " + actualResult);
        Assert.assertEquals(calculatedResult, actualResult);
    }

    @Step
    public void clickCountWorkDays(){
        timeAndDatePage.countOnlyWorkdays.click();
    }

    @Step
    public void selectIncludeOnly(){
        timeAndDatePage.selectIncludeOnly.click();
    }

    @Step
    public void selectOnlyWeekends(){
        timeAndDatePage.dayTypeWeekends.click();
    }

    @Step()
    public void excludeWeekends() throws InterruptedException {
        timeAndDatePage.dayTypeWeekends.click();
        Thread.sleep(3000);
    }

    @Step()
    public long calculateDifferenceExcludingWeekends(String considerEndDate) {
        //calculation of End Date, including or excluding the end day
        long differenceInDays = 0;
        String finalEndDate = null;
        if (considerEndDate.equals("including")) {
            Integer dayIncludingEndDay = Integer.valueOf(EndDate.substring(0, 2)) + 1;
            String restOfEndDate = EndDate.substring(2);
            String endDateDateIncludingEndDay = dayIncludingEndDay + restOfEndDate;
            finalEndDate = endDateDateIncludingEndDay;
        } else {
            finalEndDate = EndDate;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date d1 = sdf.parse(StartDate);
            Date d2 = sdf.parse(finalEndDate);
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal1.setTime(d1);
            cal2.setTime(d2);
            while (cal1.before(cal2)) {
                if ((Calendar.SATURDAY != cal1.get(Calendar.DAY_OF_WEEK))
                        && (Calendar.SUNDAY != cal1.get(Calendar.DAY_OF_WEEK))) {
                    differenceInDays++;
                }
                cal1.add(Calendar.DATE, 1);
            }
            String result = "Calculated result: " + differenceInDays + " days";
            System.out.println(result);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            System.out.println("This method calculated the difference excluding weekends.");
        }
        return differenceInDays;
    }

    @Step()
    public long calculateDifferenceIncludingWeekendsOnly(String considerEndDate) {
        //calculation of End Date, including or excluding the end day
        long differenceInDays = 0;
        String finalEndDate = null;
        if (considerEndDate.equals("including")) {
            Integer dayIncludingEndDay = Integer.valueOf(EndDate.substring(0, 2)) + 1;
            String restOfEndDate = EndDate.substring(2);
            String endDateDateIncludingEndDay = dayIncludingEndDay + restOfEndDate;
            finalEndDate = endDateDateIncludingEndDay;
        } else {
            finalEndDate = EndDate;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date d1 = sdf.parse(StartDate);
            Date d2 = sdf.parse(finalEndDate);
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal1.setTime(d1);
            cal2.setTime(d2);
            while (cal1.before(cal2)) {
                if ((Calendar.SATURDAY == cal1.get(Calendar.DAY_OF_WEEK))
                        && (Calendar.SUNDAY == cal1.get(Calendar.DAY_OF_WEEK))) {
                    differenceInDays++;
                }
                cal1.add(Calendar.DATE, 1);
            }
            String result = "Calculated result: " + differenceInDays + " days";
            System.out.println(result);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            System.out.println("This method calculated the difference including weekends only.");
        }
        return differenceInDays;
    }

    @Step
    public void validateResultExcludingWeekends(String considerEndDay) {
        String calculatedResult = "Result: " + calculateDifferenceExcludingWeekends(considerEndDay) + " days";
        System.out.println("The expected " + calculatedResult);
        String actualResult = timeAndDatePage.result.getText();
        System.out.println("The actual " + actualResult);
        Assert.assertEquals(calculatedResult, actualResult);
    }

    @Step
    public void validatePublicHolidaysOnly() {
        String expectedResult = "Result: " + numberOfPublicHolidaysBetweenSixteenthONovemberAndThirteenthOfJanuary + " days";
        System.out.println("The expected: " + expectedResult);
        String actualResult = timeAndDatePage.result.getText();
        System.out.println("The actual " + actualResult);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Step
    public void validateResultIncludingWeekendsOnly(String considerEndDay) throws InterruptedException {
        String calculatedResult = "Result: " + (calculateDifference(considerEndDay) - calculateDifferenceExcludingWeekends(considerEndDay)) + " days";
        System.out.println("The expected " + calculatedResult);
        String actualResult = timeAndDatePage.result.getText();
        System.out.println("The actual " + actualResult);
        Assert.assertEquals(calculatedResult, actualResult);
    }
}