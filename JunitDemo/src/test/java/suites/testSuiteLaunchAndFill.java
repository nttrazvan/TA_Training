package suites;


import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("A demo Test Suite running tests for Browser Launching and Fill contact data")
@IncludeTags(value = {"launchBrowser","enterContactData"})
@SelectPackages("tests")
public class testSuiteLaunchAndFill {
}
