package suites;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("A demo Test Suite running tests 1 and 3")
@IncludeTags(value ={"test1","test3"})
@SelectPackages("tests")
public class testSuite2 {
}
