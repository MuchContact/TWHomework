package henry.core;

import org.junit.Assert;
import org.junit.Test;

public class ShoppingFactoryTest {
	@Test
	public void testForInput1FromString(){
		
		String input = "1 book at 12.49\r\n" +
				"1 music CD at 14.99\r\n" +
				"1 chocolate bar at 0.85\r\n";
		
		double deta = .000;
		Order order = ShoppingFactory.createOrder(input);
		Assert.assertEquals(1.5, order.getSalesTaxes(),deta);
		Assert.assertEquals(29.83, order.getTotalFee(),deta);
		order.showOrderDetail();
	}
	@Test
	public void testForInput2FromString(){
		String input = "1 imported box of chocolates at 10.00\r\n" +
				"1 imported bottle of perfume at 47.50\r\n";
		
		double deta = .000;
		Order order = ShoppingFactory.createOrder(input);
		Assert.assertEquals(7.65, order.getSalesTaxes(),deta);
		Assert.assertEquals(65.15, order.getTotalFee(),deta);
		order.showOrderDetail();
	}
	@Test
	public void testForInput3FromString(){
		String input = "1 imported bottle of perfume at 27.99\r\n" +
				"1 bottle of perfume at 18.99\r\n" +
				"1 packet of headache pills at 9.75\r\n" +
				"1 box of imported chocolates at 11.25\r\n";
		
		double deta = .000;
		Order order = ShoppingFactory.createOrder(input);
		Assert.assertEquals(6.70, order.getSalesTaxes(),deta);
		Assert.assertEquals(74.68, order.getTotalFee(),deta);
		order.showOrderDetail();
	}
	
	@Test
	public void createOrderItem(){
		
	}
	
	@Test
	public void checkValid(){
		Assert.assertEquals(true, ShoppingFactory.checkValid("1 book at 12.49"));
		Assert.assertEquals(false, ShoppingFactory.checkValid("1 book at 12.49a"));
	}
	
	@Test
	public void isImportedGood(){
		Assert.assertEquals(true, ShoppingFactory.isImportedGood("1 imported book at 12.49"));
		Assert.assertEquals(false, ShoppingFactory.isImportedGood("1 book at 12.49"));
	}
	
	@Test
	public void isExemptGood(){
		Assert.assertEquals(true, ShoppingFactory.isExemptGood("1 book at 12.49"));
		Assert.assertEquals(false, ShoppingFactory.isExemptGood("1 perfume at 12.49"));
	}
	
	@Test
	public void getQuantityNameAndPrice(){
		Assert.assertEquals(null, ShoppingFactory.getQuantityNameAndPrice(""));
		Assert.assertEquals(null, ShoppingFactory.getQuantityNameAndPrice("1 book at"));
		Assert.assertEquals(null, ShoppingFactory.getQuantityNameAndPrice(null));
		Assert.assertEquals("1; book ;12.49", ShoppingFactory.getQuantityNameAndPrice("1 book at  12.49"));
	}
}
