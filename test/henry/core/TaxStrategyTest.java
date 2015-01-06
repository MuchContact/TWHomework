package henry.core;

import org.junit.Test;

import junit.framework.Assert;

public class TaxStrategyTest {
	/**
	 * test the effect of rounding up number to the nearest 0.05
	 */
	@Test
	public void defaultRoundup(){
		TaxStrategy ts = new TaxStrategy(1.0);
		double input[] = {0.93,0.92,0,0.65,0.625,0.624};
		double expects[] = {0.95,0.95,0,0.65,0.65,0.65};
		for(int i=0;i<expects.length;i++){
			Assert.assertEquals(expects[i], ts.defaultRoundup(input[i]), 0);
		}
	}
}
