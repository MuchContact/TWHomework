package henry.core;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ShoppingFactoryTest.class, OrderTest.class, OrderItemTest.class,
				BookTest.class, NormalGoodTest.class, TaxStrategyTest.class,
				ImportedTaxStrategyTest.class})
public class TestSuit {

}
