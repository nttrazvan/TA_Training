package suites;

import org.junit.jupiter.api.Tag;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@SelectPackages("tests")
@IncludeTags({"emagHome"})
@Suite
@SuiteDisplayName("Emag Home Page Suite")
@Tag("emagHomeSuite")
public class emagHomePageSuite {
}
