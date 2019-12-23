package Cucumber.CucumberUtils.steps;

import Cucumber.CucumberUtils.pages.EmptyTemplatePage;
import Cucumber.TestDataContainer.TestDataContainer;
import Cucumber.Utils.DriverUtils;
import cucumber.api.DataTable;
import cucumber.api.java.bs.I;
import javafx.util.Pair;
import net.thucydides.core.annotations.Step;
import org.jruby.RubyProcess;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertTrue;

public class EmptyTemplateSteps {
    private EmptyTemplatePage emptyTemplatePage;
    private DriverUtils driverUtils;
    private int initialValue = 0;

    @Step("I set the value of the int initialValue to the given parameter")
    public void stepWithOneParameter(int initialValueParameter) {
        initialValue = initialValueParameter;
    }

    @Step("I verify the initialParameter + firstParameter = secondParameter")
    public void stepWithTwoParameters(int firstParameter, int secondParameter) {
        assertTrue("This message will be thrown when the test does not pass in the console",
                initialValue + firstParameter == secondParameter);
    }

    @Step("STEP: I navigate to URL")
    public void navigate(String url){
        emptyTemplatePage.navigate(url);
    }

    @Step("STEP: I input the string")
    public void inputString(String something){
        emptyTemplatePage.searchField.sendKeys(something);
        emptyTemplatePage.searchField.submit();
    }

    @Step("STEP: I verify it the string is present in the results at least once")
    public void verifySearchResultsTitles(String something){
        System.out.println("The number of search results titles is: " + emptyTemplatePage.resultsTitles.size());
        boolean exitResult = false;
        int index = 0;
        for(WebElement element : emptyTemplatePage.resultsTitles){
            int i = emptyTemplatePage.resultsTitles.indexOf(element) + 1;
            if (element.getAttribute("textContent").toLowerCase().contains(something)){
                System.out.println("The title numbered: " + i + " contains the string: " + something);
            exitResult = true;
            } else {
                System.out.println("The title numbered: " + i + " does not contain the string: " + something);}
        }
        assertTrue("This message will be thrown when the test does not pass in the console",
                exitResult);
    }

    @Step("STEP: I check the headers are something")
    public void checkHeader(String header){
        boolean exitResult=false;
        for(WebElement element:emptyTemplatePage.headersList){
            if(element.getAttribute("textContent").contains(header.toString())){
                exitResult=true;
                break;
            }
        }
        Assert.assertTrue("The header does not contain the value" + header.toString(), exitResult);
    }

    @Step("STEP: I check the list")
    public void tableContains(String Index, String col1, String col2, String col3, String col4, String col5, String col6, String col7) throws InterruptedException {
        boolean comparationResult = true;
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(emptyTemplatePage.cellList(Index).get(0)));
        List<String> parameterList = new ArrayList<>(7);parameterList.add(col1);parameterList.add(col2);parameterList.add(col3);parameterList.add(col4);parameterList.add(col5);parameterList.add(col6);parameterList.add(col7);
        String value = "";
        WebElement element1 = null;
        Iterator<WebElement> elementIterator = emptyTemplatePage.cellList(Index).iterator();
        for(String string : parameterList){
            element1 = elementIterator.next();
            value = string;
            System.out.println("DEBUG: The PARAMETER is: "+value.replaceAll("\\s+",""));
            System.out.println("DEBUG: The ELEMENT VALUE is: "+element1.getAttribute("textContent").replaceAll("\\s+",""));
            if(!element1.getAttribute("textContent").replaceAll("\\s+","").contains(value.replaceAll("\\s+",""))){
                comparationResult=false;
            }
        }
        Assert.assertTrue("The parameters given and values do not match", comparationResult);
    }

    @Step("Check title")
    public void checkTitle(String title){
        Assert.assertTrue("The title is not the correct one", getDriver().getTitle().contains(title));
    }

    @Step("Check if the content matches")
    public void theContentMatches(){
        Assert.assertTrue("The content does not match the expected conditions", emptyTemplatePage.contentHolder.getAttribute("textContent").contains(TestDataContainer.content));
    }

    @Step("I click the required button and verify it has text")
    public void clickAndVerifyButton(String button){
        switch(button) {
            case "Blue":
                emptyTemplatePage.blueButton.click();
                driverUtils.assertButtonContainsText(emptyTemplatePage.blueButton);
                break;
            case "Red":
                emptyTemplatePage.redButton.click();
                driverUtils.assertButtonContainsText(emptyTemplatePage.redButton);
                break;
            case "Green":
                emptyTemplatePage.greenButton.click();
                driverUtils.assertButtonContainsText(emptyTemplatePage.greenButton);
                break;
            default:
                Assert.fail("\n button was not found \n");
        }
    }

    @Step("I verify that the canvas has numbers")
    public void iVerifyCanvasHasNumbers(){
        final By SCRIPT = By.tagName("script");
        List<WebElement> scripts = new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(SCRIPT));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        String query = "return document.getElementsByTagName(\"script\")[arguments[0]].innerHTML;";
        Pattern p = Pattern.compile("canvas.strokeText\\('Answer: \\d+'");
        Pattern p2 = Pattern.compile("\\d+");
        String number = IntStream.range(0, scripts.size())
                .mapToObj(i -> (String)js.executeScript(query, i))
                .map(string -> p.matcher(string))
                .filter(m -> m.find())
                .map(m -> p2.matcher(m.group()))
                .filter(m -> m.find())
                .map(m -> m.group())
                .findFirst()
                .orElse(null);
        System.out.println(number);
        boolean exitResult = false;
        int transformToInt;
        try{
            transformToInt = Integer.parseInt(number);
            if(transformToInt == (int)transformToInt) {
                exitResult = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue("The canvas does not contain numbers", exitResult);
    }

    @Step("Check the bottom redirect works")
    public void checkBottomRedirect() throws InterruptedException {
        emptyTemplatePage.redirectBottom.click();
        Thread.sleep(1);
        ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs2.get(1));
        Assert.assertFalse("The title is not the correct one", getDriver().getTitle().contains("The Internet"));
    }

    @Step("Check the top redirect works")
    public void checkTopRedirect(){
        emptyTemplatePage.redirectTop.click();
        Assert.assertFalse("The title is not the correct one", getDriver().getTitle().contains("The Internet"));
    }

    @Step("Navigate back")
    public void navigateBack(){
        getDriver().navigate().back();
    }

    @Step("Close tab")
    public void closeTab(){
        getDriver().close();
        ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs2.get(0));
    }
}