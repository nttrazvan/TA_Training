package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.emptyTestTemplate1;
import tests.emptyTestTemplate2;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        emptyTestTemplate1.class,
        emptyTestTemplate2.class
})
public class testSuite1 {
}
