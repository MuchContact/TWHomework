package henry.core;

import org.junit.Assert;
import org.junit.Test;

public class BookTest {
	@Test(expected=IllegalArgumentException.class)
	public void constructorTest(){
		Book bt = new Book(-1, "book", true);
	}
	@Test
	public void getTax(){
		Book bt = new Book(10, "book", false);
		Assert.assertEquals(0, bt.getTax(), 0);
		
		Book bti = new Book(10, "book", true);
		Assert.assertEquals(0.5, bti.getTax(), 0);
	}
	@Test
	public void isBook(){
		Assert.assertEquals(true, Book.isBook("this is a book"));
		Assert.assertEquals(true, Book.isBook("this is a BOOK"));
		Assert.assertEquals(true, Book.isBook("this is a booK"));
		Assert.assertEquals(false, Book.isBook("this is a booa"));
	}
}
