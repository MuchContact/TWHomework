package henry.core;

import java.util.ArrayList;

/**
 * @author Liu hengjian.
 * 
 */
public class Medical extends Good{
	
	//medical dictionary
	public static ArrayList<String> medicalDictionary ;
	
	static{
		medicalDictionary = new ArrayList<String>();
		//load dictionary, here we just add some examples
		medicalDictionary.add("pills");
		//TODO add your own dictionary here
	}
	
	/**
	 * Just demonstrate a simple way of judging whether a good is medical. 
	 * @param goodName name of a good
	 * @return true if goodName represents a medical, otherwise return false.
	 */
	public static boolean isMedical(String goodName){
		if(goodName==null)
			return false;
		String lowercase = goodName.toLowerCase();
		for(String item:medicalDictionary){
			if(lowercase.contains(item))
				return true;
		}
		return false;
	}
	
	public Medical(double price, String name, boolean isImported) {
		super(price, name);
		setTaxStrategy(TaxStrategyFactory.getTaxStrategyInstance(isImported, true));
	}

	@Override
	public void showGoodDetail() {
		// TODO Auto-generated method stub
		
	}

}
