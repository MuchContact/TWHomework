package henry.core;


import java.text.NumberFormat;

import junit.framework.Assert;

import org.junit.Test;

public class ImportedTaxStrategyTest {
	@Test
	public void getRate(){
		TaxStrategy ts = new TaxStrategy(0.1);
		ImportedTaxStrategy its = new ImportedTaxStrategy(ts);
		Assert.assertEquals(0.15, its.getRate(),0.001);
		Assert.assertEquals(15, its.getTax(100),0.001);
	}
}
