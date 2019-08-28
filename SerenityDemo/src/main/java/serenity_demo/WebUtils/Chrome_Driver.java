package serenity_demo.WebUtils;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Chrome_Driver extends DriverBaseClass {

	private static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
	private static String returnedOS = variables.getProperty("environment.os").toLowerCase();
	private static String driverName = "";

	@Override
	public WebDriver newDriver() {
		super.newDriver();
		File file = new File(filePath + driverName);
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		// Add ChromeDriver-specific capabilities through ChromeOptions.
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addExtensions(new File("/path/to/extension.crx"));
		 * capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		 */

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);

		return driver;
	}

}
