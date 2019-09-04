package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.emptyTestTemplate1;
import tests.emptyTestTemplate3;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        emptyTestTemplate1.class,
        emptyTestTemplate3.class
})
public class testSuite2 {
}
