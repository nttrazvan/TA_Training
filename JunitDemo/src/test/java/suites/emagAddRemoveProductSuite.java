package suites;

import org.junit.jupiter.api.Tag;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@SelectPackages("tests")
@IncludeTags({"addToCart", "removeFromCart"})
@Suite
@SuiteDisplayName("Emag Add Remove Product Suite")
@Tag("emagAddReemoveProductSuite")
public class emagAddRemoveProductSuite {
}