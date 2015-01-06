package henry.core;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Liu hengjian.
 * 
 */
public class Order {
	
	//every order item contains an instance of Good and the quantity
	private List<OrderItem> items = new ArrayList<OrderItem>(); 
	
	
	/**
	 * if item is null, do not add it.
	 * The return value is the instance itself, able to add items continuously
	 * @param item
	 * @return the instance itself.
	 */
	public Order addItem(OrderItem item){
		if(item!=null)
			items.add(item);
		return this;
	}
	
	/**
	 * @return number of order items
	 */
	public int getItemSize(){
		return items.size();
	}
	
	
	/**
	 * @return total sales taxes
	 */
	public double getSalesTaxes(){
		double totalTax=0.0;
		for(OrderItem item:items){
			totalTax += item.getTax();
		}
		return formatNumberWith2Decimal(totalTax);
	}
	
	
	/**
	 * @return total fee of all goods
	 */
	public double getTotalFee(){
		double total=0.0;
		for(OrderItem item:items){
			total += item.getTotalFee();
		}
		return formatNumberWith2Decimal(total);
	}
	
	/**
	 * output information of order detail in the console
	 */
	public void showOrderDetail(){
		for(OrderItem item:items){
			System.out.println(item.getOrderItemDetail());
		}
		System.out.println("Sales Taxes:"+formatNumber2StrWith2Decimal(getSalesTaxes()));
		System.out.println("Total:"+formatNumber2StrWith2Decimal(getTotalFee()));
		
	}
	
	/**
	 * to fix the decimal bug and format the number
	 * @param number
	 * @return a formated number
	 */
	private double formatNumberWith2Decimal(double number){
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		return new BigDecimal(nf.format(number)).doubleValue();
	}
	
	/**
	 * @param number
	 * @return
	 */
	private String formatNumber2StrWith2Decimal(double number){
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		return nf.format(number);
	}
}
