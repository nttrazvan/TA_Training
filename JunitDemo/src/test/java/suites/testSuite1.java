package suites;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("A demo Test Suite running tests 1 and 2")
@IncludeTags(value = {"test1","test2"})
@SelectPackages("tests")
public class testSuite1{
}
