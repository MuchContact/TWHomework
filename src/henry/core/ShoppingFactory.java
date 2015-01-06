package henry.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Liu hengjian.
 *
 */
public class ShoppingFactory {
	//the required string format for a single line input
	private static final String PATTERN = "([0-9]+)(.+)at\\s+([0-9]+\\.[0-9]+)";
	
	/**
	 * @param input
	 * @return
	 */
	public static Order readInput(String input){
		return createOrder(input);
	}
	
	/**
	 * @param input
	 * @return
	 */
	public static OrderItem readSingleLineInput(String input){
		return createOrderItem(input);
	}
	
	/**
	 * @param input
	 * @return new instance of Order class
	 */
	public static Order createOrder(String input){
		if(input==null)
			return null;
		
		BufferedReader reader = new BufferedReader(new StringReader(input));
		
		Order order = new Order();
		try {
			String source;
			while ((source = reader.readLine()) != null) {
				order.addItem(createOrderItem(source));
			}
			//order.showOrderDetail();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return order;
	}
	
	/**
	 * Build an orderitem instance using a method object of OrderItemCreator.
	 * @param source
	 * @return
	 */
	public static OrderItem createOrderItem(String source){
		if(source==null)
			return null;
		
		String infor = getQuantityNameAndPrice(source);
		if(infor==null)
			return null;
		
		String arr[] = infor.split(";");
		if(arr.length<3)
			return null;
		
		return new OrderItemCreator(arr[0], arr[1], arr[2], isImportedGood(source),
										isExemptGood(source)
									).create();
	}
	
	/**
	 * If source is matched for pattern {number}{any character}at{any character}{number}.{number}
	 * then joint Quantity+";"+Name+";"+Price and return the result string.
	 * Otherwise return null.
	 * @param source
	 * @return good item information or null
	 */
	public static String getQuantityNameAndPrice(String source){
		if(source==null||!checkValid(source))
			return null;
		return source.replaceAll(PATTERN, "$1;$2;$3");
	}
	
	/**
	 * match string like "{number}{any character}at{any character}{number}.{number}"
	 * @param source
	 * @return true if source matches the pattern, otherwise return false
	 */
	public static boolean checkValid(String source){
		if(source==null)
			return false;
		Pattern pat = Pattern.compile(PATTERN);
		Matcher match = pat.matcher(source);
		return match.matches();
	}

	/**
	 * judge if source represents a good which is imported
	 * @param source 
	 * @return true if source contains substring "imported", otherwise return false
	 */
	public static boolean isImportedGood(String source){
		if(source==null)
			return false;
		return source.toLowerCase().contains("imported");
	}
	
	/**
	 * judge if source represents a good without basic taxes
	 * @param source
	 * @return true if source is food, or book, or medical
	 */
	public static boolean isExemptGood(String source){
		if(source==null)
			return false;
		
		if(Food.isFood(source)||Book.isBook(source)||Medical.isMedical(source))
			return true;
		
		return false;
	}
	
	/**
	 * A method class for the sake of create OrderItem
	 *
	 */
	private static class OrderItemCreator{
		
		private int quantity;
		private String name;
		private double price;
		private boolean isImported;
		private boolean isExempt;
		
		
		OrderItemCreator(String quantity, String name, String price, 
				boolean isImported, boolean isExempt) {
			this.quantity = Integer.valueOf(quantity);
			this.name = name;
			this.price = Double.valueOf(price);
			this.isImported = isImported;
			this.isExempt = isExempt;
		}
		
		
		/**
		 * create instance of OrderItem without specific subclasses of Good
		 * @return a new instance of OrderItem
		 */
		public OrderItem create(){
			
			TaxStrategy ts = TaxStrategyFactory
								.getTaxStrategyInstance(isImported, isExempt);
			
			Good good = new Good(price, name, ts) {
				
				@Override
				public void showGoodDetail() {
					// TODO Auto-generated method stub
					
				}
			};
			
			return new OrderItem(good, quantity);
		}
		
		/**
		 * create instance of OrderItem with specific subclasses of Good
		 * @return a new instance of OrderItem
		 */
		public OrderItem create1(){
			
			Good good = null;
			
			if(Food.isFood(name))
				good = new Food(price, name, isImported);
			else if(Book.isBook(name))
				good = new Book(price, name, isImported);
			else if(Medical.isMedical(name))
				good = new Medical(price, name, isImported);
			else
				good = new NormalGood(price, name, isImported);
			
			return new OrderItem(good, quantity);
		}
	}
}
