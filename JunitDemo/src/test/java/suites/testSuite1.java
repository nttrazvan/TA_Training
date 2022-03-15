package suites;

import org.junit.platform.suite.api.*;
import tests.emptyTestTemplate1;
import tests.emptyTestTemplate2;
import tests.emptyTestTemplate3;

@SelectClasses({emptyTestTemplate1.class, emptyTestTemplate2.class, emptyTestTemplate3.class})
@IncludeTags({"test1","test2"})
@Suite
@SuiteDisplayName("A demo Test Suite running tests 1 and 2")
public class testSuite1 {
}
