package data_layer;

import java.util.Date;

public class Student extends Customer{
	protected double discountPercentage = 20;

	Student(Item borrowedItem, Date startBorrow, Date endBorrow) {
		super(borrowedItem, startBorrow, endBorrow);
		// TODO Auto-generated constructor stub
	}
	
	Student(Student otherStu){
		super(otherStu);
	}
	Student(){super();}
	@Override
	public double calcTotal() {
		return ((calcBorrowingCharge() + calcReturnCharge()) * (100-discountPercentage));
	}
	public double calcDiscount() {
		return 0;
		
	}
	
	public Student clone() {
		return new Student(this);
	}

	@Override
	public double calcReturnCharge() {
		if (((endBorrow.getTime()-startBorrow.getTime())/86400000) > borrowedItem.getDaysConsideredLate()){
			return borrowedItem.getLateCharge();
		}
		else {return 0;}
	}

}
