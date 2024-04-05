package data_layer;

import java.util.Date;

public class Book extends Item {
	private String author;
	private String publisher;

	public Book(int itemNumber, String title, String itemType, Priority priority, String author, String publisher) {
		super(itemNumber, title, itemType, priority);
		this.author = author;
		this.publisher = publisher;
		chargePerDay = 5;
		daysConsideredLate = 10;
		lateCharge = 5;
	}
	
	public Book(Book otherBook) {
		super(otherBook);
		this.author = otherBook.author;
		this.publisher = otherBook.publisher;
		chargePerDay = 5;
		daysConsideredLate = 10;
		lateCharge = 5;
	}


	public Book clone(){
		return new Book(this);
	}
}
