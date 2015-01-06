package tax.tdd;

public class Commodity {
	private boolean imported = false;
	private String type;
	public Commodity(boolean isImported, String type) {
		this.imported = isImported;
		this.type = type;
	}

	public double getTaxRate() {
		if(isBasicTaxExempted()&&!imported){
			return .00;
		}else if(isBasicTaxExempted()&&imported){
			return .05;
		}else if(!isBasicTaxExempted()&&!imported){
			return .10;
		}else{
			return .15;
		}
	}
	
	public boolean isBasicTaxExempted(){
		return type.equalsIgnoreCase("food")||
				type.equalsIgnoreCase("book")||
				type.equalsIgnoreCase("medicine");
	}
}
