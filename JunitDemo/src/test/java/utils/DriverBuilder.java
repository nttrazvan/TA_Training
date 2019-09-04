package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DriverBuilder {
    public static WebDriver getDriver;

    public static void setDriverDefaultWait(int seconds){
        getDriver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static WebDriver setDriver() {
        if (System.getProperty("webdriver.driver").contains("chrome")) {
            return getDriver = new ChromeDriver();
        } else if (System.getProperty("webdriver.driver").contains("firefox")) {
            return getDriver = new FirefoxDriver();
        } else if (System.getProperty("webdriver.driver").contains("internetExplorer")) {
            return getDriver = new InternetExplorerDriver();
        } else {
            return null;
        }
    }

    public static void initialiseWebdriver() throws IOException {
        Helpers.getPropValues();
        DriverBuilder.setDriver();
        DriverBuilder.setDriverDefaultWait(20);
        getDriver.get(System.getProperty("default.url"));
        getDriver.manage().window().maximize();
    }

    public static void kill() {
        if (getDriver != null) {
            getDriver.quit();
            getDriver = null;
        }
    }
}