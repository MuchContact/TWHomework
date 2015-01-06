package henry.core;

import java.util.ArrayList;

/**
 * @author Liu hengjian.
 * 
 */
public class Food extends Good {
	
	//food dictionary
	public static ArrayList<String> foodDictionary ;
	
	static{
		foodDictionary = new ArrayList<String>();
		//load food dictionary, here we just add some examples
		foodDictionary.add("chocolate");
		foodDictionary.add("bread");
		//TODO add your own food dictionary here
	}
	
	/**
	 * Just demonstrate a simple way of judging whether a good is food. 
	 * @param goodName name of a good
	 * @return true if goodName represents food, otherwise return false.
	 */
	public static boolean isFood(String goodName){
		if(goodName==null)
			return false;
		String lowercase = goodName.toLowerCase();
		for(String item:foodDictionary){
			if(lowercase.contains(item))
				return true;
		}
		return false;
	}
	/**
	 * @param price
	 * @param name
	 */
	public Food(double price, String name) {
		this(price, name, false);
	}
	
	/**
	 * @param price
	 * @param name
	 * @param isImported indicates whether this kind of food is imported
	 */
	public Food(double price, String name, boolean isImported) {
		super(price, name);
		setTaxStrategy(TaxStrategyFactory.getTaxStrategyInstance(isImported, true));
		
	}

	@Override
	public void showGoodDetail() {
		// TODO Auto-generated method stub
		
	}

}
