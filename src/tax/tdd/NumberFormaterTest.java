package tax.tdd;

import junit.framework.Assert;

public class NumberFormaterTest {
	@Test
	public void get_0.89_given_0.889(){
		NumberFormater nf = new NumberFormater();
		Assert.assertEquals(.89, nf.roundWith2Decimals(0.889));;
	}
}
