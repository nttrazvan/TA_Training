package suites;

import org.junit.jupiter.api.Tag;
import org.junit.platform.suite.api.*;

import java.lang.annotation.Annotation;

@SelectPackages("tests")
@IncludeTags({"test1","test3"})
@Suite
@SuiteDisplayName("A demo Test Suite running tests 1 and 3")
@Tag(value = "suite2")
public class testSuite2 {
}
