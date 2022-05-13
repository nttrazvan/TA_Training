package suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
//Todo - The Suite Display Name is not grammatically correct
@Suite
@SuiteDisplayName("This tests validate the login functionality")
@IncludeTags(value = {"smoke","login"})
@SelectPackages("tests")
public class loginFormValidationSuite {
}
