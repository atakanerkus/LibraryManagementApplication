package data_layer;

import java.util.Date;

import business_layer.FileIO;

public abstract class Item implements Searchable {
	private int itemNumber;
	private String title;
	private Priority priority;
	private String itemType;

	protected double chargePerDay;
	protected int daysConsideredLate;
	protected int lateCharge;

	Item(int itemNumber, String title, String itemType, Priority priority) {
		this.itemNumber = itemNumber;
		this.title = title;
		this.itemType = itemType;
		this.priority = priority;
	}
	
	Item(Item otherItem) {
		this.itemNumber = otherItem.itemNumber;
		this.title = otherItem.title;
		this.itemType = otherItem.itemType;
		this.priority = otherItem.priority;
	}
	public abstract Object clone(); //this method shouldn't be used with this class
	
	public String getName() {
		return title;
	}
	public int getNumber() {
		return itemNumber;
	}
	public String getType() {
		return itemType;
	}
	public int getPrioVal() {	//Returns priority value directly
		return priority.getPriorityValue();
	}
	public double getChargePerDay() {
		return chargePerDay;
	}
	public int getDaysConsideredLate() {
		return daysConsideredLate;
	}
	public int getLateCharge() {
		return lateCharge;
	}
	
	public boolean searchTitle(String title) {
		return this.title.equals(title);
	}
	
	
	public boolean searchTitleAndItemType(String title, String itemType) {
		return (this.title.equals(title) && this.itemType.equals(itemType)) ;

	}
}
