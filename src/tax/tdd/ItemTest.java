package tax.tdd;

import junit.framework.Assert;

import org.junit.Test;

public class ItemTest {
	@Test
	public void charge_20_89_given_perfume_at_18.99(){
		boolean imported = false;
		Item item = new Item("perfume", 18.99, "normal", imported);
		Assert.assertEquals(20.89, item.getShelfPrice());
	}
}
