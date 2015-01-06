package henry.core;


/**
 * Use composite pattern to add additional responsibility to TaxStrategy
 * 
 * @author Liu hengjian.
 * 
 */
public class ImportedTaxStrategy extends TaxStrategy {
	
	//composite a TaxStrategy instance
	private TaxStrategy ts;
	//Import duty is an additional sales tax
	private final double importedRate = 0.05;
	
	/**
	 * composite a TaxStrategy instance
	 * @param ts
	 */
	public ImportedTaxStrategy(TaxStrategy ts) {
		this.ts = ts;
	}
	
	/* (non-Javadoc)
	 * @see henry.core.TaxStrategy#getRate()
	 */
	@Override
	public double getRate() {
		return importedRate + ts.getRate();
	}
	
}
