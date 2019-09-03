package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static utils.DriverBuilder.getDriver;

public class Helpers {
    private static InputStream inputStream;

    public static void getPropValues() throws IOException {
        try {
            Properties prop=new Properties();
            FileInputStream ip= new FileInputStream("./config.properties");
            prop.load(ip);
            System.setProperty("default.url",prop.getProperty("default.url"));
            System.setProperty("webdriver.driver",prop.getProperty("webdriver.driver"));
            System.setProperty("webdriver.timeouts.implicitlywait",prop.getProperty("webdriver.timeouts.implicitlywait"));
            System.setProperty("webdriver.chrome.driver",prop.getProperty("webdriver.chrome.driver"));
            System.setProperty("webdriver.ie.driver",prop.getProperty("webdriver.ie.driver"));
            System.setProperty("webdriver.gecko.driver",prop.getProperty("webdriver.gecko.driver"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void killDriverProcess() throws IOException {
        Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
        Runtime.getRuntime().exec("taskkill /im geckodriver.exe /f");
        Runtime.getRuntime().exec("taskkill /im IEDriverServer64.exe /f");
    }
    public static void waitForElement(int seconds, WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
