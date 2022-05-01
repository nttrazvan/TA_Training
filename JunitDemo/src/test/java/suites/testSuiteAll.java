package suites;


import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("A Test Suite running tests for Browser Launching, Fill contact data and find Submit button")
@IncludeTags(value = {"launchBrowser","enterContactData", "submitBtn"})
@SelectPackages("tests")
public class testSuiteAll {
}
