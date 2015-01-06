package henry.core;
/**
 * @author Liu hengjian.
 * 
 */
public class TaxStrategyFactory {
	//////////////////////////////////////
	// Basic TaxStrategy instances		//
	//////////////////////////////////////
	
	//single TaxStrategy instance for normal unimported goods
	private static final TaxStrategy basicTaxInstance = new TaxStrategy(0.1);
	//single TaxStrategy instance for exempt unimported goods
	private static final TaxStrategy noTaxInstance = new TaxStrategy(0);
	
	//////////////////////////////////////
	// Composite TaxStrategy instances  //
	//////////////////////////////////////
	
	//single TaxStrategy instance for exempt imported goods
	private static final TaxStrategy importedNoTaxInstance = 
										new ImportedTaxStrategy(noTaxInstance);
	//single TaxStrategy instance for normal imported goods
	private static final TaxStrategy importedBasicTaxInstance = 
										new ImportedTaxStrategy(basicTaxInstance);
	
	
	public static TaxStrategy getBasicTaxInstance(){
		return basicTaxInstance;
	}
	public static TaxStrategy getNoTaxInstance(){
		return noTaxInstance;
	}
	public static TaxStrategy getImportedNoTaxInstance(){
		return importedNoTaxInstance;
	}
	public static TaxStrategy getImportedBasicTaxInstance(){
		return importedBasicTaxInstance;
	}
	
	public static TaxStrategy getTaxStrategyInstance(boolean isImported, boolean isExempt){
		if(isExempt&&isImported)
			return TaxStrategyFactory.getImportedNoTaxInstance();
		else if(isExempt&&!isImported)
			return TaxStrategyFactory.getNoTaxInstance();
		else if(!isExempt&&isImported)
			return TaxStrategyFactory.getImportedBasicTaxInstance();
		else
			return TaxStrategyFactory.getBasicTaxInstance();
	}
	
}
