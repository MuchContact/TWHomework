package henry.core;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * @author Liu hengjian.
 * 
 */
public class TaxStrategy {
	
	//Tax rate
	private double rate;
	
	protected TaxStrategy() {
		this(0);
	}
	
	public TaxStrategy(double rate) {
		this.rate = rate;
	}
	
	public double getRate() {
		return rate;
	}
	
	/**
	 * Calculate taxes for specific price.
	 * Here I get rate using getRate(), so the ImportedTaxStrategy 
	 * could override getRate() to make it polymorphic
	 * @param price
	 * @return the rounded up(to the nearest 0.05) tax
	 */
	public double getTax(double price){
		return defaultRoundup(price*getRate());
	}
	
	/**
	 * round up number to the nearest higher 0.05
	 * @param number
	 * @return the rounded up number
	 */
	protected double defaultRoundup(double number){
		int tmp=(int)(number*100);
		int lastDigit=tmp%10;
		boolean incr=false;
		if(lastDigit>5){
			incr=true;
			lastDigit=0;
		}else if(lastDigit>0){
			lastDigit=5;
		}else{
			lastDigit=0;
		}
		tmp=tmp/10;
		if(incr){
			tmp+=1;
		}
		tmp=tmp*10;
		tmp=tmp+lastDigit;
		return formatNumberWith2Decimal(tmp/100F);
	}
	
	/**
	 * To fix the decimal bug and format the number.
	 * See tests in TaxStrategyTest.class
	 * @param number
	 * @return a formated number
	 */
	private double formatNumberWith2Decimal(double number){
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		return new BigDecimal(nf.format(number)).doubleValue();
	}
}
