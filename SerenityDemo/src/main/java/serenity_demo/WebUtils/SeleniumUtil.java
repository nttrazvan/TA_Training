package serenity_demo.WebUtils;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by corina.pip on 3/3/2017.
 */
public class SeleniumUtil {

    public static WebDriverWait defaultWait = new WebDriverWait(getDriver(), 12);

    /**
     * Provide a dropdown to this method so that you can defaultWait for it to load properly
     * before interacting with it
     *
     * @param dropdown
     * @throws InterruptedException
     */



    public void waitForDropdownToBePopulated(List<WebElementFacade> dropdown) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);

        ExpectedCondition<Boolean> dropdownNotEmpty = arg0 -> {
            boolean isPopulated = false;
            try {
                int size = dropdown.size();
                //the first time the dropdown opens it displays a Loading... message
                //the method waits until the dropdown has any number of options except
                //except if it only has one element which is Loading...
                if ((size == 1 && !dropdown.get(0).getText().equals("Loading...")) || size > 1) isPopulated = true;
            }
            //avoiding Stale exception mostly
            catch (Exception e) {
                isPopulated = false;
            }
            return isPopulated;
        };
        wait.until(dropdownNotEmpty);
    }

    public static void Sleep(int Duration){
        try {
            Thread.sleep(Duration);
        } catch (InterruptedException e) { }
    }

    public static void scrollElementIntoView(WebElementFacade element) {
        JavascriptExecutor je = (JavascriptExecutor) getDriver();
        je.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollElementIntoView(WebElement element){
        JavascriptExecutor je = (JavascriptExecutor) getDriver();
        je.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public static void setElementOpacityToOne(String elementCss) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("$('" + elementCss + "').css('opacity','1');");
    }

    public static void setElementOpacityToOne(WebElementFacade element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("$('" + element + "').css('opacity','1');");
    }

    //method for clicking radio buttons and checkboxes which have opacity:0
    // and selenium can't find them as displayed
    public static void clickSpecialElement(String elementCss) {
        scrollElementIntoView(findElementByCss(elementCss));
        setElementOpacityToOne(elementCss);
        findElementByCss(elementCss).click();
    }

    public static void clickUncheckedElement(String elementCSS) {
        boolean isElementChecked = false;
        scrollElementIntoView(findElementByCss(elementCSS));
        setElementOpacityToOne(elementCSS);
        try {
            if (findElementByCss(elementCSS).getAttribute("checked").contains("true")) {
                isElementChecked = true;
            }
        } catch (Exception f) {
        }
        if (!isElementChecked) {
            findElementByCss(elementCSS).click();
        }
    }

    public static void selectSpecialCheckbox(String elemCss){
        try {
            setElementOpacityToOne(elemCss);
            WebElement checkbox = findElementByCss(elemCss);
            if (!checkbox.isSelected()) {
                clickSpecialElement(elemCss);
            }
        }catch (Exception e){}
    }

    public static void uncheckSpecialCheckbox(String elemCss){
        setElementOpacityToOne(elemCss);
        WebElement checkbox = findElementByCss(elemCss);
        if(checkbox.isSelected()){
            clickSpecialElement(elemCss);
        }
    }

    public static WebElement findElementByCss(String elementCss) {
        return getDriver().findElement(By.cssSelector(elementCss));
    }

    public static List<WebElement> findElementsByCss(String elementCss) {
        return getDriver().findElements(By.cssSelector(elementCss));
    }

    public static WebElement findElementByXpath(String elementXpath) {
        defaultWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        return getDriver().findElement(By.xpath(elementXpath));
    }

    public static List<WebElement> findElementsByXpath(String elementXpath) {
        defaultWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        return getDriver().findElements(By.xpath(elementXpath));
    }

    public static void selectFromDropdownByVisibleText(WebElementFacade element, String visibleText){
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(visibleText);
    }

    public static void selectFromMultiselectByValue(WebElementFacade element, String visibleText){
        Select multiselect = new Select(element);
        multiselect.selectByValue(visibleText);
    }

    public static boolean isElementDisplayed(String elementXpath) {
        try{
            findElementByXpath(elementXpath).isDisplayed();
        } catch(Exception e){
            return false;
        }
        return true;
    }

    public static boolean isElementDisplayed(WebElementFacade element) {
        try{
            Sleep(150);
            element.isDisplayed();
        } catch(Exception e){
            return false;
        }
        return true;
    }

    public static List<WebElement> findElements(String xpath) {
        return getDriver().findElements(By.xpath(xpath));
    }

    public static void setInputValue(WebElementFacade element, String value) {
        element.clear();
        element.sendKeys(value);
    }

}
