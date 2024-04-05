package business_layer;

import data_layer.*;

public class LibraryManagement {
	String search1Title = "History of Art";
	String search1Type = "book";
	String search2Title = "Animal Farm";
	FileIO f = new FileIO();
	Customer[] cusArray = f.getCustomerArray();
	Item[] itemArray = f.getItemArray();

	private String isLate(Customer customer) { // Checks if it exceeds borrowing time

		if (customer.getBorrowTime() > customer.getBorrowedItem().getDaysConsideredLate()) {
			return "EXCEEDS";

		} else {
			return "NOT EXCEEDS";
		}
	}

	public void searchByTitle() {
		boolean flag = false;
		for (Customer customer : cusArray) {
			if (customer.getBorrowedItem().searchTitle(search2Title)) {
				flag = true;
				System.out.println("Exists Item Number: " + customer.getBorrowedItem().getNumber() + " Item Type: "
						+ customer.getBorrowedItem().getType() + " Borrowing Days: " + customer.getBorrowTime()
						+ " days Exceed: " + isLate(customer) + " Total Price: $" + customer.calcTotal());
				break;
			}
		}
		if (!flag) {
			System.out.println("Does not exist");
			}


	}

	public void searchByTitleAndType() {
		boolean flag = false;
		for (Customer customer : cusArray) {
			if (customer.getBorrowedItem().searchTitleAndItemType(search1Title, search1Type)) {
				flag = true;
				System.out.println("Exists Item Number: " + customer.getBorrowedItem().getNumber() + " Item Type: "
						+ customer.getBorrowedItem().getType() + " Borrowing Days: " + customer.getBorrowTime()
						+ " days Exceed: " + isLate(customer) + " Total Price: $" + customer.calcTotal());
				break;
			}

		}
		if (!flag) {
		System.out.println("Does not exist");
		}

	}

	public void display() {
		for (Customer customer : cusArray) {
			System.out.println("Item Number: " + customer.getBorrowedItem().getNumber() + " Item Type: "
					+ customer.getBorrowedItem().getType() + " Borrowing Days: " + customer.getBorrowTime()
					+ " days Exceed: " + isLate(customer) + " Total Price: $" + customer.calcTotal());

		}

	}

}
