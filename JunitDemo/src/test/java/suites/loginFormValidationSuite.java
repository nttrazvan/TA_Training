package suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
//Todo - The Suite Display Name does not explain what the suite actually does
@Suite
@SuiteDisplayName("A demo Test Suite running tests 1 and 2")
@IncludeTags(value = {"validateTitle","loginFormValidation"})
@SelectPackages("tests")
public class loginFormValidationSuite {
}
