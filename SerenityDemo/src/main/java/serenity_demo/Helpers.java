package serenity_demo;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Helpers {
    public static WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

}
