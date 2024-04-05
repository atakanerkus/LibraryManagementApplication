package data_layer;

import java.util.Date;

public class ScholarshipStudent extends Student{

	public ScholarshipStudent(Item borrowedItem, Date startBarrow, Date endBarrow) {
		super(borrowedItem, startBarrow, endBarrow);
		discountPercentage = 30;
	}
	
	public ScholarshipStudent(ScholarshipStudent otherScholarshipStudent) {
		super(otherScholarshipStudent);
		discountPercentage = 30;
	}
	public ScholarshipStudent copy() {
		return new ScholarshipStudent(this);
	}
	 public ScholarshipStudent() {super();}
	
}
