package suites;

import org.junit.jupiter.api.Tag;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import java.lang.annotation.Annotation;

@SelectPackages("tests")
@IncludeTags({"enterCredentials"})
@Suite
@SuiteDisplayName("A demo Test Suite running tests 1 and 3")
@Tag(value = "suite2")
public class no2 {
}
