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
            System.out.println("DEBUG: Attempting to fetch the properties");
            Properties prop=new Properties();
            FileInputStream ip= new FileInputStream("./config.properties");
            prop.load(ip);
            System.setProperty("default.url",prop.getProperty("default.url"));
            System.setProperty("webdriver.driver",prop.getProperty("webdriver.driver"));
            System.setProperty("webdriver.timeouts.implicitlywait",prop.getProperty("webdriver.timeouts.implicitlywait"));
            System.setProperty("webdriver.chrome.driver",prop.getProperty("webdriver.chrome.driver"));
            System.setProperty("webdriver.ie.driver",prop.getProperty("webdriver.ie.driver"));
            System.setProperty("webdriver.gecko.driver",prop.getProperty("webdriver.gecko.driver"));
            System.setProperty("webdriver.restart",prop.getProperty("webdriver.restart"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void killDriverProcess() throws IOException {
        System.out.println("DEBUG: Attempting to quit the driver process");
            if (System.getProperty("webdriver.driver").contains("chrome")) {
                Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
                Runtime.getRuntime().exec("Taskkill /F /IM chromedriver.exe");
                Runtime.getRuntime().exec("taskkill /IM chrome.exe /F");
            } else if (System.getProperty("webdriver.driver").contains("firefox")) {
                Runtime.getRuntime().exec("taskkill /im geckodriver.exe /f");
                Runtime.getRuntime().exec("taskkill /IM firefox.exe /F");
            } else if (System.getProperty("webdriver.driver").contains("internetExplorer")) {
                Runtime.getRuntime().exec("taskkill /im IEDriverServer64.exe /f");
                Runtime.getRuntime().exec("taskkill /IM iexplore.exe /F");
            }
    }

    public static void waitForElement(int seconds, WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
