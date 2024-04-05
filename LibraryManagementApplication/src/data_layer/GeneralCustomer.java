package data_layer;

import java.util.Date;

public class GeneralCustomer extends Customer{
	public GeneralCustomer(Item borrowedItem, Date startBorrow, Date endBorrow) {
		super(borrowedItem, startBorrow, endBorrow);
	}

	GeneralCustomer(GeneralCustomer otherGenCus) {
		super(otherGenCus);
	}
	public GeneralCustomer(){super();}
	@Override
	public double calcTotal() {
		
		return calcBorrowingCharge() + calcReturnCharge();
	}
	
	public GeneralCustomer clone(){
		return new GeneralCustomer(this);
	}

	

	


}
