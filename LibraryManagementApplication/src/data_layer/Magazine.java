package data_layer;

import java.util.Date;
import business_layer.*;

public class Magazine extends Item {
	private String genre;
	private String producer;

	public Magazine(int itemNumber, String title, String itemType, Priority priority, String genre, String producer) {
		super(itemNumber, title, itemType, priority);
		this.genre = genre;
		this.producer = producer;
		chargePerDay = 10;
		daysConsideredLate = 7;
		lateCharge = 2;
	}
	
	public Magazine(Magazine otherMag) {
		super(otherMag);
		this.genre = otherMag.genre;
		this.producer = otherMag.producer;
		chargePerDay = 10;
		daysConsideredLate = 7;
		lateCharge = 2;
	}

	


	
	public Magazine clone(){
		return new Magazine(this);
	}

}
