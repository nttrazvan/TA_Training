package serenity_demo.WebUtils;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriver extends DriverBaseClass {

	@Override
	public WebDriver newDriver() {

		super.newDriver();

		String driverName = "IEDriverServer.exe";
		int BrowserAttachTimeoutMiliseconds = 5000;

		File file = new File(filePath + driverName);
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());

		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
		capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
		capabilities.setCapability(InternetExplorerDriver.BROWSER_ATTACH_TIMEOUT, BrowserAttachTimeoutMiliseconds);
		capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, false);
		capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		capabilities.setCapability("disable-popup-blocking", true);
		capabilities.setCapability("ignoreProtectedModeSettings", true);

		driver = new InternetExplorerDriver(capabilities);
		return driver;
	}

}
