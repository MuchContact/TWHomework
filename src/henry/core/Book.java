package henry.core;

import java.util.ArrayList;

/**
 * @author Liu hengjian.
 * 
 */
public class Book extends Good {
	
	//book dictionary
	public static ArrayList<String> bookDictionary ;
	
	static{
		bookDictionary = new ArrayList<String>();
		//load dictionary, here we just add some examples
		bookDictionary.add("book");
		bookDictionary.add("document");
		//TODO load your own dictionary here
	}
	
	/**
	 * Just demonstrate a simple way of judging whether a good is a book. 
	 * @param goodName name of a good
	 * @return true if goodName represents a book, otherwise return false.
	 */
	public static boolean isBook(String goodName){
		if(goodName==null)
			return false;
		String lowercase = goodName.toLowerCase();
		for(String item:bookDictionary){
			if(lowercase.contains(item))
				return true;
		}
		return false;
	}
	
	
	public Book(double price, String name, boolean isImported) {
		super(price, name);
		setTaxStrategy(TaxStrategyFactory.getTaxStrategyInstance(isImported, true));
	}

	@Override
	public void showGoodDetail() {
		// TODO Auto-generated method stub

	}

}
