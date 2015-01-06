package henry.core;

/**
 * @author Liu hengjian.
 * 
 */
public class NormalGood extends Good {
	/**
	 * @param price
	 * @param name
	 * @param isImported
	 */
	public NormalGood(double price, String name, boolean isImported) {
		super(price, name);
		setTaxStrategy(TaxStrategyFactory.getTaxStrategyInstance(isImported, false));
	}

	@Override
	public void showGoodDetail() {
		// TODO Auto-generated method stub

	}

}
