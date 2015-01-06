package henry.core;

import org.junit.Assert;
import org.junit.Test;

public class NormalGoodTest {
	@Test(expected=IllegalArgumentException.class)
	public void constructorTest(){
		NormalGood ng = new NormalGood(-1, "perfume", true);
	}
	@Test
	public void getTax(){
		NormalGood ng = new NormalGood(10, "perfume", false);
		Assert.assertEquals(1, ng.getTax(), 0);
		
		NormalGood bti = new NormalGood(10, "perfume", true);
		Assert.assertEquals(1.5, bti.getTax(), 0);
	}
}
