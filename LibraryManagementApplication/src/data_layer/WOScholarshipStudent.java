package data_layer;

import java.util.Date;

public class WOScholarshipStudent extends Student{

	public WOScholarshipStudent(Item borrowedItem, Date startBarrow, Date endBarrow) {
		super(borrowedItem, startBarrow, endBarrow);
		discountPercentage = 20;
	}
	public WOScholarshipStudent() {super();}
	
	public WOScholarshipStudent(WOScholarshipStudent otherWOScholarShipStudent) {
		super(otherWOScholarShipStudent);
		discountPercentage = 20;
	}
	
	public WOScholarshipStudent copy() {
		return new WOScholarshipStudent(this);
	}
}
