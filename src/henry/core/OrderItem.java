package henry.core;

import java.math.BigDecimal;
import java.text.NumberFormat;
/**
 * @author Liu hengjian.
 * 
 */
public class OrderItem {
	
	private Good good;		//single good object
	private int quantity;	//indicates how many goods in this order item
	
	
	/**
	 * default quantity is 1
	 * @param good
	 */
	public OrderItem(Good good) {
		this(good, 1);
	}
	
	
	public OrderItem(Good good, int quantity) {
		if(good==null)
			throw new IllegalArgumentException("Good object should not be null");
		if(quantity<0)
			throw new IllegalArgumentException("quantity should not be negative");
		this.good = good;
		this.quantity = quantity;
	}
	
	
	/**
	 * To avoid the decimal bug, use NumberFormat to make the result accurate
	 * @return total tax of all the goods
	 */
	public double getTax(){
		//good.getTax(good.getPrice()*quantity)
		return formatNumberWith2Decimal(good.getTax()*quantity);
	}
	
	
	/**
	 * To avoid the decimal bug, use NumberFormat to make the result accurate.
	 * @return total fee of all the goods.
	 */
	public double getTotalFee(){
		return formatNumberWith2Decimal(good.getShelfPrice()*quantity);
	}
	
	/**
	 * @return the detail information of this item, 
	 * include name and total fee of all goods.
	 */
	public String getOrderItemDetail(){
		return quantity+" "+good.getName()+":"+ formatNumber2StrWith2Decimal(getTotalFee());
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
