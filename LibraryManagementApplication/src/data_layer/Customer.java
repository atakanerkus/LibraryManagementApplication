package data_layer;

import java.util.Date;

public abstract class Customer implements Borrowing {
	protected Date startBorrow;
	protected Date endBorrow;
	protected Item borrowedItem;
	
	Customer(Item borrowedItem,Date startBorrow, Date endBorrow){
		this.borrowedItem = borrowedItem;
		this.startBorrow = startBorrow;
		this.endBorrow = endBorrow;	
	}
	
	Customer(Customer otherCus){
		this.borrowedItem = otherCus.borrowedItem;
		this.startBorrow = otherCus.startBorrow;
		this.endBorrow = otherCus.endBorrow;	
	}
	public Customer(){}
	
	public Item getBorrowedItem() {
		return borrowedItem;
	}
	public abstract double calcTotal(); //abstract because of discount calculations differ
	
	public double calcBorrowingCharge() {
		if (endBorrow.after(startBorrow)) { //date validity check
			return borrowedItem.getChargePerDay()*borrowedItem.getPrioVal()*(getBorrowTime());
		}
		else {return -1;} //means dates are not written correctly
	}
	
	public double calcReturnCharge() {
		if ((getBorrowTime()) > borrowedItem.getDaysConsideredLate()){ //if should be penalized
			return borrowedItem.getLateCharge();
		}
		else {return 0;}
	}
	
	
	public void borrow(Item item, Date startBorrow, Date endBorrow) {
		 this.borrowedItem = item;
		 this.startBorrow = startBorrow;
		 this.endBorrow = endBorrow;
	}
	
	public abstract Object clone(); //this method shouldn't be used with this class 
		
	public Date getEndDate() {
		return endBorrow;
	}
	public long getBorrowTime() {
		return ((endBorrow.getTime()-startBorrow.getTime())/86400000);
	}
}
