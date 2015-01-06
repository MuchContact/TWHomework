package henry.core;
/**
 * @author Liu hengjian.
 * 
 */
public abstract class Good {
	//good name
	private String name;
	//price without tax
	private double price;
	//delegate to a TaxStrategy which determines how to calculate taxes.
	private TaxStrategy taxStrategy;
	
	
	/**
	 * Construct a new object with a basic non-imported tax strategy 
	 * @param price
	 * @param name 
	 */
	public Good(double price, String name) {
		this(price, name, TaxStrategyFactory.getBasicTaxInstance());
	}
	
	public Good(double price, String name, TaxStrategy ts) {
		if(price<0)
			throw new IllegalArgumentException("price should not be negative");
		if(ts==null)
			throw new IllegalArgumentException("TaxStrategy should not be null");
		this.price = price;
		this.name = name;
		this.taxStrategy = ts;
	}
	
	protected void setTaxStrategy(TaxStrategy taxStrategy) {
		this.taxStrategy = taxStrategy;
	}
	
	public String getName() {
		return name;
	}
	
	public double getTax(){
		return taxStrategy.getTax(price);
	}
	
	/**
	 * Calculate taxes under tax strategy in this instance
	 * @param totalPrice 
	 * @return taxes based on the given price
	 */
	public double getTax(double totalPrice){
		return taxStrategy.getTax(totalPrice);
	}
	
	/**
	 * @return the sold out price
	 */
	public double getShelfPrice(){
		return price+getTax();
	}
	
	/**
	 * Show some additional information
	 */
	public abstract void showGoodDetail();
}


