package business_layer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import data_layer.*;

public class FileIO {
	
	public FileIO(){readDataArrays();}
	
	public static final int TRANSACTION_COUNT = 20;
	private Item[] items = new Item[TRANSACTION_COUNT];
	private Customer[] customers = new Customer[TRANSACTION_COUNT];
	private String line = "";
	private String splitBy = ";";// default delimiter for csv
	private int itemNum = -1; // initialized to -1 to understand if there is an error
	private String itemTitle = "";
	private String stringItemPriority = "";
	private String itemType = "";
	private String itemAuthorGenre = "";
	private String itemPublisherProducer = "";
	private String customerType = "";
	private String stringStartDate = "";
	private String stringEndDate = "";
	private Priority itemPriority;
	private Date startDate;
	private Date endDate;
	
	private void readDataArrays() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("items.csv"));
			int number = 101; //Couldn't convert string to int, NumberFormatException
			int index = 0;
			while ((line = br.readLine()) != null) {
				String[] temp = line.split(splitBy);
				itemNum = number;
				itemTitle = temp[1];
				stringItemPriority = temp[2];
				itemType = temp[3];
				itemAuthorGenre = temp[4];
				itemPublisherProducer = temp[5];
				customerType = temp[6];
				stringStartDate = temp[7];
				stringEndDate = temp[8];
				itemPriority = Priority.valueOf(stringItemPriority.replace(" ",""));
				
				try {
					endDate = new SimpleDateFormat("dd/MM/yyyy").parse(stringEndDate);
					startDate = new SimpleDateFormat("dd/MM/yyyy").parse(stringStartDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				switch(itemType) {
				case "book":
					items[index] = new Book(itemNum,itemTitle,itemType,itemPriority,itemAuthorGenre,itemPublisherProducer);
					break;
				case "magazine":
					items[index] = new Magazine(itemNum,itemTitle,itemType,itemPriority,itemAuthorGenre,itemPublisherProducer);
					break;
				default:
					System.out.println("An error happened while trying to construct items.");
				}
				
				switch(customerType) {
				case "studentWOScholar":
					customers[index] = new WOScholarshipStudent();
					customers[index].borrow(items[index], startDate, endDate);
					break;
				case "studentWScholar":
					customers[index] = new ScholarshipStudent();
					customers[index].borrow(items[index], startDate, endDate);
					break;
				case "general":
					customers[index] = new GeneralCustomer();
					customers[index].borrow(items[index], startDate, endDate);
					break;
				default:
					System.out.println("An error happened while trying to construct customers.");
				}
				index++;
				number += 100;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Item[] getItemArray() {
		Item[] temp = new Item[TRANSACTION_COUNT];
		for(int i=0;i<temp.length;i++) {
			temp[i] = (Item)items[i].clone();
		}
		return temp;
	}

	public Customer[] getCustomerArray() {
		Customer[] temp = new Customer[TRANSACTION_COUNT];
		for(int i=0;i<temp.length;i++) {
			temp[i] = (Customer)customers[i].clone();
		}
		return temp;
	}
}