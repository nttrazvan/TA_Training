package serenity_demo.WebUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox_Driver extends DriverBaseClass {

	@Override
	public WebDriver newDriver() {

		super.newDriver();

		driver = new FirefoxDriver(capabilities);

		return driver;
	}
}
