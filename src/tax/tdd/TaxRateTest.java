package tax.tdd;

import org.junit.Assert;
import org.junit.Test;

public class TaxRateTest {
	@Test
	public void get_tax_rate_at_0_15_when_item_is_imported_and_unexempted(){
		TaxRate tr = new TaxRate();
		tr.setImported(true);
		tr.setExempted(false);
		Assert.assertEquals(.15, tr.getTaxRate(), .001);
	}
	@Test
	public void get_tax_rate_at_0_10_when_item_is_normal(){
		TaxRate tr = new TaxRate();
		tr.setImported(false);
		tr.setExempted(false);
		Assert.assertEquals(.10, tr.getTaxRate(), .001);
	}
	@Test
	public void get_tax_rate_at_0_05_when_item_is_imported_and_unexempted(){
		TaxRate tr = new TaxRate();
		tr.setImported(true);
		tr.setExempted(true);
		Assert.assertEquals(.05, tr.getTaxRate(), .001);
	}
	@Test
	public void get_tax_rate_at_0_when_item_is_domain_and_exempted(){
		TaxRate tr = new TaxRate();
		tr.setImported(false);
		tr.setExempted(true);
		Assert.assertEquals(.00, tr.getTaxRate(), .001);
	}
}
