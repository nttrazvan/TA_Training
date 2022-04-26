package suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("A demo Test Suite running tests 1 and 3")
@IncludeTags(value ={"enterCredentials", "validateLogin", "test3"})
@SelectPackages("tests")
public class no2 {
}
