package suites;

import org.junit.jupiter.api.Tag;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@SelectPackages("tests")
@IncludeTags({"testNavigation","testChooseModel"})
@Suite
@SuiteDisplayName("A Test Suite running navigation tests")
@Tag(value = "suite3")
public class testSuite3 {
}
