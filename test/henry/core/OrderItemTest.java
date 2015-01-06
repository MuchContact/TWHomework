package henry.core;

import org.junit.Assert;
import org.junit.Test;

public class OrderItemTest {
	@Test(expected=IllegalArgumentException.class)
	public void constructorTest1(){
		OrderItem oi = new OrderItem(null,1);
	}
	@Test(expected=IllegalArgumentException.class)
	public void constructorTest2(){
		OrderItem oi = new OrderItem(new Good(12.0,"Book") {
			
			@Override
			public void showGoodDetail() {
				// TODO Auto-generated method stub
				
			}
		},-1);
	}
	@Test
	public void getTax(){
		Book book = new Book(12.45, "Refractor", false);
		OrderItem oi = new OrderItem(book);
		Assert.assertEquals(.0, oi.getTax(), 0);
		
		Book importedBook = new Book(12.45, "Refractor", true);
		oi = new OrderItem(importedBook,2);
		Assert.assertEquals(1.30, oi.getTax(), 0);
	}
	@Test
	public void getTotalFee(){
		Book book = new Book(12.45, "Refractor", false);
		OrderItem oi = new OrderItem(book);
		Assert.assertEquals(12.45, oi.getTotalFee(), 0);
		
		Book importedBook = new Book(12.45, "Refractor", true);
		oi = new OrderItem(importedBook);
		Assert.assertEquals(13.10, oi.getTotalFee(), 0);
	}
	@Test
	public void getOrderItemDetail(){
		Book book = new Book(12.45, "Refractor", false);
		OrderItem oi = new OrderItem(book);
		Assert.assertEquals("1 Refractor:12.45", oi.getOrderItemDetail());
	}
	
}
