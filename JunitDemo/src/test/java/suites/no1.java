package suites;

import org.junit.jupiter.api.Tag;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@SelectPackages("tests")
@IncludeTags({"launchBrowser","button"})
@Suite
@SuiteDisplayName("A demo Test Suite running tests Launch Browser and find submit button")
@Tag("no1")
public class no1 {
}
