package henry.core;

import org.junit.Assert;
import org.junit.Test;

public class OrderTest {
	@Test
	public void addItem(){
		Order order = new Order();
		order.addItem(new OrderItem(new Book(12.49, "book", false)));
		Assert.assertEquals(1, order.getItemSize());
		order.addItem(null);
		Assert.assertEquals(1, order.getItemSize());
	}
	@Test
	public void getSalesTaxes(){
		Order order = new Order();
		order.addItem(new OrderItem(new Book(12.49, "book", false)));
		Assert.assertEquals(.0, order.getSalesTaxes(),0);
		order.addItem(null);
		Assert.assertEquals(.0, order.getSalesTaxes(),0);
	}
	@Test
	public void getTotalFee(){
		Order order = new Order();
		order.addItem(new OrderItem(new Book(12.49, "book", false)));
		Assert.assertEquals(12.49, order.getTotalFee(),0);
		order.addItem(null);
		Assert.assertEquals(12.49, order.getTotalFee(),0);
	}

	@Test
	public void testInput1FromObject(){
		System.out.println("Output 1:");
		double deta = .000;
		Book book_1 = new Book(12.49, "book", false);
		NormalGood ng1_1 = new NormalGood(14.99, "music CD", false);
		Food food_1 = new Food(0.85, "chocolate bar", false);
		
		OrderItem oi1_1 = new OrderItem(book_1);
		Assert.assertEquals(12.49, oi1_1.getTotalFee(),deta);
		
		OrderItem oi2_1 = new OrderItem(ng1_1);
		Assert.assertEquals(16.49, oi2_1.getTotalFee(),deta);
		
		OrderItem oi3_1 = new OrderItem(food_1);
		Assert.assertEquals(0.85, oi3_1.getTotalFee(),deta);
		
		Order order = new Order();
		order.addItem(oi1_1).addItem(oi2_1).addItem(oi3_1);
		
		Assert.assertEquals(1.5, order.getSalesTaxes(),deta);
		Assert.assertEquals(29.83, order.getTotalFee(),deta);
		order.showOrderDetail();
	}
	@Test
	public void testInput2FromObject(){
		System.out.println("Output 2:");
		double deta = .000;
		Food ig1_2 = new Food(10.0, "imported box of chocolates", true);
		NormalGood ig2_2 = new NormalGood(47.5, "imported bottle of perfume", true);
		
		OrderItem oi1_2 = new OrderItem(ig1_2);
		Assert.assertEquals(10.5, oi1_2.getTotalFee(),deta);
		
		OrderItem oi2_2 = new OrderItem(ig2_2);
		Assert.assertEquals(54.65, oi2_2.getTotalFee(),deta);
		
		Order order2 = new Order();
		order2.addItem(oi1_2).addItem(oi2_2);
		
		Assert.assertEquals(7.65, order2.getSalesTaxes(),deta);
		Assert.assertEquals(65.15, order2.getTotalFee(),deta);
		order2.showOrderDetail();
		
		
	}
	@Test
	public void testInput3FromObject(){
		System.out.println("Output 3:");
		double deta = .000;
		
		NormalGood ig1_3 = new NormalGood(27.99, "imported bottle of perfume", true);
		NormalGood ng1_3 = new NormalGood(18.99, "bottle(s) of perfume", false);
		Medical m1_3 = new Medical(9.75, "packet(s) of headache pills", false);
		Food food_3 = new Food(11.25, "box(es) imported chocolates", true);
		
		OrderItem oi1_3 = new OrderItem(ig1_3);
		Assert.assertEquals(32.19, oi1_3.getTotalFee(),deta);
		
		OrderItem oi2_3 = new OrderItem(ng1_3);
		Assert.assertEquals(20.89, oi2_3.getTotalFee(),deta);
		
		OrderItem oi3_3 = new OrderItem(m1_3);
		Assert.assertEquals(9.75, oi3_3.getTotalFee(),deta);
		
		OrderItem oi4_3 = new OrderItem(food_3);
		Assert.assertEquals(11.85, oi4_3.getTotalFee(),deta);
		
		Order order3 = new Order();
		order3.addItem(oi1_3).addItem(oi2_3).addItem(oi3_3).addItem(oi4_3);
		
		Assert.assertEquals(6.7, order3.getSalesTaxes(),deta);
		Assert.assertEquals(74.68, order3.getTotalFee(),deta);
		order3.showOrderDetail();
	}
	
}
